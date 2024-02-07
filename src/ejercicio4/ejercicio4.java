package ejercicio4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ejercicio4 extends JFrame {


    private JTextField textField1;
    private JLabel nombre;
    private JComboBox<String> caja;
    private JLabel titulo;
    private JLabel edad;
    private JSpinner spinnerEdad;
    private SpinnerModel sm = new SpinnerNumberModel(18, 18, 99, 1);
    private JLabel provincia;
    private JRadioButton masculino = new JRadioButton("Masculino");
    private JRadioButton femenino = new JRadioButton("Femenino");
    private JRadioButton otro = new JRadioButton("Otro");
    private JLabel sexo;
    private ButtonGroup grupoSexo = new ButtonGroup();
    private JButton enviar;
    private JFrame jFrameConfirmacion = new JFrame("Confirmacion");
    private JCheckBox checkBox;


    public ejercicio4() {

        setLayout(null);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setTitle("Formulario");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Titulo
        titulo = new JLabel("Formulario de inscripcion");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(200, 0, 1000, 100);
        add(titulo);

        //Apartado nombre
        nombre = new JLabel("Nombre:");
        nombre.setBounds(10, 110, 100, 20);
        add(nombre);

        textField1 = new JTextField();
        textField1.setBounds(10, 130, 100, 20);
        add(textField1);

        //Apartado edad
        edad = new JLabel("Edad:");
        edad.setBounds(200, 110, 100, 20);
        add(edad);

        spinnerEdad = new JSpinner(sm);
        spinnerEdad.setBounds(240, 110, 40, 20);
        add(spinnerEdad);

        //Apartado provincia
        provincia = new JLabel("Provincia:");
        provincia.setBounds(10, 170, 100, 20);
        add(provincia);

        caja = new JComboBox<String>();
        caja.setBounds(70, 170, 100, 20);
        caja.addItem("Valencia");
        caja.addItem("Madrid");
        caja.addItem("Barcelona");
        caja.addItem("Alicante");
        caja.addItem("Huelva");
        add(caja);

        //Apartado sexo
        sexo = new JLabel("Sexo:");
        sexo.setBounds(10, 210, 50, 20);
        add(sexo);

        grupoSexo.add(masculino);
        grupoSexo.add(femenino);
        grupoSexo.add(otro);

        masculino.setBounds(50, 210, 90, 20);
        femenino.setBounds(140, 210, 90, 20);
        otro.setBounds(230, 210, 90, 20);

        add(masculino);
        add(femenino);
        add(otro);

        //Boton
        enviar = new JButton("Enviar");
        enviar.setBounds(0, 350, this.getWidth(), 60);
        enviar.setEnabled(false);
        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] opciones = {"Confirmar", "Cerrar", "Cancelar"};

                int n = JOptionPane.showOptionDialog(jFrameConfirmacion, "Quieres aceptar los datos del formulario?", "Confirmacion", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[2]);

                switch (n) {
                    case JOptionPane.YES_OPTION:
                        System.out.println("Has seleccionado confirmar");
                        break;
                    case JOptionPane.NO_OPTION:
                        System.out.println("Has seleccionado cerrar");
                        System.exit(0);
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        System.out.println("Has seleccionado cancelar");
                        break;
                }
            }
        });

        jFrameConfirmacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(enviar);

        //Apartado checkbox
        checkBox = new JCheckBox("Acepta la publicidad");
        checkBox.setBounds(440, 300, 400, 20);

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                enviar.setEnabled(e.getStateChange() == ItemEvent.SELECTED);

            }
        });
        add(checkBox);
        setVisible(true);

    }

    public static void main(String[] args) {

        new ejercicio4();
    }
}

