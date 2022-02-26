class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Queue<String> list = new LinkedList<>();
        Queue<Integer> step = new LinkedList<>();
        list.offer(beginWord);
        step.offer(1);
        while(!list.isEmpty()){
            String current = list.poll();
            int length = step.poll();
            if(current.equals(endWord)) return length;

            for(int i=0 ; i<wordList.size() ; i++){
                String word = wordList.get(i);

                if(judge(current, word)){
                    list.offer(word);
                    step.offer(length+1);
                    wordList.remove(i--);
                }
            }
        }
        return
    }

    private boolean judge(String current, String word){
        if(current.equals(word)) return false;
        int count = 0;
        for (int i=0 ; i<current.length() ; i++){
            if(current.charAt(i) != word.charAt(i)){
                count++;
                if(count > 1) return false;
            }
        }
        return true;
    }
}