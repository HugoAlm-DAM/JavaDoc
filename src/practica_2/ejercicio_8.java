package practica_2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Esta clase cabia la intensidad de un cuadrado verde dependiendo del valor indicado
 * Ademas esta clase implementa la clase JFrame
 * @author Hugo Almodovar
 */
public class ejercicio_8 extends JFrame {

    private JSlider slider;
    private JPanel panel;

    /**
     * En este constructor se establecen los valores del JFrame y se añaden sus elementos
     */
    public ejercicio_8() {

        setSize(300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        agregarSlider();
        agregarPanel();
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                panel.setBackground(new Color(0, slider.getValue() * 255 / 100, 0));
            }
        });

        setVisible(true);
    }

    /**
     * Este metodo crea el Jslider
     */
    public void agregarSlider() {
        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(20);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBounds(0, 20, 280, 50);
        add(slider, BorderLayout.NORTH);

    }

    /**
     * Este metodo crea el JPanel
     */
    public void agregarPanel() {
        panel = new JPanel();
        panel.setBounds(100, 100, 80, 50);
        panel.setBackground(Color.GREEN);
        getContentPane().add(panel, BorderLayout.CENTER);
    }

    /**
     * Es la entrada de la aplicacion
     */
    public static void main(String[] args) {
        new ejercicio_8();
    }
}
