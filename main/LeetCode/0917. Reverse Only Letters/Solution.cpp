class Solution {
public:
    string reverseOnlyLetters(string S) {
        string res;
        for(int i=0,j=S.size()-1 ; i<S.size() ; i++){
            if(!isalpha(S[i])){
                res += S[i];
            }else if(!isalpha(S[j])){
                while(!isalpha(S[--j]));
                res += S[j--];
            }else{
                res += S[j--];
            }
        }
        return res;
    }
};