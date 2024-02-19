import java.util.Scanner;

public class RotateMatrix {
    
    static void rotate(int[][] matrix){
        if (matrix.length == 0 || matrix.length != matrix[0].length)
            return;

        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;
                
                int top = matrix[first][i]; //save top

                // left --> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom --> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right --> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top --> right
                matrix[i][last] = top; // right <- saved top

            }
        }
        
    }
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        }

        // rotating
        rotate(matrix);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        
        sc.close();
    }
}


/* 1 0 1 0 1         0 0 1 1 1 
 * 1 0 0 0 1         0 1 1 0 0 
 * 1 1 1 1 1   -->   0 0 1 0 1  
 * 0 1 0 1 0         0 1 1 0 0
 * 0 0 0 0 0         0 0 1 1 1
*/
