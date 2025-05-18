import java.util.*;

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        Item[] items = new Item[n];

        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value of item " + (i + 1) + ": ");
            int value = sc.nextInt();
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            int weight = sc.nextInt();
            items[i] = new Item(value, weight);
        }

        System.out.print("Enter capacity of knapsack: ");
        int capacity = sc.nextInt();

       
        Arrays.sort(items, (a, b) -> {
            double r1 = (double) a.value / a.weight;
            double r2 = (double) b.value / b.weight;
            return Double.compare(r2, r1);
        });

        double totalValue = 0.0;
        int remainingCapacity = capacity;

       
        for (Item item : items) {
            if (remainingCapacity == 0)
                break;

            if (item.weight <= remainingCapacity) {
                
                totalValue += item.value;
                remainingCapacity -= item.weight;
                
            } else {
              
                double fraction = (double) remainingCapacity / item.weight;
                totalValue += item.value * fraction;

                remainingCapacity = 0;
            }
        }

        System.out.printf("\nMaximum value in knapsack = %.2f\n", totalValue);
        sc.close();
    }
}

