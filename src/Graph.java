import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Graph {
    public int[][] FloydWarshallMatrix;
    public boolean PathError;
    final static int INFINITY = Integer.MAX_VALUE;

    private int V;  // number of vertices
    private int E;  // number of edges
    private String path;
    private int[][] graph;
    private Vector<Edges> edges = new Vector<>(V);

    public Graph(String path) {

        this.path = path;
        readInputFile(path);
    }

    public int getV() {
        return V;
    }
    public void readInputFile(String path) {
        try {
            int n1; //source
            int n2; //destination
            int n3; //weight
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            V = scanner.nextInt();  // number of vertices
            E = scanner.nextInt();  // number of edges

            //fill graph for dijkstra & bellman-ford with zeros
            graph = new int[V][V];
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    graph[i][j] = 0;
                }
            }

            //fill floydMatrix with INF & zeros
            FloydWarshallMatrix = new int[V][V];
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (i == j) {
                        FloydWarshallMatrix[i][j] = 0;
                    } else {
                        FloydWarshallMatrix[i][j] = INFINITY;
                    }
                }
            }
            while (scanner.hasNextLine()) {

                n1 = scanner.nextInt();
                n2 = scanner.nextInt();
                n3 = scanner.nextInt();
                Edges edge = new Edges();
                edge.setSrc(n1);
                edge.setDest(n2);
                edge.setWeight(n3);
                edges.add(edge);
                graph[n1][n2] = n3;
                FloydWarshallMatrix[n1][n2] = n3;
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("ERROR opening input file!!");
        }
    }

    public void dijkstra(int source, int[] parent, int[] cost) {
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            visited[i] = 0;
            cost[i] = INFINITY;
            parent[i] = -1;
        }
        cost[source] = 0;
        for (int i = 0; i < V - 1; i++) {
            int u = minDistance(cost, visited);
            visited[u] = 1;
            for (int v = 0; v < V; v++) {
                if (visited[v] == 0 && graph[u][v] != 0 && cost[u] != INFINITY && cost[u] + graph[u][v] < cost[v]) {
                    cost[v] = cost[u] + graph[u][v];
                    parent[v] = u;
                }
            }
        }

    }

    private int minDistance(int[] cost, int[] visited) {
        int min = INFINITY;
        int min_index = -1;
        for (int v = 0; v < V; v++) {
            if (visited[v] == 0 && cost[v] <= min) {
                min = cost[v];
                min_index = v;
            }
        }
        return min_index;
    }

    public Boolean bellmanFord(int source, int[] parent, int[] cost) {
        int[] values = new int[V];
        for (int i = 0; i < V; i++) {
            values[i] = Integer.MAX_VALUE;
        }
        parent[source] = -1;
        values[source] = 0;
        Arrays.fill(parent, -1);
        boolean updated = false;
        boolean redused = false;
        for (int i = 0; i < V - 1; i++) {
            updated = false;
            for (int j = 0; j < E; j++) {
                int u = edges.get(j).getSrc();
                int v = edges.get(j).getDest();
                int w = edges.get(j).getWeight();
                if (values[u] != Integer.MAX_VALUE && values[u] + w < values[v]) {
                    values[v] = values[u] + w;
                    parent[v] = u;
                    cost[v] = values[v];
                    updated = true;
                }
            }
            if (!updated) break;

        }
        for (int j = 0; j < E && updated; j++) {
            int u = edges.get(j).getSrc();
            int v = edges.get(j).getDest();
            int w = edges.get(j).getWeight();
            if (values[u] != Integer.MAX_VALUE && values[u] + w < values[v]) {
                redused = true;
                break;
            }
        }

        if (redused) {
            return false;
        }
        System.arraycopy(values, 0, cost, 0, V);
        return true;
    }

    public Boolean floydWarshall(int[][] costs, int[][] predecessors) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                costs[i][j] = FloydWarshallMatrix[i][j];
                if (i == j) {
                    predecessors[i][j] = -1;
                } else if (FloydWarshallMatrix[i][j] != INFINITY) {
                    predecessors[i][j] = i;
                } else predecessors[i][j] = -1;
            }
        }
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if ((costs[i][k] != INFINITY) && (costs[k][j] != INFINITY) && (costs[i][k] + costs[k][j] < costs[i][j])) {
                        costs[i][j] = costs[i][k] + costs[k][j];
                        predecessors[i][j] = predecessors[k][j];
                    }
                }
            }
        }
        //detect negative cycle
        for (int i = 0; i < V; i++) {
            if (costs[i][i] < 0) {
                return false;
            }
        }
        return true;
    }

    public void printFloydPath(int source, int dest, int[][] predecessor, int[][] cost) {
        if (cost[source][dest] == Integer.MAX_VALUE) {
            System.out.println("NO PATH");
            System.out.println("*-----------------------------------------------*");
        } else {
            Stack<Integer> stack = new Stack<>();
            stack.push(dest);
            while (predecessor[source][dest] != -1) {
                stack.push(predecessor[source][dest]);
                dest = predecessor[source][dest];
            }
            // Print the path
            while (!stack.isEmpty()) {
                int node = stack.pop();
                if (!stack.isEmpty()) {
                    System.out.print(node + " -> ");
                } else {
                    System.out.println(node);
                }
            }
            System.out.println("*-----------------------------------------------*");
        }
    }

    public void printPath(int dest, int[] parent) {
        int i = dest;
        Stack<Integer> stack = new Stack<>();
        stack.push(i);
        while (parent[i] != -1) {
            stack.push(parent[i]);
            i = parent[i];
        }
        while (!stack.empty()) {
            if (stack.size() == 1) System.out.print(stack.pop());
            else
                System.out.print(stack.pop() + " -> " );
        }
        System.out.println();
        System.out.println("*-----------------------------------------------*");
    }
}
