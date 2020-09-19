import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    static List<String> getMissingRanges(int[] nums, int lower, int upper){
        List<String> result = new ArrayList<>();
        int n = nums.length;
        //start from first valid number
        int next = lower;
        for(int i = 0; i < n; i++) {
            if(nums[i] < next) //if lower ignore
                continue;
            if(nums[i] == next){ //if equal found it, check if next valid next++ exists
                next++;
                continue;
            }
            //will come here only when something didnt match above
            //find the range upto nums[i]
            String ranges = getRange(next, nums[i] - 1);
            result.add(ranges);
            next = nums[i] + 1;
        }

        //final check for remaining upto upper valid number
        if(next <= upper)
        {
            String ranges = getRange(next, upper);
            result.add(ranges);
        }
        return result;
    }

    static String getRange(int n1, int n2){
        if(n1 == n2)
            return String.valueOf(n1);
        return String.format("%d->%d", n1, n2);
    }

    public static void main(String[] args) {
        int[] nums = {0,1,3,50,75};
        int lower = 0, upper = 99;
        System.out.println(getMissingRanges(nums, lower, upper).toString());
    }
}
