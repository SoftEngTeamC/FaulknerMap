/**
 * Created by jack on 3/31/17.
 */
public class Coordinate {
    private float xpos;
    private float ypos;
    private int zpos;

    public Coordinate(float xpos, float ypos, int zpos){
        this.xpos = xpos;
        this.ypos = ypos;
        this.zpos = zpos;
    }

    float distanceTo(Coordinate otherCord){return 0;}
}
