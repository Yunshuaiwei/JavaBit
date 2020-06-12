import java.util.Scanner;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/12 18:43
 * @Version
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = input.nextInt();
        }
        for (int i = 0; i < length; i++) {
            System.out.println(findL(arr, arr[i], i) + " " + findR(arr, arr[i], i));
        }
    }

    public static int findL(int[] arr, int target, int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (arr[i] < target) {
                return i;
            }
        }
        return -1;
    }

    public static int findR(int[] arr, int target, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] < target) {
                return i;
            }
        }
        return -1;
    }
}
