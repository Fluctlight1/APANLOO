package SimpleGUI;

import java.awt.*;
import java.awt.event.*;

/**
 * Una ventana, centrada en la pantalla y que termina la aplicación al cerrarse
 * que contiene dos botones y una etiqueta y realiza acciones al presionar los
 * botones
 * 
 * @author Salvador Gonzalez Arellano
 * @version 1.1
 */
public class EjemploCompleto1 extends Frame implements ActionListener {
    Label valorLabel;
    Button incrementarButton;
    Button reiniciarButton;

    /**
     * Constructor de la clase
     */
    public EjemploCompleto1() {
        super("Un incrementador");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evento) {
                System.exit(0);
            }
        });
        inicializar();
    }

    /**
     * Inicializa los componentes gráficos de la ventana y agrega los
     * ActionListeners a los botones
     */
    private void inicializar() {
        setSize(250, 100);
        setLayout(null);

        incrementarButton = new Button("Incrementar");
        incrementarButton.setBounds(30, 40, 85, 25);
        // Registra la instancia de esta/this clase como listener
        incrementarButton.addActionListener(this);
        add(incrementarButton);

        reiniciarButton = new Button("Reiniciar");
        reiniciarButton.setBounds(135, 40, 85, 25);
        // Registra la instancia de esta/this clase como listener
        reiniciarButton.addActionListener(this);
        add(reiniciarButton);

        valorLabel = new Label("0", Label.CENTER);
        valorLabel.setBounds(100, 70, 50, 25);
        add(valorLabel);

        centrar();
        setVisible(true);
    }

    /**
     * Incrementa el valor de la etiqueta si la accion realizada fue sobre el boton
     * incrementButton, establece el valor de la etiqueta a 0 si la accion realizada
     * fue sobre el boton resetButton
     * 
     * @param evento
     */
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == incrementarButton) {
            int valor = Integer.parseInt(valorLabel.getText());
            valorLabel.setText(String.valueOf(valor + 1));
        } else if (evento.getSource() == reiniciarButton) {
            valorLabel.setText("0");
        }
    }

    /**
     * Centra la ventana con respecto a las dimesiones de la pantalla
     */
    public void centrar() {
        Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension tamVentana = this.getSize();
        // Se ajusta el tamaño de la ventana, si es mayor al de la pantalla
        if (tamVentana.height > tamPantalla.height)
            tamVentana.height = tamPantalla.height;
        if (tamVentana.width > tamPantalla.width)
            tamVentana.width = tamPantalla.width;
        // Se centra la ventana
        this.setLocation((tamPantalla.width - tamVentana.width) / 2,
                (tamPantalla.height - tamVentana.height) / 2);
    }

    public static void main(String[] args) {
        new EjemploCompleto1();
    }
}
