class Solution {
    public int lengthOfLongestSubstring(String s) {
        char [] c = s.toCharArray();
		  int length = s.length();  
	      int counter1 = 0, counter2 = 0;  
	      int maxLen = 0;  
	      
	      Boolean[]  exist = new Boolean[256]; 
	      for(int x=0 ; x<256 ; x++) {
	    	  exist[x] = false;
	      }
	      
		  while (counter2 < length) {  
		    if (exist[c[counter2]]) {  
		      maxLen = Math.max(maxLen, counter2-counter1);  
		      while (c[counter1] != c[counter2]) {  
		        exist[c[counter1]] = false;  
		        counter1++;  
		      }  
		      counter1++;  
		      counter2++;  
		    } else {  
		      exist[c[counter2]] = true;  
		      counter2++;  
		    }  
		  }  
		  maxLen = Math.max(maxLen, length-counter1);  
		  return maxLen;
    }
}