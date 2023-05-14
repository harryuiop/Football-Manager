package main;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClubGUI {

	JFrame frmClub;


	/**
	 * Create the application.
	 */
	public ClubGUI(Team team, GameEnviroment game, Market market, Player player) {
		initialize(team,game,market,player);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, Market market, Player player) {
		frmClub = new JFrame();
		frmClub.setMinimumSize(new Dimension(700,500));
		frmClub.getContentPane().setEnabled(false);
		frmClub.setTitle("Club");
		frmClub.setResizable(true);
		frmClub.setSize(440,648);
		frmClub.setPreferredSize(new Dimension(700,500));
		frmClub.setBounds(100, 100, 450, 300);
		frmClub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClub.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Clubroom");
		lblWelcomeToThe.setBounds(251, 12, 203, 15);
		frmClub.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblStartingLineup = new JLabel("Starting Lineup");
		lblStartingLineup.setBounds(289, 34, 134, 15);
		frmClub.getContentPane().add(lblStartingLineup);
	}
}
