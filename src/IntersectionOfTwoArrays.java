import java.util.*;

public class IntersectionOfTwoArrays {

    //O(n) time
    //O(n) space
    public static int[] intersectionWithSet(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums1)
            set.add(num);
        List<Integer> result = new ArrayList<>();
        for(int num: nums2){
            if(set.contains(num)){
                result.add(num);
                set.remove(num);
            }
        }
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
            res[i] = result.get(i);
        return res;
    }

    //O(n) time (considering sorted arrays)
    //O(1) space (ignoring output space)
    public static int[] intersectionWithoutSet(int[] nums1, int[] nums2) {
        //output space is not counted
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length){
            //ignore duplicates
            while(i > 0 && i < nums1.length && nums1[i] == nums1[i - 1])
                i++;
            while(j > 0 && j < nums2.length && nums2[j] == nums2[j - 1])
                j++;

            //if still valid
            if(i < nums1.length && j < nums2.length){
                int m = nums1[i];
                int n = nums2[j];
                if(m == n){
                    result.add(n);
                    i++;
                    j++;
                }
                else if(m > n)
                    j++;
                else
                    i++;
            }
        }
        return result.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersectionWithSet(nums1, nums2)));

        /*
        Now the second improvement that can be asked for is do this in linear time and constant space.
        for the linear time, we need to have sorted arrays, otherwise sorting itself will take nlogn
        so we assume sorted arrays (rather sort it for this solution)
         */
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        System.out.println(Arrays.toString(intersectionWithoutSet(nums1, nums2)));
    }
}
