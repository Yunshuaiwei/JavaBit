import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/29 18:01
 * @Version
 **/
public class Main1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(input.nextInt());
        }
        while (true) {
            int min = min(list);
            if (min == -1) {
                break;
            } else {
                boolean flag = true;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) == min && flag) {
                        list.remove(i);
                        flag = false;
                    } else {
                        list.set(i, min * 2);
                        break;
                    }
                }
            }
        }
        System.out.println(list);
    }

    private static int min(ArrayList<Integer> list) {
        HashSet<Integer> set = new HashSet<>();
        int min = list.get(0);
        boolean flag = true;
        for (Integer integer : list) {
            if (!set.add(integer)) {
                flag = false;
                if (integer < min) {
                    min = integer;
                }
            }
        }
        if (flag) {
            return -1;
        } else {
            return min;
        }
    }
}
