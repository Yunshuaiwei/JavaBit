/**
 * @ProjectName Bit
 * @ClassName SignalListTest2
 * Description
 * @Auther YunSW
 * @Date 2019/11/12 14:51
 * @Version 1.0
 **/
public class SignalListTest2 {
    public static void main(String[] args) {
        MySignalList3 list3 = new MySignalList3();
        list3.addLast(1);
        list3.addLast(2);
        list3.addLast(3);
        list3.addLast(21);
        list3.addLast(5);

        list3.display();
    }
    //合并两个有序单链表
    public static ListNode3 mergeTwoLists(ListNode3 headA,ListNode3 headB){
        ListNode3 node=new ListNode3(-1);
        ListNode3 tmp=node;
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
            tmp.next=headA;
        }
        if((headB != null)){
            tmp.next=headB;
        }
        return node.next;
    }
    //两个单链表的交点
    public static ListNode3 getIntersectionNode(ListNode3 headA,ListNode3 headB){
        if(headA==null||headB==null){
            return null;
        }
        ListNode3 pL=headA;
        ListNode3 pS=headB;
        int lenA = 0;
        ListNode3 tmp1=headA;
        while(tmp1!=null){
            lenA++;
            tmp1=tmp1.next;
        }
        int lenB=0;
        ListNode3 tmp2=headB;
        while(tmp2!=null){
            lenB++;
            tmp2=tmp2.next;
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
class ListNode3{
    public int data;
    public ListNode3 next;
    public ListNode3(int data){
        this.data=data;
        this.next=null;
    }
}
class MySignalList3{
    public ListNode3 head;

    public MySignalList3() {
        this.head = null;
    }
    //尾插法
    public void addLast(int data){
        ListNode3 node= new ListNode3(data);
        ListNode3 cur=this.head;
        if(this.head==null){
            this.head=node;
        }else{
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    public void display(){
        ListNode3 cur=this.head;
        while(cur!=null){
            System.out.printf("%d\t",cur.data);
            cur=cur.next;
        }
        System.out.println();
    }
    //删除诶一次出现关键字key
    public void remove(int key){
        if(this.head==null){
            return;
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
        ListNode3 prev=searchPrev(key);
        if(prev!=null){
            prev.next=prev.next.next;
        }else{
            return;
        }
    }
    private ListNode3 searchPrev(int key){
        ListNode3 cur=this.head;
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
        ListNode3 prev=this.head.next;
        ListNode3 cur=prev.next;
        if(this.head==null){
            return;
        }
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
    public ListNode3 reverseList(){
        ListNode3 cur=this.head;
        ListNode3 prev=null;
        ListNode3 newHead=null;
        while(cur!=null){
            ListNode3 curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=prev.next;
            cur=curNext;
        }
        return newHead;
    }
    //返回中间元素
    public ListNode3 middleNode(){
        ListNode3 fast=this.head;
        ListNode3 slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    //找到到时第k个节点
    public ListNode3 findKithTtail(int k){
        if(k<0){
            return null;
        }
        ListNode3 fast=this.head;
        ListNode3 slow=this.head;
        while(k-1>0){
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else{
                return null;
            }
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    //将有序链表分为大于x和小于x两部分，并且不改变以前的顺序
    public ListNode3 partion(int x){
        ListNode3 cur=this.head;
        ListNode3 beforeStart=null;
        ListNode3 beforeEnd=null;
        ListNode3 afterStart=null;
        ListNode3 afterEnd=null;
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
    public ListNode3 daleteDuplication(){
        ListNode3 cur=this.head;
        ListNode3 node=new ListNode3(-1);
        ListNode3 tmp=node;
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
        ListNode3 fast=this.head;
        ListNode3 slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode3 tmp=slow.next;
        while(tmp!=null){
            ListNode3 tmpNext=tmp.next;
            tmp.next=slow;
            slow=tmp;
            tmp=tmpNext;
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
    //判断单链表是否有环
    public boolean hasCycle(){
        ListNode3 fast=this.head;
        ListNode3 slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    //环的入口
    public ListNode3 dateCycle(){
        ListNode3 fast=this.head;
        ListNode3 slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
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
}