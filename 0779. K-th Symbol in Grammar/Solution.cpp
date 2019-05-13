class Solution {
public:
    int kthGrammar(int N, int K) {
        if(N==1 && K==1) return 0;
        auto m = 1 << (N-2);
        return K>m?!kthGrammar(N-1,K-m):kthGrammar(N-1,K);
    }
};