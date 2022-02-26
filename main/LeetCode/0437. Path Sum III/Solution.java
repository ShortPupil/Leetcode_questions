/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int result = 0;

        if (root == null) return result;

        // 用队列来存储每次当做计算开头的每个节点
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            for (int i = 0; i < levelNum; i++) {// 计算队列中每个元素可否满足条件，并将子节点添加到队列
                result += canSum(queue.peek(), sum, 0);

                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                queue.poll();
            }
        }
        return result;
    }

    // 计算节点能达成条件的情况数量
    public int canSum(TreeNode root, int targetSum, int tempSum) {
        int sumNumber = 0;
        if (root == null) return sumNumber;

        if (root.val + tempSum == targetSum) sumNumber++;
        sumNumber += canSum(root.left, targetSum, root.val + tempSum) + canSum(root.right, targetSum, root.val + tempSum);
        return sumNumber;
    }
}