import os
import random
import re
import sys
import requests
import json

# ==========================================
# 配置区
# ==========================================
DEEPSEEK_API_KEY = ""
DEEPSEEK_API_URL = "https://api.deepseek.com/chat/completions"

def clear_screen():
    os.system('cls' if os.name == 'nt' else 'clear')

def print_header(text):
    print("\n" + "="*50)
    print(f" {text}")
    print("="*50 + "\n")

def get_multiline_input(prompt="请输入你的答案 (输入 'EOF' 结束):"):
    print(prompt)
    lines = []
    while True:
        line = sys.stdin.readline()
        if not line: break
        if line.strip() == 'EOF': break
        lines.append(line)
    return "".join(lines).strip()

class DeepSeekEvaluator:
    @staticmethod
    def evaluate(question_type, title, context, standard_answer, user_answer):
        if not DEEPSEEK_API_KEY:
            return "API Key 未设置，无法进行 AI 评估。"
        
        prompt = f"""
你是一位算法设计与分析课程的助教。请评价学生在刷题练习中的表现。

【题目类型】: {question_type}
【题目名称】: {title}
【题目上下文/代码】:
{context}

【标准答案】:
{standard_answer}

【学生的回答】:
{user_answer}

请根据标准答案评估学生的回答是否正确（逻辑等价即可）。
1. 首先给出明确的结论：【正确】或【错误】。
2. 给出简洁的评价或解释，指出其逻辑是否严密，如有错误请指出。
3. 请使用中文回答。
"""
        headers = {
            "Content-Type": "application/json",
            "Authorization": f"Bearer {DEEPSEEK_API_KEY}"
        }
        data = {
            "model": "deepseek-chat",
            "messages": [
                {"role": "system", "content": "你是一个专业的算法老师。"},
                {"role": "user", "content": prompt}
            ],
            "stream": False
        }
        
        try:
            print("\n正在请求 AI 进行评估，请稍候...")
            response = requests.post(DEEPSEEK_API_URL, headers=headers, json=data, timeout=30)
            response.raise_for_status()
            result = response.json()
            return result['choices'][0]['message']['content']
        except Exception as e:
            return f"评估出错: {str(e)}"

class QuestionBank:
    def __init__(self, base_path):
        self.base_path = base_path
        self.choices = self.load_choices()
        self.fill_blanks = self.load_fill_blanks()
        self.designs = self.load_designs()

    def load_choices(self):
        path = os.path.join(self.base_path, 'multiple_choice.md')
        if not os.path.exists(path): return []
        with open(path, 'r', encoding='utf-8') as f:
            content = f.read()
        
        # Match questions: **Qn. text** A. B. C. D. Answer: X
        questions = []
        pattern = r"\*\*Q(\d+)\. (.*?)\*\*\s+A\. (.*?)\s+B\. (.*?)\s+C\. (.*?)\s+D\. (.*?)\s+Answer:\s*([A-D])"
        matches = re.findall(pattern, content, re.DOTALL)
        for m in matches:
            questions.append({
                'id': m[0],
                'question': m[1].strip(),
                'options': {'A': m[2].strip(), 'B': m[3].strip(), 'C': m[4].strip(), 'D': m[5].strip()},
                'answer': m[6].strip()
            })
        return questions

    def load_fill_blanks(self):
        path = os.path.join(self.base_path, 'fill_in_the_blank.md')
        if not os.path.exists(path): return []
        with open(path, 'r', encoding='utf-8') as f:
            content = f.read()
        
        blocks = content.split('---')
        questions = []
        for block in blocks:
            title_match = re.search(r"\*\*(\d+)\. (.*?)\*\*", block)
            code_match = re.search(r"```python\n(.*?)\n```", block, re.DOTALL)
            answer_match = re.search(r"答案：\n```python\n(.*?)\n```", block, re.DOTALL)
            
            if title_match and code_match and answer_match:
                questions.append({
                    'id': title_match.group(1),
                    'title': title_match.group(2),
                    'code': code_match.group(1),
                    'answer': answer_match.group(1)
                })
        return questions

    def load_designs(self):
        path = os.path.join(self.base_path, 'programming_questions.md')
        if not os.path.exists(path): return []
        with open(path, 'r', encoding='utf-8') as f:
            content = f.read()
        
        blocks = content.split('---')
        questions = []
        for block in blocks:
            title_match = re.search(r"\*\*(\d+)\. (.*?)\*\*", block)
            if title_match:
                # The rest of the block after the title is the content
                body = block.split(title_match.group(0))[1].strip()
                questions.append({
                    'id': title_match.group(1),
                    'title': title_match.group(2),
                    'body': body
                })
        return questions

