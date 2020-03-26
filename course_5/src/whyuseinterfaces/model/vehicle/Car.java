package whyuseinterfaces.model.vehicle;

import whyuseinterfaces.Washable;

/**
 * @author cvoinea
 */
public class Car implements Washable {

    @Override
    public void wash() {
        System.out.println("washing a car");
    }
}
