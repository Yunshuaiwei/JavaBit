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
        l1.addLast(1);
        l1.addLast(2);
        l1.addLast(3);
        l1.addLast(4);
        l1.addLast(5);
        l1.display(l1.head);
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
}