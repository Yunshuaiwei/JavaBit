import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/26 20:40
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] nums = new int[m];
        int[] money = new int[m];
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = input.nextInt();
        }
        for (int i = 0; i < m; i++) {
            nums[i] = input.nextInt();
            money[i] = input.nextInt();
        }

    }

}
