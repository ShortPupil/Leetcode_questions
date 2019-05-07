class Solution {
public:
    int rangeBitwiseAnd(int m, int n) {
        unsigned int i;
        for(i=n ; i>m ;){
            i = i & (i-1);
            if(i == 0)
                return 0;
        }
        return i;
    }
    
};