import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/8 17:13
 * @Version
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str=input.nextLine();
        String[] arr = str.split(" ");
        int [] res=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if (s.length()>=8&&s.length()<=120){
                if (method(s)){
                    res[i]=0;
                }else{
                    res[i]=2;
                }
            }else{
                res[i]=1;
            }
        }
        for (int re : res) {
            System.out.println(re);
        }
    }
    private static boolean method(String str){
        boolean [] flag=new boolean[4];
        for (int i=0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!flag[0]&&c>=48&&c<=57){
                flag [0]=true;
            }else if (!flag[1]&&c>=65&&c<97){
                flag[1]=true;
            }else if (!flag[2]&&c>=97&&c<=122){
                flag[2]=true;
            }else{
                flag[3]=true;
            }
        }
        for (int i = 0; i < flag.length; i++) {
            if (!flag[i]){
                return false;
            }
        }
        return true;
    }
}
