class MagicDictionary {

    String [] s;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        s = dict;
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        boolean ans = false;
        for(String x : s){
            if(x.length() != word.length()) continue;
            
            boolean chk = false;
            boolean tmp = true;
            for(int i=0 ; i<x.length() ; i++){
                if(x.charAt(i) != word.charAt(i)){
                    if(chk){
                        tmp = false;
                        break;
                    }
                    else
                        chk = true;
                }
            }
            if(tmp && chk){
                ans = true;
                break;
            }
        }
        return ans;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */