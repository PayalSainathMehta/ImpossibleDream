import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumChairs {
    /*
    This problem is same as Meeting room 2 where we find the minimum number of rooms needed for conducting all meetings
     */
    public static int minChairs(int[][] intervals) {
        if(intervals.length == 0 || intervals == null)
            return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); //start time ascending
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(intervals[0][1]); //add end times
        for(int i = 1; i < intervals.length; i++){
            int endTime = pq.peek();
            if(intervals[i][0] < endTime)//we need new room
                pq.offer(intervals[i][1]);
            else{//no conflict, use same room
                pq.poll();//we need to reuse hence assign previous chair
                pq.offer(intervals[i][1]);//to next
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        int[] s = {1,2,6,5,3};
        int[] e = {5,5,7,6,8};
        int n = s.length;
        int[][] intervals = new int[s.length][2]; //as start and end times
        for(int i = 0 ;i < n; i++){
            intervals[i][0] = s[i];
            intervals[i][1] = e[i];
        }
        System.out.println(minChairs(intervals));
    }
}
