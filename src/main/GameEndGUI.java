package main;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GameEndGUI {

	JFrame frmGameEnd;


	/**
	 * Create the application.
	 */
	public GameEndGUI(GameEnviroment game, Player player) {
		initialize(game, player, this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnviroment game, Player player, GameEndGUI gameEnd) {
		frmGameEnd = new JFrame();
		frmGameEnd.setTitle("Game End");
		frmGameEnd.setBounds(100, 100, 450, 300);
		frmGameEnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
