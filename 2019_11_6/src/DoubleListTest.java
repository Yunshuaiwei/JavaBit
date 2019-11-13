/**
 * @ProjectName Bit
 * @ClassName DoubleListTest
 * Description
 * @Auther YunSW
 * @Date 2019/11/6 21:04
 * @Version 1.0
 **/
public class DoubleListTest {
    public static void main(String[] args) {
        DoubleList list=new DoubleList();
        list.addLast(1);
        list.addLast(1);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
//        list.addIndex(5,1);
//        int remove = list.remove(1);
//        System.out.println(remove);
//        list.removeAllKey(1);
//        list.display();
        list.clearList();
        System.out.println("hhhhh");
    }
}
class ListNode {
    public int data;
    public ListNode prev;//前驱
    public ListNode next;//后继
    //new ListNode(10);
    public ListNode(int data) {
        this.data = data;
    }
}

class DoubleList {
    public ListNode head;//头
    public ListNode last;//尾巴

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head==null){
            this.head=node;
            this.last=null;
        }else{
            node.next=this.head;
            this.head.prev=node;
            this.head=node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode node=new ListNode(data);
        if(this.head==null){
            this.head=node;
            this.last=node;
        }else{
            this.last.next=node;
            node.prev=this.last;
            this.last=node;
        }
    }
    //打印
    public void display(){
        ListNode cur=this.head;
        if(this.head==null){
            return;
        }
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }
    //链表长度
    public int getLength(){
        ListNode cur=this.head;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }
    //任意位置插入
    private ListNode searchIndex(int index) {
        ListNode cur=this.head;
        while(index>0){
            cur=cur.next;
            index--;
        }
        return cur;
    }
    public void addIndex(int index, int data){
        ListNode node=new ListNode(data);
        if(index<0||index>getLength()){
            return;
        }
        if(index==0){
            addFirst(data);
        }
        ListNode listNode = searchIndex(index);
        if(index==getLength()){
            addLast(data);
        }else{
            listNode.prev.next=node;
            node.prev=listNode.prev;
            node.next=listNode;
            listNode.prev=node;
        }
    }
    //删除第一次出现关键字为key的节点
    //返回要删除的数字
    public int remove(int key){
        int oldData=-1;
        ListNode cur=this.head;
        while(cur!=null) {
            if (cur.data == key) {
                oldData = cur.data;
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                    return oldData;
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                    return oldData;
                }
            }
            cur=cur.next;
        }
        return oldData;
    }
    //删除所有key
    public void removeAllKey(int key){
        ListNode cur=this.head;
        while(cur!=null) {
            if (cur.data == key) {
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        this.last = cur.prev;
                    }
                }
            }
            cur=cur.next;
        }
    }
    //clear()
    public void clearList(){
        ListNode cur=this.head;
        while(cur!=null){
            if(cur.next!=null){
                cur=cur.next;
                cur.prev.next=null;
                cur.prev=null;
            }else{
                if (cur.prev != null) {
                    cur.prev.next=null;
                }
                cur.prev=null;
            }
        }
    }
}