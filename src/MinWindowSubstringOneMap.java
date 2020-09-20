import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstringOneMap {

    public String minWindow(String s, String t) {
        if(s.length() == 0 || s == null || s.length() < t.length() || t == null)
            return "";
        Map<Character, Integer> map = new HashMap<>();
        //create hashmap for string t
        for(char c: t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        //some initializations
        int left = 0;
        int minLeft = 0;
        int minLength = s.length() + 1;
        int count = 0;

        //traverse with right pointer for search string s
        for(int right = 0; right < s.length(); right++){
            char r = s.charAt(right);
            //if char is in hashmap, that means t has this char too
            if(map.containsKey(r))
            {
                map.put(r, map.get(r) - 1);
                //we subtract and if count of char is still greater than 0, that means t has more
                //so now we check equal to t.
                if(map.get(r) >= 0)
                    count++;

                //find all chars and move left
                while(count == t.length()){
                    //when count matches, that means all chars found so now update minleft and minlength
                    if(right - left + 1 < minLength){
                        minLeft = left;
                        minLength = right - left + 1;
                    }
                    //now move l forward
                    char l = s.charAt(left);
                    if(map.containsKey(l)){
                        map.put(l, map.get(l) + 1);
                        if(map.get(l) > 0)
                            count--;
                    }
                    left++;
                }
            }//finish loop for right
        }

        if(minLength > s.length())
            return "";
        return s.substring(minLeft, minLeft + minLength);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        String s = "adobecidebanc";
        String t = "abc";
        System.out.println(obj.minWindow(s, t));
    }
}
