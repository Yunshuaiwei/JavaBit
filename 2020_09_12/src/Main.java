import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/12 19:17
 * @Version
 **/
public class Main {

    public static void main1(String[] args) {
        Scanner input = new Scanner(System.in);
        String str=input.nextLine();
        String[] s = str.split(" ");

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(input.nextLine());
        int n=input.nextInt();
        String s = sb.toString();
        char[] chars = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(chars);
        int flag=n;
        for (int i = chars.length-1; i >=0 ; i--) {
            char aChar = chars[i];
            for (int j = i; j > 3; j++) {

            }
            for (int j = 0; j < sb.length(); j++) {
                char c = sb.charAt(j);
                if (c==aChar){
                    sb.deleteCharAt(j);
                    n--;
                }else{
                    break;
                }
            }
        }
    }
}
