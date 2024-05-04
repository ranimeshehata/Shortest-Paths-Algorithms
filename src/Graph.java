import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Graph {
    public int[][] FloydWarshallMatrix;
    public boolean file_path_error;
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

    }

    public Boolean bellmanFord(int source, int[] parent, int[] cost) {

        return true;
    }

    public Boolean floydWarshall(int[][] cost, int[][] predecessors) {

        return true;
    }
}
