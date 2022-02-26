/**
*  struct ListNode {
*        int val;
*        struct ListNode *next;
*        ListNode(int x) :
*              val(x), next(NULL) {
*        }
*  };
*/
class Solution {
public:
    vector<int> printListFromTailToHead(ListNode* head) {
        ListNode* pre = nullptr;
        ListNode* cur = head;
        ListNode* temp = cur;
        while (cur) {
            temp = cur->next; //需要现保存一下，不然断开了就找不到了
            cur->next = pre;
            pre = cur; // pre 和 cur分别向右边平移
            cur = temp;
        }
        vector<int> ret;
        while (pre) {
            ret.push_back(pre->val);
            pre = pre->next;
        }
        return ret;
    }
};