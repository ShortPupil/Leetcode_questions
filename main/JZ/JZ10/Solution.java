package code.JZ10;

/**
 * TODO ..
 * User: 钟镇鸿
 * Date: 2022/2/26
 * Time: 21:06
 * Description:
 */
public class Solution {
    /**1.递归方法计算*/
    public int Fibonacci1(int n) {
        if(n <= 0) return 0;
        if(n == 1 || n == 2) return 1;
        return Fibonacci1(n-1) + Fibonacci1(n-2);
    }
    /**
     * 非递归方法，每次只存储最近的两个数
     * sum 存储第 n 项的值
     * one 存储第 n-1 项的值
     * two 存储第 n-2 项的值*/
    public int Fibonacci2(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        int sum = 0;
        int one = 1;
        int two = 0;
        for(int i = 2 ; i<=n ; i++) {
            sum = one + two;
            one = sum;
            two = one;
        }
        return sum;
    }

    /**
     * 观察上一版发现，sum 只在每次计算第 n 项的时候用一下，其实还可以利用 sum 存储第 n-1 项，
     * 例如当计算完 f(5) 时 sum 存储的是 f(5) 的值，
     * 当需要计算 f(6) 时，f(6) = f(5) + f(4)，sum 存储的 f(5)，f(4) 存储在 one 中，由 f(5)-f(3) 得到
     * [0(one) 1(sum) 1 2 3 5 8]
     * [0 1(one) 1(sum) 2 3 5 8]
     * [0 1 1(one) 2(sum) 3 5 8]*/
    public int Fibonacci3(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        int sum = 1;
        int one = 0;
        for(int i = 2 ; i<=n ; i++) {
            sum = one + sum;
            one = sum - one;
        }
        return sum;
    }
}
