import java.util.Arrays;
import java.util.Collections;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/22 18:49
 * @Version
 **/
public class Main1 {
    public static void main(String[] args) {
        String str = "19 5 9 255";
        int sort = new Main1().sort(str);
        System.out.println(sort);

    }

    public int sort(String inData) {
        // write code here
        String[] s = inData.split(" ");
        int[] arr1 = new int[s.length];
        int[] arr2 = new int[s.length];

        for (int i = 0; i < s.length; i++) {
            arr1[i] = Integer.parseInt(s[i]);
            arr2[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr2);
        int i = 0, j = 0;
        while (i < arr1.length && j < arr1.length) {
            if (arr1[i] != arr2[j]) {
                i++;
            } else {
                i++;
                j++;
            }
        }
        return arr1.length - j;
    }
}
