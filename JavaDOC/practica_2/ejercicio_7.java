package practica_2;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Calculadorea de edad.
 * Este programa es capaz de calcular la edad de una persona introduciendo su fecha de nacimiento
 *
 * @author Hugo Almodovar
 */
public class ejercicio_7 {

    /**
     * Este metodo se pide la fecha de nacimiento del usuario para poder realizar los calculo
     */
    public static void main(String[] args){

        JFrame frame = new JFrame("Calculadora de Edad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("##-##-####");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JFormattedTextField birthDateField = new JFormattedTextField(formatter);
        birthDateField.setColumns(20);

        JButton calculateButton = getjButton(birthDateField, frame);

        JPanel panel = new JPanel();
        panel.add(birthDateField);
        panel.add(calculateButton);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    /**
     * Funcionamiento del boton.
     *El boton comprueba la fecha introducida y nos enseña un panel con la edad calculada
     * @param birthDateField El formato de fecha que se utiliza
     * @param frame Es el frame en el cual sale el mensaje del calculo de la edad
     * @return Devuelve la accion del boton
     */
    public static JButton getjButton(JFormattedTextField birthDateField, JFrame frame) {
        JButton calculateButton = new JButton("Calcular Edad");
        calculateButton.addActionListener(e -> {
            String birthDateStr = birthDateField.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date birthDate = sdf.parse(birthDateStr);
                int age = calculateAge(birthDate);
                JOptionPane.showMessageDialog(frame, "Tu edad es " + age + " años.");
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
        });
        return calculateButton;
    }

    /**
     * Calcula la edad en años.
     *La calcula haciendo la resta del año actual a la fecha introducida
     * @param birthDate La fecha de nacimiento pedida
     * @return La edad en un entero
     */
    public static int calculateAge(Date birthDate) {
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

        return age;
    }
}
