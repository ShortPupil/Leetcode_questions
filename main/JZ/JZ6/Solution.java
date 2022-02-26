package code.JZ6;
import java.util.ArrayList;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}


/**输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
 * 倒序打印链表*/

public class Solution {
    /**利用arraylist特性，直接在表头插入元素 时间n 空间n*/
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(listNode != null) {
            res.add(0, listNode.val);
            listNode = listNode.next;
        }
        return res;
    }
    /**简单递归方法实现 时间n 空间n 效率很差*/
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(listNode != null) {
            res.add(0, listNode.val);
            listNode = listNode.next;
        }
        return res;
    }

    /**反转链表自实现*/
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ListNode pre = null;
        ListNode cur = listNode;
        ListNode tmp = cur;
        while(cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(pre != null) {
            res.add(pre.val);
            pre = pre.next;
        }
        return res;
    }
}