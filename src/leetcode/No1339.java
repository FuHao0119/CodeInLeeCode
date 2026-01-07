package leetcode;


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }

class No1339 {
    int  total = 0;
    long  max = 0;
    final static int  m = 1_000_000_000 + 7;
    public int preOrderReturnSum(TreeNode root){
        if(root == null) return 0;
        int val = root.val;
        return val + preOrderReturnSum(root.left) +
                preOrderReturnSum(root.right);
    }

    public long proOrderToMax(TreeNode root){
        if(root == null) return 0;
        long currentTreeVal = root.val + proOrderToMax(root.left) + proOrderToMax(root.right) ;
        long otherTreeVal = total - currentTreeVal;
        max = Math.max(max, currentTreeVal * otherTreeVal);
        return currentTreeVal;
    }

    public int maxProduct(TreeNode root) {
        total = preOrderReturnSum(root); // 计算出总权值
        proOrderToMax(root);
        return (int)(max %  m);
    }
}
