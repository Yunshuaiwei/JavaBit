/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/10 17:08
 * @Version
 **/
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newNode = null;
        ListNode cur = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (newNode == null) {
                    newNode = new ListNode(l1.val);
                    cur = newNode;
                } else {
                    cur.next = new ListNode(l1.val);
                    cur = cur.next;
                }
                l1 = l1.next;
            } else {
                if (newNode == null) {
                    newNode = new ListNode(l2.val);
                    cur = newNode;
                } else {
                    cur.next = new ListNode(l2.val);
                    cur = cur.next;
                }
                l2 = l2.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return newNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
