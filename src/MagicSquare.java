import java.util.Arrays;

public class MagicSquare {

    /*
    for odd value of n, the rules are straightforward.
    1. starting position of i is n / 2 and j is n - 1
    2. next position is j + 1 and i - 1
    3. if (i == -1) and (j == n) then i = 0, j = n - 2
    4. if (i == -1) then i = n - 1
    5. if (j == n) then  j = 0
    6. if cell already occupied then new pos = i = i + 1, j = j - 2;
     */
    static int[][] generateSquareOdd(int n){
        int[][] matrix = new int[n][n];
        int i = n / 2,  j = n - 1; //rule 1
        for(int num = 1; num <= n * n;){
            if(i == -1 && j == n) //rule 3
            {
                i = 0;
                j = n - 2;
            }
            else {
                if (i == -1) { //rule 4
                    i = n - 1;
                }
                if (j == n) { //rule 5
                    j = 0;
                }
            }
            if(matrix[i][j] != 0){ //rule 6
                i = i + 1;
                j = j - 2;
                continue;
            }
            else
                matrix[i][j] = num++;
            //rule 2
            j++;
            i--;
        }
        return matrix;
    }


    //for even number its ridiculous.
    /*
    focus on
    1. first fill entire matrix with actual numbers [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]] for n = 4
    2. remember n * n + 1 - matrix[i][j]
    3. top left => i,j will go from 0 - n / 4
    4. top right => i will go from 0 - n / 4, j will go from 3n / 4 to n
    5. bottom left => i will go from 3n / 4 to n, j will go from 0 - n / 4
    6. bottom right => i,j will go from 3n / 4 - n
    7. center => i,j  will go from n / 4 to 3n / 4
     */
    static int[][] generateSquareEven(int n){
        int[][] matrix = new int[n][n];
        //for even we first need to populate original numbers;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                matrix[i][j] = (n * i) + j + 1;


        //top left
        for(int i = 0; i < n / 4; i++)
            for(int j = 0; j < n / 4; j++)
                matrix[i][j] = (n * n + 1) - matrix[i][j];
        //top right
        for(int i = 0; i < n / 4; i++)
            for(int j = (3 * n) / 4; j < n; j++)
                matrix[i][j] = (n * n + 1) - matrix[i][j];
        //bottom left
        for(int i = (3 * n) / 4; i < n; i++)
            for(int j = 0; j < n / 4; j++)
                matrix[i][j] = (n * n + 1) - matrix[i][j];
        //bottom right
        for(int i = (3 * n) / 4; i < n; i++)
            for(int j =(3 * n) / 4; j < n; j++)
                matrix[i][j] = (n * n + 1) - matrix[i][j];
        //center
        for(int i = n / 4; i < (3 * n) / 4; i++)
            for(int j = n / 4; j < (3 * n) / 4; j++)
                matrix[i][j] = (n * n + 1) - matrix[i][j];

        return matrix;
    }

    public static void main(String[] args) {
        int n = 4;
        if(n % 2 == 1)
            System.out.println(Arrays.deepToString(generateSquareOdd(n)));
        else
            System.out.println(Arrays.deepToString(generateSquareEven(n)));
    }
}
