import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/31 19:51
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        m.translateNum(121);
    }

    public ArrayList<String> findCommonString(ArrayList<ArrayList<String>> values) {
        // write code here
        ArrayList<String> tmp = new ArrayList<>();
        HashSet<String> res = new HashSet<>();
        tmp.addAll(values.get(0));
        for (int i = 1; i < values.size(); i++) {
            ArrayList<String> list = values.get(i);
            for (String s : list) {
                if (tmp.contains(s)) {
                    res.add(s);
                } else {
                    res.remove(s);
                }
            }
        }
        return new ArrayList<>(res);
    }

    public int translateNum(int num) {
        // write code here
        int count = 1;
        String s = String.valueOf(num);
        for (int i = 0; i < s.length() - 1; i++) {
            String s1 = s.substring(i, i + 2);
            int i1 = Integer.parseInt(s);
            if (i1 < 26) {
                count++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            String s1 = s.substring(i, i + 2);
            int i1 = Integer.parseInt(s);
            if (i1 < 26) {
                int j = i + 2;
                while (j < s1.length() - 1) {
                    String s2 = s.substring(j, j + 2);
                    if (Integer.parseInt(s2) < 26) {
                        count++;
                    } else {
                        j++;
                    }
                }
            }
        }


        return count;
    }
}
