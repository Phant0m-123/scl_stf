import java.util.Scanner;

public class Question15 {
    int n, m;
    int[] arr_linear;
    int[][] arr;
    int[] min_ind = new int[2];
    int[] max_ind = new int[2];

    Question15(int a, int b) {
        n = a;
        m = b;
        arr_linear = new int[n * m];
        arr = new int[m][n];
    }

    void display() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    void inp() {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter your input");
                arr[i][j] = (new Scanner(System.in)).nextInt();
                arr_linear[count++] = arr[i][j];
            }
        }
    }

    void sortMatrix() {
        for (int i = 0; i < n * m - 1; i++) {
            for (int j = 0; j < n * m - 1 - i; j++) {
                if (arr_linear[j] > arr_linear[j + 1]) {
                    int temp = arr_linear[j];
                    arr_linear[j] = arr_linear[j + 1];
                    arr_linear[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr_linear[0] == arr[i][j]) {
                    min_ind[0] = i;
                    min_ind[1] = j;
                } else if (arr_linear[m * n - 1] == arr[i][j]) {
                    max_ind[0] = i;
                    max_ind[1] = j;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = arr_linear[count++];
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean inpValidity = true;
        int n, m;
        for (int i = 0; i < 1; i++) {
            System.out.println("Enter number of columns 'n'");
            n = sc.nextInt();
            if (n <= 2 || n >= 20) {
                inpValidity = false;
                break;
            }
            System.out.println("Enter number of rows 'm'");
            m = sc.nextInt();
            if (m <= 2 || m >= 20) {
                inpValidity = false;
                break;
            }
            Question15 obj = new Question15(n, m);
            obj.inp();
            System.out.println("Original Matrix");
            obj.display();
            obj.sortMatrix();
            System.out.println("Largest number = "+obj.arr[m-1][n-1]+"\nRow:" + obj.max_ind[0] + "\nColumn:" + obj.max_ind[1] + "\nSmallest number ="+obj.arr[0][0]+"\nRow:" + obj.min_ind[0] + "\nColumn:" + obj.min_ind[1]);
            System.out.println("Rearranged matrix:");
            obj.display();
        }
        if (!inpValidity) {
            System.out.println("INVALID INPUT");
        }
    }

}
