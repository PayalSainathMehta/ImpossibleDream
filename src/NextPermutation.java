import java.util.Arrays;

public class NextPermutation {

    static void nextPermutation(int[] nums){
         //approach
        //1. we find the first element - nums[i] after which the sequence is strictly increasing
        //2. now we find the element - nums[j] starting from end which is just greater than nums[i]
        //3. now we swap both of these
        //4. we reverse the numbers from nums[i + 1]
        
        int n = nums.length;
        int i = n - 2;
        //1. 
        while(i >= 0 && nums[i] >= nums[i + 1])
            i--;
        //now i is the pos after which the seq is strictly decreasing
        //2.
        if(i >= 0) //sometimes the entire array might be strictly decreasing, in that case we just do reverse - direct step 4.
        {
            int j = n - 1;
            while(j >= 0 && nums[i] >= nums[j])
                j--;
            //now j is the pos where nums[j] is just greater than nums[i];
            //3.
            swap(nums, i, j);
        }
        //4.
        reverse(nums, i + 1);
    }

    static void reverse(int[] nums, int start){
        int i = start, j = nums.length - 1;
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    static void swap(int[] nums, int i, int j){
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
