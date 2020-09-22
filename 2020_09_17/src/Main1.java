import java.util.Scanner;

/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/17 20:39
 * @Version
 **/
public class Main1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int i = 0; i < T; i++) {
            int n = input.nextInt();
            int m = input.nextInt();
            char[][] map = new char[n][m];
            for (int j = 0; j < n; j++) {
                map[j] = input.next().toCharArray();
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    char c = map[j][k];
                    if (c == 'S') {
                        boolean[][] flag = new boolean[n][m];
                        boolean e = dfs(map, j, k, 'E', flag);
                        if (e) {
                            System.out.println("YES");
                        } else {
                            System.out.println("NO");
                        }
                    }
                }
            }
        }
    }

    private static boolean dfs(char[][] map, int i, int j, char c, boolean[][] flag) {
        if (i < 0 || i >= map.length || j < 0 || j >= map[0].length
                || map[i][j] == '#') {
            return false;
        }
        if (map[i][j] == c) {
            return true;
        }
        return dfs(map, i + 1, j, c, flag) || dfs(map, i - 1, j, c, flag)
                || dfs(map, i, j + 1, c, flag) || dfs(map, i, j - 1, c, flag);
    }
}
