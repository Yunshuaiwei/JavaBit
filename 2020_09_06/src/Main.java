import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/6 21:08
 * @Version
 **/
public class Main {
    public static void main1(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = input.nextLine();
            if (map.containsKey(str)) {
                Integer val = map.get(str);
                map.put(str, val + 1);
            } else {
                map.put(str, 1);
            }
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arrA = new int[n];
        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = input.nextInt();
        }
        int[] arrB = new int[arrA.length];
        for (int i = 0; i < arrB.length; i++) {
            arrB[i] = arrA[i];
        }
        Arrays.sort(arrA);
        int a = arrA[(n / 2) - 1];
        int b = arrA[(n / 2) - 1];
        for (int i = 0; i < n; i++) {
            if (arrB[i] < arrA[n / 2]) {
                System.out.println(a);
            } else {
                System.out.println(b);
            }
        }

    }

    public int threeSumClosest1(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (Math.abs(target - sum) < res) {
                        res = sum;
                    }
                }
            }
        }
        return res;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int tmp = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            start = i + 1;
            int end = nums.length - 1;
            int a = nums[i];
            while (start < end) {
                int b = nums[start];
                int c = nums[end];
                int sum = a + b + c;
                tmp = (Math.abs(target - sum) < Math.abs(target - tmp)) ? tmp = sum : tmp;
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return sum;
                }
            }
        }
        return tmp;
    }




}
