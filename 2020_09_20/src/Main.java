import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/20 15:55
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        String [] str=new String[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String next = input.next();
            String[] split = next.split(",");
            int i1 = Integer.parseInt(split[0]);
            int i2 = Integer.parseInt(split[1]);
            for (int j = 0; j < i2; j++) {
                list.add(i1);
            }
        }
        Random random = new Random();
    }
}
