package ee.idu1550.h2;

import ee.ttu.idu1550.h2.CartesianPoint;
import ee.ttu.idu1550.h2.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mart Aarma on 13.09.2015.
 */
public class CartesianPointTests {

    public static final double DELTA = 0.0000000000001;
    private Point p1;
    private Point p2;

    @Before
    public void setUp() {
        p1 = createPoint(0.5, -4.5);
        p2 = createPoint(0.5, 0.0);
    }

    public Point createPoint(Double x, Double y) {
        return new CartesianPoint(x, y);
    }

    @Test
    public void testXY() {
        assertEquals(p1.getX(), 0.5, DELTA);
        assertEquals(p1.getY(), -4.5, DELTA);
        assertEquals(p2.getX(), 0.5, DELTA);
        assertEquals(p2.getY(), 0, DELTA);
    }

    @Test
    public void testRho() {
        assertEquals(p1.getRho(), Math.sqrt(Math.pow(0.5, 2) + Math.pow(4.5, 2)), DELTA);
    }

    @Test
    public void testTheta() {
        assertEquals(p1.getTheta(), Math.atan2(-4.5, 0.5), DELTA);
    }

    @Test
    public void testDistance() {
        assertEquals(4.5, p1.getDistance(p2), DELTA);
        assertEquals(4.5, p2.getDistance(p1), DELTA);
    }

    @Test
    public void testVectorTo() {
        Point v = p1.vectorTo(p2);
        assertEquals(v.getX(), 0, DELTA);
        assertEquals(v.getY(), 4.5, DELTA);
    }

    @Test
    public void testTranslate() {
        p1.translate(-0.5, 4.5);
        assertEquals(p1.getX(), 0, DELTA);
        assertEquals(p1.getY(), 0, DELTA);
        p1.translate(0.5, -4.5);
    }

    @Test
    public void testScale() {
        p1.scale(10.0);
        assertEquals(p1.getX(), 5, DELTA);
        assertEquals(p1.getY(), -45, DELTA);
        p1.scale(0.1);
    }

    @Test
    public void testCenterRotate() {
        p1.centerRotate(Math.PI / 3);
        assertEquals(p1.getX(), 4.147114317029974, DELTA);
        assertEquals(p1.getY(), -1.816987298107781, DELTA);
        assertEquals(p1.getRho(), 4.527692569068709, DELTA);
        assertEquals(p1.getTheta(), -0.4129415544244033, DELTA);
    }

    @Test
    public void testRotate() {
        p1.rotate(p2, Math.PI / 3);
        assertEquals(p1.getX(), 4.397114317029974, DELTA);
        assertEquals(p1.getY(), -2.25, DELTA);
        assertEquals(p1.getRho(), 4.939343510733989, DELTA);
        assertEquals(p1.getTheta(), -0.47296312665809603, DELTA);
    }
}
