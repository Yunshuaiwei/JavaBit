import javax.swing.*;

/**
 * @ProjectName Bit
 * @ClassName SignalListTest
 * Description
 * @Auther YunSW
 * @Date 2019/11/8 14:09
 * @Version 1.0
 **/
public class SignalListTest {
    public static void main(String[] args) {
        MySignalList1 list=new MySignalList1();
        list.addFirst(6);
        list.addFirst(4);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.display2(list.head);
    }

    public static ListNode1 getIntersectionNode(ListNode1 headA,ListNode1 headB){
        if(headA==null||headB==null){
            return null;
        }
        ListNode1 pL=headA;
        ListNode1 pS=headB;
        int lenA=0;
        ListNode1 tmp1=pL;
        while(tmp1!=null){
            lenA++;
            tmp1=tmp1.next;
        }
        int lenB=0;
        ListNode1 tmp2=pS;
        while(tmp2!=null){
            lenB++;
            tmp2=tmp2.next;
        }
        int len=lenA-lenB;
        if(len<0){
            pL=headB;
            pS=headB;
            len=lenB-lenA;
        }
        while(len>0){
            pL=pL.next;
            len--;
        }
        while(pL!=pS&&pS!=null){
            pL=pL.next;
            pS=pS.next;
        }
        if(pL==pS&&pS!=null){
            return pL;
        }
        return null;
    }
    //相交两个单链表
    public static void interect(ListNode1 headA,ListNode1 headB){
        headA.next.next=headB.next.next.next;
    }
    //合并两个有序单链表
    public static ListNode1 mergeTwoLists(ListNode1 headA,ListNode1 headB){
        ListNode1 node=new ListNode1(-1);
        ListNode1 tmp=node;
        while(headA!=null&&headB!=null){
            if(headA.data<headB.data){
                tmp.next=headA;
                headA=headA.next;
                tmp=tmp.next;
            }else{
                tmp.next=headB;
                headB=headB.next;
                tmp=tmp.next;
            }
        }
        if(headA!=null){
            return headB;
        }
        if(headB!=null){
            return headA;
        }
        return null;
    }
}
class ListNode1 {
    public int data;
    public ListNode1 next;

    public ListNode1(int data) {
        this.data = data;
        this.next = null;
    }
}//节点类

class MySignalList1 {
    public ListNode1 head;

    public MySignalList1() {
        this.head = null;
    }

    //头插法
    public void addFirst(int data) {
        ListNode1 node = new ListNode1(data);
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = head;
            this.head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode1 node = new ListNode1(data);
        ListNode1 cur = this.head;
        if (this.head == null) {
            this.head = node;
        } else {
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }
    public void display2(ListNode1 newHead) {
        ListNode1 cur = newHead;
        while (cur != null) {
            System.out.printf("%d\t", cur.data);
            cur = cur.next;
        }
        System.out.println();
    }
    //找到倒数第k个节点之后的节点
    public ListNode1 findKtjToTail(int k){
        if(k<0){
            return null;
        }
        ListNode1 slow=this.head;
        ListNode1 fast=this.head;
        while(k-1>0){
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else{
                return null;
            }
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    public ListNode1 partition(int x){
        ListNode1 cur=this.head;
        ListNode1 beforeStart=null;
        ListNode1 beforeEnd=null;
        ListNode1 afterStart=null;
        ListNode1 afterEnd=null;
        while(cur!=null){
            if(cur.data<x){
                if(beforeStart==null){
                    beforeStart=cur;
                    beforeEnd=cur;
                }else{
                    beforeEnd.next=cur;
                    beforeEnd=beforeEnd.next;
                }
            }else{
                if(afterStart==null){
                    afterStart=cur;
                    afterEnd=cur;
                }else{
                    afterEnd.next=cur;
                    afterEnd=afterEnd.next;
                }
            }
            cur=cur.next;
        }
        if(beforeStart==null){
            return afterStart;
        }
        beforeEnd.next=afterStart;
        if(afterStart!=null){
            afterEnd.next=null;
        }
        return beforeStart;
    }
    //删除重复节点
    public ListNode1 daleteDuplication(){
        ListNode1 node=new ListNode1(-1);
        ListNode1 cur=this.head;
        ListNode1 tmp=node;
        while(cur!=null){
            if(cur.next!=null&&cur.data==cur.next.data){
                while(cur.next!=null&&cur.data==cur.next.data){
                    cur=cur.next;
                }
                cur=cur.next;
            }else{
                tmp.next=cur;
                cur=cur.next;
                tmp=tmp.next;
            }
        }
        tmp.next=null;
        return node.next;
    }
    //回文
    public boolean chkPalindrome(){
        ListNode1 fast=this.head;
        ListNode1 slow=this.head;
        while(fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode1 p=slow.next;
        while(p!=null){
            ListNode1 pNext=p.next;
            p.next=slow;
            slow=slow.next;
            p=pNext;
        }

        while(this.head!=slow){
            if(this.head.data==slow.data){
                this.head=this.head.next;
                slow=slow.next;
                if(this.head.next==slow&&this.head.data==slow.data){
                    return true;
                }
            }else{
                 return false;
            }
        }
        return true;
    }

    //判断是否有环
    public boolean hasCycle(){
        ListNode1 fast=this.head;
        ListNode1 slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public void creatCycle(){
        ListNode1 cur=this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=this.head.next.next;
    }
    public ListNode1 datactCycle(){
        ListNode1 fast=this.head;
        ListNode1 slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                break;
            }
        }
        if(fast==null||fast.next==null){
            return null;
        }
        slow=this.head;
        while(fast!=null&&fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    //反转单链表
    public ListNode1 reverseList(){
        ListNode1 cur=null;
        ListNode1 prev=this.head;
        ListNode1 newHead=null;
        while(prev!=null){
            ListNode1 prevNext=prev.next;
            if(prevNext==null){
                newHead=prev;
            }
            prev.next=cur;
            cur=prev;
            prev=prevNext;
        }
        return newHead;
    }
}