package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.Random;

public class MatchSelectionGUI{

	JFrame frmMatchSelect;
	private ArrayList<Athlete> opposingTeam;



	public MatchSelectionGUI(Team team, GameEnviroment game, Market market, Player player, JFrame frmClub, ClubGUI clubgui) {
	    initialize(team, game, market, player, frmClub, this, clubgui);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, Market market, Player player, JFrame frmClub, MatchSelectionGUI matchSelectionGUI, ClubGUI clubgui) {
		frmMatchSelect = new JFrame();
		frmMatchSelect.setTitle("Match Selection");
		frmMatchSelect.setBounds(100, 100, 700, 500);
		frmMatchSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatchSelect.getContentPane().setLayout(null);
		Random random = new Random();
		
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
				int guess = random.nextInt(100);
				if (guess > 5) {
					int playerLeavingIndex = random.nextInt(team.getReserveName().size());
					Athlete playerToQuit = team.getReserveName().get(playerLeavingIndex);
					team.removeReservePlayer(playerLeavingIndex);
					JOptionPane.showMessageDialog(frmMatchSelect, playerToQuit.getName(playerToQuit) + " has retierd from your team.");
					
				} else if (guess > 99 && guess < 99) {
					int playerLeavingIndex = random.nextInt(team.getStartingName().size());
					Athlete playerToImprove = team.getReserveName().get(playerLeavingIndex);
					if (playerToImprove.getPosition(playerToImprove) == 1) {
						playerToImprove.setOffence(playerToImprove.getOffence() + 10);
						JOptionPane.showMessageDialog(frmMatchSelect, playerToImprove.getName(playerToImprove) + "'s offence has been increased by 10.");
					} else {
						playerToImprove.setDefence(playerToImprove.getDefence() + 10);
						JOptionPane.showMessageDialog(frmMatchSelect, playerToImprove.getName(playerToImprove) + "'s defence has been increased by 10.");
					}
					
				}
				if (game.getCurrentWeekNum() < game.getChoosenNumWeeks()) {
					game.setCurrentWeekNum(game.getCurrentWeekNum() + 1);
					frmClub.dispose();
					game.LaunchClubGUI(team, game, market, player);
					market.rotateWavier();
					market.rotateMarketItems();
					frmMatchSelect.dispose();
					
					// random event generation
				}
				else {
					game.closeClubGUI(clubgui);
					game.LaunchGameEnd(game, player);
					matchSelectionGUI.frmMatchSelect.dispose();
				}
				
				
				
			}
		});
		btnNextWeek.setBounds(564, 427, 110, 23);
		frmMatchSelect.getContentPane().add(btnNextWeek);
		
	}

}
