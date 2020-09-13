import java.util.Stack;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/8/13 18:46
 * @Version
 **/
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
//        boolean b = m.IsValidExp("{[]}");
//        System.out.println(b);
//        int i = m.GetCoinCount(200);
//        System.out.println(i);
        int [] arr=new int[]{7,2,1,10};
        boolean b = m.Game24Points(arr);
        System.out.println(b);
    }

    public boolean Game24Points(int[] arr) {
        // write code here
        int[] arr1 = num(arr[0], arr[1]);
        int[] arr2 = num(arr[2], arr[3]);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int[] num = num(arr1[i], arr2[j]);
                for (int i1 : num) {
                    if (i1==24){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private int [] num(int x,int y){
        int [] arr=new int[4];
        for (int i = 0; i < 4; i++) {
            if (i==0){
                arr[i]=x+y;
            }
            if (i==1){
                arr[i]=x-y;
            }
            if (i==2){
                arr[i]=x*y;
            }
            if (i==3){
                arr[i]=x/y;
            }
        }
        return arr;
    }

    public boolean IsValidExp(String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character pop = stack.peek();
                    if ((c == '}' && pop == '{') || (c == ']' && pop == '[') || (c == ')' && pop == '(')) {
                        stack.pop();
                    }
                }
            }
        }

        return stack.isEmpty();
    }

    public int GetCoinCount(int N) {
        // write code here
        int count = 0;
        int num = 1024 - N;
        while (num > 0) {

            if (num >= 64) {
                count++;
                num -= 64;
            } else if (num >= 16) {
                count++;
                num -= 16;
            } else if (num >= 4) {
                count++;
                num -= 4;
            } else {
                num -= 1;
                count++;
            }
        }
        return count;
    }

}
