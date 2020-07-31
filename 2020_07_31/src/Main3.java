import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/31 15:02
 * @Version
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String res = "";
        String str = s.trim();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) - 48 >= 0 && str.charAt(i) - 48 <= 9) {
                res += str.charAt(i);
            }
        }
        System.out.println(res);
    }
}
