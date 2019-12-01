import com.sun.media.sound.SoftTuning;

/**
 * @author DELL
 * @Date 2019/12/1 17:47
 **/
public class DemoTest {

    public static void main(String[] args) {
        int [] arr1=new int[]{2,4,6,8};
        int [] arr2=new int[]{1,3,6,9};
        int j=0;
        String arr="";
        for (int i = 0; i <arr1.length ; i++) {
            for (; j <arr2.length ; j++) {
                if(arr1[i]<arr2[j]){
                    arr+=arr1[i];
                    break;
                }else{
                    arr+=arr2[j];
                }
            }
        }
        System.out.println(arr);
    }
}
