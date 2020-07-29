import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/29 17:45
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int x=0;
        int [] ns=new int[n];
        for (int i = 0; i < m; i++) {
            x+=input.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ns[i]=input.nextInt();
        }
        Arrays.sort(ns);
        System.out.println(ns[0]+x);
    }
}
