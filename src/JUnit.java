import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit {
    int[][] predecessors;
    int[][] weights;
    int[] parent;
    int[] cost;

    @Test
    public void time_dijkstra_10_5_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 10,5, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 10 vertices and 5 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_bellman_10_5_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 10,5, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 10 vertices and 5 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_10_5_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 10,5, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 10 vertices and 5 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_dijkstra_10_10_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 10,10, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 10 vertices and 10 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_bellman_10_10_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 10,10, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 10 vertices and 10 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_10_10_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 10,10, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 10 vertices and 10 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }



    @Test
    public void time_dijkstra_100_5_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,5, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 100 vertices and 5 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_bellman_100_5_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,5, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 100 vertices and 5 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_100_5_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,5, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 100 vertices and 5 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }



    @Test
    public void time_dijkstra_100_10_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,10, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 100 vertices and 10 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_bellman_100_10_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,10, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 100 vertices and 10 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_100_10_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,10, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 100 vertices and 10 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }


    @Test
    public void time_dijkstra_100_25_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,25, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 100 vertices and 25 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_bellman_100_25_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,25, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 100 vertices and 25 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_100_25_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,25, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 100 vertices and 25 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }



    @Test
    public void time_dijkstra_250_50_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,50, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 250 vertices and 50 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_bellman_250_50_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,50, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 250 vertices and 50 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_250_50_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,50, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 250 vertices and 50 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }


    @Test
    public void time_dijkstra_250_100_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,100, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 250 vertices and 100 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_bellman_250_100_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,100, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 250 vertices and 100 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_250_100_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,100, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 250 vertices and 100 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }



    @Test
    public void time_dijkstra_250_200_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 250 vertices and 200 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_250_200_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 250 vertices and 200 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_250_200_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 250 vertices and 200 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }



    @Test
    public void time_dijkstra_500_50_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,50, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 500 vertices and 50 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_500_50_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,50, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 500 vertices and 50 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_500_50_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,50, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 500 vertices and 50 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }



    @Test
    public void time_dijkstra_500_100_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,100, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 500 vertices and 100 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_500_100_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,100, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 500 vertices and 100 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_500_100_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,100, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 500 vertices and 100 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }


    @Test
    public void time_dijkstra_500_200_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 500 vertices and 200 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_500_200_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 500 vertices and 200 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_500_200_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 500 vertices and 200 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_dijkstra_750_200_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 750 vertices and 200 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_750_200_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 750 vertices and 200 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_750_200_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 750 vertices and 200 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }


    @Test
    public void time_dijkstra_750_300_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,300, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 750 vertices and 300 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_750_300_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,300, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 750 vertices and 300 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_750_300_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,300, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 750 vertices and 300 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_dijkstra_750_400_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,400, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 750 vertices and 400 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_750_400_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,400, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 750 vertices and 400 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_750_400_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,400, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 750 vertices and 400 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_dijkstra_750_500_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,500, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 750 vertices and 500 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_750_500_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,500, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 750 vertices and 500 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_750_500_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,500, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 750 vertices and 500 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }




    @Test
    public void time_dijkstra_1000_200_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 1000 vertices and 200 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_1000_200_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 1000 vertices and 200 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_1000_200_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 1000 vertices and 200 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }


    @Test
    public void time_dijkstra_1000_300_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,300, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 1000 vertices and 300 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_1000_300_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,300, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 1000 vertices and 300 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_1000_300_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,300, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 1000 vertices and 300 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_dijkstra_1000_400_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,400, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 1000 vertices and 400 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_1000_400_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,400, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 1000 vertices and 400 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_1000_400_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,400, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 1000 vertices and 400 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_dijkstra_1000_500_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,500, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.dijkstra(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 1000 vertices and 500 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_1000_500_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,500, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            for (int j = 0; j < g.getV(); j++) {
                g.bellmanFord(j, parent, cost);
                predecessors[j] = parent;
                weights[j] = cost;
                parent = new int[g.getV()];
                cost = new int[g.getV()];
            }
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 1000 vertices and 500 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_1000_500_all() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,500, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 1000 vertices and 500 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    /*   ###############################
    ##########################
    ####################################
     */







    @Test
    public void time_dijkstra_10_5_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 10,5, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 10 vertices and 5 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_bellman_10_5_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 10,5, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2,parent,cost);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 10 vertices and 5 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_10_5_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 10,5, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 10 vertices and 5 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_dijkstra_10_10_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 10,10, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 10 vertices and 10 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_bellman_10_10_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 10,10, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2,parent,cost);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 10 vertices and 10 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_10_10_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 10,10, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 10 vertices and 10 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }



    @Test
    public void time_dijkstra_100_5_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,5, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 100 vertices and 5 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_bellman_100_5_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,5, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2,parent,cost);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between all nodes in a graph of 100 vertices and 5 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_100_5_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,5, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 100 vertices and 5 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }



    @Test
    public void time_dijkstra_100_10_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,10, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 100 vertices and 10 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_bellman_100_10_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,10, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2,parent,cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 100 vertices and 10 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_100_10_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,10, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 100 vertices and 10 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }


    @Test
    public void time_dijkstra_100_25_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,25, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 100 vertices and 25 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_bellman_100_25_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,25, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2,parent,cost);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 100 vertices and 25 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_100_25_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 100,25, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 100 vertices and 25 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }



    @Test
    public void time_dijkstra_250_50_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,50, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 250 vertices and 50 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_bellman_250_50_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,50, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2,parent,cost);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 250 vertices and 50 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_250_50_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,50, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 250 vertices and 50 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }


    @Test
    public void time_dijkstra_250_100_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,100, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 250 vertices and 100 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_bellman_250_100_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,100, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2,parent,cost);
        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 250 vertices and 100 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_250_100_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,100, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 250 vertices and 100 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }



    @Test
    public void time_dijkstra_250_200_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 250 vertices and 200 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_250_200_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 250 vertices and 200 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_250_200_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 250,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 250 vertices and 200 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }



    @Test
    public void time_dijkstra_500_50_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,50, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 500 vertices and 50 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_500_50_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,50, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 500 vertices and 50 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_500_50_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,50, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 500 vertices and 50 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }



    @Test
    public void time_dijkstra_500_100_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,100, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 500 vertices and 100 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_500_100_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,100, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 500 vertices and 100 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_500_100_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,100, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 500 vertices and 100 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }


    @Test
    public void time_dijkstra_500_200_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 500 vertices and 200 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_500_200_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 500 vertices and 200 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_500_200_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 500,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 500 vertices and 200 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

    @Test
    public void time_dijkstra_750_200_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 750 vertices and 200 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_750_200_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 750 vertices and 200 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_750_200_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 750 vertices and 200 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }


    @Test
    public void time_dijkstra_750_300_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,300, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 750 vertices and 300 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_750_300_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,300, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 750 vertices and 300 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_750_300_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,300, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 750 vertices and 300 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_dijkstra_750_400_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,400, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 750 vertices and 400 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_750_400_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,400, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 750 vertices and 400 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_750_400_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,400, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 750 vertices and 400 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_dijkstra_750_500_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,500, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 750 vertices and 500 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_750_500_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,500, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 750 vertices and 500 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_750_500_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 750,500, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 750 vertices and 500 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }




    @Test
    public void time_dijkstra_1000_200_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 1000 vertices and 200 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_1000_200_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 1000 vertices and 200 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_1000_200_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,200, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 1000 vertices and 200 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }


    @Test
    public void time_dijkstra_1000_300_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,300, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 1000 vertices and 300 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_1000_300_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,300, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between between source node and all nodes in a graph of 1000 vertices and 300 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_1000_300_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,300, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between between source node and all nodes in a graph of 1000 vertices and 300 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_dijkstra_1000_400_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,400, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 1000 vertices and 400 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_1000_400_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,400, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 1000 vertices and 400 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_1000_400_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,400, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 1000 vertices and 400 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_dijkstra_1000_500_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,500, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.dijkstra(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 1000 vertices and 500 edges using dijkstra:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_bellman_1000_500_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,500, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.bellmanFord(2, parent, cost);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between between source node and all nodes in a graph of 1000 vertices and 500 edges using bellman:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }
    @Test
    public void time_floyd_1000_500_one() {
        long start1 = System.currentTimeMillis();
        for(int i=0;i<10;i++){
            String filename = String.format("cases/input_V%d_E%d_%d.txt", 1000,500, i);
            Graph g= new Graph(filename);
            predecessors = new int[g.getV()][g.getV()];
            weights = new int[g.getV()][g.getV()];
            parent = new int[g.getV()];
            cost = new int[g.getV()];
            g.floydWarshall(weights, predecessors);

        }
        long end1 = System.currentTimeMillis();
        long duration1 = (end1 - start1)/10;
        System.out.print("Time to find shortest paths between source node and all nodes in a graph of 1000 vertices and 500 edges using floyd:");
        System.out.println("\u001B[35m(" + duration1 + ") ms\u001B[0m");

    }

}
