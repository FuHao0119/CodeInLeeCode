package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class No958 {
}

class Solution {
    private Queue<TreeNode> pq  = new LinkedList<>();
    private Queue<TreeNode> queue  = new LinkedList<>();
    public void cenxu(TreeNode root){ // 层序遍历把所有节点放到队列中
        queue.offer(root);
        while(queue.size() > 0){
            TreeNode node = queue.poll();
            pq.offer(node);
            if(node.val == -999) continue;

            if(node.left!=null){
                queue.offer(node.left);
            }else {
                TreeNode tmp = new TreeNode(-999);
                queue.offer(tmp);
            }

            if(node.right!=null){
                queue.offer(node.right);
            }else {
                TreeNode tmp = new TreeNode(-999);
                queue.offer(tmp);
            }

        }
    }

    public boolean isCompleteTree(TreeNode root) {
        cenxu(root);
        TreeNode pre = pq.peek();
        while(pq.size() > 0){
            TreeNode node = pq.poll();
            System.out.println(node.val);
            if(pre.val == -999 && node.val != -999) return false;
            pre = node;
        }
        return true;
    }
}
