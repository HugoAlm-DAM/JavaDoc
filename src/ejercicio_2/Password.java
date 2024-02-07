package ejercicio_2;

/**
 * Crea una contrasenya y la comprueba.
 * Se crea una contrasenya aleatoria y despues comprueba si esta contrasenya es fuerte o no.
 * @author Hugo Almodovar Fuster
 * @version 1.5
 */
public final class Password {
    private final static int LONG_DEF = 8;

    private int longitud;

    private String contrasenya;

    /**
     * Es un metodo que devuelve la longitud
     * @return Devuelve la longitud de la contrasenya
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * Este metodo asigna la longitud de la contrasenya
     * @param longitud Es la longitud que tiene la contrasenya
     */
    public void setLongitud(int longitud) {

        this.longitud = longitud;
    }


    /**
     * Este metodo devuelve la contrasenya
     * @return Devuelve la contrasenya
     */
    public String getcontrasenya() {
        return contrasenya;
    }

    /**
     * Este metodo genera aleatoriamente una contrasenya
     * @return Devuelve la contrasenya en un String
     * @see Math#random() La informacion de la clase Random
     * @see Math#floor(double) La informacion de la clase Floor
     */
    public String generaPassword() {
        String password = "";
        for (int i = 0; i < longitud; i++) {
            int eleccion = ((int) Math.floor(Math.random() * 3 + 1));

            if (eleccion == 1) {
                char minusculas = (char) ((int) Math.floor(Math.random() * (123 - 97) + 97));
                password += minusculas;
            } else {
                if (eleccion == 2) {
                    char mayusculas = (char) ((int) Math.floor(Math.random() * (91 - 65) + 65));
                    password += mayusculas;
                } else {
                    char numeros = (char) ((int) Math.floor(Math.random() * (58 - 48) + 48));
                    password += numeros;
                }
            }
        }
        return password;
    }

    /**
     * Este metodo comprueba si la contrasenya es fuerte
     * @return Devuelve si la contrasenya es fuerte o no (verdadero o falso)
     * @see String#charAt(int) La informacion de la clase CharAt
     */
    public boolean esFuerte() {
        int cuentanumeros = 0;
        int cuentaminusculas = 0;
        int cuentamayusculas = 0;

        for (int i = 0; i < contrasenya.length(); i++) {
            if (contrasenya.charAt(i) >= 97 && contrasenya.charAt(i) <= 122) {
                cuentaminusculas += 1;
            } else {
                if (contrasenya.charAt(i) >= 65 && contrasenya.charAt(i) <= 90) {
                    cuentamayusculas += 1;
                } else {
                    cuentanumeros += 1;
                }
            }
        }
        if (cuentanumeros >= 5 && cuentaminusculas >= 1 && cuentamayusculas >= 2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Este metodo comprueba si la contrasenya es fuerte
     * @return Devuelve si es fuerte o no la contrasenya
     * @deprecated Obsoleto desde la version 1.2, remplazado por {@link #esFuerte()}
     */
    @Deprecated
    public boolean esFort() {
        int cuentanumeros = 0;
        int cuentaminusculas = 0;
        int cuentamayusculas = 0;

        for (int i = 0; i < contrasenya.length(); i++) {
            if (contrasenya.charAt(i) >= 97 && contrasenya.charAt(i) <= 122) {
                cuentaminusculas += 1;
            } else {

                if (contrasenya.charAt(i) >= 65 && contrasenya.charAt(i) <= 90) {
                    cuentamayusculas += 1;
                } else {
                    cuentanumeros += 1;
                }
            }
        }
        if (cuentanumeros >= 3 && cuentaminusculas >= 1 && cuentamayusculas >= 1) {
            return true;
        } else {
            return false;
        }
    }

    public Password() {
        this(LONG_DEF);
    }

    public Password(int longitud) {
        this.longitud = longitud;
        contrasenya = generaPassword();
    }

}
