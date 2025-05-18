import java.util.*;

class Activity {
    int start, finish;

    Activity(int start, int finish) {
        this.start = start;
        this.finish = finish;
    }
}

public class ActivitySelection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number of activities: ");
        int n = sc.nextInt();

        Activity[] activities = new Activity[n];

        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter start time of activity " + (i + 1) + ": ");
            int start = sc.nextInt();
            System.out.print("Enter finish time of activity " + (i + 1) + ": ");
            int finish = sc.nextInt();
            activities[i] = new Activity(start, finish);
        }

        
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

        
        System.out.println("\nSelected activities:");
        int count = 1;
        System.out.println("Activity 1: Start = " + activities[0].start + ", Finish = " + activities[0].finish);
        int lastFinishTime = activities[0].finish;

        for (int i = 1; i < n; i++) {
            if (activities[i].start >= lastFinishTime) {
                System.out.println("Activity " + (i + 1) + ": Start = " + activities[i].start + ", Finish = " + activities[i].finish);
                lastFinishTime = activities[i].finish;
                count++;
            }
        }

        System.out.println("\nMaximum number of non-overlapping activities: " + count);
        sc.close();
    }
}
