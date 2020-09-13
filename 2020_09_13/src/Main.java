import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/13 20:40
 * @Version
 **/
public class Main {
    //    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n=input.nextInt()*3;
//        int m=input.nextInt();
//        int res=n*m;
//        for (int i = 1; i < n; i++) {
//            res+=i*m;
//        }
//        System.out.println(res);
//    }
    static String str = "";
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = input.next();
        }
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = str[i].charAt(j);
            }
        }
        dfs(map,0,0);
        System.out.println(list);
    }

    public static void dfs(char[][] map,int i,int j){
        if (i>=map.length||i<0||j>=map[0].length||j<0){
            return;
        }
        if (i==map.length-1&&j==map[0].length-1){
            str="";
            list.add(str);
        }
        str+=map[i][j];
        char c=map[i][j];
        map[i][j]='/';
        if (map[i][j]!='/'){
            dfs(map,i+1,j);
            dfs(map,i-1,j);
            dfs(map,i,j+1);
            dfs(map,i,j-1);
        }else{
            return;
        }
        map[i][j]=c;
    }


}
