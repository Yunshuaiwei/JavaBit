import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/11 19:55
 * @Version
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean[] flag = null;
        while (input.hasNext()) {
            String str = input.nextLine();
            if (str.length() >= 8) {
                flag = new boolean[4];
                boolean tmp = true;
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (c >= 48 && c <= 57) {
                        flag[0] = true;
                    } else if (c >= 97 && c <= 122) {
                        flag[1] = true;
                    } else if (c >= 65 && c <= 90) {
                        flag[2] = true;
                    } else {
                        flag[3] = true;
                    }
                }
                for (boolean b : flag) {
                    if (!b) {
                        System.out.println("Irregular password");
                        tmp = false;
                        break;
                    }
                }
                if (tmp) {
                    System.out.println("Ok");
                }
            } else {
                System.out.println("Irregular password");
            }
        }
    }

}
