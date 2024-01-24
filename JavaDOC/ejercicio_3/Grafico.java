package ejercicio_3;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Es una clase para crear un formulario.
 * En este formulario se pediroan varios valores que tiene que introducir el usuario
 */
public class Grafico {

    private JFrame frame = new JFrame();
    private JTextField nombre;
    private JLabel textoNombre;
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
    private JMenuBar barraMenu;
    private JMenu menu;
    private JCheckBoxMenuItem item1;
    private JCheckBoxMenuItem item2;
    private JCheckBoxMenuItem item3;
    private JCheckBoxMenuItem item4;

    public Grafico() {
        frame.setLayout(null);
        frame.setLayout(null);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Formulario");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.orange);
        Image icon = new ImageIcon(getClass().getResource("whastapp.png")).getImage();
        frame.setIconImage(icon);
        agregarlabels();
        agregarInteractuables();
        frame.setVisible(true);

    }

    public void agregarlabels() {
        titulo = new JLabel("Formulario de inscripcion");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(200, 0, 1000, 100);
        frame.add(titulo);

        textoNombre = new JLabel("Nombre:");
        textoNombre.setBounds(10, 110, 100, 20);
        frame.add(textoNombre);

        edad = new JLabel("Edad:");
        edad.setBounds(200, 110, 100, 20);
        frame.add(edad);

        provincia = new JLabel("Provincia:");
        provincia.setBounds(10, 170, 100, 20);
        frame.add(provincia);

        sexo = new JLabel("Sexo:");
        sexo.setBounds(10, 210, 50, 20);
        frame.add(sexo);
    }

    public void agregarInteractuables() {
        nombre = new JTextField();
        nombre.setBounds(10, 130, 100, 20);
        frame.add(nombre);

        spinnerEdad = new JSpinner(sm);
        spinnerEdad.setBounds(240, 110, 40, 20);
        frame.add(spinnerEdad);

        caja = new JComboBox<String>();
        caja.setBounds(70, 170, 100, 20);
        caja.addItem("Valencia");
        caja.addItem("Madrid");
        caja.addItem("Barcelona");
        caja.addItem("Alicante");
        caja.addItem("Huelva");
        frame.add(caja);

        grupoSexo.add(masculino);
        grupoSexo.add(femenino);
        grupoSexo.add(otro);
        masculino.setBounds(50, 210, 90, 20);
        femenino.setBounds(140, 210, 90, 20);
        otro.setBounds(230, 210, 90, 20);
        masculino.setSelected(true);
        frame.add(masculino);
        frame.add(femenino);
        frame.add(otro);

        enviar = new JButton("Enviar");
        enviar.setBounds(0, 350, 600, 60);
        enviar.setEnabled(false);
        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] opciones = {"Confirmar", "Cerrar", "Cancelar"};

                int n = JOptionPane.showOptionDialog(jFrameConfirmacion,
                        "Quieres aceptar los datos del formulario?", "Confirmacion",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciones,
                        opciones[2]);

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
        frame.add(enviar);

        checkBox = new JCheckBox("Acepta la publicidad");
        checkBox.setBounds(440, 300, 400, 20);
        frame.add(checkBox);

        barraMenu = new JMenuBar();
        barraMenu.setBounds(0, 0, 1000, 20);
        frame.add(barraMenu);
        menu = new JMenu("Desactivar");
        menu.setMnemonic(KeyEvent.VK_F);
        menu.setBounds(10, 0, 100, 20);
        barraMenu.add(menu);

        item1 = new JCheckBoxMenuItem("Desactivar nombre");
        item1.setBounds(30, 0, 100, 20);
        item1.setMnemonic(KeyEvent.VK_C);
        menu.add(item1);

        item2 = new JCheckBoxMenuItem("Desactivar edad");
        item2.setBounds(40, 0, 100, 20);
        item2.setMnemonic(KeyEvent.VK_C);
        menu.add(item2);

        item3 = new JCheckBoxMenuItem("Desactivar provincia");
        item3.setBounds(50, 0, 100, 20);
        item3.setMnemonic(KeyEvent.VK_C);
        menu.add(item3);

        item4 = new JCheckBoxMenuItem("Desactivar sexo");
        item4.setBounds(60, 0, 100, 20);
        item4.setMnemonic(KeyEvent.VK_C);
        menu.add(item4);

        ActionListener aListener = new ActionListener() {
            public void actionPerformed(ActionEvent event) {

                if (item1.isSelected()) {

                    nombre.setVisible(false);
                    textoNombre.setVisible(false);
                } else if (!item1.isSelected()) {

                    nombre.setVisible(true);
                    textoNombre.setVisible(true);
                }

                if (item2.isSelected()) {

                    edad.setVisible(false);
                    spinnerEdad.setVisible(false);
                } else if (!item2.isSelected()) {

                    edad.setVisible(true);
                    spinnerEdad.setVisible(true);
                }

                if (item3.isSelected()) {

                    provincia.setVisible(false);
                    caja.setVisible(false);
                } else if (!item3.isSelected()) {

                    provincia.setVisible(true);
                    caja.setVisible(true);
                }

                if (item4.isSelected()) {

                    sexo.setVisible(false);
                    masculino.setVisible(false);
                    femenino.setVisible(false);
                    otro.setVisible(false);
                } else if (!item4.isSelected()) {
                    sexo.setVisible(true);
                    masculino.setVisible(true);
                    femenino.setVisible(true);
                    otro.setVisible(true);
                }
            }
        };
        item1.addActionListener(aListener);
        item2.addActionListener(aListener);
        item3.addActionListener(aListener);
        item4.addActionListener(aListener);

        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                enviar.setEnabled(e.getStateChange() == ItemEvent.SELECTED);

            }
        });
    }


    public static void main(String[] args) {

        new Grafico();
    }
}
