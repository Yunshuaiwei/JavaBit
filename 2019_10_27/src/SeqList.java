import java.util.Arrays;

/**
 * @ProjectName 2019_10_27
 * @ClassName SeqList
 * Description
 * @Auther YunSW
 * @Date 2019/10/27 12:57
 * @Version 1.0
 **/
public class SeqList {
    public static void main(String[] args) {
        MyArrayList lis=new MyArrayList();
        lis.add(0,5);
        lis.add(1,2);
        lis.add(2,3);
        lis.add(3,2);
        lis.add(4,1);
        System.out.println(lis.contains(9));
        System.out.println(lis.search(5));
        System.out.println(lis.getPos(1));
        lis.remove(2);
        System.out.println(lis.size());
        lis.display();
    }
}
class MyArrayList {
    public int usedSize;
    public int[] elem;

    public final int CAPACITY = 10;

    public MyArrayList() {
        this.usedSize = 0;
        this.elem = new int[CAPACITY];
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        //1、pos是否合法
        if(pos<0||pos>usedSize){
            System.out.println("插入位置不合法！");
            return;
        }
        //2、挪数据
        if(usedSize==elem.length){
            int []tmp=new int[elem.length*2];
            System.arraycopy(elem,0,tmp,0,usedSize);
            this.elem=tmp;
        }
        //3、插入数据
        int tmp=usedSize;
        while(usedSize!=pos){
            elem[tmp+1]=elem[tmp--];
        }
        elem[pos]=data;
        //4、usedSize++
        usedSize++;
        System.out.println("插入成功");
    }
    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i <usedSize ; i++) {
            if(this.elem[i]==toFind){
                return true;
            }
        }
        return false;
    }
    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i <usedSize ; i++) {
            if(elem[i]==toFind){
                return i;
            }
        }
        return -1;
    }
    // 获取 pos 位置的元素
    public int getPos(int pos) {
        if(pos<0||pos>this.usedSize){
            System.out.println("位置不合法！");
            return -1;
        }
        return this.elem[pos];
    }
    // 给 pos 位置的元素设为 value
    // public void setPos(int pos, int value) { }
    //删除第一次出现的关键字key
    public void remove(int toRemove) {
        if(usedSize==0){
            return;
        }
        int a=search(toRemove);
        if(a<0){
            System.out.println("没有你要删除的数据！");
            return;
        }else{
            for(int i=a;i<this.usedSize-1;i++){
                this.elem[i]=this.elem[i+1];
            }
            this.usedSize--;
        }
    }
    // 获取顺序表长度
    public int size() {
        return usedSize;
    }
    // 清空顺序表
    public void clear() {
        this.usedSize=0;
    }
    // 打印顺序表
    public void display() {
        for (int i = 0; i <usedSize ; i++) {
            System.out.print(elem[i]);
        }
    }
}