import java.util.Arrays;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/11 14:56
 * @Version
 **/
public class Main1 {
    public static void main(String[] args) {
        Main1 m = new Main1();
//        long sum = m.sum(3, 5);
//        System.out.println(sum);
        int [] nums=new int[]{1,2,4};
        int i = m.minMoves(nums);
        System.out.println(i);
    }

    public long sum(int num, int itemNum) {
        // write code here
        long res = 0;
        String str = "";
        for (int i = 0; i < itemNum; i++) {
            String s = String.valueOf(num);
            str += s;
            res += Long.parseLong(str);
        }
        return res;
    }

    public int minMoves (int[] nums) {
        // write code here
        Arrays.sort(nums);
        int m=nums.length/2;
        int res=0;
        for (int num : nums) {
            res += Math.abs(num - nums[m]);
        }
        return res;
    }

}
