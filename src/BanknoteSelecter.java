import java.util.Scanner;

public class BanknoteSelecter {
    int amt, amtc;
    int[] noteValues = {1000,500,100,50,20,10,5,2,1};
    int[] amtOfEachNote = {0,0,0,0,0,0,0,0,0};

    void calNotes(){
        amtc = amt;
        for(int i = 0; i < 9; i++){
            while(amtc>=noteValues[i]){
                amtc -= noteValues[i];
                amtOfEachNote[i]++;
            }
        }
        for(int i = 0; i<9; i++){
            System.out.println("Denomination "+noteValues[i]+": "+amtOfEachNote[i]);
        }
    }

    void acceptAmt(){
        System.out.println("Enter the amount");
        amt = (new Scanner(System.in)).nextInt();
    }

    public static void main(String[] args) {
        BanknoteSelecter ob = new BanknoteSelecter();
        ob.acceptAmt();
        ob.calNotes();
    }
}
