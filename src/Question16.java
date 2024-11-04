import java.util.Scanner;

public class Question16 {
    int n;
    Question16(int a){
        n = a;
    }

    boolean isPrime(int a){
        boolean flag = true;
        for(int i = 2; i <= Math.sqrt(a); i++){
            if(a%i==0){
                flag = false;
                break;
            }
        }
        return (a>=2)&&flag;
    }

    void closestTwinPrime(){
        System.out.println("Number read in is:"+n);
        int prLeft = 0;
         int prRight;
        int count = 0;
        if(isPrime(n-1) && isPrime(n+1)){
            System.out.println("p1 = "+(n-1)+" p2 = "+(n+1));
        } else {
            while (count != n) {
                if (isPrime(n - count) && isPrime(n - count - 2)) {
                    prLeft = n - count;
                    break;
                }
                count++;
            }
            count = 0;
            while (true) {
                if (isPrime(n + count) && isPrime(n + count + 2)) {
                    prRight = n + count;
                    break;
                }
                count++;
            }
            if (prLeft != 0) {
                if (Math.min(Math.abs(n - prRight), Math.abs(n - prRight + 2)) < Math.min(Math.abs(n - prLeft), Math.abs(n - prLeft + 2))) {
                    System.out.println("p1 = "+prRight+" p2 = "+(prRight+2));
                } else {
                    System.out.println("p1 = "+(prLeft-2)+" p2 = "+prLeft);
                }
            } else {
                System.out.println("p1 = "+prRight+" p2 = "+(prRight+2));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter your number n (must be a +ve integer)");
        Question16 obj = new Question16((new Scanner(System.in)).nextInt());
        obj.closestTwinPrime();
    }
}
