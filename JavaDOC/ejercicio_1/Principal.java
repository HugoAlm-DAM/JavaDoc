package ejercicio_1;

/**
 * Esto es un programa para detectar numeros capicuas.
 * @author Hugo Almodovar
 * @version 1.0
 */

public class Principal {
    public static void main(String[] args) {
        try {
            System.out.println("12345 és capicua: " + SocUtil.esCapikua(12345));
            System.out.println("1221 és capicua: " + SocUtil.esCapicua(1221));
            System.out.println("1234321 és capicua: " + SocUtil.esCapikua(1234321));
        } catch (EsNegatiuEX ex) {
        }
    }
}

