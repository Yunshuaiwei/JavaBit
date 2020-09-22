import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/14 18:40
 * @Version
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int k = 0; k < T; k++) {
            int n = input.nextInt();//人数
            int m = input.nextInt();//剧组角色数量
            int[] arrN = new int[n];
            int[] arrM = new int[m];
            for (int i = 0; i < n; i++) {
                arrN[i] = input.nextInt();
            }
            for (int i = 0; i < m; i++) {
                arrM[i] = input.nextInt();
            }
            int [] res=new int[n];
            Arrays.sort(arrM);
            for (int i = 0; i < n; i++) {
                if (arrN[i]<arrM[arrM.length-1]){
                    for (int j = 0; j < m; j++) {
                        if (arrM[j]>=arrN[i]){
                            res[i]+=m-j;
                            break;
                        }
                    }
                }
                System.out.print(res[i]+" ");
            }
//            for (int re : res) {
//                System.out.print(re+" ");
//            }
            System.out.println();
        }
    }
}
