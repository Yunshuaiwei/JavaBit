/**
 * @author DELL
 * @Date 2019/12/25 17:04
 **/
public class MyLinkedList {

    /** Initialize your data structure here. */
    class Node{
        private int val;
        private Node next;
        public Node(int val){
            this.val=val;
            this.next=null;
        }
    }
    private int size;
    private Node head=null;
    public MyLinkedList() {
        head=new Node(-1);
        size=0;
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0||index>size){
            return -1;
        }
        Node cur=head;
        for(int i=0;i<size;i++){
            cur=cur.next;
        }
        return cur.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node =new Node(val);
        node.next=head;
        head=node;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node cur=head;
        Node node=new Node(val);
        if(cur.next==null){
            cur.next=node;
            size++;
        }
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index==size){
            addAtTail(val);
        }
        if(index>size){
            return;
        }
        if(index<0){
            addAtHead(val);
        }
        Node cur=head;
        Node node = new Node(val);
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        Node nodeNext=cur.next;
        cur.next=node;
        node.next=nodeNext;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0||index>size){
            return;
        }
        Node cur=head;
        for(int i=0;i<index-1;i++){
            cur=cur.next;
        }
        cur=cur.next.next;
    }
}