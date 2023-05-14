package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class StartScreen {

	private JFrame frmStartScreen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartScreen window = new StartScreen();
					window.frmStartScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StartScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStartScreen = new JFrame();
		frmStartScreen.setTitle("Start Screen");
		frmStartScreen.setBounds(100, 100, 800, 500);
		frmStartScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStartScreen.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fantasy Football Manager");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 28));
		lblNewLabel.setBounds(178, 81, 422, 117);
		frmStartScreen.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start Game");
		btnNewButton.setBounds(318, 231, 117, 25);
		frmStartScreen.getContentPane().add(btnNewButton);
	}
}
