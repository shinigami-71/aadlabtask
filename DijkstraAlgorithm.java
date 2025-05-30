import java.util.*;

public class DijkstraAlgorithm {
    
    static final int INF = Integer.MAX_VALUE;

    
    static int minDistance(int[] dist, boolean[] visited, int n) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < n; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    
    static void dijkstra(int[][] graph, int src, int n) {
        int[] dist = new int[n];         
        boolean[] visited = new boolean[n];  

        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int count = 0; count < n - 1; count++) {
            int u = minDistance(dist, visited, n);
            visited[u] = true;

            for (int v = 0; v < n; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                    dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        
        System.out.println("\nVertex \t Distance from Source");
        for (int i = 0; i < n; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter adjacency matrix (0 if no edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source vertex (0 to " + (n - 1) + "): ");
        int src = sc.nextInt();

        dijkstra(graph, src, n);
        sc.close();
    }
}
