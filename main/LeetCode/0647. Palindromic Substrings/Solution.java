//动态规划
class Solution {
    public int countSubstrings(String s) {
        char [] chars = new char[s.length()];
        s.getChars(0, s.length(), chars, 0);
        boolean[][] dp = new boolean[chars.length][chars.length];
        int count = dp.length;
        
        for(int i=0 ; i<dp.length ; i++){
            dp[0][i] = true;
            dp[i][i] = true;
        }
        
        for(int i=dp.length-2 ; i>=0 ; i--){
            for(int j=i+1 ; j<dp.length ; j++){
                if(j-i == 1){
                    if(chars[i] == chars[j]){
                        dp[i][j] = true;
                        count++;
                    }
                } else {
                    if(chars[i] == chars[j] && dp[i+1][j-1]){
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }
}