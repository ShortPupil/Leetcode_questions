package code.JZ7;

import java.util.*;
/**
 * Definition for binary tree
 */
/**给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。*/

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        if(pre.length == 0 || vin.length == 0) {
            return null;
        }
        TreeNode treeNode = new TreeNode(pre[0]);
        for(int i=0 ; i<vin.length ; i++) {
            if(pre[0] == vin[i]) {
                treeNode.left = reConstructBinaryTree
                        (Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(vin, 0, i));
                treeNode.right = reConstructBinaryTree
                        (Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(vin, i + 1, vin.length));
                break;
            }
        }
        return treeNode;
    }
}