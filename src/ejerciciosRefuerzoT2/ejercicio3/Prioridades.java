package ejerciciosRefuerzoT2.ejercicio3;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Prioridades extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static JTextField Contador;
    private static HiloCarrera hilo;
    private static HiloCarrera hilo2;
    private static HiloCarrera hilo3;

    private static JTextField contador2;
    private static JLabel lblHilo1;
    private static JLabel lblHilo2;
    private static JProgressBar barra1;
    private static JProgressBar barra2;
    private static JProgressBar barra3;
    private static JTextField contador3;
    private static JLabel lblGanador;
    private static JButton btnComenzar;
    private static JSlider prioridad1;
    private static JSlider prioridad2;
    private static JSlider prioridad3;
    private JLabel lblNewLabel;
    private JLabel label;
    private JLabel label_1;
    private JLabel lp1;
    private JLabel lp2;
    private JLabel lp3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio6CarreraHilosPrioridades frame = new Ejercicio6CarreraHilosPrioridades();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}// fin run
		});*/

        // 1.- Definición de la Interfaz Gráfica
        try {
            Prioridades frame = new Prioridades();
            frame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2.- Crear los hilos (sólos se crean, no se inician)
        IniciarHilos();

        // 3.- Iteración para actualizar las barras de progreso mientras no haya un hilo ganador,
        //     es decir, finaliza cuando haya un hilo que alcance el máximo en el contador (100).
        //     Observar que la iteración no tiene fin, pero cuando un hilo gana se paran todos,
        //     por lo que el bucle seguiría iterando pero sin ejecutar ninguna instrucción.
        //     El usuario puede decidir empezar otra carrera por lo que los 3 hilos volverían a iniciarse.
        while (true) {
            if (hilo.isAlive()) {
                int con1 = hilo.getContador();
                Contador.setText(String.valueOf(con1));
                barra1.setValue(con1);
                if (con1 == barra1.getMaximum()) {
                    FinalizarProceso();
                    lblGanador.setText("GANA HILO 1");
                }
            }

            if (hilo2.isAlive()) {
                int con2 = hilo2.getContador();
                contador2.setText(String.valueOf(con2));
                barra2.setValue(con2);
                if (con2 == barra2.getMaximum()) {
                    FinalizarProceso();
                    lblGanador.setText("GANA HILO 2");
                }
            }

            if (hilo3.isAlive()) {
                int con3 = hilo3.getContador();
                contador3.setText(String.valueOf(con3));
                barra3.setValue(con3);
                if (con3 == barra3.getMaximum()) {
                    FinalizarProceso();
                    lblGanador.setText("GANA HILO 3");
                }
            }
        }
    }// fin de main

    private static void IniciarHilos() {
		/*
		//mismo tiempo para todos
		hilo = new HILOCARRERA("UNO", 200);//Math.random() * 1000 + 1);
		hilo2 = new HILOCARRERA("DOS", 200);//Math.random() * 1000 + 1);
		hilo3 = new HILOCARRERA("TRES", 200);//Math.random() * 1000 + 1);
		*/
        //tiempo aleatorio
        hilo = new HiloCarrera("UNO", Math.random() * 1000 + 1);
        hilo2 = new HiloCarrera("DOS", Math.random() * 1000 + 1);
        hilo3 = new HiloCarrera("TRES", Math.random() * 1000 + 1);
    }

    /**
     * Create the frame.
     */
    public Prioridades() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                ;
            }
        });

        setTitle("USANDO PRIORIDADES. CARRERA DE HILOS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 510, 352);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        barra1 = new JProgressBar();
        barra1.setBounds(23, 89, 461, 18);
        contentPane.add(barra1);

        btnComenzar = new JButton("Comenzar Carrera");

        // Ejemplo de clase anónima
        btnComenzar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblGanador.setText("                     ");
                // Sólo iniciamos el hilo si no está ya funcionando, por lo que
                // si pulsamos el botóón de Comenzar Carrera no tendrá efecto en caso que ya haya
                // una carrera en curso. Mismo comentario para el resto de hilos.
                if (!hilo.isAlive()) {
                    hilo.setPriority(prioridad1.getValue());
                    lp1.setText("Prioridad: " + Integer.toString(prioridad1.getValue()));
                    hilo.start();
                }

                if (!hilo2.isAlive()) {
                    hilo2.setPriority(prioridad2.getValue());
                    lp2.setText("Prioridad: " + Integer.toString(prioridad2.getValue()));
                    hilo2.start();
                }

                if (!hilo3.isAlive()) {
                    hilo3.setPriority(prioridad3.getValue());
                    lp3.setText("Prioridad: " + Integer.toString(prioridad3.getValue()));
                    hilo3.start();
                }

                btnComenzar.setEnabled(false);

                if (hilo.isAlive())
                    System.out.println(hilo.getPriority());
                if (hilo2.isAlive())
                    System.out.println(hilo2.getPriority());
                if (hilo3.isAlive())
                    System.out.println(hilo3.getPriority());
            }
        });
        btnComenzar.setBounds(142, 11, 178, 23);
        contentPane.add(btnComenzar);

        Contador = new JTextField();
        Contador.setEditable(false);
        Contador.setFont(new Font("Tahoma", Font.PLAIN, 13));
        Contador.setHorizontalAlignment(SwingConstants.CENTER);
        Contador.setBounds(60, 255, 86, 20);
        contentPane.add(Contador);
        Contador.setColumns(10);

        contador2 = new JTextField();
        contador2.setHorizontalAlignment(SwingConstants.CENTER);
        contador2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contador2.setEditable(false);
        contador2.setColumns(10);
        contador2.setBounds(197, 255, 86, 20);
        contentPane.add(contador2);

        lblHilo1 = new JLabel("HILO 1");
        lblHilo1.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblHilo1.setHorizontalAlignment(SwingConstants.CENTER);
        lblHilo1.setForeground(Color.RED);
        lblHilo1.setBounds(-25, 65, 146, 14);
        contentPane.add(lblHilo1);

        lblHilo2 = new JLabel("HILO 2");
        lblHilo2.setHorizontalAlignment(SwingConstants.CENTER);
        lblHilo2.setForeground(Color.RED);
        lblHilo2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblHilo2.setBounds(-25, 130, 147, 14);
        contentPane.add(lblHilo2);

        barra2 = new JProgressBar();
        barra2.setBounds(24, 150, 461, 18);
        contentPane.add(barra2);

        JLabel lblHilo = new JLabel("HILO 3");
        lblHilo.setHorizontalAlignment(SwingConstants.CENTER);
        lblHilo.setForeground(Color.RED);
        lblHilo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblHilo.setBounds(-21, 193, 147, 14);
        contentPane.add(lblHilo);

        barra3 = new JProgressBar();
        barra3.setBounds(24, 218, 461, 18);
        contentPane.add(barra3);

        lblGanador = new JLabel("");
        lblGanador.setHorizontalAlignment(SwingConstants.CENTER);
        lblGanador.setForeground(Color.RED);
        lblGanador.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblGanador.setBounds(104, 288, 279, 14);
        contentPane.add(lblGanador);

        contador3 = new JTextField();
        contador3.setHorizontalAlignment(SwingConstants.CENTER);
        contador3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contador3.setEditable(false);
        contador3.setColumns(10);
        contador3.setBounds(339, 255, 86, 20);
        contentPane.add(contador3);

        prioridad1 = new JSlider();
        prioridad1.setToolTipText("Prioridad Hilo 1");
        prioridad1.setValue(5);
        prioridad1.setMinimum(1);
        prioridad1.setMaximum(10);
        prioridad1.setBounds(152, 50, 161, 26);
        contentPane.add(prioridad1);

        prioridad2 = new JSlider();
        prioridad2.setToolTipText("Prioridad Hilo 2");
        prioridad2.setValue(5);
        prioridad2.setMinimum(1);
        prioridad2.setMaximum(10);
        prioridad2.setBounds(152, 113, 161, 26);
        contentPane.add(prioridad2);

        prioridad3 = new JSlider();
        prioridad3.setToolTipText("Prioridad Hilo 3");
        prioridad3.setValue(5);
        prioridad3.setMinimum(1);
        prioridad3.setMaximum(10);
        prioridad3.setBounds(152, 179, 161, 26);
        contentPane.add(prioridad3);

        lblNewLabel = new JLabel("1                     5                     10");
        lblNewLabel.setBounds(152, 73, 158, 14);
        contentPane.add(lblNewLabel);

        label = new JLabel("1                     5                     10");
        label.setBounds(152, 136, 158, 14);
        contentPane.add(label);

        label_1 = new JLabel("1                     5                     10");
        label_1.setBounds(152, 203, 158, 14);
        contentPane.add(label_1);

        lp1 = new JLabel("Prioridad: 5");
        lp1.setHorizontalAlignment(SwingConstants.RIGHT);
        lp1.setForeground(Color.RED);
        lp1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lp1.setBounds(323, 64, 161, 14);
        contentPane.add(lp1);

        lp2 = new JLabel("Prioridad: 5");
        lp2.setHorizontalAlignment(SwingConstants.RIGHT);
        lp2.setForeground(Color.RED);
        lp2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lp2.setBounds(323, 130, 161, 14);
        contentPane.add(lp2);

        lp3 = new JLabel("Prioridad: 5");
        lp3.setHorizontalAlignment(SwingConstants.RIGHT);
        lp3.setForeground(Color.RED);
        lp3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lp3.setBounds(323, 195, 161, 14);
        contentPane.add(lp3);
    }

    private static void FinalizarProceso() {
        hilo.pararHilo();
        hilo2.pararHilo();
        hilo3.pararHilo();

        IniciarHilos();

        btnComenzar.setEnabled(true);
        lblGanador.setText("                               ");
    }
}