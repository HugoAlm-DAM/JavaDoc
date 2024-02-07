package ejercicio_1;

/**
 * Esta clase es la que hace los calculos para saber si son capicuas
 */
public class SocUtil {
    /**
     *Comprueba el numero si es capicua y lo hace por medio de operaciones aritmeticas
     * @param numero Es el numero introducido por pantalla
     * @return Devuelve si es verdadero o no
     * @throws EsNegatiuEX Lanza una excepcion al haber un numeor negativo, ya que no se pueden calcular el capicua de los numero negativos
     * @deprecated Desde la version 1.35 esta en desuso, remplazado por {@link #esCapikua(int)}
     */
    @Deprecated
    public static boolean esCapicua(int numero) throws EsNegatiuEX {
        if (numero < 0) {
            throw new EsNegatiuEX();
        }
        int numAlReves = 0;
        int copia = numero;
        while (numero > 0) {
            numAlReves = numAlReves * 10 + numero % 10;
            numero /= 10;
        }
        return copia == numAlReves;
    }

    /**
     * Comprueba si es capicua mediante un StringBuilder y dandole la vuelta
     * @param numero Es el numero que se introduce por pantalla
     * @return Devuelve si es verdadero o falso
     * @throws EsNegatiuEX Lanza una excepcion al haber un numeor negativo, ya que no se pueden calcular el capicua de los numero negativos
     */

    public static boolean esCapikua(int numero) throws EsNegatiuEX {
        if (numero < 0) {
            throw new EsNegatiuEX();
        }
        String cadNum = numero + "";
        String numAlReves = (new StringBuilder(cadNum)).reverse().toString();
        return cadNum.equals(numAlReves);
    }

    /**
     * Comprueba si es capicua dividiendo el numero y comprobando cada digito
     * @param numero Es el numero que se introduce por pantalla
     * @return Devuelve si es verdadero o falso
     * @throws EsNegatiuEX Lanza una excepcion al haber un numeor negativo, ya que no se pueden calcular el capicua de los numero negativos
     */
    public static boolean esPrimer(int numero) throws EsNegatiuEX {
        if (numero < 0) {
            throw new EsNegatiuEX();
        }
        int limit = numero / 2 + 1;
        int div = 2;
        while (div < limit) {
            if (numero % div == 0) {
                return false;
            }
            div++;
        }
        return true;
    }


    /**
     * Saca el factorial
     * @param numero El numero hasta donde se va a hacer el factorial
     * @return Devuelve el numero facotrial
     * @throws EsNegatiuEX Lanza una excepcion al haber un numeor negativo, ya que no se pueden calcular el factorial de los numero negativos
     * @see <a href="http://www.sangakoo.com/es/temas/el-factorial-de-un-numero">Sangaku maths</a>
     */
    public static long getFactorial(int numero) throws EsNegatiuEX {
        if (numero < 0) {
            throw new EsNegatiuEX("no es pot calcular el factorial d'un número negatiu");
        }
        long fact = 1L;
        while (numero > 1) {
            fact *= numero;
            numero--;
        }
        return fact;
    }
}
