import java.util.Scanner;

public class Revstr {
    String Str, Revst = "";
    void getStr(){
        Scanner sc = new Scanner(System.in);
        Str = sc.nextLine();
    }

    void recReverse(int n){
        try{
            Revst += Str.charAt(n);
            recReverse(--n);
        } catch (StringIndexOutOfBoundsException e){
            ;
        }
    }

    void check(){
        recReverse(Str.length()-1);
        System.out.println((Str.equals(Revst))? "Palindrome string":"Not palindrome string");
    }

    void lucky_numbers(int n){
        int pr[] = new int[n-1];
        for(int i = 0; i< n-1;i++){
            pr[i] = i+1;
        }
        for(int i = 1; i<n-1;i++){
            for(int j = i; j<n-1-i;j++){
                pr[j] = pr[j+1];
            }
            for(int j = 0; j<n-1;j++){
                System.out.print(pr[j]+"\t");
            }
            System.out.println();
        }
        for(int i = 0;i<n-1;i++){
            if (pr[i]==pr[i+1]) {
                break;
            }
            System.out.println(pr[i]);
        }

    }
}
