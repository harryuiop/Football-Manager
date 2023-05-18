package main;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class MatchSelectionGUI {

	private JFrame frmMatchSelect;


	/**
	 * Create the application.
	 */
	public MatchSelectionGUI(Team team, GameEnviroment game, Player player) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMatchSelect = new JFrame();
		frmMatchSelect.setTitle("Match Selection");
		frmMatchSelect.setBounds(100, 100, 450, 300);
		frmMatchSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
