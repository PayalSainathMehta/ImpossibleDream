import java.util.Arrays;

public class NextPermutation {

    static void nextPermutation(int[] nums){
        if(nums.length == 0 || nums == null)
            return;
        int n = nums.length;
        int i = n - 2; //start from second last element
        while(i >= 0 && nums[i] >= nums[i + 1]) //continue till the point you find smaller element
            i--;
        if(i >= 0){ //now if still there are some left that means its not descending sorted
            int j = n - 1; //start from last
            while(j >= 0 && nums[i] >= nums[j]) //find least greater to nums[i]
                j--;
            swap(nums, i, j); //swap both
        }
        reverse(nums, i + 1); //reverse upto last
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
