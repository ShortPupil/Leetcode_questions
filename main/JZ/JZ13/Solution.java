package JZ.JZ13;

/**
 * TODO ..
 * User: 钟镇鸿
 * Date: 2022/2/26
 * Time: 22:21
 * Description:
 */

import java.util.LinkedList;
import java.util.Queue;

/**地上有一个 rows 行和 cols 列的方格。
 * 坐标从 [0,0] 到 [rows-1,cols-1] 。
 *
 * 一个机器人从坐标 [0,0] 的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于 threshold 的格子。
 *
 * 例如，当 threshold 为 18 时，机器人能够进入方格   [35,37] ，因为 3+5+3+7 = 18。
 * 但是，它不能进入方格 [35,38] ，因为 3+5+3+8 = 19 。
 * 请问该机器人能够达到多少个格子？
 * */

public class Solution {
    /** 用dfs解法 时间nm 空间nm*/
    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] mark = new boolean[rows][cols];
        if(threshold < 0) return 0;
        int res = 0;

        return dfs(0, 0, threshold, rows, cols, mark);
    }

    private int dfs(int i, int j, int threshold, int rows, int cols, boolean[][] mark) {
        if(i < 0 || j < 0 || i >= rows || j >= cols || mark[i][j])
            return 0;
        // 检查当前坐标是否符合要求，不符合直接出局
        if(check(i) + check(j) > threshold)
            return 0;
        mark[i][j] = true;
        return 1 + dfs(i+1, j, threshold, rows, cols, mark) +
                dfs(i, j+1, threshold, rows, cols, mark);
    }

    private int check(int i) {
        int sum = 0;
        while(i != 0) {
            sum += (i%10);
            i /= 10;
        }
        return sum;
    }

    /**用bfs算法，广度优先*/
    public int movingCount2(int threshold, int rows, int cols) {
        //临时变量visited记录格子是否被访问过
        boolean[][] visited = new boolean[rows][cols];
        int res = 0;
        //创建一个队列，保存的是访问到的格子坐标，是个二维数组
        Queue<int[]> queue = new LinkedList<>();
        //从左上角坐标[0,0]点开始访问，add方法表示把坐标
        // 点加入到队列的队尾
        queue.add(new int[]{0, 0});
        while (queue.size() > 0) {
            //这里的poll()函数表示的是移除队列头部元素，因为队列
            // 是先进先出，从尾部添加，从头部移除
            int[] x = queue.poll();
            int i = x[0], j = x[1];
            //i >= rows || j >= cols是边界条件的判断，threshold < sum(i, j)判断当前格子坐标是否
            // 满足条件，visited[i][j]判断这个格子是否被访问过
            if (i >= rows || j >= cols || threshold < check(i)+check(j) || visited[i][j])
                continue;
            //标注这个格子被访问过
            visited[i][j] = true;
            res++;
            //把当前格子右边格子的坐标加入到队列中
            queue.add(new int[]{i + 1, j});
            //把当前格子下边格子的坐标加入到队列中
            queue.add(new int[]{i, j + 1});
        }
        return res;
    }
}
