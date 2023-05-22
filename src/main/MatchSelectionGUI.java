package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MatchSelectionGUI {

	JFrame frmMatchSelect;
	private ArrayList<Athlete> opposingTeam;

	/**
	 * Create the application.
	 */
	public MatchSelectionGUI(Team team, GameEnviroment game, Player player, JFrame frmClub) {
		initialize(team, game, player, frmClub, this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, Player player, JFrame frmClub, MatchSelectionGUI matchSelectionGUI) {
		frmMatchSelect = new JFrame();
		frmMatchSelect.setTitle("Match Selection");
		frmMatchSelect.setBounds(100, 100, 700, 500);
		frmMatchSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatchSelect.getContentPane().setLayout(null);
		
		JLabel lblMatchSelection = new JLabel("Match Selection");
		lblMatchSelection.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMatchSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatchSelection.setBounds(215, 24, 252, 71);
		frmMatchSelect.getContentPane().add(lblMatchSelection);
		
		JLabel lblByeIndicator = new JLabel("");
		lblByeIndicator.setHorizontalAlignment(SwingConstants.CENTER);
		lblByeIndicator.setBounds(143, 338, 401, 42);
		frmMatchSelect.getContentPane().add(lblByeIndicator);
		
		
		PotentialPlayers oppositionGenerator = new PotentialPlayers();
		
		JButton btnBye = new JButton("Take a Bye");
		JButton btnTeam1 = new JButton("teamOne");
		JButton btnTeam2 = new JButton("teamTwo");
		JButton btnTeam3 = new JButton("teamThree");
		

		

		btnTeam1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opposingTeam = oppositionGenerator.createOpposingTeam(game, 1);
				game.LaunchMatchGUI(team, game, player, opposingTeam, frmMatchSelect);
				btnTeam1.setEnabled(false);
				frmMatchSelect.setVisible(false);
				btnBye.setEnabled(false);
			}
		});
		btnTeam1.setBounds(35, 156, 154, 130);
		frmMatchSelect.getContentPane().add(btnTeam1);
		
		
		btnTeam2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opposingTeam = oppositionGenerator.createOpposingTeam(game, 2);
				game.LaunchMatchGUI(team, game, player, opposingTeam, frmMatchSelect);
				btnTeam2.setEnabled(false);
				frmMatchSelect.setVisible(false);
				btnBye.setEnabled(false);
			}
		});
		btnTeam2.setBounds(263, 156, 154, 130);
		frmMatchSelect.getContentPane().add(btnTeam2);
		

		btnTeam3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opposingTeam = oppositionGenerator.createOpposingTeam(game, 3);
				game.LaunchMatchGUI(team, game, player, opposingTeam, frmMatchSelect);
				btnTeam3.setEnabled(false);
				frmMatchSelect.setVisible(false);
				btnBye.setEnabled(false);
			}
		});
		btnTeam3.setBounds(486, 156, 154, 130);
		frmMatchSelect.getContentPane().add(btnTeam3);
		
		
		btnBye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Athlete Ath: team.getStartingName()) {
					Ath.setStamina(100);
				}
				for (Athlete Ath: team.getReserveName()) {
					Ath.setStamina(100);
				}
				btnTeam1.setEnabled(false);
				btnTeam2.setEnabled(false);
				btnTeam3.setEnabled(false);
				lblByeIndicator.setText("Athlete Stamina Replenished! Proceed to the Next Week");;
			}
		});
		btnBye.setBounds(486, 427, 89, 23);
		frmMatchSelect.getContentPane().add(btnBye);
		
		JLabel lblNewLabel = new JLabel("Select your opponent:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(214, 105, 242, 22);
		frmMatchSelect.getContentPane().add(lblNewLabel);
		
		JLabel lblGame1 = new JLabel("Match Result");
		lblGame1.setBounds(81, 297, 74, 14);
		frmMatchSelect.getContentPane().add(lblGame1);
		
		JLabel lblGame1_1 = new JLabel("Match Result");
		lblGame1_1.setBounds(307, 297, 74, 14);
		frmMatchSelect.getContentPane().add(lblGame1_1);
		
		JLabel lblGame1_2 = new JLabel("Match Result");
		lblGame1_2.setBounds(532, 297, 74, 14);
		frmMatchSelect.getContentPane().add(lblGame1_2);
		
		JButton btnBackClub = new JButton("Back to Club");
		btnBackClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmClub.setVisible(true);
				frmMatchSelect.setVisible(false);
				
			}
		});
		btnBackClub.setBounds(10, 427, 109, 23);
		frmMatchSelect.getContentPane().add(btnBackClub);
		
		JButton btnNextWeek = new JButton("Next Week");
		btnNextWeek.setBounds(585, 427, 89, 23);
		frmMatchSelect.getContentPane().add(btnNextWeek);
		
		

	}
}
