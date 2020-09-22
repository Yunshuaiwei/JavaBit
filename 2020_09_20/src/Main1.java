import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/20 15:25
 * @Version
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int n = input.nextInt();
        ArrayList<String[]> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String str = input.next();
            String[] split = str.split(",");
            list.add(split);
        }
        String[] split = input.next().split(",");
        ArrayList<String> res = new ArrayList<>();
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);
        if (num == 1) {
            for (String[] strings : list) {
                int a = Integer.parseInt(strings[0]);
                int b = Integer.parseInt(strings[1]);
                if (a >= start && b <= end) {
                    res.add(strings[0] + "," + strings[1]);
                }
            }
        } else {
            for (String[] strings : list) {
                int a = Integer.parseInt(strings[0]);
                int b = Integer.parseInt(strings[1]);
                if ((a >= start && a <= end) || (b >= start && b <= end)) {
                    res.add(strings[0] + "," + strings[1]);
                }
            }
        }
        for (String re : res) {
            System.out.println(re);
        }
    }
}
