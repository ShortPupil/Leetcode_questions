package JZ.JZ11;

/**
 * TODO ..
 * User: 钟镇鸿
 * Date: 2022/2/26
 * Time: 21:22
 * Description:
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        for(int i= 0 ; i<array.length-1 ; i++) {
            if(array[i] > array[i+1]) {
                return array[0] < array[i+1] ? array[0] : array[i+1];
            }
        }
        return array[0] < array[array.length - 1] ? array[0] : array[array.length - 1];
    }
}
