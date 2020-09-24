import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/24 9:03
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[] numOfLength = new int[num];
        for (int i = 0; i < num; i++) {
            numOfLength[i] = input.nextInt();
        }
        input.nextLine();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < num; i++) {
            String str = input.nextLine();
            String[] s = str.split(" ");
            for (String value : s) {
                int key = value.charAt(0) - 48;
                int val = value.charAt(2) - 48;
                if (map.containsKey(key)) {
                    Integer v = map.get(key);
                    map.put(key, v + val);
                } else {
                    map.put(key, val);
                }
            }
        }
        for (Integer integer : map.keySet()) {
            System.out.print(integer + ":" + map.get(integer) + " ");
        }
    }
}
