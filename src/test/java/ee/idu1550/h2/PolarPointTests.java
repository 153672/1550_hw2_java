package ee.idu1550.h2;

import ee.ttu.idu1550.h2.Point;
import ee.ttu.idu1550.h2.PolarPoint;

/**
 * Created by Mart on 22.09.2015.
 */
public class PolarPointTests extends CartesianPointTests {

    @Override
    public Point createPoint(Double x, Double y) {
        return new PolarPoint(x, y);
    }
}
