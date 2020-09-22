import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/18 14:53
 * @Version
 **/
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String res = input.nextLine();
        String tmp = "";
        for (int i = 0; i < res.length(); i++) {
            char c = res.charAt(i);
            if (c >= '0' && c <= '9') {
                tmp += c;
            }
        }
        int j = 0;
        int[][] edges = new int[tmp.length() / 2][2];
        for (int i = 0; i < edges.length; i++) {
            edges[i][0] = tmp.charAt(j++) - 48;
            edges[i][1] = tmp.charAt(j++) - 48;
        }
        String s = removeOneConnection(edges);
        System.out.println(s);
    }

    /**
     * @return java.lang.String
     * @Param
     * @Date 17:22 2020/9/18
     * @Description: 第一题
     **/
    public static String removeOneConnection(int[][] edges) {
        String res = String.valueOf(edges[0][0]) + String.valueOf(edges[0][1]);
        for (int i = 1; i < edges.length; i++) {
            int[] ints = edges[i];
            if (res.contains((ints[0] + ""))) {
                if (res.contains((ints[1] + ""))) {
                    return "Y";
                } else {
                    res += (ints[1] + "");
                }
            } else {
                if (res.contains((ints[1] + ""))) {
                    res += (ints[0] + "");
                } else {
                    res += (ints[0] + "");
                    res += (ints[1] + "");
                }
            }
        }
        return "N";
    }
}

