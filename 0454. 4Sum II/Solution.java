class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int length = A.length;
        int result = 0;
        for(int i = 0 ; i < length ; ++i){
            for(int j = 0 ; j < length ; ++j){
                int tempSum = A[i] + B[j];
                map.put(tempSum, map.getOrDefault(tempSum, 0) + 1);
            }
        }
        
        for(int i = 0 ; i < length; ++i){
            for(int j = 0 ; j < length ; ++j){
                int tempSum = 0 - (C[i] + D[j]);
                result += map.getOrDefault(tempSum, 0);
            }
        }
        return result;
    }
}