public class PrintJob {
    int[] job;
    int Front;
    int Rear;
    int Capacity;
    int Newjob=0;

    PrintJob() {
        Capacity = 20;
        Front = -1;
        Rear = -1;
        this.createJob();
    }


    void createJob() {
        job = new int[Capacity];
    }

    void addJob() {
        if (Rear + 1 == Capacity) {
            System.out.println("Printjob is full, cannot add any more");
        } else {
            job[++Rear] = Newjob++;
        }
    }

    void removeJob() {
        if (Front == Rear) {
            System.out.println("Printjob is empty");
        } else {
            ++Front;
        }
    }

}
