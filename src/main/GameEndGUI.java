package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;


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
		frmGameEnd.setBounds(100, 100, 700, 500);
		frmGameEnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGameEnd.getContentPane().setLayout(null);
		
		JLabel lblGameOver = new JLabel("Game Over");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblGameOver.setBounds(187, 11, 303, 83);
		frmGameEnd.getContentPane().add(lblGameOver);
		
		JLabel lblGameOverStats = new JLabel("");
		lblGameOverStats.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOverStats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGameOverStats.setBounds(60, 133, 564, 83);
		frmGameEnd.getContentPane().add(lblGameOverStats);
		
		lblGameOverStats.setText("You finished the game with $" + player.getMoneyBalance() + " and " + game.getWinAmount() + " wins.");
	}
}
