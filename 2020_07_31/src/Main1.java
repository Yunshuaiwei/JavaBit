import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/31 13:58
 * @Version
 **/
public class Main1 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }
        int k = input.nextInt();
        int res = 0;
        while (k > 0) {
            if (k - 100 >= 0 && arr[4] > 0) {
                arr[4] = arr[4] - 1;
                res++;
                k -= 100;
                continue;
            }
            if (k - 50 >= 0 && arr[3] > 0) {
                arr[3] = arr[3] - 1;
                res++;
                k -= 50;
                continue;
            }
            if (k - 10 >= 0 && arr[2] > 0) {
                arr[2] = arr[2] - 1;
                res++;
                k -= 10;
                continue;
            }
            if (k - 5 >= 0 && arr[1] > 0) {
                arr[1] = arr[1] - 1;
                res++;
                k -= 5;
                continue;
            }
            if (arr[0] > 0) {
                arr[0] = arr[0] - 1;
                res++;
                k -= 1;
            }else{
                res=-1;
                break;
            }
        }
        System.out.println(res);
    }
}
