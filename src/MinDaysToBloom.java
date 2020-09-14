public class MinDaysToBloom {
    /*
    In this problem,
    we are given rose i blooms on day roses[i].
    we are required to return roses[i] value when we can have n bouquets with k bloomed roses each.
     */
    static int getMinDays(int[] roses, int k, int n){
        if(roses == null || k == 0 || n == 0)
            return 0;
        //main base condition
        if(n * k > roses.length)
            return -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int r: roses){
            min = Math.min(min, r);
            max = Math.max(max, r);
        }
        //binary search
        while(min <= max){
            int mid = min + (max - min) / 2; //middle day
            if(isValid(roses, k, n, mid)) max = mid - 1; //check if that day is valid, valid if day lesser or equal to exists in roses[]
            else min = mid + 1;
        }
        return min;
    }

    static boolean isValid(int[] roses, int k, int n, int day){
        int curcount = 0, cursize = 0;
        for(int val: roses){
            if(val <= day)
                cursize++;
            else
                cursize = 0;
            if(cursize == k)
            {
                cursize = 0;
                curcount++;
            }
            if(curcount == n)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] roses = {1,2,4,9,3,4,1};
        int n = 2, k = 2;
        System.out.println(getMinDays(roses, k, n));
    }
}