def practice_choice(questions):
    if not questions:
        print("没有找到选择题。")
        return
    
    random.shuffle(questions)
    correct_count = 0
    total = len(questions)
    
    for i, q in enumerate(questions):
        clear_screen()
        print_header(f"选择题练习 ({i+1}/{total}) - 正确: {correct_count}")
        print(f"Q: {q['question']}\n")
        for opt in ['A', 'B', 'C', 'D']:
            print(f"{opt}. {q['options'][opt]}")
        
        ans = input("\n请输入你的答案 (A/B/C/D) 或 Q 退出: ").strip().upper()
        if ans == 'Q': break
        
        if ans == q['answer']:
            print("\n✅ 正确!")
            correct_count += 1
        else:
            print(f"\n❌ 错误。正确答案是 {q['answer']}。")
        
        input("\n按回车继续...")
    
    print(f"\n练习结束。你的得分: {correct_count}/{total}")
    input("\n按回车返回主菜单...")

def practice_fill_blank(questions):
    if not questions:
        print("没有找到填空题。")
        return
    
    random.shuffle(questions)
    for i, q in enumerate(questions):
        clear_screen()
        print_header(f"填空题练习 ({i+1}/{len(questions)})")
        print(f"题目: {q['title']}\n")
        print(q['code'])
        
        print("\n" + "-"*30)
        user_ans = get_multiline_input("请补全空白部分的内容 (输入 'EOF' 结束):")
        
        feedback = DeepSeekEvaluator.evaluate("程序填空题", q['title'], q['code'], q['answer'], user_ans)
        
        print("\n" + "="*50)
        print("【AI 评估结果】:")
        print(feedback)
        print("\n【参考标准答案】:")
        print(q['answer'])
        
        cont = input("\n继续下一题？(Y/n): ").strip().lower()
        if cont == 'n': break

def practice_design(questions):
    if not questions:
        print("没有找到综合设计题。")
        return
    
    random.shuffle(questions)
    for i, q in enumerate(questions):
        clear_screen()
        print_header(f"综合设计题练习 ({i+1}/{len(questions)})")
        print(f"题目: {q['title']}\n")
        
        user_ans = get_multiline_input("请写出你的算法思想、关键步骤或伪代码 (输入 'EOF' 结束):")
        
        feedback = DeepSeekEvaluator.evaluate("综合设计题", q['title'], "见题目描述", q['body'], user_ans)
        
        print("\n" + "="*50)
        print("【AI 评估结果】:")
        print(feedback)
        print("\n【参考标准方案】:")
        print(q['body'])
        
        cont = input("\n继续下一题？(Y/n): ").strip().lower()
        if cont == 'n': break

def main():
    base_path = 'exam-tutor/references/'
    qb = QuestionBank(base_path)
    
    while True:
        clear_screen()
        print_header("算法设计与分析 考试刷题程序 (AI 增强版)")
        print("1. 选择题练习 (60题)")
        print("2. 程序填空题练习 (13题 - AI 评改)")
        print("3. 综合设计题练习 (28题 - AI 评改)")
        print("Q. 退出程序")
        
        choice = input("\n请选择功能 (1-3/Q): ").strip().upper()
        
        if choice == '1':
            practice_choice(qb.choices)
        elif choice == '2':
            practice_fill_blank(qb.fill_blanks)
        elif choice == '3':
            practice_design(qb.designs)
        elif choice == 'Q':
            print("\n祝你考试顺利！再见。")
            break
        else:
            print("\n无效选择，请重试。")
            input("按回车继续...")

if __name__ == "__main__":
    main()
