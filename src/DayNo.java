import java.util.*;

public class DayNo {
    private int day, year, N;
    boolean input_validity = false;

    private boolean leap_year() {
        return (year % 100 == 0) ? (year % 400 == 0) : (year % 4 == 0);
    }

    public void accept_data() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the year");
            year = sc.nextInt();
            if (year < 1000 || year >9999) {
                System.out.println("Invalid input!");
                break;
            } else {
                input_validity = true;
            }

            System.out.println("Enter the day number");
            day = sc.nextInt();

            if ((!leap_year() && day == 366) || day > 366 || day < 1) {
                System.out.println("Invalid input!");
                input_validity = false;
                break;
            } else {
                input_validity = true;
            }

            System.out.println("Enter the number of days after");
            N = sc.nextInt();

            if (N > 100 || N < 1) {
                System.out.println("Invalid input!");
                input_validity = false;
                break;
            } else {
                input_validity = true;
            }

            break;
        }
    }

    private String d(int d) {
        int month_size[] = {31, (leap_year()) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int i = 0;
        String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String month = months[0];
        while (d > month_size[i]) {
            month = months[i + 1];
            d -= month_size[i];
            i++;
        }
        return (d + ((d >= 4 && d <= 20) ? "Th " :
                (d % 10 == 1) ? "St " :
                        (d % 10 == 2) ? "Nd " :
                                (d % 10 == 3) ? "Rd " : "Th ") + "of " + month + ", " + year);
    }

    public void date() {
        if (input_validity) {
            String a = this.d(day);
            int d = N;
            while (d >= ((leap_year()) ? 366 : 365)) {
                d -= (leap_year()) ? 366 : 365;
                year++;
            }
            String b = this.d(day + d);
            System.out.println("The required date is: " + a + "\nand after " + N + " days it will be: " + b);
        }
    }


    public static void main(String[] args) {
        DayNo ob = new DayNo();
        ob.accept_data();
        ob.date();
    }
}
