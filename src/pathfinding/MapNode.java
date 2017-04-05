package pathfinding;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class MapNode implements Node<MapNode> {
    private Coordinate location;
    private Set<MapNode> neighbors;

    public MapNode(Coordinate location) {
        this.location = location;
        this.neighbors = new HashSet<>();
    }

    public MapNode(Coordinate location, Set<MapNode> neighbors) {
        this.location = location;
        this.neighbors = neighbors;
    }

    public MapNode(db.dbClasses.Node dbNode) {
        db.dbClasses.Coordinate c = dbNode.getPosition();
        this.location = new Coordinate(c.getXpos(), c.getYpos(), c.getZpos());
    }

    public double heuristicCost(MapNode goal) {
        return distanceTo(goal);
    }

    public double traversalCost(MapNode neighbor) {
        return distanceTo(neighbor);
    }

    public Set<MapNode> neighbors() {
        return this.neighbors;
    }

    public double distanceTo(MapNode n) {
        double xDelta = this.location.getX() - n.location.getX();
        double yDelta = this.location.getY() - n.location.getY();
        return Math.sqrt(Math.pow(xDelta, 2) + Math.pow(yDelta, 2));
    }

    public void addNeighbor(MapNode n) {
        neighbors.add(n);
    }
}
