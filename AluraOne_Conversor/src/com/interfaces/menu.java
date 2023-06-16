package com.interfaces;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.sisi.monedas;
import com.sisi.velo;

public class menu extends JFrame {
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public menu() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500); // Cambia el tamaño de la ventana aquí
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JButton btnMoneda = new JButton("");
		btnMoneda.setToolTipText("Conversor de Monedas");
		btnMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				monedas controlador = new monedas();
				ventanamoneda frame = new ventanamoneda(controlador);
				frame.setVisible(true);
				menu.this.dispose();
			}
		});
		btnMoneda.setIcon(new ImageIcon(new ImageIcon("img/pila-de-monedas.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
		btnMoneda.setBounds(180, 200, 150, 150);
		btnMoneda.setHorizontalAlignment(SwingConstants.CENTER);
		btnMoneda.setVerticalAlignment(SwingConstants.CENTER);
		contentPane.add(btnMoneda);


		JLabel lblTitulo = new JLabel("APP DE CONVERSIONES- Alioth ONE");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("arial", Font.BOLD, 24));
		lblTitulo.setBounds(250, 100, 400, 40); // Ajusta la posición de los componentes según el nuevo tamaño
		contentPane.add(lblTitulo);

		JButton btnVelocidad = new JButton("");
		btnVelocidad.setToolTipText("Conversor de Velocidades");
		btnVelocidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				velo controlador = new velo();
				ventanadevelocidad frame = new ventanadevelocidad(controlador);
				frame.setVisible(true);
				menu.this.dispose();
			}
		});
		btnVelocidad.setIcon(new ImageIcon(new ImageIcon("img/velocimetro.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT)));
		btnVelocidad.setBounds(470, 200, 150, 150);
		btnVelocidad.setHorizontalAlignment(SwingConstants.CENTER);
		btnVelocidad.setVerticalAlignment(SwingConstants.CENTER);
		contentPane.add(btnVelocidad);

		JLabel lblFondo = new JLabel("");
		ImageIcon fondoIcon = new ImageIcon("img/ptada.jpg");
		Image fondoImage = fondoIcon.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
		lblFondo.setIcon(new ImageIcon(fondoImage));
		lblFondo.setBounds(0, 0, 800, 500);
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setVerticalAlignment(SwingConstants.CENTER);
		contentPane.add(lblFondo);

	}
}
