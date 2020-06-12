import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/6/12 18:23
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
//        int [] arr=new int[n];
        int a = 0;
        int b = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int arr = input.nextInt();
            if (map.containsKey(arr)) {
                Integer value = map.get(arr);
                value++;
                map.put(arr, value);
            } else {
                map.put(arr, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                if (a == 0) {
                    a = entry.getKey();
                } else {
                    b = entry.getKey();
                }
            }
        }
        if (a > b) {
            System.out.println(b + " " + a);
        } else {
            System.out.println(a + " " + b);
        }
    }
}
