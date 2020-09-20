public class ExpressiveWords {

    public static int expressiveWords(String s, String[] words) {
        if(s == null || words == null)
            return 0;
        int count = 0;
        for(String word: words)
            if(isStretchy(s, word))
                count++;
        return count;
    }

    static boolean isStretchy(String s, String word){
        if(word == null)
            return false;
        int i = 0; int j = 0;
        //two pointer approach, i for s, j for word
        while(i < s.length() && j < word.length()){
            //if characters equal get lengths of repeating chars
            if(s.charAt(i) == word.charAt(j)){
                int len1 = getRepeatedLength(s, i);
                int len2 = getRepeatedLength(word, j);
                //since we want the stretched character to be 3, so if it is 3 but word has more then also its false
                if(len1 < 3 && len1 != len2 || len1 >=3 && len1 < len2)
                    return false;
                i += len1;
                j += len2;
            }
            else
                return false;
        }
        return i == s.length() && j == word.length();
    }

    static int getRepeatedLength(String s, int start){
        int j = start;
        while(j < s.length() && s.charAt(j) == s.charAt(start))
            j++;
        return j - start;
    }

    public static void main(String[] args) {
        String s = "heeellooo";
        String[] words = {"hello", "hi", "helo"};
        System.out.println(expressiveWords(s, words));
    }
}
