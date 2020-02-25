import com.sun.media.sound.SoftTuning;

/**
 * @ProjectName JavaBit
 * @ClassName TestDemo1
 * Description
 * @Auther YunSW
 * @Date 2019/11/16 9:24
 * @Version 1.0
 * 1、接口关键字为interface
 * 2、接口当中的方法不能有具体的实现，默认为public abstract；
 * 3、阿里巴巴：接口当中的方法尽量简洁
 * 4、接口当中的成员变量默认为 public static final
 * 5、不能实例化
 * 6、接口之间可以继承
 * 7、自定义类型进行排序需要实现comparable接口，并重写compareTo方法
 * 8、空接口，Cloneable接口：标志此方法可以被克隆
 **/

/**
 * @author
 */
public class TestDemo1 {

    public static void main(String[] args) {
        int [] arr=new int[]{6,5,3,4,1,2};
        display(arr);
        sort(arr);
        display(arr);
    }
    public static int [] sort(int [] arr){
        boolean flag=true;
        for (int i = 0; i <arr.length-1; i++) {
            for (int j = 0; j <arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                    flag=false;
                }
            }
            if(flag){
                break;
            }
        }
        return arr;
    }
    public static void display(int [] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
    }
}
