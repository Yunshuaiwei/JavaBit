import org.junit.Test;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/6 16:28
 * @Version
 **/
public class Main4 {
    public static void main(String[] args) {
        Main4 m = new Main4();
//        int i = m.primePalindrome(6);
//        boolean num = m.num(7);
//        System.out.println(num);
//        System.out.println(i);
        String str = "A man, a plan, a canal: Panama";
        boolean b = m.isPalindrome(str);
        System.out.println(b);

    }

    public int primePalindrome(int N) {
        // write code here
        for (int i = N; i < Integer.MAX_VALUE; i++) {
            if (method(i) && num(i)) {
                return i;
            }
        }
        return 0;
    }

    private boolean method(int n) {
        String str = String.valueOf(n);
        int j = str.length() - 1;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            j--;
        }
        return true;
    }

    private boolean num(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String str) {
        // write code here
        str = str.toLowerCase();
        String s = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < 97 || c > 122) {
                continue;
            } else {
                s += c;
            }
        }
        System.out.println(s);
        int j = s.length() - 1;
        for (int i = 0; i < s.length() / 2; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if (c1 != c2) {
                return false;
            }
            j--;
        }
        return true;
    }

    @Test
    public void test() {
        String str = "A man, a plan, a canal: Panama";
        String s = str.toLowerCase();
        System.out.println(s);
    }

}
