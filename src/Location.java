import db.dbClasses.Node;

/**
 * Created by jack on 3/31/17.
 */
public class Location {
    private String name;
    private Node node;

    public Location(String name, Node node){
        this.name = name;
        this.node = node;
    }
}
