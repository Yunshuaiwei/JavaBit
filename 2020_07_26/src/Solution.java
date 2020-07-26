import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/7/26 20:14
 * @Version
 **/
public class Solution {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        Solution s = new Solution();
        ArrayList<Integer> list = s.GetLeastNumbers_Solution(arr, 4);
        System.out.println(list);
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>(k);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        if (k > input.length) {
            return list;
        }
        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);
        }
        while (k > 0) {
            list.add(queue.poll());
            k--;
        }
        return list;
    }
}
