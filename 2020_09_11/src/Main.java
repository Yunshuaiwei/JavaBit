import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/11 21:12
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//公司人数
        int m = input.nextInt();//打卡记录条数
        int[][] board = new int[m][2];
        for (int i = 0; i < m; i++) {
            board[i][0] = input.nextInt();
            board[i][1] = input.nextInt();
        }

    }

}
