package ee.ttu.idu1550.h2;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

/**
 * Created by NORI on 13.09.2015.
 */
public class Start {

    public static void main(String [] args)
    {
        Double x  = 2d;
        Point p = new CartesianPoint(x,1.0);
        p.getX();
        p.translate(2,5);
        p.getTheta();
    }
}
