# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        head = ListNode(0)
        res = head
        carry = 0
        while l1 and l2:
            addNum = l1.val + l2.val + carry
            carry = 1 if addNum >= 10 else 0
            head.next = ListNode(addNum % 10)
            head = head.next
            l1, l2 = l1.next, l2.next
        l = l1 if l1 else l2
        while l:
            addNum = l.val + carry
            carry = 1 if addNum >= 10 else 0
            head.next = ListNode(addNum % 10)
            head = head.next
            l = l.next
        if carry:
            head.next = ListNode(1)
        return res.next