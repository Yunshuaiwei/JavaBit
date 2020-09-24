import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/23 18:53
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String[] split = s.split("#");

        StringBuilder res = new StringBuilder();
        int flag = 0;
        int i;
        int j = split[1].length() - 1;
        for (i = split[0].length() - 1; i >= 0; i--) {
            int a = split[0].charAt(i) - 48;
            int b = 0;
            if (j >= 0) {
                b = split[1].charAt(j--) - 48;
            } else {
                break;
            }
            int sum = a + b + flag;
            flag = 0;
            if (sum < 10) {
                res.insert(0, sum);
            } else {
                flag = sum / 10;
                res.insert(0, sum % 10);
            }
        }
        if (i <= 0 && j <= 0) {
            if (flag != 0) {
                res.insert(0, flag);
            }
            System.out.println(res.toString());
            return;
        }

        if (i > 0) {
            if (flag != 0) {
                while (i >= 0) {
                    int sum = 0;
                    int a = split[0].charAt(i--) - 48;
                    sum = a + flag;
                    flag = 0;
                    if (sum < 10) {
                        res.insert(0, sum);
                    } else {
                        flag = sum / 10;
                        res.insert(0, sum % 10);
                    }
                }
                if (flag != 0) {
                    res.insert(0, flag);
                }
                System.out.println(res.toString());
                return;
            } else {
                while (i >= 0) {
                    char a = split[0].charAt(i--);
                    res.insert(0, a);
                }
                System.out.println(res.toString());
                return;
            }
        } else {
            if (flag != 0) {
                while (j >= 0) {
                    int sum = 0;
                    int a = split[0].charAt(j--) - 48;
                    sum = a + flag;
                    flag = 0;
                    if (sum < 10) {
                        res.insert(0, sum);
                    } else {
                        flag = sum / 10;
                        res.insert(0, sum % 10);
                    }
                }
                if (flag != 0) {
                    res.insert(0, flag);
                }
                System.out.println(res.toString());
                return;
            } else {
                while (j >= 0) {
                    char a = split[0].charAt(j--);
                    res.insert(0, a);
                }
                System.out.println(res.toString());
                return;
            }
        }
    }

}
