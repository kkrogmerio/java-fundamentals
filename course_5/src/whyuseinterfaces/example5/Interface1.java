package whyuseinterfaces.example5;

/**
 * @author cvoinea
 */
public interface Interface1 {

    default void m1(){
        System.out.println("m1 in interface1");
    }
}
