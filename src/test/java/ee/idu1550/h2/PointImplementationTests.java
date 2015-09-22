package ee.idu1550.h2;

import com.google.java.contract.PostconditionError;
import ee.ttu.idu1550.h2.CartesianPoint;
import ee.ttu.idu1550.h2.Point;
import ee.ttu.idu1550.h2.PolarPoint;
import org.junit.Assert;
import org.junit.Test;

import static java.lang.Math.PI;
import static org.junit.Assert.assertEquals;

/**
 * Created by Mart Aarma on 13.09.2015.
 */
public class PointImplementationTests {

    public static final double DELTA = 0.0000000000001;
    private static final Point p1 = new CartesianPoint(10.0, 20.0);
    private static final Point p2 = new CartesianPoint(17.0, 0.0);
    private static final Point pp1 = new PolarPoint(10.0, 20.0);
    private static final Point pp2 = new PolarPoint(17.0, 0.0);

    @Test
    public void testXY() {
        Point p1 = new CartesianPoint(10.0, 20.0);
        assertEquals(p1.getX(), pp1.getX(), DELTA);
        assertEquals(p1.getY(), pp1.getY(), DELTA);
    }

    @Test
    public void testRho() {
        assertEquals(p1.getRho(), pp1.getRho(), DELTA);
    }

    @Test
    public void testTheta() {
        assertEquals(p1.getTheta(), pp1.getTheta(), DELTA);
    }

    @Test
    public void testDistance() {
        double distance = p1.getDistance(p2);
        double distancePolar = pp1.getDistance(pp2);
        assertEquals(distance, distancePolar, DELTA);
    }

    @Test
    public void testVectorTo() {
        Point vp1 = p1.vectorTo(p2);
        Point vpp1 = pp1.vectorTo(pp2);
        assertEquals(vp1.getX(), vpp1.getX(), DELTA);
        assertEquals(vp1.getY(), vpp1.getY(), DELTA);
    }

    @Test
    public void testTranslate() {
        p1.translate(5, 4);
        pp1.translate(5, 4);
        assertEquals(p1.getX(), pp1.getX(), DELTA);
        assertEquals(p1.getY(), pp1.getY(), DELTA);
    }

    @Test
    public void testScale() {
        p1.scale(5);
        pp1.scale(5);
        assertEquals(p1.getX(), pp1.getX(), DELTA);
        assertEquals(p1.getY(), pp1.getY(), DELTA);
    }

    @Test
    public void testCenterRotate() {
        p1.centerRotate(PI);
        pp1.centerRotate(PI);
        assertEquals(p1.getX(), pp1.getX(), DELTA);
        assertEquals(p1.getY(), pp1.getY(), DELTA);
    }

    @Test
    public void testRotate() {
        Point rp1 = new CartesianPoint(8.0, 9.0);
        Point rpp1 = new PolarPoint(8.0, 9.0);
        p1.rotate(rp1, PI);

        pp1.rotate(rpp1, PI);
        assertEquals(p1.getX(), pp1.getX(), DELTA);
        assertEquals(p1.getY(), pp1.getY(), DELTA);
    }
}
