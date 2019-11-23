import com.sun.media.sound.SoftTuning;

/**
 * @Auther
 * @Date 2019/11/23 14:19
 **/
public class SignalListTest5 {
    public static void main(String[] args) {
        MyList5 list5 = new MyList5();
        list5.addLast(1);
        list5.addLast(2);
        list5.addLast(4);
        list5.addLast(6);
        list5.addLast(2);
        list5.addLast(8);
        list5.display(list5.head);
    }
    public static ListNode5 getIntersectionNode(ListNode5 headA,ListNode5 headB){
        if(headA==null||headB==null){
            return null;
        }
        ListNode5 pL=headA;
        ListNode5 pS=headB;
        int lenA=0;
        ListNode5 tmp1=pL;
        while(tmp1!=null){
            tmp1=tmp1.next;
            lenA++;
        }
        int lenB=0;
        ListNode5 tmp2=pS;
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
        while(pL!=null&&pS!=null){
            pL=pL.next;
            pS=pS.next;
        }
        if(pL==pS&&pS!=null){
            return pL;
        }
        return null;
    }
    public static ListNode5 mergeTwoLists(ListNode5 headA,ListNode5 headB){
        ListNode5 node=new ListNode5(-1);
        ListNode5 tmp=node;
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
        if(headB!=null){
            tmp.next=headB;
        }
        return node.next;
    }

}
class ListNode5 {
    public int data;
    public ListNode5 next;

    public ListNode5(int data) {
        this.data = data;
        this.next = null;
    }
}//节点类
class MyList5{
    ListNode5 head;
    /**
     * 尾插法
     * @param data
     */
    public void addLast(int data){
        ListNode5 node=new ListNode5(data);
        ListNode5 cur=this.head;
        if(this.head==null){
            this.head=node;
        }else{
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    public void display(ListNode5 node){
        ListNode5 cur=node;
        if(cur==null){
            return;
        }
        while(cur!=null){
            System.out.print(cur.data+"  ");
            cur=cur.next;
        }
        System.out.println();
    }
    //删除第一次出现关键字key的节点
    //key的前驱节点
    private ListNode5 searchPrev(int key){
        ListNode5 cur=this.head;
        while(cur.next.data!=key){
            cur=cur.next;
            if(cur.next==null){
                return null;
            }
        }
        return cur;
    }
    public void remove(int key){
        if(this.head==null){
            System.out.println("单链表为空！");
            return;
        }
        ListNode5 lis=searchPrev(key);
        if(lis==null){
            return;
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
        lis.next=lis.next.next;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode5 prev=this.head.next;
        ListNode5 cur=this.head;
        while(cur.next.data==key){
            cur.next=prev.next;
            prev=prev.next;
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
    }
    public ListNode5 reverseList(){
        ListNode5 prev=null;
        ListNode5 newHead=null;
        ListNode5 cur=this.head;
        while(cur!=null){
            ListNode5 curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return newHead;
    }
    //单链表的中间节点
    public ListNode5 middleNode() {
        ListNode5 fast = this.head;
        ListNode5 slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode5 findKtjTotail(int k){
        if(k<0){
            return null;
        }
        ListNode5 fast=this.head;
        ListNode5 slow=this.head;
        while(k-1>0){
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else{
                System.out.println("没有这个节点！");
            }
        }
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
    public ListNode5 partition(int x){
        ListNode5 cur=this.head;
        ListNode5 beforeStart=null;
        ListNode5 beforeEnd=null;
        ListNode5 afterStart=null;
        ListNode5 afterEnd=null;
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
    public ListNode5 daleteDuplication(){
        ListNode5 node=new ListNode5(-1);
        ListNode5 cur=this.head;
        ListNode5 tmp=node;
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
    public boolean chkPalindrome(){
        ListNode5 fast=this.head;
        ListNode5 slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode5 p=slow.next;
        while(p!=null){
            ListNode5 pNext=p.next;
            p.next=slow;
            slow=p;
            p=pNext;
        }
        while(this.head!=null){
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
    public boolean hasCycle(){
        ListNode5 fast=this.head;
        ListNode5 slow=this.head;
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
        ListNode5 cur=this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=this.head.next;
    }
    public ListNode5 detectCycle(){
        ListNode5 fast=this.head;
        ListNode5 slow=this.head;
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
}