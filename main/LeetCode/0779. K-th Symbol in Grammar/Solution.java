class Solution {
    public int kthGrammar(int N, int K) {
        if(N == 1) return 0;
        int res = kthGrammar(N-1, (K+1)/2);
        if(res == 1){
            return K%2 == 0 ? 0 : 1;
        }
        else {
            return K%2 == 0 ? 1 : 0;
        }
    }
}