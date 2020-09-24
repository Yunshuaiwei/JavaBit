import org.testng.annotations.Test;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/21 14:42
 * @Version
 **/
public class Main {
    public static void main(String[] args) {


    }

    public static int method(int [] arr){
        int dp0=arr[0];
        int dp1;
        int res=dp0;
        for (int i = 1; i < arr.length; i++) {
            dp1=Math.max(arr[i],arr[i]+dp0);
            dp0=dp1;
            res=Math.max(res,dp1);
        }
        return res;
    }

}