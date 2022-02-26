package code.JZ4;

/**在一个二维数组array中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 [
 [1,2,8,9],
 [2,4,9,12],
 [4,7,10,13],
 [6,8,11,15]
 ]
 给定 target = 7，返回 true。

 给定 target = 3，返回 false。

 数据范围：矩阵的长宽满足 0 \le n,m \le 5000≤n,m≤500 ， 矩阵中的值满足 0 \le val \le 10^90≤val≤10
 9

 进阶：空间复杂度 O(1)O(1) ，时间复杂度 O(n+m)O(n+m)*/
public class Solution {
    /**暴力解法，遍历全部求解 时间n^2*/
    public boolean Find(int target, int [][] array) {
        for(int i = 0 ; i < array.length ; i++) {
            for(int j = 0 ; j < array[i].length ; j++) {
                if(array[i][j] == target) return true;
            }
        }
        return false;
    }

    /**二维数组的二分法：
     *  arr 0 1 3 4 5
     *  0   < < < < val（这一行是本列最小的数）
     *  1           >
     *  2           >
     *  3     t     >
     *  4           >
     *           （这一列是最大本行最大的数）
     *  1）设初始值为右上角元素，arr[0][5] = val，目标tar = arr[3][1]
     * 2）接下来进行二分操作：
     * 3）如果val == target,直接返回
     * 4）如果 tar > val, 说明target在更大的位置，val左边的元素显然都是 < val，间接 < tar，说明第 0 行都是无效的，所以val下移到arr[1][5]
     * 5）如果 tar < val, 说明target在更小的位置，val下边的元素显然都是 > val，间接 > tar，说明第 5 列都是无效的，所以val左移到arr[0][4]
     * 6）继续步骤2）
     * */
    public boolean Find1(int target, int [][] array) {
        if(array.length == 0 || array[0].length == 0) return false;
        int length = array.length;
        int width = array[0].length;
        int l = 0;
        int w = width - 1;
        while(l < length && w >=0) {
            if(array[l][w] == target) return true;
            else if(array[l][w] < target) ++l;
            else if(array[l][w] > target) --w;
        }
        return false;
    }
}