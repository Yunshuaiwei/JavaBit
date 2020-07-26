import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/26 19:48
 * @Version
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        HashSet<Character> set = new HashSet<>();
        String res = "";
        String tmp = String.valueOf(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (tmp.charAt(tmp.length() - 1) + 1 == str.charAt(i)) {
                tmp += str.charAt(i);
            } else {
                if (tmp.length() > res.length()) {
                    res = tmp;
                }
                tmp = String.valueOf(str.charAt(i++));
                i--;
            }
        }
        if (res.length() > tmp.length()) {
            System.out.println(res);
        } else {
            System.out.println(tmp);
        }

    }

}
