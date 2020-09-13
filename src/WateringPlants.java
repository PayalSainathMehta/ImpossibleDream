public class WateringPlants {

    private static int getNumRefills(int[] plants, int cap1, int cap2) {
        int numRefills = 0; //initially no refills
        int can1 = 0, can2 = 0, lo = 0, hi = plants.length - 1;
        while(lo < hi) //apply binary search
        {
            if(can1 < plants[lo]){ //if you dont have enough
                can1 = cap1; //in the start you wont.
                numRefills++;
            }
            if(cap2 < plants[hi]){
                can2 = cap2;
                numRefills++;
            }
            can1 -= plants[lo++];
            can2 -= plants[hi--];
        }
        if(lo == hi && plants[lo] > can1 + can2) //for remaining
            return ++numRefills;
        return numRefills;
    }

    public static void main(String[] args) {
        int[] plants = {2,4,5,1,2};
        int cap1 = 5, cap2 = 7;
        System.out.println(getNumRefills(plants, cap1, cap2));
    }
}
