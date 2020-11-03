public class MinimumWindowSubsequence {

    static String getMinimumWindowSubseq(String s, String t){
        if(s.length() == 0 || t.length() == 0)
            return "";

        int right = 0; //this is the fast pointer
        int minLen = Integer.MAX_VALUE; //max value put in minLen
        String result = ""; //to be returned
        for(right = 0; right < s.length();) { //traverse till end
            int ti = 0; //find last character of t in s
            while (right < s.length()) { //traverse till end
                if (s.charAt(right) == t.charAt(ti))
                    ti++;
                if (ti == t.length())
                    break;
                right++;
            }
            if (right == s.length())
                break;

            // use another slow pointer to traverse from right to left until find first character of T in S
            int left = right;
            ti = t.length() - 1;
            while(left >= 0){
                if(s.charAt(left) == t.charAt(ti))
                    ti--;
                if(ti < 0)
                    break;
                left--;
            }
            // if we found another subsequence with smaller length, update result
            if (right - left + 1 < minLen) {
                minLen = right - left + 1;
                result = s.substring(left, left + minLen);
            }
            // WARNING: we have to move right pointer to the next position of left pointer, NOT the next position
            // of right pointer
            right = left + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcdebede";
        String t = "bde";
        System.out.println(getMinimumWindowSubseq(s, t));
    }
}
