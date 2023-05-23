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
	public GameEndGUI(GameEnviroment game, Player player, Team team) {
		initialize(game, player, this, team);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(GameEnviroment game, Player player, GameEndGUI gameEnd, Team team) {
		frmGameEnd = new JFrame();
		frmGameEnd.setTitle("Game End");
		frmGameEnd.setBounds(100, 100, 700, 500);
		frmGameEnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGameEnd.getContentPane().setLayout(null);
		
		JLabel lblGameOver = new JLabel("Game Over");
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblGameOver.setBounds(195, 0, 303, 83);
		frmGameEnd.getContentPane().add(lblGameOver);
		
		JLabel lblGameOverStats = new JLabel("");
		lblGameOverStats.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOverStats.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGameOverStats.setBounds(60, 133, 564, 83);
		frmGameEnd.getContentPane().add(lblGameOverStats);
		
		lblGameOverStats.setText("You finished the game with $" + player.getMoneyBalance() + " and " + game.getWinAmount() + " wins.");
		
		JLabel name = new JLabel("name");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(205, 81, 267, 16);
		frmGameEnd.getContentPane().add(name);
		name.setText("Team: " +team.getName());
		
		JLabel duration = new JLabel("druation");
		duration.setHorizontalAlignment(SwingConstants.CENTER);
		duration.setBounds(195, 109, 277, 16);
		frmGameEnd.getContentPane().add(duration);
		duration.setText("Weeks Played: " + game.getChoosenNumWeeks()+"");
	}
}
