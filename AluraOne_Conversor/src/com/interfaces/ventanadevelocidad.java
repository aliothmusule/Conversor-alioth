package com.interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import com.modelo.Velocidad;
import com.sisi.velo;

public class ventanadevelocidad extends JFrame {

	private JPanel contentPane;
	private JComboBox<Velocidad> comboVelocidad1; 
	private JComboBox<Velocidad> comboVelocidad2;
	private JTextField txtValor;
	private JLabel lblResultado;
	double num;
	double velocidad1;
	double velocidad2;
	Double conversion;
	String unidades;
	
	// Create the frame.
	public ventanadevelocidad(velo controlador) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 620, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				
		JLabel lblConvertir = new JLabel("CONVERTIR:");
		lblConvertir.setBackground(new Color(192, 192, 192));
		lblConvertir.setHorizontalAlignment(SwingConstants.CENTER);
		lblConvertir.setForeground(new Color(0, 0, 0));
		lblConvertir.setFont(new Font("arial", Font.BOLD, 16));
		lblConvertir.setBounds(20, 96, 110, 30);
		contentPane.add(lblConvertir);
		
		JLabel lblA = new JLabel("A ->");
		lblA.setBackground(new Color(240, 240, 240));
		lblA.setForeground(new Color(0, 0, 0));
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("arial", Font.BOLD, 16));
		lblA.setBounds(325, 96, 60, 30);
		contentPane.add(lblA);
		
		JLabel lblTitulo = new JLabel("CONVERSOR DE MONEDAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("arial", Font.BOLD, 22));
		lblTitulo.setBounds(97, 25, 342, 36);
		contentPane.add(lblTitulo);
		
		txtValor = new JTextField();
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setFont(new Font("arial", Font.BOLD, 16));
		txtValor.setBounds(110, 150, 160, 30);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		

		JLabel lblResultado = new JLabel();
		lblResultado.setFont(new Font("arial", Font.BOLD, 16));
		lblResultado.setForeground(new Color(0, 0, 0));
		lblResultado.setBounds(300, 150, 230, 30);
		contentPane.add(lblResultado);
		
		// Leer el numero en txtValor y setear lblResultado con el resultado de la operacion al instante.
        txtValor.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                actualizarTexto();
            }
            public void removeUpdate(DocumentEvent e) {
                actualizarTexto();
            }
            public void insertUpdate(DocumentEvent e) {
                actualizarTexto();
            }
            private void actualizarTexto() {
            	try {
                    // Leer el número del primer campo de texto
                    num = Double.parseDouble(txtValor.getText());
					// Realizar el cálculo y mostrar el resultado en el segundo campo de texto
                    conversion = controlador.conversorVelocidades(num, velocidad1, velocidad2);
                    
                    lblResultado.setText("Equivale a: "+(double) Math.round(conversion*100d)/100 +" " +unidades  );
                    System.out.println(velocidad1+" - "+velocidad2);
                } catch (NumberFormatException ex) {
                // Si no hay un numero para calcular la conversion setear en Null el lblResultado 
                	lblResultado.setText(null);
               }
            }
        });
		
		
     // Agregar el DocumentFilter al modelo de documento del campo de texto
        ((AbstractDocument) txtValor.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final String regex = "\\d+\\.?\\d*";
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + string;
                if (newStr.matches(regex)) {
                    super.insertString(fb, offset, string, attr);
                } else {
                    // Si se intenta insertar texto no numérico, se reproduce un sonido de alerta.
                    Toolkit.getDefaultToolkit().beep();
                }
            }
            
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newStr = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;
                if (newStr.matches(regex)) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    // Si se intenta insertar texto no numérico, se reproduce un sonido de alerta.
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
		
     // Creamos comboBox para mostrar las opciones de monedas de conversion
     		comboVelocidad1 = new JComboBox<>();
     		comboVelocidad1.addItemListener(new ItemListener() {
     			public void itemStateChanged(ItemEvent e) {
     				txtValor.setText("");
     			}
     		});
     		comboVelocidad1.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				velocidad1= comboVelocidad1.getItemAt(comboVelocidad1.getSelectedIndex()).getValorEnMetroPorSeg();
     			}
     		});

     		comboVelocidad1.setBounds(140, 95, 170, 30);
     		contentPane.add(comboVelocidad1);
     		
     		comboVelocidad2 = new JComboBox<>();
     		comboVelocidad2.addItemListener(new ItemListener() {
     			public void itemStateChanged(ItemEvent e) {
     				txtValor.setText("");
     			}
     		});
     		comboVelocidad2.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				velocidad2= comboVelocidad2.getItemAt(comboVelocidad2.getSelectedIndex()).getValorEnMetroPorSeg();
     				unidades= comboVelocidad2.getItemAt(comboVelocidad2.getSelectedIndex()).getUnidades();
     			}
     		});
     		
     		comboVelocidad2.setBounds(390, 95, 170, 30);
     		contentPane.add(comboVelocidad2);
     		
     		// Mostramos las opciones de monedas desde el controlador
     		List<Velocidad> velocidades = controlador.getVelocidades();
     		// Agregar los elementos al JComboBox
     		for (Velocidad velocidad : velocidades) {
     			comboVelocidad1.addItem(velocidad);
     			comboVelocidad2.addItem(velocidad);
     		}

        JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu viewOpcion = new menu();
				viewOpcion.setVisible(true);
				ventanadevelocidad.this.dispose();
			}
		});
		btnRegresar.setToolTipText("volver");
		btnRegresar.setIcon(new ImageIcon("img/cerrar-sesion.png"));
		btnRegresar.setBounds(410, 250, 160, 50);
		contentPane.add(btnRegresar);
		
				// Colocamos una imagen de fondo
				JLabel lblFondo = new JLabel();
				lblFondo.setIcon(new ImageIcon("img/ptada.jpg"));
				lblFondo.setBounds(0, 0, 700, 400);
				contentPane.add(lblFondo);
	}
	
}

