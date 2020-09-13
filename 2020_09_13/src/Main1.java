import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/13 18:26
 * @Version
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();
            String str = input.next();
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                StringBuilder tmp = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    tmp.append(str.charAt(i));
                    i++;
                    if (i == str.length()) {
                        break;
                    }
                }
                i--;
                list.add(tmp.toString());
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                String s = list.get(i);
                StringBuilder sb = new StringBuilder(s);
                StringBuilder reverse = sb.reverse();
                res.append(reverse.toString());
            }
            System.out.println(res.toString());
        }
    }
}
