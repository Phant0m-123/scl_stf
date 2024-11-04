import java.util.Scanner;

public class NumberInWords {
    int n;
    String[] basic = {"ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN","NINETEEN"};
    String[] tens = {"TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};

    NumberInWords(int a){
        n = a;
    }

    String toWords(){
        String output = ((n>=100)? basic[(int) Math.floor(n/100) - 1] + " HUNDRED AND ": "") + ((n%100<=19)? basic[n%100 - 1]: (tens[((int) (n - 100*Math.floor(n/100)- n%10)/10 - 2)] + " "+ basic[n%10 - 1]));
        return output;
    }

    public static void main(String[] args) {
        System.out.println("Enter your number");
        int n = (new Scanner(System.in)).nextInt();
        if (n>0 && n <1000){
            NumberInWords obj = new NumberInWords(n);
            System.out.println(obj.toWords());
        } else {
            System.out.println("OUT OF RANGE");
        }
    }
}
