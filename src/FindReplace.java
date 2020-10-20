import java.util.HashMap;
import java.util.Map;

public class FindReplace {

    static String replace(String s, int[] indexes, String[] sources, String[] targets){

        //first form a hashmap by adding source only if original string starts with it
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < indexes.length; i++){
            if(s.startsWith(sources[i], indexes[i]))
                map.put(indexes[i], i);
        }
        //now traverse original string and replace if in hashmap
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length();){
            if(map.containsKey(i)){
                sb.append(targets[map.get(i)]);
                i += sources[map.get(i)].length();
            }
            else{
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcd";
        int[] indexes = {0,2};
        String[] sources = {"a","cd"};
        String[] targets = {"eee", "ffff"};
        System.out.println(replace(s, indexes, sources, targets));
    }
}
