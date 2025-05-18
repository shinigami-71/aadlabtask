import java.util.*;

public class Bfs {
    // BFS function
    public static void bfs(int start, List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[start] = true;
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        System.out.print("Enter the number of nodes: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of edges: ");
        int m = scanner.nextInt();
   
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Input the edges
        System.out.println("Enter the edges (u v) representing an undirected graph:");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); 
        }
        
        System.out.print("Enter the starting node for BFS: ");
        int startNode = scanner.nextInt();
        
        System.out.println("Breadth First Search (BFS) starting from node " + startNode + ":");
        bfs(startNode, graph);
        
        scanner.close();
    }
}
