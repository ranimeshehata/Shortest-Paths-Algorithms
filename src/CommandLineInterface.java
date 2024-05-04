import java.util.Scanner;

public class CommandLineInterface {
    Scanner scanner = new Scanner(System.in);
    Graph graph;
    int[][] predecessors;
    int[][] weights;
    int[] parent;
    int[] cost;
    public void Interface() {
        while (true) {
            Input();
            while (true){
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
                    case 2:
                        subMenu2();
                    case 3:
                        subMenu3();
                    case 4:
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
                case 3:
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
            while (true) {
                int source_node = InputNode("Source");
                int destination_node = InputNode("Destination");

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
                        if (weights[source_node][destination_node] == Integer.MAX_VALUE)
                            System.out.println("\u001B[34m" + "Shortest path from " + source_node + " to " + destination_node + " = " + "NO PATH" + "\u001B[0m");
                        else
                            System.out.println("\u001B[34m" + "Shortest path from " + source_node + " to " + destination_node + " = " + weights[source_node][destination_node] + "\u001B[0m");
                        break;
                    case 2:
                        graph.printFloydPath(source_node, destination_node, predecessors, cost);
                        break;
                    case 3:
                        break;
                }
            }
        }
    }

    public void subMenu1() {
        while (true) {

            System.out.println("Source node: ");
            String node = scanner.nextLine();
            while (isValidInput(node)) {
                System.out.println("INVALID INPUT .. Please enter a valid one!!");
                node = scanner.nextLine();
            }
            int sourceNode =Integer.parseInt(node);

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
                    case 4:
                        break;

                }

                System.out.println("Destination node: ");
                node = scanner.nextLine();
                while (isValidInput(node)) {
                    System.out.println("INVALID INPUT .. Please enter a valid one!!");
                    node = scanner.nextLine();
                }
                int destinationNode =Integer.parseInt(node);

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
                                    System.out.println("Shortest path from " + sourceNode + " to " + destinationNode + " = " + "NO PATH");
                                else
                                    System.out.println("Shortest path from " + sourceNode + " to " + destinationNode + " = " + weights[sourceNode][destinationNode]);
                            } else {
                                if (cost[destinationNode] == Integer.MAX_VALUE)
                                    System.out.println("Shortest path from " + sourceNode + " to " + destinationNode + " = " + "NO PATH");
                                else
                                    System.out.println("Shortest path from " + sourceNode + " to " + destinationNode + " = " + cost[destinationNode]);
                            }
                            break;
                        case 2:
                            if (algorithm == 3) {
                                //print path for floyd warshall
                                graph.printFloydPath(sourceNode, destinationNode, predecessors, cost);
                            } else {
                                graph.printPath(destinationNode, parent);
                            }
                            break;
                        case 3:
                            break;
                    }
                }
            }
            //break;
        }
    }

    public void Input() {
        System.out.println("Enter the input file path: ");
        String path = scanner.nextLine();
        graph = new Graph(path);
        while (graph.PathError) {
            System.out.println("ERROR opening the input file!!");
            System.out.println("Enter the input file path: ");
            path = scanner.nextLine();
            graph = new Graph(path);
        }
        predecessors = new int[graph.getV()][graph.getV()];
        weights = new int[graph.getV()][graph.getV()];
        parent = new int[graph.getV()];
        cost = new int[graph.getV()];
        System.out.println("Graph created successfully ..");
    }

    public int InputNode(String type) {
        System.out.println("Enter " + type + " node: ");
        String node = scanner.nextLine();
        while (isValidInput(node)) {
            System.out.println("INVALID INPUT .. Please enter a valid one!!");
            node = scanner.nextLine();
        }
        return Integer.parseInt(node);
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
