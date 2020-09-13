import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/6 10:45
 * @Version
 **/
public class Main2 {
    public static void main1(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        int n1 = 0;//大写字母
        int n2 = 0;//小写字母
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 97 && c <= 122) {
                n2++;
            } else {
                n1++;
            }
        }
        int i = str.length() / 2;
        int res = Math.min(Math.abs(i - n2), Math.abs(i - n1));
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[] ai = new int[num + 1];
        for (int i = 1; i < ai.length; i++) {
            ai[i] = input.nextInt();
        }
        int[] bi = new int[ai.length];
        for (int i = 1; i < bi.length; i++) {
            bi[i] = method(ai[i], num, i);
        }
        for (int i = 2; i < bi.length; i++) {
            bi[1] ^= bi[i];
        }
        System.out.println(bi[1]);
    }

    private static int method(int num, int n, int j) {
        for (int i = 1; i <= n; i++) {
            num ^= (j % i);
        }
        return num;
    }
}
