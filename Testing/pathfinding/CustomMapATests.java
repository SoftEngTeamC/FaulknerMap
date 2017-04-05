package pathfinding;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;

/**
 * Created by sam on 4/4/17.
 */
public class CustomMapATests {
    MapNode A, B, C, D, E;

    @Before
    public void setUp() throws Exception {
        // A --- B
        //  \   /       E (isolated)
        //   \ /
        //    C --- D
        this.A = new MapNode(new Coordinate(0, 5, 1));
        this.B = new MapNode(new Coordinate(3, 4, 1));
        this.C = new MapNode(new Coordinate(1, 0, 1));
        this.D = new MapNode(new Coordinate(6, 0, 1));
        this.E = new MapNode(new Coordinate(8, 3, 1));
        this.A.addNeighbor(B);
        this.A.addNeighbor(C);
        this.B.addNeighbor(C);
        this.C.addNeighbor(D);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shortestPathIsolated() throws Exception {
        assertNull(PathFinder.shortestPath(A, E));
    }

}