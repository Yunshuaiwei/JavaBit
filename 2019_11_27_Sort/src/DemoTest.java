import org.junit.Test;

/**
 * @author DELL
 * @Date 2019/11/27 18:41
 **/
public class DemoTest {
    public static void main(String[] args) {

    }
    @Test
    public void test(){
        String str="12334a6";
        char[] chars = str.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            if(chars[i]>'9'){
                System.out.println("不在！");
                return;
            }
        }
        System.out.println("在！");
    }
    @Test
    public String test2(){
        char [] array={'a','b','c','d'};
        return new String (array);
}
}
