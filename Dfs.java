import java.util.*;

public class Dfs {
    
    public static void dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");
    
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
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
        
        
        System.out.println("Enter the edges (u v) representing an undirected graph:");
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u); 
        }
        
        System.out.print("Enter the starting node for DFS: ");
        int startNode = scanner.nextInt();
        
        boolean[] visited = new boolean[n];
        
        System.out.println("Depth First Search (DFS) starting from node " + startNode + ":");
        dfs(startNode, graph, visited);
        
        scanner.close();
    }
}
