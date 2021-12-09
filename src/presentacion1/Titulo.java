package presentacion1;

import javax.swing.*;
import java.awt.*;

public class Titulo extends JLabel
{
    public Titulo (String titulo, Color colorFondo)
    {
        this.setText(titulo);
        this.setBackground(colorFondo);
        this.setForeground(new Color(15, 100, 55));
        this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }
}
