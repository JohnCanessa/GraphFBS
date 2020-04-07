import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */
public class Solution {

    // **** test file ****
    static final String TEST_CASE_1 = "c:\\Temp\\input01.txt";

    /**
     * Test scaffolding
     * 
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        // **** instantiate a graph with the specified number of vertices ****
        Graph g = new Graph(4);
     
        // **** add edges to the graph ****
        g.addEdge(0, 1, 10);
        g.addEdge(0, 2, 11);
        g.addEdge(0, 3, 12);

        g.addEdge(2, 0, 13);
        g.addEdge(2, 1, 14);

        g.addEdge(1, 3, 15);

        // ???? ????
        System.out.println("main <<< getVertices: " + g.getVertices());
        System.out.println("main <<< getEdges: " + g.getEdges());
        System.out.println("main <<< g: " + g.toString());

        // **** display the path between the specified vertices ****
        String fromTo;

        fromTo = "0 - 1";
        System.out.println("main <<< fromTo: " + fromTo + ": ");
        g.path(fromTo);
        
        fromTo = "1 - 2";
        System.out.println("main <<< fromTo: " + fromTo + ": ");
        g.path(fromTo);

        fromTo = "2 - 3";
        System.out.println("main <<< fromTo: " + fromTo + ": ");
        g.path(fromTo);
        System.out.println();


        // **** instantiate a graph with the specified number of vertices ****
        g = new Graph(6);

        // **** add edges to the graph ****
        g.addEdge(1, 2, 6);
        g.addEdge(1, 4, 1);

        g.addEdge(2, 4, 2);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 5);

        g.addEdge(4, 5, 1);
        
        g.addEdge(5, 3, 5);

        // ???? ????
        System.out.println("main <<< getVertices: " + g.getVertices());
        System.out.println("main <<< getEdges: " + g.getEdges());
        System.out.println("main <<< g: " + g.toString());

        // **** display the path between the specified vertices ****
        fromTo = "1 - 2";
        System.out.println("main <<< fromTo: " + fromTo + ": ");
        g.path(fromTo);

        fromTo = "1 - 3";
        System.out.println("main <<< fromTo: " + fromTo + ": ");
        g.path(fromTo);

        fromTo = "1 - 4";
        System.out.println("main <<< fromTo: " + fromTo + ": ");
        g.path(fromTo);

        fromTo = "1 - 5";
        System.out.println("main <<< fromTo: " + fromTo + ": ");
        g.path(fromTo);
        System.out.println();


        /*
        // **** specify file and open it with the scanner ****
        File file = new File(TEST_CASE_1);
        Scanner sc = new Scanner(file);

        // **** read first line from the file and extract # of vertices and edges ****
        String[] nm = sc.nextLine().trim().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        // ???? ????
        System.out.println("main <<< n: " + n + " m: " + m);

        // **** instantiate a graph with the specified number of vertices ****
        g = new Graph(n + 1);

        // **** read the edges ****
        for (int i = 0; i < m; i++) {

            // **** read and parse the next line from the file ***
            String[] uvc = sc.nextLine().trim().split(" ");
            int u = Integer.parseInt(uvc[0]);
            int v = Integer.parseInt(uvc[1]);
            int c = Integer.parseInt(uvc[2]);

            // **** add the edge to the graph ****
            g.addEdge(u, v, c);
        }

        // **** read the source and destination vertices ****
        String[] sd = sc.nextLine().trim().split(" ");
        int s = Integer.parseInt(sd[0]);
        int d = Integer.parseInt(sd[1]);

        // ???? ????
        System.out.println("main <<< s: " + s + " d: " + d);

        // **** close scanner ****
        sc.close();

        // ???? ????
        System.out.println("main <<< getVertices: " + g.getVertices());
        System.out.println("main <<< getEdges: " + g.getEdges());
        System.out.println("main <<< g: " + g.toString());

        // **** display the path between the specified vertices ****
        fromTo = s + " - " + d;
        System.out.println("main <<< fromTo: " + fromTo + ": ");
        g.path(fromTo);
        */

    }
}