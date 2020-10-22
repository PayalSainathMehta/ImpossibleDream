import java.util.Arrays;

public class HousesAndStores {

    static int[] getDistance(int[] houses, int[] stores){
        int h = houses.length;
        int s = stores.length;
        int[] result = new int[h];
        Arrays.sort(stores); //as we going to apply BS
        for(int i = 0; i < h; i++){
            int house = houses[i];
            int dist = Integer.MAX_VALUE;
            int store = 0;
            int left = 0, right = s - 1;
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(house == stores[mid]) //found it
                {
                    store = house;
                    break;
                } //now begins the search,
                //first work on distance
                //always keep minimum in dist hence we started with max value
                else{
                    int d = Math.abs(house - stores[mid]);
                    if(d == dist){
                        store = Math.min(store, stores[mid]);
                    }
                    else if(d < dist){
                        dist = d;
                        store = stores[mid];
                    }
                    if (stores[mid] < house) {
                        left = mid + 1; //BS condition
                    } else {
                        right = mid - 1; //BS condition
                    }
                }
            }
            result[i] = store; //we found it
        }
        return result;
    }

    public static void main(String[] args) {
        int[] houses = {2,4,2};
        int[] stores = {5,1,2,3};
        System.out.println(Arrays.toString(getDistance(houses, stores)));
    }
}
