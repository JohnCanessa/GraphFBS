
/**
 * Represents an edge between vertices.
 */
public class Edge {

    // **** ****
    int a;
    int c;


    /**
     * Constructor.
     */
    public Edge (int a, int c) {
        this.a = a;
        this.c = c;
    }


    /**
     * 
     */
    @Override
    public String toString() {
        return "a: " + a + " c: " + c;
    }
}