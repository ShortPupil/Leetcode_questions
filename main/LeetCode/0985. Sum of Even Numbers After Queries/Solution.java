class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] res = new int[A.length];
        int sum = 0, i = 0;
        for(int n : A)
            sum += (n % 2 == 0 ? n : 0);
        for(int[] q : queries){
            int val = q[0], idx = q[1];
            int prev = A[idx];
            A[idx] += val;
            if(prev % 2 == 0)
                sum -= prev;
            if(A[idx] % 2 == 0)
                sum += A[idx];
            res[i++] = sum;
        }
        return res;
    }
}