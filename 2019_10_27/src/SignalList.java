/**
 * @ProjectName 2019_10_27
 * @ClassName SignalList
 * Description
 * @Auther YunSW
 * @Date 2019/10/27 15:07
 * @Version 1.0
 **/
public class SignalList {
    public static void main(String[] args) {
        MySignalList lis=new MySignalList();
        lis.addFirst(3);
        lis.addFirst(2);
        lis.addFirst(1);
        lis.addLast(4);
        lis.addLast(5);
//        lis.addLast(6);
//        lis.remove(6);
        lis.display();
//        lis.removeAllKey(1);
//        lis.display();
//        ListNode listNode = lis.reverseList();
//        lis.display2(listNode);
        System.out.println(lis.middleNode().data);
    }
    //两个单链表的交点
    public static ListNode getIntersectionNode
    (ListNode headA,ListNode headB){
        if(headA==null||headB==null){
            return null;
        }
        //永远指向最长的单链表
        ListNode pL=headA;
        //永远指向最短的单链表
        ListNode pS=headB;

        int lenA=0;
        ListNode tmp1=pL;
        while(tmp1!=null){
            lenA++;
            tmp1=tmp1.next;
        }
        int lenB=0;
        ListNode tmp2=pS;
        while(tmp2!=null){
            lenB++;
            tmp2=tmp2.next;
        }
        //求长度的差值
        int len=lenA-lenB;
        if(len<0){
            pL=headB;
            pS=headA;
            len=lenB-lenA;
        }
        //让pL走len步
        while(len>0){
            pL=pL.next;
            len--;
        }
        //两个同时走
        while(pL!=pS&&pS!=null){
            pL=pL.next;
            pS=pS.next;
        }
        if(pL==pS&&pS!=null){
            return pL;
        }
        return null;
    }
    //合并两个有序单链表
    public static ListNode mergeTwoLists(ListNode headA,ListNode headB){
        ListNode node=new ListNode(-1);
        ListNode tmp=node;
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
        return null;
    }

//    public static ListNode mergeTwoLists2(ListNode headA,ListNode headB){
//        ListNode tmp=new ListNode(-1);
//        while(headA!=null&&headB!=null){
//            if(headA.data<headB.data){
//                tmp.next=headA;
//                headA=headA.next;
//                tmp=tmp.next;
//            }else{
//
//            }
//        }
//    }



}
class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}//节点类

class MySignalList {
    public ListNode head;

    public MySignalList() {
        this.head = null;
    }
    private ListNode searchIndex(int index) {
        ListNode cur = this.head;
        //cur -> index-1
        int count=0;
        while(count<index-1){
            count++;
            cur=cur.next;
        }
//        while(cur.next!=null){
//            cur=cur.next;
//            if(count==index-1){
//                break;
//            }
//            count++;
//        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        if(index <  0 || index > getLength()) {
            System.out.println("index不合法！");
            return false;
        }
        if(index == 0) {
            addFirst(data);
            return true;
        }
        //找到index-1的位置
        ListNode cur = searchIndex(index);
        ListNode node=new ListNode(data);
        node.next=cur.next;
        cur.next=node;
        return true;
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head==null){
            this.head=node;
        }else{
            node.next=head;
            this.head=node;
        }
    }

    //尾插法
    public void addLast(int data){
        ListNode node=new ListNode(data);
        ListNode cur=this.head;
        if(this.head==null){
            this.head=node;
        }else{
            while(cur.next!=null){
                cur=cur.next;
            }
            cur.next=node;
        }
    }
    //查找
//    public boolean contains(int key){
//        ListNode cur=this.head;
//        while(cur.data!=key){
//            cur=cur.next;
//            if(cur.next==null){
//                return false;
//            }
//        }
//        return true;
//    }

    //获得链表长度
    public int getLength(){
        int count=0;
        ListNode cur=this.head;
        while(cur.next!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }

    //打印
    public void display(){
        ListNode cur=this.head;
        while(cur.next!=null){
            System.out.printf("%d\t",cur.data);
            cur=cur.next;
        }
        System.out.print(cur.data);
        System.out.println();
    }
    public void display2(ListNode newHead){
        ListNode cur=newHead;
        while(cur!=null){
            System.out.printf("%d\t",cur.data);
            cur=cur.next;
        }
        System.out.println();
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur=this.head;
        while(cur.data!=key){
            cur=cur.next;
            if(cur.next==null){
                return false;
            }
        }
        return true;
    }
    private ListNode searchPrev(int key) {
        ListNode cur =this.head;
        while(cur.next.data!=key){
            cur=cur.next;
            if(cur.next==null){
                return null;
            }
        }
        return cur;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head == null) {
            System.out.println("单链表为空");
            return;
        }
        //0、删除的节点是否是头结点
        if(this.head.data == key) {
            this.head = this.head.next;
            return;
        }
        //1、找到key的前驱  如果返回空
        ListNode prev = searchPrev(key);
        if(prev==null){
            System.out.println("没有该元素！");
            return;
        }
        //2、删除节点
        prev.next=prev.next.next;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        ListNode prev=this.head.next;
        ListNode cur=prev.next;
        if(this.head==null){
            return;
        }
        while(cur.next!=null){
            if(prev.next.data==key){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
//            if(prev.next.data!=key){
//                prev=cur;
//                cur=cur.next;
//            }
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
    }

    //反转单链表
    public ListNode reverseList(){
        ListNode prev=null;
        ListNode newHead=null;
        ListNode cur=this.head;
        while(cur!=null){
            ListNode curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return newHead;
    }
    //返回中间元素
    public ListNode middleNode(){
        ListNode slow=this.head;
        ListNode fast=this.head;
        if(slow.next==null){
            return null;
        }
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    //找倒数第k个节点
    public ListNode findKithToTail(int k){
        if(k<0){
            return null;
        }
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(k-1>0){
            if(fast.next!=null){
                fast=fast.next;
                k--;
            }else{
                System.out.println("没有这个节点！");
            }
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
    //将链表分为大于x和小于x两部分，并且不改变以前的顺序
    public ListNode partition(int x){
        ListNode cur=this.head;
        ListNode beforeStart=null;
        ListNode beforeEnd=null;
        ListNode afterStart=null;
        ListNode afterEnd=null;
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
    public ListNode daleteDuplication(){
        ListNode node=new ListNode(-1);
        ListNode cur=this.head;
        ListNode tmp=node;
        while(cur!=null){
            if(cur.next!=null&&cur.data==cur.next.data){
                while(cur.next!=null&&cur.data==cur.next.data){
                    cur=cur.next;
                }
                cur=cur.next;
            }else{
                //当前节点不等于下一个节点
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
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //反转
        ListNode p=slow.next;
        while(p!=null){
            ListNode pNext=p.next;
            //反转
            p.next=slow;
            slow=p;
            p=pNext;
        }
        //slow往前    head 往后  .data不一样 返回false
        //直到相遇
        while(this.head!=slow){
            if(this.head.data==slow.data){
                this.head=this.head.next;
                slow=slow.next;
                //偶数
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
        ListNode fast=this.head;
        ListNode slow=this.head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    //创建一个环
    public void creatCycle(){
        ListNode cur=this.head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=this.head.next.next;
    }
    //环的入口
    public ListNode detectCycle(){
        ListNode fast=this.head;
        ListNode slow=this.head;
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
    public ListNode reverseList2(){
        ListNode prev=null;
        ListNode cur=this.head;
        ListNode newHead=null;
        while(cur!=null){
            ListNode newNext=cur.next;
            if(newNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=newNext;
        }
        return newHead;
    }
    //11月8日

}//单链表
