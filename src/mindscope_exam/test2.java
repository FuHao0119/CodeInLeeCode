package mindscope_exam;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode{
    String val;
    TreeNode left;
    TreeNode right;
    TreeNode(){

    }
    TreeNode(String val){
        this.val = val;
    }
    TreeNode(String val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean getResult(TreeNode root) {
        if(root == null){
            return true;
        }
        return isMirror(root.left,root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if(left == null && right == null){return true;}
        if(left == null || right == null){return false;}
        if(!left.val.equals(right.val)){return false;}
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}




public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        String[] treeNodes = string.substring(1, string.length() - 1).split(",");
        // if (treeNodes.length == 0) System.out.println("True"); // 空树是对称的

        if (treeNodes[0].isEmpty() || treeNodes[0].equals("null")) {
            System.out.println("True");
            scanner.close();
            return;
        }

        TreeNode root = new TreeNode(treeNodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); int index = 1;
        while(!queue.isEmpty() && index<treeNodes.length){
            TreeNode node = queue.poll();
            // zuo
            if(index < treeNodes.length && !treeNodes[index].equals("null")){
                node.left = new TreeNode(treeNodes[index]);
                queue.offer(node.left);
            }
            index++;

            // you
            if(index < treeNodes.length && !treeNodes[index].equals("null")){
                node.right = new TreeNode(treeNodes[index]);
                queue.offer(node.right);
            }
            index++;
        }
        boolean result = new Solution().getResult(root);
        if(result == false){
            System.out.println("False");
        }else{
            System.out.println("True");
        }



        scanner.close();
    }
}
