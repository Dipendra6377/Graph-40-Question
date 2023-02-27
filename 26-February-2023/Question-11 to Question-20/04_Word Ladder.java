class pair{
    String first;
    int second;

    pair(String first,int second){
        this.first = first;
        this.second= second;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<pair> q =new LinkedList<>();
        Set<String> set = new HashSet<>();

        q.offer(new pair(beginWord,1));
        int size = wordList.size();

        for(int i=0;i<size;i++){
            set.add(wordList.get(i));
        }

        if(set.contains(beginWord)){
            set.remove(beginWord);
        }

        while(!q.isEmpty()){
            String word = q.peek().first;
            int step =q.peek().second;

            q.remove();
            if(word.equals(endWord)) {
                return step;
            }
            for(int i=0;i<word.length();i++){
                for(char c='a';c<='z';c++){
                    char replacedCharword[] =word.toCharArray();
                    replacedCharword[i]=c;
                    String replacedWord = new String(replacedCharword);

                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.offer(new pair(replacedWord,step+1));
                    }
                }
            }
        }
        return 0;
    }
}
