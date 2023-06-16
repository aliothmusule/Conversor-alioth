package com.interfaces;

import java.awt.*;
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

import com.modelo.Moneda;
import com.sisi.monedas;

public class ventanamoneda extends JFrame {

	private JPanel contentPane;
	private JComboBox<Moneda> comboMoneda1; 
	private JComboBox<Moneda> comboMoneda2;
	private JTextField textovalor;
	private JLabel lblResultado;
	double num;
	double moneda1;
	double moneda2;
	Double conversion;
	char signo2;
	
	// Create the frame.
	public ventanamoneda(monedas controlador) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 620, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				
		JLabel programaconversion = new JLabel("Moneda:");
		programaconversion.setBackground(new Color(0xF40AFF));
		programaconversion.setHorizontalAlignment(SwingConstants.CENTER);
		programaconversion.setForeground(new Color(0, 0, 0));
		programaconversion.setFont(new Font("arial", Font.BOLD, 12));
		programaconversion.setBounds(20, 96, 110, 30);
		contentPane.add(programaconversion);
		
		JLabel texto = new JLabel("->");
		texto.setBackground(new Color(240, 240, 240));
		texto.setForeground(new Color(0, 0, 0));
		texto.setHorizontalAlignment(SwingConstants.CENTER);
		texto.setFont(new Font("arial", Font.BOLD, 12));
		texto.setBounds(325, 96, 60, 30);
		contentPane.add(texto);
		
		JLabel lblTitulo = new JLabel("CONVERSOR DE MONEDAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
		lblTitulo.setBounds(97, 25, 342, 36);
		contentPane.add(lblTitulo);
		
		textovalor = new JTextField();
		textovalor.setHorizontalAlignment(SwingConstants.CENTER);
		textovalor.setFont(new Font("Arial", Font.BOLD, 12));
		textovalor.setBounds(110, 150, 160, 30);
		contentPane.add(textovalor);
		textovalor.setColumns(8);
		

		JLabel labelresultado = new JLabel();
		labelresultado.setFont(new Font("Arial", Font.BOLD, 16));
		labelresultado.setForeground(new Color(0, 0, 0));
		labelresultado.setBounds(300, 150, 230, 30);
		contentPane.add(labelresultado);
		
        textovalor.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                regres();
            }
            public void removeUpdate(DocumentEvent e) {
                regres();
            }
            public void insertUpdate(DocumentEvent e) {
                regres();
            }
            private void regres() {
            	try {

                    num = Double.parseDouble(textovalor.getText());
                    conversion = controlador.conversorMonedas(num, moneda1, moneda2);
                    
                    labelresultado.setText("Igual: "+ signo2 +" "+(double) Math.round(conversion*100d)/100 );
                    System.out.println(moneda1+" - "+moneda2);
                } catch (NumberFormatException ex) {
                	labelresultado.setText(null);
               }
            }
        });
		
		
     // Agregar el DocumentFilter al modelo de documento del campo de texto
        ((AbstractDocument) textovalor.getDocument()).setDocumentFilter(new DocumentFilter() {
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
     		comboMoneda1 = new JComboBox<>();
     		comboMoneda1.addItemListener(new ItemListener() {
     			public void itemStateChanged(ItemEvent e) {
     				textovalor.setText("");
     			}
     		});
     		comboMoneda1.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				moneda1= comboMoneda1.getItemAt(comboMoneda1.getSelectedIndex()).getValorEnDolar();
     			}
     		});

     		comboMoneda1.setBounds(140, 95, 170, 30);
     		contentPane.add(comboMoneda1);
     		
     		comboMoneda2 = new JComboBox<>();
     		comboMoneda2.addItemListener(new ItemListener() {
     			public void itemStateChanged(ItemEvent e) {
     				textovalor.setText("");
     			}
     		});
     		comboMoneda2.addActionListener(new ActionListener() {
     			public void actionPerformed(ActionEvent e) {
     				moneda2= comboMoneda2.getItemAt(comboMoneda2.getSelectedIndex()).getValorEnDolar();
     				signo2= comboMoneda2.getItemAt(comboMoneda2.getSelectedIndex()).getSigno();
     			}
     		});
     		
     		comboMoneda2.setBounds(390, 95, 170, 30);
     		contentPane.add(comboMoneda2);
     		
     		// Mostramos las opciones de monedas desde el controlador
     		List<Moneda> monedas = controlador.getMonedas();
     		// Agregar los elementos al JComboBox
     		for (Moneda moneda : monedas) {
     			comboMoneda1.addItem(moneda);
     			comboMoneda2.addItem(moneda);
     		}

        JButton btnRegresar = new JButton("REGRESAR");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu viewOpcion = new menu();
				viewOpcion.setVisible(true);
				ventanamoneda.this.dispose();
			}
		});
		btnRegresar.setToolTipText("volver");
		btnRegresar.setIcon(new ImageIcon(new ImageIcon("img/cerrar-sesion.png").getImage().getScaledInstance(160, 50, Image.SCALE_DEFAULT)));
		btnRegresar.setBounds(410, 250, 160, 50);
		btnRegresar.setHorizontalAlignment(SwingConstants.CENTER);
		btnRegresar.setVerticalAlignment(SwingConstants.CENTER);
		contentPane.add(btnRegresar);


		// Colocamos una imagen de fondo
				JLabel lblFondo = new JLabel();
				lblFondo.setIcon(new ImageIcon("img/ptada.jpg"));
				lblFondo.setBounds(0, 0, 700, 400);
				contentPane.add(lblFondo);
	}
	
}

