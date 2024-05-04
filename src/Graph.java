import java.io.File;
import java.io.FileNotFoundException;
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

    public int[][] getGraph() {
        return graph;
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
        return true;
    }

    public Boolean floydWarshall(int[][] cost, int[][] predecessors) {

        return true;
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
                System.out.print(stack.pop() + " -> ");
        }
        System.out.println();
    }

    public void printFloydPath(int source, int dest, int[][] predecessor, int[][] cost) {
        if (cost[source][dest] == Integer.MAX_VALUE)
            System.out.println("NO PATH");
        else {
            Stack<Integer> stack = new Stack<>();
            stack.push(dest);
            while (predecessor[source][dest] != -1) {
                stack.push(predecessor[source][dest]);
                dest = predecessor[source][dest];
            }
            while (!stack.empty()) {
                if (stack.size() == 1) System.out.print(stack.pop());
                else System.out.print(stack.pop());
            }
            System.out.println();
        }
    }

    public void printPath(int sourceNode, int destinationNode, int[] parent) {
        // Stack to store the path
        Stack<Integer> path = new Stack<>();

        // Start from the destination node
        int currentNode = destinationNode;

        // Traverse upwards using the parent array until reaching the source node
        while (currentNode != sourceNode) {
            path.push(currentNode);
            currentNode = parent[currentNode];
        }

        // Add the source node
        path.push(sourceNode);

        // Print the path
        System.out.print("Path from " + sourceNode + " to " + destinationNode + ": ");
        while (!path.isEmpty()) {
            System.out.print(path.pop());
            if (!path.isEmpty()) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}
