import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/31 14:47
 * @Version
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = input.nextInt();
        }

        int Ax1 = arr[0];
        int Ay1 = arr[3];
        int Ax2 = arr[2];
        int Ay2 = arr[1];

        int Bx1 = arr[4];
        int By1 = arr[7];
        int Bx2 = arr[6];
        int By2 = arr[5];
        int res = 1;
        if (Bx2 >= Ax1) {
            res = 0;
        } else if (By2 >= Ay1) {
            res = 0;
        } else if (Bx1 <= Ax2) {
            res = 0;
        } else if (By1 <= Ay2) {
            res = 0;
        } else {
            res = 1;
        }
        System.out.println(res);
    }
}
