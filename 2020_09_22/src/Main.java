import java.util.Arrays;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/22 18:49
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] ints = new Main().pushIntArray(arr, 2);
        System.out.println(Arrays.toString(ints));
    }

    public int[] pushIntArray(int[] arr, int pushOffset) {
        // write code here
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[(i + pushOffset) % res.length] = arr[i];
        }
        return res;
    }

}
