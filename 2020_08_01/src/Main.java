import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/1 15:46
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int W = input.nextInt();
        int n = input.nextInt();
        int[] p = new int[n];
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = input.nextInt();
            w[i] = input.nextInt();
        }
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= W; j++) {
                if (j < p[i-1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(w[i-1], dp[i - 1][j] + dp[i - 1][W - j]);
                }
            }
        }
        System.out.println(dp[n][W]);
    }

}
