import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {

    static int[] getNextElement(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[m];

        //form stack and hashmap for next greater element.
        //add to map as ele, next greater element to ele
        Stack<Integer> stack = new Stack();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && stack.peek() < nums2[i])
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }
        for(int i = 0; i < m; i++){
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(getNextElement(nums1, nums2)));
    }
}
