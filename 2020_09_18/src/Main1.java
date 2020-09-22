import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/18 17:55
 * @Version
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = input.next();
        }
        if (n == 1) {
            if (str[0].charAt(0) != str[0].charAt(3)) {
                System.out.println("N");
            } else {
                System.out.println("Y");
            }
            return;
        }
        StringBuilder res = new StringBuilder("" + (str[0].charAt(0)) + (str[0].charAt(3)));
        for (int i = 1; i < n; i++) {
            String s = str[i];
            String c1 = s.charAt(3) + "";
            String c2 = s.charAt(0) + "";
            if (!res.toString().contains(c2)) {
                res = new StringBuilder(c2 + c1);
                continue;
            }
            if (res.toString().contains(c1)) {
                System.out.println("Y");
                return;
            } else {
                res.append(c1);
            }
        }
        System.out.println("N");
    }
}
