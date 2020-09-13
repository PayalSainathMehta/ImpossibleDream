public class DominoRotations {

    static int getMinRotations(int[] a, int[] b){
        //O(n) time
        int[] countA = new int[7]; //as values in arrays will be dice values 1-6
        int[] countB = new int[7];
        int[] same = new int[7];
        int n = a.length;
        for(int i = 0; i < n; i++){
            countA[a[i]]++;
            countB[b[i]]++;
            if(a[i] == b[i])
                same[a[i]]++;
        }
        //logic
        for(int i = 0; i < 7; i++){
            if(countA[i] + countB[i] - same[i] == n)
                return n - Math.max(countA[i], countB[i]);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {2,1,2,4,2,2};
        int[] b = {5,2,6,2,3,2};
        System.out.println(getMinRotations(a, b));
    }
}
