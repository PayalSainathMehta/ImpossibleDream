public class NumberOfDecreasingSubsequences {

    /*
    we use binary search
    O(nlogn)
     */
    static int getCount(int[] nums){
        int size = 0;
        int[] piles = new int[nums.length];
        for(int val: nums){
            int pile = binarySearch(piles, 0, size, val);
            piles[pile] = val;
            if(pile == size)
                size++;
        }
        return size;
    }

    static int binarySearch(int[] piles, int lo, int hi, int target){
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(piles[mid] <= target)
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {2, 9, 12, 13, 4, 7, 6, 5, 10};
        System.out.println(getCount(nums));
    }
}


