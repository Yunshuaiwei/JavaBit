import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/17 19:32
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                String tmp = "";
                while (i < str.length()) {
                    if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                        i++;
                        break;
                    }
                    tmp += str.charAt(i);
                    i++;
                }
                if (tmp.length() > 0) {
                    int i1 = Integer.parseInt(tmp);
                    if (i1 >= 1000 && i1 <= 3999) {
                        res += tmp;
                        res += " ";
                    }
                }
            }
        }
        System.out.println(res.trim());
    }
}
