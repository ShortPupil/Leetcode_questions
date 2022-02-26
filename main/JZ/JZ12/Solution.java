package code.JZ12;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param matrix char字符型二维数组 
     * @param word string字符串 
     * @return bool布尔型
     */
    public boolean hasPath (char[][] matrix, String word) {
        // write code here
        if(matrix.length == 0 || matrix[0].length == 0 || word.length() == 0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(word.charAt(0) == matrix[i][j]) {
                    // 关键在于访问数组的设置
                    boolean vis[][] = new boolean[n][m];
                    if(dfs(i, j, vis, matrix, 0, word)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, boolean[][] vis, char[][] matrix, int k, String word) {
        // 如果i,j在矩阵之外，则false；如果走过这个结点也是false
        if(i >= matrix.length || j >= matrix[0].length || i < 0 || j < 0 || vis[i][j] == true) return false;
        // 如果字母与字符串最后一个相等，则找到路径，不再遍历，返回true
        if(matrix[i][j] == word.charAt(word.length()-1) && k==word.length()-1) return true;
        // 字符串字母是序号对应字母
        if(matrix[i][j] == word.charAt(k)) {
            // 已经遍历过了
            vis[i][j] = true;
            // 有路可走，继续向下遍历
            if(dfs(i+1, j, vis, matrix, k+1, word) || dfs(i, j+1, vis, matrix, k+1, word) ||
                    dfs(i-1, j, vis, matrix, k+1, word) || dfs(i, j-1, vis, matrix, k+1, word)) {
                return true;
            } else {
                // 无路可走，设为false
                vis[i][j] = false;
                return false;
            }
        } else {
            // 不可能是当前路径，无路可走，设为false
            vis[i][j] = false;
            return false;
        }
    }
}