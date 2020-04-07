import java.util.ArrayList;


/**
 * Class used to represent a graph.
 */
public class Graph {

    // **** number of vertices in the graph ****
    private int vertices;

    // **** adjacency list ****
    private ArrayList<Edge>[] adjList;


    /**
     * Constructor.
     */
    public Graph(int vertices) {

        // **** set the number of vertices ****
        this.vertices = vertices;

        // **** initialize the adjacency list ****
        initAdjList();
    }


    /**
     * Initialize adjacency list.
     */
    @SuppressWarnings("unchecked")
    private void initAdjList() {

        // **** ****
        adjList = new ArrayList[this.vertices];

        // **** initialize the adjecency list ****
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new ArrayList<Edge>();
        }
    }


    /**
     * Return the number of vertices in the graph.
     */
    public int getVertices() {
        return this.vertices;
    }


    /**
     * Return number of edges in the graph.
     */
    public int getEdges() {

        // **** number of edges ****
        int edges = 0;

        // **** loop once per vertex****
        for (int i = 0; i < vertices; i++) {
            edges += adjList[i].size();
        }

        // **** return the number of edges in the graph ****
        return edges;
    }


    /**
     * Add edge between vertices u and v.
     * NOTE:  The cost (c) is currently not being used.
     */
    public void addEdge(int u, int v, int c) {
        
        // **** create new edge ****
        Edge e = new Edge(v, c);

        // **** add edge to vertex u ****
        adjList[u].add(e);
    }


    /**
      * Generate a string that represents this graph.
      */
    public String toString() {

        // **** ****
        StringBuilder sb = new StringBuilder();

        // **** populate string builder ****
        for (int v = 0; v < this.vertices; v++) {
            sb.append("(v: " + v + " " + adjList[v].toString() + ") ");
        }

        // **** return the required string ****
        return sb.toString();
    }


    /**
     * Generate and display the path(s) and cost from u to v.
     */
    public void path(String fromTo) {

        // **** ****
        boolean[] visited = new boolean[vertices];
        ArrayList<Integer> pathList = new ArrayList<Integer>();

        // **** source and destination vertices ****
        String[] sd = fromTo.split(" - ");
        Integer s = Integer.parseInt(sd[0]);
        Integer d = Integer.parseInt(sd[1]);

        // **** add s to the path list ****
        pathList.add(s);

        // **** generate and display the path ****
        path(s, d, visited, pathList);
    }


    /**
     * Recursive method that generates and prints the path(s) and cost from u to v.
     */
    public void path(Integer u, Integer d, boolean[] visited, ArrayList<Integer> pathList) {

        // **** flag we have visited u ****
        visited[u] = true;

        // **** reached destination vertex (display the path) ****
        if (u.equals(d)) {

            // **** display the path between vertices ****
            displayPath(pathList);

            // **** ****
            visited[u] = false;

            // **** ****
            return;
        }

        // **** check all adjacent vertices ****
        for (Edge e : adjList[u]) {

            // **** adjacent vertex ****
            int a = e.a;

            // **** check if vertex has not been visited ****
            if (!visited[a]) {

                // **** add vertex to path list  ****
                pathList.add(a);

                // **** recurse from this vertex ****
                path(a, d, visited, pathList);

                // **** remove vertex from path list ****
                pathList.remove(pathList.indexOf(a));
            }
        }

        // **** flag that we have not visited this vertex ****
        visited[u] = false;
    }


    /**
     * Display path and cost from path list.
     */
    public void displayPath(ArrayList<Integer> pathList) {

        // **** total cost ****
        int cost = 0;

        // **** OR cost ****
        int orCost = 0;

        // **** display first vertex ****
        // System.out.print(pathList.get(0) + " -> ");

        // **** ****
        for (int i = 1; i < pathList.size(); i++) {

            // **** ****
            int u = pathList.get(i - 1);
            int v = pathList.get(i);

            // **** display path component between u and v ****
            System.out.print(pathList.get(i));
            if (i < pathList.size() - 1)
                System.out.print(" -> ");

            // **** check adjacent vertices ****
            for (Edge e : adjList[u]) {

                // **** this is the vertex of integers ****
                if (e.a == v) {

                    // **** update total cost from u to v ****
                    cost += e.c;

                    // **** update OR cost from u to v ****
                    orCost |= e.c;

                    // **** done with this vertex ****
                    break;
                }
            }
        }

        // **** display cost and orCost ****
        System.out.println("  cost: " + cost + " orCost: " + orCost);
    }
}