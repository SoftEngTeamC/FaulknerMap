import db.dbClasses.Edge;
import db.dbClasses.Node;

import java.util.Collection;
import java.util.List;

/**
 * Created by jack on 3/31/17.
 */
public class Map {
    private Collection<Node> nodes;
    private Collection<Edge> edges;

    public Map(Collection<Node> nodes, Collection<Edge> edges){
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<Edge> findPath(Node n1, Node n2){return null;};
}
