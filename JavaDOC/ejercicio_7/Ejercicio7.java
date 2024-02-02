package ejercicio_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Ejercicio7 extends JFrame {

    private JLabel titulo;
    private JTextField pedirNumero;
    private JLabel numero;
    private Random random = new Random();
    private int numAleatorio;
    private JButton adivinar;

    public Ejercicio7() {
        setLayout(null);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setTitle("Adivina el numero");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Titulo
        titulo = new JLabel("Adivinar el numero");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(200, 0, 1000, 100);
        add(titulo);

        //Numero
        numero = new JLabel("Escribe el numero que desees: ");
        numero.setBounds(90, 100, 200, 20);
        add(numero);

        pedirNumero = new JTextField();
        pedirNumero.setBounds(270, 100, 50, 20);
        add(pedirNumero);

        adivinar = new JButton("Jugar");
        adivinar.setBounds(0, 350, this.getWidth(), 60);
        adivinar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int valor = Integer.parseInt(pedirNumero.getText());
                numAleatorio = random.nextInt(300);
                if(numAleatorio == valor){
                    JOptionPane.showMessageDialog(null,"Has ganado :)");
                } else JOptionPane.showMessageDialog(null,"Perdiste :(");
            }
        });
        add(adivinar);
        setVisible(true);
    }

    public static void main(String[] args) {

        new Ejercicio7();
    }
}
