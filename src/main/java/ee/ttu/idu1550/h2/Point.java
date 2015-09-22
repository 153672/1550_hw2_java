package ee.ttu.idu1550.h2;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

/**
 * Created by Mart Aarma on 13.09.2015.
 */
@Invariant({"getX() != null", "getY() != null"})
public interface Point {

    @Ensures("result != null")
    Double getX();

    @Ensures("result != null")
    Double getY();

    @Ensures("result >= 0")
    double getRho();

    double getTheta();

    @Ensures("result >= 0")
    double getDistance(Point other);

    Point vectorTo(Point other);

    void rotate(Point p, double angle);

    void translate(double dx, double dy);

    @Requires("angle >= 0 && angle <= 2 * java.lang.Math.PI")
    void centerRotate(double angle);

    @Requires("factor <= java.lang.Integer.MAX_VALUE")
    void scale(Double factor);
}
