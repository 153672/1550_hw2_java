package ee.ttu.idu1550.h2;

import static java.lang.Math.*;
import static java.lang.Math.sin;

/**
 * Created by Mart Aarma on 13.09.2015.
 */
public class PolarPoint implements Point {

    private double rho;
    private double theta;

    public PolarPoint(Double x, Double y) {
        setRho(x, y);
        setTheta(x, y);
    }

    private void setTheta(double x, double y) {
        this.theta = atan2(y, x);
    }

    private void setRho(double x, double y) {
        this.rho = sqrt(pow(x, 2) + pow(y, 2));
    }

    @Override
    public double getRho() {
        return rho;
    }

    @Override
    public double getTheta() {
        return theta;
    }

    @Override
    public double getDistance(Point other) {
        return vectorTo(other).getRho();
    }

    @Override
    public Point vectorTo(Point other) {
        return new PolarPoint(other.getX() - this.getX(), other.getY() - this.getY());
    }

    @Override
    public void rotate(Point p, double angle) {
        translate(-p.getX(), -p.getY());
        centerRotate(angle);
        translate(p.getX(), p.getY());
    }

    @Override
    public void translate(double dx, double dy) {
        double x = getX() + dx;
        double y = getY() + dy;
        setRho(x, y);
        setTheta(x, y);
    }

    @Override
    public void centerRotate(double angle) {
        this.theta = (this.theta + angle) % (2 * Math.PI);
    }

    @Override
    public void scale(Double factor) {
        this.rho *= factor;
    }

    @Override
    public Double getX() {
        return getRho()*cos(getTheta());
    }

    @Override
    public Double getY() {
        return getRho()*sin(getTheta());
    }

    @Override
    public String toString() {
        return "x: " + getX() + " y: " + getY() + " rho: " + getRho() + " theta: " + getTheta();
    }
}
