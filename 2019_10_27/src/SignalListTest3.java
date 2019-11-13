import java.util.List;

/**
 * @ProjectName Bit
 * @ClassName SignalListTest3
 * Description
 * @Auther YunSW
 * @Date 2019/11/13 11:59
 * @Version 1.0
 **/
public class SignalListTest3 {
    public static void main(String[] args) {
        MySignalList4 list4 = new MySignalList4();
        list4.addLast(1);
        list4.addLast(2);
        list4.addLast(3);
        list4.addLast(4);
        list4.addLast(5);
        list4.display();

    }

    //合并两个有序单链表
    public static ListNode4 mergeTwoLists(ListNode4 headA,ListNode4 headB){
        ListNode4 node=new ListNode4(-1);
        ListNode4 tmp=node;
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
            tmp.next=headB;
        }
        if(headB!=null){
            tmp.next=headA;
        }
        return node.next;
    }
    //两个单量表的交点
    public static ListNode4 getIntersectionNode(ListNode4 headA,ListNode4 headB){
        if(headA==null||headB==null){
            return null;
        }
        ListNode4 pL=headA;
        ListNode4 pS=headB;
        int lenA=0;
        ListNode4 tmp1=headA;
        while(tmp1!=null){
            tmp1=tmp1.next;
            lenA++;
        }
        ListNode4 tmp2=headB;
        int lenB=0;
        while(tmp2!=null){
            tmp2=tmp2.next;
            lenB++;
        }
        int len=lenA-lenB;
        if(len<0){
            pL=headB;
            pS=headA;
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
}
class ListNode4{
    public int data;
    public ListNode4 next;
    public ListNode4(int data){
        this.data=data;
        this.next=null;
    }
}
class MySignalList4 {
    public ListNode4 head;

    public MySignalList4() {
        this.head = null;
    }
    //头插法
    public void addFirst(int data){
        ListNode4 node= new ListNode4(data);
        if(this.head==null){
            this.head=node;
        }else{
            node.next=head;
            this.head=node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode4 node= new ListNode4(data);
        ListNode4 cur=this.head;
        if(this.head==null){
            this.head=node;
        }else{
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    //打印
    public void display(){
        ListNode4 cur=this.head;
        while(cur!=null){
            System.out.printf("%d\t",cur.data);
            cur=cur.next;
        }
        System.out.println();
    }
    //删除第一次出现关键字key
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
        ListNode4 prev=searchPrev(key);
        if(prev==null){
            return;
        }else{
            prev.next=prev.next.next;
        }
    }
    private ListNode4 searchPrev(int key){
        ListNode4 cur=this.head;
        while(cur!=null){
            if(cur.next.data==key){
                return cur;
            }
            cur=cur.next;
        }
        return null;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode4 prev=this.head.next;
        ListNode4 cur=prev.next;
        while(cur!=null){
            if(prev.next.data==key){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
    }
    //反转单链表
    public ListNode4 reverseList(){
        ListNode4 cur=this.head;
        ListNode4 prev=null;
        ListNode4 newHead=null;
        while(cur!=null){
            ListNode4 curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return newHead;
    }
    //返回中间元素
    public ListNode4 middleNode(){
        ListNode4 fast=this.head;
        ListNode4 slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //找倒数第k个节点
    public ListNode4 findKithTotail(int k){
        if(k<0){
            return null;
        }
        ListNode4 fast=this.head;
        ListNode4 slow=this.head;
        while(k-1>0){
            fast=fast.next;
            k--;
        }
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //将有序链表分为大于x和小于x两部分，不改变之前的顺序
    public ListNode4 partion(int x){
        ListNode4 cur=this.head;
        ListNode4 beforeStart=null;
        ListNode4 beforeEnd=null;
        ListNode4 afterStart=null;
        ListNode4 afterEnd=null;
        while(cur!=null){
            if(cur.data<x){
                if(beforeStart==null){
                    beforeStart=cur;
                    beforeEnd=cur;
                }else{
                    beforeEnd.next=cur;
                    beforeEnd=cur;
                }
            }else{
                if(afterStart==null){
                    afterStart=cur;
                    afterEnd=cur;
                }else{
                    afterEnd.next=cur;
                    afterEnd=cur;
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
    public ListNode4 daleteDuplication(){
        ListNode4 cur=this.head;
        ListNode4 node=new ListNode4(-1);
        ListNode4 tmp=node;
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
    public boolean chkPalindroma(){
        ListNode4 fast=this.head;
        ListNode4 slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode4 p=slow.next;
        while(p!=null){
            ListNode4 pNext=p.next;
            p.next=slow;
            slow=p;
            p=pNext;
        }
        while(this.head!=slow){
            if(this.head.data==slow.data){
                slow=slow.next;
                this.head=this.head.next;
                if(this.head.next==slow&&this.head.data==slow.data){
                    return true;
                }
            }else{
                return false;
            }
        }
        return true;
    }
    //判断链表是否有环
    public boolean hasCycle(){
        ListNode4 fast=this.head;
        ListNode4 slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    //找环的入口
    public ListNode4 datectCycle(){
        ListNode4 fast=this.head;
        ListNode4 slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||slow==null){
            return null;
        }
        slow=this.head;
        while(fast!=slow&&fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}