import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String searchString, String t) {
        Map<Character, Integer> requiredCharacters = buildMappingOfCharactersToOccurrences(t);
        Map<Character, Integer> windowCharacterMapping = new HashMap<Character, Integer>();

        int left = 0;
        int right = 0;

        int totalCharFrequenciesToMatch = requiredCharacters.size();
        int charFrequenciesInWindowThatMatch = 0;

        int minWindowLengthSeenSoFar = Integer.MAX_VALUE;
        String minWindow = "";

        //just store current window characters to hashmap
        while (right < searchString.length()) {
            char characterAtRightPointer = searchString.charAt(right);
            addCharacterToHashtableMapping(windowCharacterMapping, characterAtRightPointer);

            //check if requirement met
            boolean rightCharIsARequirement = requiredCharacters.containsKey(characterAtRightPointer);
            if (rightCharIsARequirement) {
                boolean requirementForCharacterMet = requiredCharacters.get(characterAtRightPointer)
                        .intValue() == windowCharacterMapping.get(characterAtRightPointer).intValue();

                //add to match
                if (requirementForCharacterMet) {
                    charFrequenciesInWindowThatMatch++;
                }
            }

            //if we found all matches and left <=right, we can still look for better answers
            while (charFrequenciesInWindowThatMatch == totalCharFrequenciesToMatch && left <= right) {
                char characterAtLeftPointer = searchString.charAt(left);
                int windowSize = right - left + 1;

                //update min window
                if (windowSize < minWindowLengthSeenSoFar) {
                    minWindowLengthSeenSoFar = windowSize;
                    minWindow = searchString.substring(left, right + 1);
                }

                windowCharacterMapping.put(characterAtLeftPointer, windowCharacterMapping.get(characterAtLeftPointer) - 1);

                //check if we need the left character, or else can we do left++ to shorten the matched string
                boolean leftCharIsARequirement = requiredCharacters.containsKey(characterAtLeftPointer);
                if (leftCharIsARequirement) {
                    boolean characterFailsRequirement = windowCharacterMapping.get(characterAtLeftPointer)
                            .intValue() < requiredCharacters.get(characterAtLeftPointer).intValue();

                    if (characterFailsRequirement) {
                        charFrequenciesInWindowThatMatch--;
                    }
                }

                left++;
            }

            right++;
        }

        return minWindow;
    }

    //just store the string t chars with frequencies in map
    private Map<Character, Integer> buildMappingOfCharactersToOccurrences(String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0) + 1);
        }

        return map;
    }

    //just put the frequencies of the window character
    private void addCharacterToHashtableMapping(Map<Character, Integer> map, Character c) {
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        String s = "adobecidebanc";
        String t = "abc";
        System.out.println(obj.minWindow(s, t));
    }
}

