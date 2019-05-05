/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int level=getLevel(root);
        int cul=(int) Math.pow(2,level)-1;
        List<List<String>> res=new ArrayList<>(level);
        for (int i=0;i<level;i++)
        {
            List<String> list=new ArrayList<>(cul);
            res.add(list);
            for (int j=0;j<cul;j++)
            {
                list.add("");
            }
        }
        dfs(root,0,cul-1,0,res);
        return res;
    }

    //迭代 深度遍历
    private void dfs(TreeNode root, int left, int right, int level,List<List<String>> res) {
        if(root==null)return;
        int mid=(left+right)/2;
        res.get(level).set(mid,Integer.toString(root.val));
        dfs(root.left,left,mid-1,level+1,res);
        dfs(root.right,mid+1,right,level+1,res);
    }

    private  int getLevel(TreeNode root) {
        if(root==null) return 0;
        return Math.max(getLevel(root.left),getLevel(root.right))+1;
    }
}