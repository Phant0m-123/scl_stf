import java.util.Scanner;

public class MatrixOpr {
    int n;
    int[] arr_linear;
    int[][] arr;
    int[] min_ind = new int[2];
    int[] max_ind = new int[2];
    MatrixOpr(int a){
        n = a;
        arr_linear = new int[n*n];
        arr = new int[n][n];
    }

    void sortMatrix(){
        for(int i = 0; i < n*n - 1; i++){
            for (int j = 0; j < n*n - 1 - i; j++){
                if (arr_linear[j]>arr_linear[j+1]){
                    int temp = arr_linear[j];
                    arr_linear[j] = arr_linear[j+1];
                    arr_linear[j+1] = temp;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (arr_linear[0] == arr[i][j]){
                    min_ind[0] = i;
                    min_ind[1] = j;
                } else if (arr_linear[n*n-1]==arr[i][j]) {
                    max_ind[0] = i;
                    max_ind[1] = j;
                }
            }
        }

        for(int i = 0; i < n*n; i++){
           arr[(int) Math.floor(i/n)][i%n] = arr_linear[i];
        }
    }

    void display(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }

    void inp(){
        for(int i = 0; i < n*n; i++){
            System.out.println("Enter your input");
            arr_linear[i] = (new Scanner(System.in)).nextInt();
            arr[(int) Math.floor(i/n)][i%n] = arr_linear[i];
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter n");
        int inp = (new Scanner(System.in).nextInt());
        if (inp <= 20 && inp >=1) {
            MatrixOpr obj = new MatrixOpr(inp);
            obj.inp();
            System.out.println("Original Matrix");
            obj.display();
            obj.sortMatrix();
            System.out.println("Largest number at index [" + obj.max_ind[0] + "][" + obj.max_ind[1] + "]\nSmallest number at index [" + obj.min_ind[0] + "][" + obj.min_ind[1] + "]");
            System.out.println("Sorted matrix");
            obj.display();
        }else{
            System.out.println("Invalid Input");
        }
    }

}
