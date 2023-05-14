package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JSlider;
import javax.swing.JButton;

public class Setup {

	private JFrame frmSetup;
	private JTextField textField;
	private JLabel lblPleaseEnterYou;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Setup window = new Setup();
					window.frmSetup.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Setup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSetup = new JFrame();
		frmSetup.setSize(590, 400);
		frmSetup.setBackground(new Color(255, 255, 255));
		frmSetup.getContentPane().setForeground(new Color(255, 255, 255));
		frmSetup.setTitle("Setup");
		frmSetup.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(189, 111, 204, 35);
		frmSetup.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblPleaseEnterYou = new JLabel("Please Enter you team name");
		lblPleaseEnterYou.setBounds(189, 75, 209, 24);
		frmSetup.getContentPane().add(lblPleaseEnterYou);
		
		JSlider slider = new JSlider();
		slider.setMajorTickSpacing(1);
		slider.setMinimum(5);
		slider.setMaximum(15);
		slider.setBounds(189, 240, 204, 16);
		frmSetup.getContentPane().add(slider);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(247, 148, 94, 16);
		frmSetup.getContentPane().add(btnConfirm);
	}
}
