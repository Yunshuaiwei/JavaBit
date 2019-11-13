///**
// * @ProjectName 2019_10_27
// * @ClassName Test
// * Description
// * @Auther YunSW
// * @Date 2019/11/1 15:20
// * @Version 1.0
// **/
//public class Test {
//    private ListNode searchPrev(int key) {
//        ListNode prev = this.head;
//        //prev.next  头已经判断了
//        while (prev.next != null) {
//            if(prev.next.data == key) {
//                return prev;
//            }
//            prev = prev.next;
//        }
//        return null;
//    }
//
//    //删除第一次出现关键字为key的节点
//    public void remove(int key){
//        if(this.head == null) {
//            System.out.println("单链表为空");
//            return;
//        }
//        //0、删除的节点是否是头结点
//        if(this.head.data == key) {
//            this.head = this.head.next;
//            return;
//        }
//
//        //1、找到key的前驱  如果返回空
//        ListNode prev = searchPrev(key);
//        if(prev == null) {
//            return;
//        }
//        //2、删除节点
//        ListNode del = prev.next;
//        prev.next = del.next;
//    }
//
//    //删除所有值为key的节点
//    public void removeAllKey(int key){
//        ListNode prev = this.head;
//        ListNode cur = this.head.next;
//        while (cur != null) {
//            if(prev.next.data == key){
//                prev.next = cur.next;
//                cur = cur.next;
//            }else {
//                prev = cur;
//                cur = cur.next;
//            }
//        }
//        if(this.head.data == key) {
//            this.head = this.head.next;
//        }
//    }
//    //反转单链表
//    public ListNode reverseList() {
//        ListNode prev = null;
//        ListNode newHead = null;
//        ListNode cur = this.head;
//        while (cur != null) {
//            ListNode curNext = cur.next;
//            if(curNext == null) {
//                newHead = cur;
//            }
//            cur.next = prev;
//            prev = cur;
//            cur = curNext;
//        }
//        return newHead;
//    }
//
//    public void display2(ListNode newHead) {
//        ListNode cur = newHead;
//        while (cur != null) {
//            System.out.print(cur.data+" ");
//            cur = cur.next;
//        }
//        System.out.println();
//    }
//
//    //单链表的中间节点
//    public ListNode middleNode() {
//        ListNode fast = this.head;
//        ListNode slow = this.head;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
//    }
//
//    public ListNode findKthToTail(int k){
//        // k > getLength()
//        if(k <= 0) {
//            return null;
//        }
//        ListNode fast = this.head;
//        ListNode slow = this.head;
//        while (k-1 > 0) {
//            if(fast.next != null) {
//                fast = fast.next;
//                k--;
//            }else {
//                System.out.println("没有这个节点");
//                return null;
//            }
//        }
//        while (fast.next != null) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        return slow;
//
//    }
//}
