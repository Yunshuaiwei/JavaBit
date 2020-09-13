import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/6 11:34
 * @Version
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = input.nextInt();
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int j : arr) {
            if (list.contains(j)) {
                list.remove(j);
            }
            list.addFirst(j);
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
