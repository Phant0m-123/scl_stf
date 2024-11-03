import java.util.Scanner;

public class Special {

    int n;

    Special() {
        n = 0;
    }

    Special(int a) {
        n = a;
    }

    int factorial(int x) {
        int fact = 1;
        for (int i = 2; i <= x; i++) {
            fact *= i;
        }
        return (x >= 0) ? fact : -1;
    }

    void sum(){
        System.out.println( (int) ((n>=10)? Math.floor(n/Math.pow(10,Math.floor(Math.log10(n)))) + n%10 : n));
    }

    void isSpecial() {
        int sum = 0, cpy = n;
        while(cpy>0){
            sum+=factorial(cpy%10);
            cpy/=10;
        }
        System.out.println(n + " is " + ((n==sum)? "": "not ") + "a special number" );
    }

    public static void main(String[] args) {
        System.out.println("Enter the value of n");
        Special obj = new Special((new Scanner(System.in)).nextInt());
        obj.sum();
        obj.isSpecial();
    }

}
