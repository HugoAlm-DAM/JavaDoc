package ejercicio_1;

/**
 * Esta clase genera la excepcion
 */
public class EsNegatiuEX extends Exception {

    public EsNegatiuEX() {

        super("el valor no pot ser negatiu");
    }

    public EsNegatiuEX(String msg) {
        super(msg);
    }
}
