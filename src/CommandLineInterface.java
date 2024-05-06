import java.io.File;
import java.util.Scanner;

public class CommandLineInterface {
    Scanner scanner = new Scanner(System.in);
    Graph graph;
    int[][] predecessors;
    int[][] weights;
    int[] parent;
    int[] cost;
    final static int INFINITY = Integer.MAX_VALUE;
    public void Interface() {
        while (true) {
            Input();
            while (true){
                System.out.println("<----- Main Menu ----->");
                System.out.println("1) Find the shortest paths from source node to all other nodes.");
                System.out.println("2) Find the shortest paths between all the pairs of nodes.");
                System.out.println("3) Check if the graph contains a negative cycle.");
                System.out.println("4) Input Another File.");
                String option = scanner.nextLine();
                while (!(option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4"))) {
                    System.out.println("INVALID INPUT .. Please enter a valid one!!");
                    option = scanner.nextLine();
                }
                int mainMenu = Integer.parseInt(option);
                
                switch (mainMenu){
                    case 1:
                        subMenu1();
                        break;
                    case 2:
                        subMenu2();
                        break;
                    case 3:
                        subMenu3();
                        break;
                }
                if (mainMenu == 4) {
                    break;
                }
            }
        }
    }

    public void subMenu3() {
        while (true) {

            System.out.println("CHOOSE AN ALGORITHM: ");
            System.out.println("1) Bellman-Ford.");
            System.out.println("2) Floyd-Warshall.");
            System.out.println("3) Back To Previous Menu.");
            String option = scanner.nextLine();
            while (!(option.equals("1") || option.equals("2") || option.equals("3"))) {
                System.out.println("INVALID INPUT .. Please enter a valid one!!");
                option = scanner.nextLine();
            }
            int algorithm = Integer.parseInt(option);

            boolean negativeCycle;
            switch (algorithm) {
                case 1: //bellmanFord
                    negativeCycle = graph.bellmanFord(0, parent, cost);
                    if (!negativeCycle) {
                        System.out.println("Negative cycle found");
                    } else {
                        System.out.println("No negative cycle found");
                    }
                    break;
                case 2: //floydWarshall
                    negativeCycle = graph.floydWarshall(weights, predecessors);
                    if (!negativeCycle) {
                        System.out.println("Negative cycle found");
                    } else {
                        System.out.println("No negative cycle found");
                    }
                    break;
            }
            if (algorithm == 3) {
                break;
            }
        }
    }

    public void subMenu2() {
        while (true) {

            System.out.println("CHOOSE AN ALGORITHM: ");
            System.out.println("1) Dijkstra.");
            System.out.println("2) Bellman-Ford.");
            System.out.println("3) Floyd-Warshall.");
            System.out.println("4) Back To Previous Menu.");
            String option = scanner.nextLine();
            while (!(option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4"))) {
                System.out.println("INVALID INPUT .. Please enter a valid one!!");
                option = scanner.nextLine();
            }
            int algorithm = Integer.parseInt(option);

            switch (algorithm) {
                case 1:
                    for (int i = 0; i < graph.getV(); i++) {
                        graph.dijkstra(i, parent, cost);
                        predecessors[i] = parent;
                        weights[i] = cost;
                        parent = new int[graph.getV()];
                        cost = new int[graph.getV()];
                    }
                    break;
                case 2:
                    for (int i = 0; i < graph.getV(); i++) {
                        graph.bellmanFord(i, parent, cost);
                        predecessors[i] = parent;
                        weights[i] = cost;
                        parent = new int[graph.getV()];
                        cost = new int[graph.getV()];
                    }
                    break;
                case 3:
                    graph.floydWarshall(weights, predecessors);
                    break;
            }
            if (algorithm == 4) {
                break;
            }

                System.out.println("Source node: ");
                String node = scanner.nextLine();
                while (isValidInput(node)) {
                    System.out.println("INVALID INPUT .. Please enter a valid one!!");
                    node = scanner.nextLine();
                }
                int sourceNode =Integer.parseInt(node);

                System.out.println("Destination node: ");
                node = scanner.nextLine();
                while (isValidInput(node)) {
                    System.out.println("INVALID INPUT .. Please enter a valid one!!");
                    node = scanner.nextLine();
                }
                int destinationNode =Integer.parseInt(node);


                System.out.println("1) Get Path length.");
                System.out.println("2) Get Path.");
                System.out.println("3) Choose Another Algorithm.");
                option = scanner.nextLine();
                while (!(option.equals("1") || option.equals("2") || option.equals("3"))) {
                    System.out.println("INVALID INPUT .. Please enter a valid one!!");
                    option = scanner.nextLine();
                }
                int PathCost = Integer.parseInt(option);

                switch (PathCost) {
                    case 1:
                        if (weights[sourceNode][destinationNode] == Integer.MAX_VALUE)
                            System.out.println("NO PATH");
                        else
                            System.out.println("Shortest path from " + sourceNode + " to " + destinationNode + " = " + weights[sourceNode][destinationNode]);
                        break;
                    case 2:
                        if (algorithm == 3) {
                            //print path for floyd warshall
                            graph.printFloydPath(sourceNode, destinationNode, predecessors, weights);
                        } else {
                            graph.printPath(sourceNode, destinationNode, parent);
                        }
                        break;
                }
                if (PathCost == 3) {
                    break;
                }
        }
    }

    public void subMenu1() {
        int back = 0;
        do {

            System.out.println("Source node: ");
            String node = scanner.nextLine();
            while (isValidInput(node)) {
                System.out.println("INVALID INPUT .. Please enter a valid one!!");
                node = scanner.nextLine();
            }
            int sourceNode = Integer.parseInt(node);

            while (true) {

                System.out.println("CHOOSE AN ALGORITHM: ");
                System.out.println("1) Dijkstra.");
                System.out.println("2) Bellman-Ford.");
                System.out.println("3) Floyd-Warshall.");
                System.out.println("4) Back To Previous Menu.");
                String option = scanner.nextLine();
                while (!(option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4"))) {
                    System.out.println("INVALID INPUT .. Please enter a valid one!!");
                    option = scanner.nextLine();
                }
                int algorithm = Integer.parseInt(option);

                switch (algorithm) {
                    case 1:
                        graph.dijkstra(sourceNode, parent, cost);
                        break;
                    case 2:
                        graph.bellmanFord(sourceNode, parent, cost);
                        break;
                    case 3:
                    graph.floydWarshall(weights, predecessors);
                        break;
                }
                if (algorithm == 4) {
                    break;
                }

                System.out.println("Destination node: ");
                node = scanner.nextLine();
                while (isValidInput(node)) {
                    System.out.println("INVALID INPUT .. Please enter a valid one!!");
                    node = scanner.nextLine();
                }
                int destinationNode = Integer.parseInt(node);

                while (true) {

                    System.out.println("1) Get Path length.");
                    System.out.println("2) Get Path.");
                    System.out.println("3) Choose Another Algorithm.");
                    option = scanner.nextLine();
                    while (!(option.equals("1") || option.equals("2") || option.equals("3"))) {
                        System.out.println("INVALID INPUT .. Please enter a valid one!!");
                        option = scanner.nextLine();
                    }
                    int PathCost = Integer.parseInt(option);

                    switch (PathCost) {
                        case 1:
                            if (algorithm == 3) {
                                if (weights[sourceNode][destinationNode] == Integer.MAX_VALUE)
                                    System.out.println("NO PATH");
                                else
                                    System.out.println("Shortest path from " + sourceNode + " to " + destinationNode + " = " + weights[sourceNode][destinationNode]);
                            } else {
                                if (cost[destinationNode] == Integer.MAX_VALUE)
                                    System.out.println("NO PATH");
                                else
                                    System.out.println("Shortest path from " + sourceNode + " to " + destinationNode + " = " + cost[destinationNode]);
                            }
                            break;
                        case 2:
                            if (algorithm == 3) {
                                //print path for floyd warshall
                                graph.printFloydPath(sourceNode, destinationNode, predecessors, weights);
                            } else {
                                graph.printPath(destinationNode, parent);
                            }
                            break;
                    }
                    if (PathCost == 3) {
                        back++;
                        break;
                    }
                }
            }
        } while (back != 1);
    }

    public void Input() {

        boolean validPath = false;
        while (!validPath) {
            System.out.println("Enter the input file path: ");
            String path = scanner.nextLine();
            File file = new File(path);

            if (file.exists()) {
                graph = new Graph(path);
                if (!graph.PathError) {
                    validPath = true;
                } else {
                    System.out.println("ERROR opening the input file!!");
                }
            } else {
                System.out.println("File not found!");
            }
        }
        predecessors = new int[graph.getV()][graph.getV()];
        weights = new int[graph.getV()][graph.getV()];
        parent = new int[graph.getV()];
        cost = new int[graph.getV()];
        weights=graph.FloydWarshallMatrix;
        for (int i = 0; i < weights.length; i++) {
        for (int j = 0; j < weights.length; j++) {
            predecessors[i][j] = (i == j || weights[i][j] == INFINITY) ? -1 : i;
            }
        }
        System.out.println("Graph created successfully ..");
    }

    private boolean isValidInput(String node) {
        try {
            Integer.valueOf(node);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

}
