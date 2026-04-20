package leetcode;

import java.util.*;

public class No692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> word_count_map = new HashMap<>();
        for(String word : words){
            // 将所有文字和对应个数存入hashmap, getOrDefault:找的到就返回对应value 找不到返回自己设定的值
            word_count_map.put(word, word_count_map.getOrDefault(word, 0) + 1);
        }

        List<String> wordlist = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : word_count_map.entrySet()){ // 遍历哈希表 把word存到list
            wordlist.add(entry.getKey());
        }
        // 按照规则排序
        Collections.sort(wordlist, new Comparator<String>(){
            public int compare(String w1, String w2){
                int w1_count = word_count_map.get(w1);
                int w2_count = word_count_map.get(w2);
                if(w1_count != w2_count){
                    return w2_count - w1_count;
                } else {
                    return w1.compareTo(w2);     // 按照字典序排序
                }
            }
        });

        return wordlist.subList(0, k);
    }
}