import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/18 18:21
 * @Version
 **/
public class Main2 {
    static int res = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int money = input.nextInt();
        String str = input.next();
        String[] split = str.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(nums);
        buy(money, nums, 0);
        System.out.println(res);
    }

    public static int buy(int money, int[] items, int index) {
        if (money < 0) {
            return 0;
        }
        if (money == 0) {
            res++;
            return 0;
        }
        for (int i = index; i < items.length; i++) {
            buy(money - items[i], items, i);
        }
        return 0;
    }
}
