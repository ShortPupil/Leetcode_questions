package code.JZ8;

/**
 * TODO ..
 * User: 钟镇鸿
 * Date: 2022/2/26
 * Time: 20:11
 * Description:
 */
/**给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。
 * 下图为一棵有9个节点的二叉树。树中从父节点指向子节点的指针用实线表示，从子节点指向父节点的用虚线表示
 * */

import java.util.*;

/**
 * 输入:{8,6,10,5,7,9,11},8
 * 返回:9
 * 解析:这个组装传入的子树根节点，其实就是整颗树，中序遍历{5,6,7,8,9,10,11}，根节点8的下一个节点就是9，应该返回{9,10,11}，
 * 后台只打印子树的下一个节点，所以只会打印9，如下图，其实都有指向左右孩子的指针，还有指向父节点的指针，下图没有画出来
 * */
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class Solution {
    /** 直接还原二叉树,InOrder对二叉树进行中序遍历 n n*/
    public static ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
    public TreeLinkNode GetNext1(TreeLinkNode pNode) {
        TreeLinkNode cur = pNode;
        while(cur.next != null) {
            cur = cur.next;
        }
        InOrder(cur);
        for(int i=0 ; i<list.size()-1 ; i++) {
            if(pNode == list.get(i)) {
                return list.get(i+1);
            }
        }
        return null;
    }

    void InOrder(TreeLinkNode node) {
        if(node != null) {
            InOrder(node.left);
            list.add(node);
            InOrder(node.right);
        }
    }

    /**方法2：直接找下一个
     * 1. 有右子树，则下一个节点是右子树的最左结点
     * 2. 没有右子树，且该结点是其父节点的左子树，，则下一个节点是其父节点
     * 3. 没有左节点，且该结点是其父节点的右子树，则我们一直沿着父节点追溯，直到找到某个结点是其父节点的左子树，
     * 如果存在这样的结点，则此结点的父子书是我们要找的结点*/
    public TreeLinkNode GetNext2(TreeLinkNode pNode) {
        // 1.
        if(pNode.right != null) {
            TreeLinkNode treeLinkNode = pNode.right;
            while(treeLinkNode.left != null) {
                treeLinkNode = treeLinkNode.left;
            }
            return treeLinkNode;
        }

        // 2.
        if(pNode.next != null && pNode.next.left == pNode) {
            return pNode.next;
        }

        // 3.
        if(pNode.next != null) {
            TreeLinkNode treeLinkNode = pNode.next;
            while(treeLinkNode.next != null && treeLinkNode.next.right == treeLinkNode) {
                treeLinkNode = treeLinkNode.next;
            }
            return treeLinkNode.next;
        }
        return null;
    }
}
