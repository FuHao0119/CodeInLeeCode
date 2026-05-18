package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
这好像是回溯，怎么这么难!!!!
 */
public class No257 {
    List<String> list = new ArrayList<>();

    void dfs(TreeNode root, String tmp){
        tmp = tmp + root.val;
        if(root.left == null && root.right == null){
            list.add(tmp);
        }
        if(root.left != null) dfs(root.left, tmp+"->");
        if(root.right != null) dfs(root.right, tmp+"->");
    }

    public List<String> binaryTreePaths(TreeNode root) {
        String tmp = "";
        dfs(root, "");
        return list;
    }
}
