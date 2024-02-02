package practica_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Esta clase es un cotrol de acceso en el cual se necesita un usuario y contraseña que esten registradas
 * @author Hugo Almodovar
 */
public class ejercicio_2_UD7 implements KeyListener {

    private JFrame frame = new JFrame();
    private JPasswordField passwordField;
    private JTextField textoUser;
    private JFrame controllingFrame;
    final private Color COLORVERDE = new Color(189, 236, 182);
    final private Color COLORAZUL = new Color(178, 218, 250);
    private JFrame ventana = new JFrame();

    /**
     * El constructor en el cual se añaden todos los objetos al JFrame
     */
    public ejercicio_2_UD7() {

        frame.setLayout(null);
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Control de acceso");
        frame.setResizable(false);
        frame.getContentPane().setBackground(COLORVERDE);
        Image icon = new ImageIcon(getClass().getResource("Gorila.png")).getImage();
        frame.setIconImage(icon);
        agregarLabels();
        agregarInterectuables();
        cerrar();
        frame.setVisible(Boolean.TRUE);
    }

    /**
     * Este metodo agrega todos los Jlabels al JFrame
     */
    public void agregarLabels() {
        JLabel titulo = new JLabel("Welcome");
        titulo.setFont(new Font("Source Code Pro Light", Font.BOLD, 24));
        titulo.setBounds(100, 0, 200, 100);
        frame.add(titulo);

        JLabel user = new JLabel("USER");
        user.setBounds(50, 80, 50, 20);
        frame.add(user);

        JLabel password = new JLabel("PASSWORD");
        password.setBounds(50, 120, 100, 20);
        frame.add(password);
    }

    /**
     * Este metodo agrega todos los objetos con los culaes puede interactuar el usuario
     */
    public void agregarInterectuables() {
        textoUser = new JTextField();
        textoUser.setBounds(150, 80, 100, 20);
        frame.add(textoUser);

        passwordField = new JPasswordField(8);
        passwordField.setEchoChar('*');
        passwordField.setBounds(150, 120, 100, 20);
        passwordField.addKeyListener(this);
        frame.add(passwordField);

        JButton boton = new JButton("LOG IN");
        boton.setBounds(150, 150, 100, 30);
        boton.addActionListener(this::actionPerformed);
        frame.add(boton);

        JButton botonColor = new JButton("COLOR");
        botonColor.setBounds(20, 150, 90, 30);
        botonColor.addActionListener(this::cambiarColor);
        frame.add(botonColor);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.VK_ENTER == e.getKeyCode()){
            logIn();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * Este metodo cambia el fondo del JFrame entre 2 colores depediendo de si esta de un color o no
     *
     * @param event Sucede al tocar el boton "color"
     */
    public void cambiarColor(ActionEvent event) {
        Color colorActual = frame.getContentPane().getBackground();

        if (colorActual.getRGB() == COLORVERDE.getRGB()) {
            frame.getContentPane().setBackground(COLORAZUL);
        }

        if (colorActual.getRGB() == COLORAZUL.getRGB()) {
            frame.getContentPane().setBackground(COLORVERDE);
        }
    }

    /**
     * Este metodo es el que da el mensaje dependiedo si la contraseña y el usuario son correctas
     */
    public void logIn(){

        char[] input = passwordField.getPassword();
        String user = textoUser.getText();

        if (isPasswordCorrect(input) && isCorrectUser(user)) {
            frame.dispose();
            ventanaEmergente();


        } else {
            JOptionPane.showMessageDialog(controllingFrame,
                    "Fail. You are not in",
                    "Warning",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Este metodo crea la ventana emergente al haber insertado un usuario correcto con su contraseña correspondiente
     */
    public void ventanaEmergente(){
        ventana.setLayout(null);
        ventana.setSize(500, 200);
        ventana.setLocationRelativeTo(null);
        ventana.setTitle("Login");
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(frame);
        JLabel titulo = new JLabel("YOU ARE LOG IN");
        titulo.setFont(new Font("Source Code Pro Light", Font.BOLD, 30));
        titulo.setBounds(120, 0, 300, 100);
        ventana.add(titulo);
        JButton botonSalida = new JButton("EXIT");
        botonSalida.setBounds(200,100,100,40);
        ventana.add(botonSalida);
        botonSalida.addActionListener(this::salidaBoton);
        ventana.setVisible(Boolean.TRUE);
    }

    /**
     * Este metodo cierra la ventana emergente del login correcto
     *
     * @param e  Al presionar el boton correspondiente cierra la ventana emergente
     */
    public void salidaBoton(ActionEvent e){
        ventana.dispose();
    }

    /**
     * Este metodo se ejecuta para dar el mensaje de si es correcta o no
     *
     * @param e Al presionar el boton de login ejecutara la accion
     */
    public void actionPerformed(ActionEvent e) {

        logIn();
    }

    /**
     * Este metodo comprueba la contraseña
     *
     * @param input La contraseña introducida pasada a caracteres
     * @return True o folse dependiendo si la contraseña es correcta o no
     */
    public static boolean isPasswordCorrect(char[] input) {
        boolean isCorrect;
        char[] correctPassword = {'b', 'u', 'g', 'a', 'b', 'o', 'o'};

        if (input.length != correctPassword.length) {
            isCorrect = Boolean.FALSE;
        } else {
            isCorrect = Arrays.equals(input, correctPassword);
        }

        return isCorrect;
    }

    /**
     * Este metodo comprueba si el usuario es correcto
     *
     * @param user El nombre del usuario
     * @return True o false dependiendo de si el usuario es el correspondiente
     */
    public static boolean isCorrectUser(String user) {
        boolean isCorrect = Boolean.TRUE;
        final String CORRECTUSER = "Gustavo";

        if (!user.equals(CORRECTUSER)) {
            isCorrect = Boolean.FALSE;
        }

        return isCorrect;
    }

    /**
     * Este metoddo al presionar el cerrar del Jframe lanza una opcion
     */
    public void cerrar(){
        try{
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                  confirmarSalida();
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Este metodo confirma si se quiere salir del Jframe
     */
    public void confirmarSalida() {
        Object[] opciones = {"Confirmar", "Cancelar"};
        int n = JOptionPane.showOptionDialog(controllingFrame,
                "Estas seguro de que quieres salir?",
                "Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[1]
        );

        switch (n) {
            case JOptionPane.YES_OPTION:
                System.exit(0);
                break;
            case JOptionPane.NO_OPTION:
                break;
        }
    }

    public static void main(String[] args) {

        new ejercicio_2_UD7();

    }

}
