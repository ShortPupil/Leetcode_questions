package code.JZ3;

import java.util.*;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。存在不合法的输入的话输出-1
 * */
public class Solution {
    /**解法1：空间换时间，hash散列 时间n 空间*/
    public int duplicate (int[] numbers) {
        // write code here
        int[] s = new int [1000000];
        if(numbers.length == 0) return -1;
        for(int i=0 ; i<numbers.length ; i++) {
            if(s[numbers[i]] > 0) {
                return numbers[i];
            } else {
                s[numbers[i]]++;
            }
        }
        return -1;
    }

    /**直接进行排序，再前后比对数据 时间n 空间n*/
    public int duplicate1 (int[] numbers) {
        Arrays.sort(numbers);
        for(int i = 1 ; i < numbers.length ; i++) {
            if(numbers[i] == numbers[i-1]) return numbers[i];
        }
        return -1;
    }

    /**特殊性比较强，只能用于数组内数据在0~n-1范围内的情况 时间n 空间1*/
    public int duplicate2 (int[] numbers) {
        // write code here
        int i = 0;
        while(i < numbers.length){
            if(numbers[i] != i) {
                if(numbers[i] == numbers[numbers[i]]) {
                    return numbers[i];
                }
                int tmp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = tmp;
            } else {
                i++;
            }
        }
        return -1;
    }
}