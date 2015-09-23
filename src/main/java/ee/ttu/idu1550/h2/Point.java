package ee.ttu.idu1550.h2;

import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

/**
 * Created by Mart Aarma on 13.09.2015.
 */
@Invariant({"getRho() == Math.sqrt(Math.pow(getX(),2) + Math.pow(getY(),2))"})
public interface Point {

    @Ensures("result != null")
    Double getX();

    @Ensures("result != null")
    Double getY();

    double getRho();

    @Ensures("0 <= getTheta() && getTheta() <= (Math.PI * 2)")
    double getTheta();

    @Ensures("result == vectorTo(other).getRho()")
    double getDistance(Point other);

    @Ensures("getX() == other.getX() - old(getX()) && getY() == other.getY() - old(this.getY())")
    Point vectorTo(Point other);

    @Ensures("getTheta() == (old(getTheta()) + angle) % (2 * Math.PI)")
    void rotate(Point p, double angle);

    @Ensures("getX() == old(getX()) + dx && getY() == old(getY()) + dy")
    void translate(double dx, double dy);

    @Requires("angle >= 0 && angle <= 2 * Math.PI")
    @Ensures("getTheta() % (2*Math.PI) == (old(getTheta()) + angle) % (2*Math.PI)")
    void centerRotate(double angle);

    @Ensures("getX() == old(getX()) * factor && getY() == old(getY()) * factor")
    void scale(Double factor);
}
