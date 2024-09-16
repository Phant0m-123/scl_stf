public class PrintJob {
    int job[], Front, Rear, Capacity, Newjob=0;

    PrintJob() {
        Capacity = 3;
        Front = -1;
        Rear = -1;
        createJob();
    }


    void createJob() {
        job = new int[Capacity];
    }

    void addJob() {
        if ((Rear % Capacity) == Capacity) {
            System.out.println("Printjob is full, cannot add any more");
        } else {
            job[++Rear % Capacity] = ++Newjob;
        }
    }

    void removeJob() {
        if (Front == Rear) {
            System.out.println("Printjob is empty");
        } else {
            ++Front;
        }
    }

//    int sum(int n){
//        return (int) (Math.floor(n/(Math.pow(10,Math.floor(Math.log10(n))))) + (n%10));
//    }

    public static void main(String[] args) {
//        PrintJob a = new PrintJob();
//        a.addJob();
//        a.addJob();
//        a.addJob();
//        for (int i = 0; i < a.Capacity; i++)
//            System.out.print(a.job[i] + "\t");
//        System.out.println("\nFront: " + a.Front + "\tRear: " + a.Rear);
//        a.removeJob();
//        a.removeJob();
//        a.removeJob();
//        a.addJob();
//        a.addJob();
//        a.addJob();
//        for (int i = 0; i < a.Capacity; i++)
//            System.out.print(a.job[i] + "\t");
//        System.out.println("\nFront: " + a.Front + "\tRear: " + a.Rear);
//        a.removeJob();
//        a.removeJob();
//        a.removeJob();
//        a.addJob();
//        a.addJob();
//        a.addJob();
//        for (int i = 0; i < a.Capacity; i++)
//            System.out.print(a.job[i] + "\t");
//        System.out.println("\nFront: " + a.Front + "\tRear: " + a.Rear);
        RevString r = new RevString();
        r.lucky_numbers(10);
    }
}
