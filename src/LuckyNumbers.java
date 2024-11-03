import java.util.*;

public class LuckyNumbers {
    int[] series, copy;
    int n, prev = 0;

    LuckyNumbers(int a) {
        series = new int[a];
        copy = new int[a];
        n = a;
        this.populate();
    }

    void populate() {
        for (int i = 0; i < n; i++) {
            series[i] = i + 1;
        }
    }


    void removeXthElement(int x) {
        for (int i = x + prev - 1; i < n; i += x) {
            System.out.println(i);
            series[i] = -1;
        }
        prev = x;
    }

    void copyArray() {
        for (int i = 0; i < n; i++) {
            copy[i] = series[i];
        }
    }


    boolean isEqual() {
        boolean flag = true;

        for (int i = 0; i < n; i++) {
            if (copy[i] == series[i]) {
                flag = false;
                break;
            }
        }

        return flag;
    }


    void findLuckies() {
        this.copyArray();
        this.removeXthElement(2);
        int count = 3;
        while (!this.isEqual()) {
            this.copyArray();
            this.removeXthElement(count++);
            System.out.println();
            this.display();
        }
    }


    void display() {
        for (int i = 0; i < n; i++) {
            if (series[i] != -1) {
                System.out.print(series[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        LuckyNumbers obj = new LuckyNumbers(25);
        obj.findLuckies();
        obj.display();
    }

}
