import java.util.Scanner;

public class OuterSort {
    int[] border;
    int[][] matrix;
    int n;
    int m;

    OuterSort(int a, int b) {
        n = a;
        m = b;
        border = new int[2 * (n + m - 1)];
        matrix = new int[m][n];
    }

    void inp() {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Enter your input");
                matrix[i][j] = (new Scanner(System.in)).nextInt();
                if (i == 0 || i == m - 1) {
                    border[count++] = matrix[i][j];
                } else if ((j == 0 || j == n - 1) && !(i == 0 || i == m - 1)) {
                    border[count++] = matrix[i][j];
                }
            }
        }
    }

    void sort() {
        for (int i = 0; i < 2 * (n + m - 2) - 1; i++) {
            for (int j = 0; j < 2 * (n + m - 2) - 1 - i; j++) {
                if (border[j] > border[j + 1]) {
                    int temp = border[j];
                    border[j] = border[j + 1];
                    border[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < 2 * (m + n - 2); i++) {
            if (i < n) {
                matrix[0][i] = border[i];
            } else if (i >= n && i <= n + m - 2) {
                matrix[i - n + 1][n - 1] = border[i];
            } else if (i >= n + m - 1 && i <= m + 2 * n - 3) {
                matrix[m - 1][m + 2 * n - 3 - i] = border[i];
            } else if (i >= m + 2 * n - 2 && i <= 2 * (m + n - 2)) {
                matrix[2 * (m + n - 2) - i][0] = border[i];
            }
        }

    }

    void display() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    void displayBorderElements() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1) {
                    System.out.print(matrix[i][j] + "\t");
                } else if ((j == 0 || j == n - 1) && !(i == 0 || i == m - 1)) {
                    System.out.print(matrix[i][j] + "\t \t");
                }
            }
            System.out.println();
        }
    }

    int sumOfOuterRowsAndColumns(){
        int sum = 0;
        for(int i = 0; i<2*(m+n-2);i++){
            sum+= border[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean inpValidity = true;
        int n,m;
        for(int i = 0; i<1;i++) {
            System.out.println("Enter number of columns 'n'");
            n = sc.nextInt();
            if(n<=2||n>=20){
                inpValidity = false;
                break;
            }
            System.out.println("Enter number of rows 'm'");
            m = sc.nextInt();
            if(m<=2||m>=20){
                inpValidity = false;
                break;
            }
            OuterSort obj = new OuterSort(n, m);
            obj.inp();

            System.out.println("ORIGINAL MATRIX");
            obj.display();

            System.out.println("REARRANGED MATRIX");
            obj.sort();
            obj.display();

            System.out.println("BOUNDARY ELEMENTS");
            obj.displayBorderElements();

            System.out.println("SUM OF THE OUTER ROW AND COLUMN ELEMENTS= " + obj.sumOfOuterRowsAndColumns());
        }
        if (!inpValidity) {
            System.out.println("INVALID INPUT");
        }
    }

}
