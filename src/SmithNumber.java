import java.util.Scanner;

public class SmithNumber {
    int n;
    SmithNumber(int a){
        n=a;
    }

    int sumD(int a){
        int sum = 0;
        while(a>0){
            sum+= a%10;
            a/=10;
        }
        return sum;
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

    boolean isSmith(int a){
        int copy = a;
        int sumOfDigitsOfPF = 0, pf=2;
        while(a!=1){
            if(a%pf == 0 && this.isPrime(pf)){
                sumOfDigitsOfPF += this.sumD(pf);
                a/=pf;
            } else {
                pf++;
            }
        }
        return sumOfDigitsOfPF==this.sumD(copy)&&!this.isPrime(a);
    }

    void isSmith(){
        System.out.println(((this.isSmith(n))? "":"NOT ") + "SMITH number");
    }

    public static void main(String[] args) {
        System.out.println("Enter your number");
        SmithNumber obj = new SmithNumber((new Scanner(System.in)).nextInt());
        obj.isSmith();
    }
}
