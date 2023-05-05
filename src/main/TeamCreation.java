package main;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class TeamCreation {

	private JFrame frmTeamCreation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamCreation window = new TeamCreation();
					window.frmTeamCreation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeamCreation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTeamCreation = new JFrame();
		frmTeamCreation.setTitle("Team Creation");
		frmTeamCreation.setBounds(100, 100, 800, 500);
		frmTeamCreation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
