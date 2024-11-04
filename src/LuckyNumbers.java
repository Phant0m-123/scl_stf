import java.util.*;

public class LuckyNumbers {
    int[] nos;
    int n, size;

    LuckyNumbers(int a) {
        n = a;
        nos = new int[n];
        for(int i = 0; i < n; i++){
            nos[i] = i+1;
        }
    }

    void findLuckies() {
        int count = 2;
        size = n;
        while (count <= size) {
            int j = 0;
            for (int i = 0; i < size; i++) {
                if ((i + 1) % count != 0) {
                    nos[j] = nos[i];
                    j++;
                }
            }
            size = j;
            count++;
        }
    }

    void displayLuckies(){
        this.findLuckies();
        System.out.println("THE LUCKY NUMBERS LESS THAN  "+n+" ARE");
        for (int i = 0; i < size; i++){
            System.out.println(nos[i]);
        }
    }


    public static void main(String[] args) {
        System.out.println("Enter 'n'");
        int n = (new Scanner(System.in)).nextInt();
        if(n>0 && n<=50) {
            LuckyNumbers obj = new LuckyNumbers(n);
            obj.displayLuckies();
        } else {
            System.out.println("INVALID INPUT");
        }
    }
}
