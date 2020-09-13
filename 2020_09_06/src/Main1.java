import java.util.*;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/5 9:58
 * @Version
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int p = input.nextInt();
        int q = input.nextInt();
        int[] res = new int[3];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < p; i++) {
            set.add(input.nextInt());
        }
        int count = 0;
        for (int i = 0; i < q; i++) {
            int num = input.nextInt();
            if (set.contains(num)) {
                res[2] += 1;
                count++;
            } else {
                res[1] += 1;
            }
        }
        res[0] = set.size() - count;
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }

    public static void main1(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int p = input.nextInt();
        int q = input.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < p + q; i++) {
            int num = input.nextInt();
            if (map.containsKey(num)) {
                Integer val = map.get(num);
                map.put(num, val + 1);
            } else {
                map.put(num, 1);
            }
        }


    }
}