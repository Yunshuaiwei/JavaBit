import java.rmi.activation.ActivationGroup_Stub;

/**
 * @ProjectName JavaBit
 * @ClassName SignalListTest4
 * Description
 * @Auther YunSW
 * @Date 2019/11/15 20:58
 * @Version 1.0
 **/
public class SignalListTest4 {
    public static void main(String[] args) {
        SignalTest l1=new SignalTest();
        SignalTest l2=new SignalTest();
        l1.addLast(1);
        l1.addLast(5);
        l1.addLast(9);
        l2.addLast(2);
        l2.addLast(6);
        l2.addLast(10);
        l1.display(mergeTwoLists(l1.head,l2.head));
    }
    public static Node mergeTwoLists2(Node headA,Node headB){
        Node node=new Node(-1);
        Node tmp=node;
        while(headA!=null&&headB!=null){
            if(headA.val<headB.val){
                tmp.next=headA;
                headA=headA.next;
                tmp=tmp.next;
            }else{
                tmp.next=headB;
                headB=headB.next;
                tmp=tmp.next;
            }
        }
        if(headA==null){
            tmp.next=headB;
        }
        if(headB==null){
            tmp.next=headA;
        }
        return node.next;
    }
    public static Node mergeTwoLists(Node headA,Node headB){
        Node node=new Node(-1);
        Node tmp=node;
        while(headA!=null&&headB!=null){
            if(headA.val<headB.val){
                tmp.next=headA;
                headA=headA.next;
                tmp=tmp.next;
            }else{
                tmp.next=headB;
                headB=headB.next;
                tmp=tmp.next;
            }
        }
        if(headA==null){
            tmp.next=headB;
        }
        if(headB==null){
            tmp.next=headA;
        }
        return node.next;
    }
    public static Node getIntersectionNode2
            (Node headA,Node headB){
        if(headA==null||headB==null){
            return null;
        }
        Node pL=headA;
        Node pS=headB;
        Node tmp1=headA;
        int lenA=0;
        while(tmp1!=null){
            tmp1=tmp1.next;
            lenA++;
        }
        Node tmp2=headB;
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
        if(pS==pL&&pS!=null){
            return pS;
        }
        return null;
    }
}
class Node{
    public int val;
    public Node next;
    Node(int val){
        this.val=val;
        this.next=null;
    }
}
class SignalTest{
    public Node head=null;
    public void addLast(int val){
        Node node=new Node(val);
        Node cur=this.head;
        if(this.head==null){
            this.head=node;
        }else{
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    public void display(Node node){
        Node cur=node;
        if(cur==null){
            return;
        }
        while(cur!=null){
            System.out.print(cur.val+"  ");
            cur=cur.next;
        }
    }
    public Node reverseList(){
        Node cur=this.head;
        Node prev=null;
        Node newHead=null;
        while(cur!=null){
            Node curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;
        }
        return newHead;
    }
}