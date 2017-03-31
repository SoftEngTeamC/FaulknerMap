import java.util.List;

/**
 * Created by jack on 3/31/17.
 */
public class Node {
    private List<Node> neighbors;
    private Coordinate position;

    public Node(List<Node> neighbors, Coordinate position){
        this.neighbors = neighbors;
        this.position = position;
    }
}
