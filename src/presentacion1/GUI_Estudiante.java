package presentacion1;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_Estudiante extends JFrame
{
    private JButton miFoto, miHobby, misExpectativas;
    private JPanel panelBotones, panelDatos;
    private JTextArea textoExpectativas;
    private Titulo titulo;
    private ImageIcon imagen;
    private JLabel labelImagen;
    private Escucha escucha;

    public GUI_Estudiante()
    {
        initGUI();

        //Default window configuration
        this.setTitle("Mi ventana");
        this.setSize(600,540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
              GUI_Estudiante miGUI = new GUI_Estudiante();
            }
        });
    }

    private void initGUI()
    {
        //Set up Container and Layout
        //Create Listener and Control Objects
        escucha = new Escucha();
        //Set up JComponents
        titulo = new Titulo("¡Hola! Soy Julian, oprime un boton", Color.GRAY);
        this.add(titulo, BorderLayout.NORTH);

        miFoto = new JButton("Este soy yo");
        miFoto.addActionListener(escucha);
        miHobby = new JButton("Mi hobby");
        miHobby.addActionListener(escucha);
        misExpectativas = new JButton("Creo que");
        misExpectativas.addActionListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(miHobby);
        panelBotones.add(misExpectativas);

        this.add(panelBotones, BorderLayout.SOUTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Un poco más de mi",
                TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.CENTER, new Font(Font.SANS_SERIF,Font.BOLD+Font.ITALIC,
                20), Color.BLACK));
        this.add(panelDatos, BorderLayout.CENTER);
        labelImagen = new JLabel();
        textoExpectativas = new JTextArea(15, 20);
    }

    private class Escucha implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent objectEvent)
        {
            panelDatos.removeAll();
            if(objectEvent.getSource()==miFoto)
            {
                imagen = new ImageIcon(getClass().getResource("/recursos/Imagen2.jpg"));
                labelImagen.setIcon(imagen);
                panelDatos.add(labelImagen);
            } else
            {
                if(objectEvent.getSource()==miHobby)
                {
                    //JOptionPane.showMessageDialog(miHobby, "Diste click en mi Hobby");
                    imagen = new ImageIcon(getClass().getResource("/recursos/Imagen1.jpg"));
                    labelImagen.setIcon(imagen);
                    panelDatos.add(labelImagen);
                }

                else
                {
                    //JOptionPane.showMessageDialog(miHobby, "Diste click en mis Expectativas");
                    textoExpectativas.setText("\n" + "No se mucho de Java, pero deseo aprender bastante \n" +
                            "en este curso. \n"+
                            "A pesar de las circunstancias y los inconvenientes \n" + "siempre es posible aprender y lograr \n" +
                            "los objetivos");
                    textoExpectativas.setBackground(null);
                    textoExpectativas.setFont(new Font(Font.SANS_SERIF, Font.PLAIN+Font.ITALIC, 22));
                    panelDatos.add(textoExpectativas);
                }
             }
            revalidate();
            repaint();
        }
    }
}
