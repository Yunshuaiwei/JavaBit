/**
 * @Description TODO
 * @Author YunShuaiWei
 * @Date 2020/5/17 8:59
 * @Version
 **/
public class Sington {
    public static void main(String[] args) {
    }

    private static volatile Sington SINGTON;

    public static Sington getInstance() {
        //使用volatile修饰SINGTON保证可见性，提高效率
        if (SINGTON == null) {
            synchronized (Sington.class) {
                //为了保证单例，返回的是同一个对象
                if (SINGTON == null) {
                    //① 分配内存空间
                    //② 初始化对象
                    //③ 赋值给变量
                    SINGTON = new Sington();
                }
            }
        }
        return SINGTON;
    }
}
