package whyuseinterfaces.example1;

import whyuseinterfaces.model.cup.CoffeeCup;
import whyuseinterfaces.model.cup.Cup;
import whyuseinterfaces.model.cup.TeaCup;

/**
 * @author cvoinea
 */
public class VirtualCoffee {

    public static void prepareCup(Cup cup){
        cup.wash();
    }

    public static void main(String[] args) {

        Cup cup = new Cup();
        prepareCup(cup);

        // dynamic polymorphism
        Cup coffeeCup = new CoffeeCup();
        prepareCup(coffeeCup);

        // dynamic polymorphism
        Cup teaCup = new TeaCup();
        prepareCup(teaCup);
    }


}
