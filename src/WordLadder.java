import java.util.*;

public class WordLadder {

    //we need to use set as contains method for arraylist is O(n) which if repeated multiple times results in TLE
    //approach - we keep adding to queue and incrementing level, for every word we build a stringbuilder,
    //we then change character and check if its in wordlist, if word is present and equal to endword, return level + 1
    //else if word present in wordlist but not eq to endword, add to queue, remove from wordlist
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordset = new HashSet<>(wordList);
        if(!wordset.contains(endWord))
            return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;
        while(!q.isEmpty()){ //for queue size
            int size = q.size(); //get current size
            for(int k = 0; k < size; k++) { //go upto queue length
                String current = q.poll();
                for(int i = 0; i < current.length(); i++){ //go upto current word
                    StringBuilder sb = new StringBuilder(current);
                    for(char l = 'a'; l <= 'z'; l++) { //take letters
                        sb.setCharAt(i, l); //keep changing
                        String curword = sb.toString();
                        if (wordset.contains(curword)) {
                            if (curword.equals(endWord))
                                return level + 1;
                            q.offer(curword);
                            wordset.remove(curword);
                        }
                    }
                }
            }
            level++; //increment level
        }
        return 0;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String end = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(begin, end, wordList));
    }
}
