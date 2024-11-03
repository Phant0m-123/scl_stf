import java.util.*;

public class PrimePalindrome {

    boolean isPrime(int a) {
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                flag = false;
                break;
            }
        }
        return a > 1 && flag;
    }

    int reverseNo(int a) {
        int rev = 0;
        while (a > 0) {
            rev = rev * 10 + a % 10;
            a /= 10;
        }
        return rev;
    }

    boolean isPalindrome(int a) {
        return a == reverseNo(a);
    }

    boolean isPrimePalindrome(int a) {
        return isPrime(a) && isPrime(reverseNo(a)) && isPalindrome(a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrimePalindrome obj = new PrimePalindrome();

        System.out.print("\nPrime Palindromes between 'm' and 'n'\n-------------------------------------\nEnter 'm'\n=>");
        int m = sc.nextInt();
        boolean inpValidity = m < 3000 && m > 0;

        System.out.print("\nEnter 'n'\n=>");
        int n = sc.nextInt();
        inpValidity = n > m && n > 0 && n < 3000 && inpValidity;


        if (inpValidity) {
            int[] arr = new int[n - m];
            int arrind = 0;
            arr[0] = -999;

            for (int i = m; i <= n; i++) {
                if (obj.isPrimePalindrome(i)) {
                    arr[arrind++] = i;
                }
            }

            if (arr[0] != -999) {
                int i = 0;
                System.out.println("The Prime Palindrome numbers between m = " + m + " and n = " + n + " are:");
                while (arr[i] != 0 && i < arr.length) {
                    System.out.print(arr[i++] + ((arr[i] != 0 && i < arr.length) ? ", " : ""));
                }
            } else {
                System.out.println("There are no Prime Palindromes between " + m + " and " + n);
            }
        } else {
            System.out.println("Out of Range");
        }

    }

}
