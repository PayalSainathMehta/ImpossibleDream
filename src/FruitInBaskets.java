import java.util.HashMap;
import java.util.Map;

public class FruitInBaskets {

    /* This problem is similar
        to longest subarray length with atmost 2 unique characters , 2 can be replaced by k
     */

    //O(n)
    public static int totalFruit(int[] tree) {
        if(tree.length == 0 || tree == null)
            return 0;
        int max = 1;
        int i = 0, j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        //map at any point will only store 2 items as 2 baskets
        while(j < tree.length){
            if(map.size() <= 2)
                map.put(tree[j], j++); //j will keep moving and we update prev seen fruits
            if(map.size() > 2){ //now we'll have to remove
                int min = tree.length - 1;
                for(int value: map.values()){
                    min = Math.min(min, value); //keep updating the min
                }
                i = min + 1;
                map.remove(tree[min]); //we need min only to know what to remove
            }
            max = Math.max(max, j - i); //max elements
        }
        return max;
    }

    public static void main(String[] args) {
        int[] tree = {1,2,3,2,2};
        System.out.println(totalFruit(tree));
    }
}
