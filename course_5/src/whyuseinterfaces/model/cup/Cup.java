package whyuseinterfaces.model.cup;

import whyuseinterfaces.Washable;

/**
 * @author cvoinea
 */
public class Cup implements Washable {

    double volume;
    String color;

    public int getLevelOfFragility() {
        return Washable.FRAGILE;
    }

    @Override
    public void wash() {
        System.out.println("washing a cup");
    }
}
