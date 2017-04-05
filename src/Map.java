import com.sun.javafx.scene.NodeHelper;
import db.Driver;
import db.dbClasses.Edge;
import db.dbClasses.Node;
import db.dbHelpers.EdgesHelper;
import db.dbHelpers.NodesHelper;
import pathfinding.MapNode;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by jack on 3/31/17.
 */
public class Map {
    private java.util.Map<UUID, MapNode> nodeMap;

    public Map(Collection<Node> dbNodes) {
        NodesHelper nodeHelper = Driver.getNodesHelper();
        EdgesHelper edgeHelper = Driver.getEdgesHelper();
        nodeMap = new HashMap<>();
        for (Node n : dbNodes) {
            nodeMap.put(n.getId(), new MapNode(n));
        }
        for (UUID id : nodeMap.keySet()) {
            for (Node n : edgeHelper.getNeighbors(nodeHelper.getNodeByID(id))) {
                nodeMap.get(id).addNeighbor(nodeMap.get(n.getId()));
            }
        }
    }

    public MapNode getNode(UUID id) {
        return nodeMap.get(id);
    }
}
