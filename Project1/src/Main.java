import com.bit.book.BookList;
import com.bit.user.Admin;
import com.bit.user.NormalUser;
import com.bit.user.User;

import java.util.Scanner;

/**
 * @ProjectName JavaBit
 * @ClassName Main
 * Description
 * @Auther YunSW
 * @Date 2019/11/16 11:30
 * @Version 1.0
 **/

/**
 * @author DELL
 */
public class Main {
    public static void main(String[] args) {
        BookList bookList = new BookList();
        User user = login();
        while (true) {
            int choice = user.menu();
            if (choice > bookList.getSize()) {
                System.out.println("输入错误！");
            }
            user.doOperation(choice, bookList);
        }
    }
    public static User login(){
        System.out.println("请输入名字：");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        System.out.println("请输入你的身份：（0:普通用户，1：管理员）");
        int choice=scanner.nextInt();
        if(choice==0){
            return new NormalUser(name);
        }else{
            return new Admin(name);
        }
    }
}
