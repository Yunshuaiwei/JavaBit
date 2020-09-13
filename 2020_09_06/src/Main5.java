import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/6 19:36
 * @Version
 **/
public class Main5 {
    public static void main1(String[] args) {
        Scanner input = new Scanner(System.in);
        int n =input.nextInt();
        HashSet<Integer> set = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            set.add(input.nextInt());
        }
        ArrayList<Integer> res = new ArrayList<>();
        int m=input.nextInt();
        for (int i = 0; i < m; i++) {
            int num=input.nextInt();
            if (set.contains(num)){
                res.add(num);
            }
        }
        for (Integer re : res) {
            System.out.print(re+" ");
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(m);
        int tmp=0;
        for (int i = 0; i < m; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            int x=input.nextInt();
            for (int j = 0; j < x; j++) {
                int num = input.nextInt();
                if (num==0&&tmp==0){
                    tmp=i+1;
                }
                arr.add(num);
            }
            list.add(arr);
        }
        int count=0;
        HashSet<Integer> set = new HashSet<>(list.get(tmp - 1));
        ArrayList<Integer> list1 = new ArrayList<>(list.get(tmp - 1));
        list.remove(tmp-1);
        for (Integer integer : set) {
            boolean flag=true;
            for (int i = 0; i < list.size(); i++) {
                ArrayList<Integer> arr = list.get(i);
                if (arr.contains(integer)){
                    set.addAll(arr);
                    flag=false;
                    list.remove(i);
                }
            }
            if (flag){
                break;
            }
        }
        System.out.println(set.size());
    }

}
