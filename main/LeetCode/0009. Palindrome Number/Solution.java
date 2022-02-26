import java.util.ArrayList;
public class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
		int len = s.length();
		
        if(s.length() == 1) return true;
        
        for(int i=0 ; i<len/2 ; i++) {
        	if(s.charAt(i) != (s.charAt(len-i-1))) return false;
        }
        
        return true;
    }
}