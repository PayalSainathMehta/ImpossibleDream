import java.util.HashMap;
import java.util.Map;

public class LargestComponentByCommonFactor {

    public static int getNumberOfComponents(int[] nums){
        int maxValue = Integer.MIN_VALUE;
        for(int ele: nums)
            maxValue = Math.max(maxValue, ele);
        UnionFind uf = new UnionFind(maxValue);
        int n = nums.length;

        //pick each element and get its factors, add its factors to groups by union
        for(int ele: nums){
            for(int j = 2; j <= (int)Math.sqrt(ele); j++){
                if(ele % j == 0)
                {
                    uf.union(ele, j);
                    uf.union(ele, ele / j);
                }
            }
        }

        //now time to find.
        //pick each element - get its root, check if its root is in hashmap or not,
        //if not, add, else add + 1,
        //get count, get max, return final max
        int maxGroupSize = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int ele: nums){
            int root = uf.find(ele);
            map.put(root, map.getOrDefault(root, 0) + 1);
            int count = map.get(root);
            maxGroupSize = Math.max(maxGroupSize, count);
        }
        return maxGroupSize;
    }

    public static void main(String[] args) {
        int[] nums = {20,50,9,63};
        System.out.println(getNumberOfComponents(nums));
    }

}
