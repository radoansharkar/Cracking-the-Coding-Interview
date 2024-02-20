import java.util.Scanner;

public class ZeroMatrix {
    
    static void setZeros (int[][] matrix){ 

        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;
        
        for (int j = 0; j < m; j++){
            if (matrix[0][j] == 0)
                firstRowHasZero = true;
        }

        for (int i = 0; i < n; i++){
            if (matrix[i][0] == 0)
                firstColumnHasZero = true;
        }

        // traverse through the whole matrix except the first row and column
        for (int i = 1; i < n; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;       /* If I find any 0, I just mark the respected rows and columns position in the first column and row */
                    matrix[0][j] = 0;
                }
            }
        }

        for (int j = 0; j < m; j++){
            if (matrix[0][j] == 0)
                nullifyColumn(matrix, j);
        }

        for (int i = 0; i < n; i++){
            if (matrix[i][0] == 0)
                nullifyRow(matrix, i);
        }

        if (firstColumnHasZero)
            nullifyColumn(matrix, 0);

        if (firstRowHasZero)
            nullifyRow(matrix, 0);
    }

    static void nullifyRow(int[][] matrix, int row){
        for (int j = 0; j < matrix[0].length; j++){
            matrix[row][j] = 0;
        }
    }

    static void nullifyColumn(int[][] matrix, int column){
        for (int i = 0; i < matrix.length; i++){
            matrix[i][column] = 0;
        }
    }

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                matrix[i][j] = sc.nextInt();
        }

        setZeros(matrix);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        
        sc.close();
    }
}

/*

input:
4 5
1 1 2 4 1
1 2 3 9 8
1 1 1 1 1
5 5 0 5 5

output:
1 1 0 4 1 
1 2 0 9 8 
1 1 0 1 1 
0 0 0 0 0

*/
