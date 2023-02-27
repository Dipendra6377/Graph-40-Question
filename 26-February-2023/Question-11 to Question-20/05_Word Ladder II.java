class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String beginWord, String endWord, String[] wordList)
    {
        // Code here
        
        Set<String> set = new HashSet<>();
        int n =wordList.length;

        for(int i=0;i<n;i++){
            set.add(wordList[i]);
        }
        Queue<ArrayList<String>> q=new LinkedList<>();
        ArrayList<String> list = new ArrayList<>();
        list.add(beginWord);
        q.add(list);

        ArrayList<String> level = new ArrayList<>();
        level.add(beginWord);
        int lvl=0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>(); 

        while(!q.isEmpty()){
            ArrayList<String > sublist = q.peek();
            q.remove();

            if(sublist.size()>lvl){
                lvl++;
                for(String s:level){
                    set.remove(s);
                }
            }
            String word = sublist.get(sublist.size()-1);
            if(word.equals(endWord)){
                if(ans.size()==0) ans.add(sublist);
                else if(ans.get(0).size()==sublist.size()) ans.add(sublist);
            }

            for(int i=0;i<word.length();i++){
                for(char c='a' ;c<='z';c++){
                    char replacedcharWord[] =word.toCharArray();
                    replacedcharWord[i]=c;
                    String replaceWord = new String(replacedcharWord);
                    if(set.contains(replaceWord)==true){
                        sublist.add(replaceWord);

                        ArrayList<String> temp = new ArrayList<>(sublist);
                        q.add(temp);
                        level.add(replaceWord);
                        sublist.remove(sublist.size()-1);
                    }
                }
            }
        }
        return ans;
    }
}
