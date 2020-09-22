import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/14 20:09
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] arr = new int[m][2];
        String[] array = new String[m];
        for (int i = 0; i < m; i++) {
            array[i] = input.next();
            arr[i][0] = input.nextInt();
            arr[i][1] = input.nextInt();
        }
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i + 1);
            lists.add(list);
        }
        for (int i = 0; i < m; i++) {
            String s = array[i];
            if (s.equals("C")) {
                int a = arr[i][0];
                int b = arr[i][1];
                ArrayList<Integer> listA = lists.get(a - 1);
                ArrayList<Integer> listB = lists.get(b - 1);
                listB.addAll(listA);
                listA.clear();
            } else {
                int a = arr[i][0];
                int b = arr[i][1];
                int num1 = 0;
                int num2 = 0;
                boolean flag = false;
                for (int j = 0; j < lists.size(); j++) {
                    ArrayList<Integer> list = lists.get(j);
                    if (list.contains(a) && list.contains(b)) {
                        flag = true;
                        for (int k = 0; k < list.size(); k++) {
                            if (list.get(k) == a) {
                                num1 = k;
                            }
                            if (list.get(k) == b) {
                                num2 = k;
                            }
                        }
                    }

                }
                if (flag) {
                    System.out.println(Math.abs(num1 - num2 - 1));
                } else {
                    System.out.println(-1);
                }
            }


        }
    }
}
