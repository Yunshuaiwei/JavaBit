import java.util.ArrayList;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/1 15:19
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = new int[]{1,1,2};
        int i = s.reletive_7(arr);
        System.out.println(i);
    }

    public int reletive_7(int[] digit) {
        if (digit.length == 1) {
            if (digit[0] == 7) {
                return 1;
            } else {
                return 0;
            }
        }
        int res = 0;
        String str = "";
        for (int i : digit) {
            str += i;
        }
        ArrayList<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            for (int j = 0; j < sb.length(); j++) {
                char at = sb.charAt(j);
                if (i != j) {
                    sb.setCharAt(j, c);
                    sb.setCharAt(i, at);
                    list.add(Integer.parseInt(sb.toString()));
                    sb.setCharAt(i, c);
                    sb.setCharAt(j, at);
                }
            }
        }
        System.out.println(list);
        for (Integer integer : list) {
            if (integer % 7 == 0) {
                res++;
            }
        }
        return res;
    }
}
