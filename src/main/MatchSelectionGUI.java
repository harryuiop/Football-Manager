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

public class MatchSelectionGUI{

	JFrame frmMatchSelect;
	private ArrayList<Athlete> opposingTeam;



	/**
	 * Create the application.
	 */
	public MatchSelectionGUI(Team team, GameEnviroment game, Market market, Player player, JFrame frmClub) {
		initialize(team, game, market, player, frmClub, this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, Market market, Player player, JFrame frmClub, MatchSelectionGUI matchSelectionGUI) {
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
		
		JLabel lblSelectIndicator = new JLabel("");
		lblSelectIndicator.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectIndicator.setBounds(35, 338, 605, 42);
		frmMatchSelect.getContentPane().add(lblSelectIndicator);
		
		
		PotentialPlayers oppositionGenerator = new PotentialPlayers();
		
		JButton btnBye = new JButton("Take a Bye");
		
		JButton btnTeam1 = new JButton("teamOne");
		JButton btnTeam2 = new JButton("teamTwo");
		JButton btnTeam3 = new JButton("teamThree");
		
		JButton btnBackClub = new JButton("Back to Club");
		


		btnTeam1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isTeamHealthy = team.teamHealthy(team);
				
				if(isTeamHealthy) {
					opposingTeam = oppositionGenerator.createOpposingTeam(game, 1);
					game.LaunchMatchGUI(team, game, player, opposingTeam, matchSelectionGUI);
					btnTeam1.setEnabled(false);
					frmMatchSelect.setVisible(false);
					btnBye.setEnabled(false);
				} else {
					lblSelectIndicator.setText("Athlete on your starting team is injured! Go back to the club to make a Sub");
				}
				
			}
		});
		btnTeam1.setBounds(35, 156, 154, 130);
		frmMatchSelect.getContentPane().add(btnTeam1);
		
		
		btnTeam2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isTeamHealthy = team.teamHealthy(team);
				
				if(isTeamHealthy) {
					opposingTeam = oppositionGenerator.createOpposingTeam(game, 1);
					game.LaunchMatchGUI(team, game, player, opposingTeam, matchSelectionGUI);
					btnTeam2.setEnabled(false);
					frmMatchSelect.setVisible(false);
					btnBye.setEnabled(false);
				} else {
					lblSelectIndicator.setText("Athlete on your starting team is injured! Go back to the club to make a Sub");
				}
			}
		});
		btnTeam2.setBounds(263, 156, 154, 130);
		frmMatchSelect.getContentPane().add(btnTeam2);
		

		btnTeam3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isTeamHealthy = team.teamHealthy(team);
				
				if(isTeamHealthy) {
					opposingTeam = oppositionGenerator.createOpposingTeam(game, 1);
					game.LaunchMatchGUI(team, game, player, opposingTeam, matchSelectionGUI);
					btnTeam3.setEnabled(false);
					frmMatchSelect.setVisible(false);
					btnBye.setEnabled(false);
				} else {
					lblSelectIndicator.setText("Athlete on your starting team is injured! Go back to the club to make a Sub");
				}
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
				btnBackClub.setEnabled(false);
				lblSelectIndicator.setText("Bye Taken and Athlete Stamina Replenished! Proceed to the Next Week");;
			}
		});
		btnBye.setBounds(449, 427, 109, 23);
		frmMatchSelect.getContentPane().add(btnBye);
		
		JLabel lblNewLabel = new JLabel("Select your opponent:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(214, 105, 242, 22);
		frmMatchSelect.getContentPane().add(lblNewLabel);
		
		JLabel lblGame1 = new JLabel("Match Result");
		lblGame1.setBounds(81, 297, 74, 14);
		frmMatchSelect.getContentPane().add(lblGame1);
		
		JLabel lblGame2 = new JLabel("Match Result");
		lblGame2.setBounds(307, 297, 74, 14);
		frmMatchSelect.getContentPane().add(lblGame2);
		
		JLabel lblGame3 = new JLabel("Match Result");
		lblGame3.setBounds(532, 297, 74, 14);
		frmMatchSelect.getContentPane().add(lblGame3);
		

		btnBackClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmClub.setVisible(true);
				frmMatchSelect.setVisible(false);
				
			}
		});
		btnBackClub.setBounds(10, 427, 109, 23);
		frmMatchSelect.getContentPane().add(btnBackClub);
		
		JButton btnNextWeek = new JButton("Next Week");
		btnNextWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (game.getCurrentWeekNum() <= game.getChoosenNumWeeks()) {
					game.setCurrentWeekNum(game.getCurrentWeekNum() + 1);
					frmClub.dispose();
					game.LaunchClubGUI(team, game, market, player);
					market.rotateWavier();
					market.rotateMarketItems();
					frmMatchSelect.dispose();
				}
				
			}
		});
		btnNextWeek.setBounds(564, 427, 110, 23);
		frmMatchSelect.getContentPane().add(btnNextWeek);
		
	}

}
