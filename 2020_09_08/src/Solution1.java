/**
 * @Description: TODO
 * @Author YunShuaiWei
 * @Date 2020/9/9 19:02
 * @Version
 **/
public class Solution1 {
    private boolean[][] marked;

    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    private int m;
    private int n;
    private String word;
    private char[][] board;

    public boolean exist1(char[][] board, String word) {
        m = board.length;
        if (m == 0) {
            return false;
        }
        n = board[0].length;
        marked = new boolean[m][n];
        this.word = word;
        this.board = board;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs1(i, j, 0)) {//深度优先遍历
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs1(int i, int j, int start) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true;//将该位置标记为已访问
            for (int k = 0; k < 4; k++) {//四个方向进行遍历
                int newX = i + direction[k][0];
                int newY = j + direction[k][1];
                if (inArea(newX, newY) && !marked[newX][newY]) {//判断下标是否越界，并且判断该位置是否访问过
                    if (dfs1(newX, newY, start + 1)) {//递归访问下一个位置
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

    private boolean inArea(int x, int y) {//判断下标是否越界
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        int m = 0;
        while (i < j) {
            m = (i + j) / 2;
            if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else {
                j--;
            }
        }
        return numbers[i];
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (i < 0 || i >= board.length || j >= board[0].length || j < 0 || board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i, j + 1, k + 1) ||
                dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }

}
