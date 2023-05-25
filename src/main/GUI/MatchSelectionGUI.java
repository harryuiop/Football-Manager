package main.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import main.LOGIC.Athlete;
import main.LOGIC.GameEnviroment;
import main.LOGIC.Market;
import main.LOGIC.Player;
import main.LOGIC.PotentialPlayers;
import main.LOGIC.Team;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.awt.Color;

public class MatchSelectionGUI{
	public JFrame frmMatchSelect;
	private ArrayList<Athlete> opposingTeam;



	public MatchSelectionGUI(Team team, GameEnviroment game, Market market, Player player, JFrame frmClub, ClubGUI clubgui) {
	    initialize(team, game, market, player, frmClub, this, clubgui);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, Market market, Player player, JFrame frmClub, MatchSelectionGUI matchSelectionGUI, ClubGUI clubgui) {
		frmMatchSelect = new JFrame();
		frmMatchSelect.setBackground(Color.PINK);
		frmMatchSelect.getContentPane().setBackground(Color.PINK);
		frmMatchSelect.setTitle("Stadium");
		frmMatchSelect.setBounds(100, 100, 691, 500);
		frmMatchSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatchSelect.getContentPane().setLayout(null);
		Random random = new Random();
		
		JLabel lblMatchSelection = new JLabel("The Stadium");
		lblMatchSelection.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMatchSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatchSelection.setBounds(10, 11, 655, 71);
		frmMatchSelect.getContentPane().add(lblMatchSelection);
		JLabel lblSelectIndicator = new JLabel("");
		lblSelectIndicator.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectIndicator.setBounds(35, 338, 605, 42);
		frmMatchSelect.getContentPane().add(lblSelectIndicator);
		
		
		PotentialPlayers oppositionGenerator = new PotentialPlayers();
		
		JButton btnBye = new JButton("Take a Bye");
		
		JButton btnTeam1 = new JButton("Easy");
		btnTeam1.setBackground(new Color(255, 228, 225));
		JButton btnTeam2 = new JButton("Medium");
		btnTeam2.setBackground(new Color(255, 228, 225));
		JButton btnTeam3 = new JButton("Hard");
		btnTeam3.setBackground(new Color(255, 228, 225));
		
		JButton btnBackClub = new JButton("Back to Club");
		
		JButton btnNextWeek = new JButton("Next Week");

		btnTeam1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isTeamHealthy = team.startingTeamHealthy(team);
				
				if(isTeamHealthy) {
					btnNextWeek.setEnabled(true);
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
				boolean isTeamHealthy = team.startingTeamHealthy(team);
				
				if(isTeamHealthy) {
					btnNextWeek.setEnabled(true);
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
		btnTeam2.setBounds(247, 156, 154, 130);
		frmMatchSelect.getContentPane().add(btnTeam2);
		

		btnTeam3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean isTeamHealthy = team.startingTeamHealthy(team);
				
				if(isTeamHealthy) {
					btnNextWeek.setEnabled(true);
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
		btnTeam3.setBounds(475, 156, 154, 130);
		frmMatchSelect.getContentPane().add(btnTeam3);
		
		
		btnBye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				team.regenStam(team.getReserveName());
				team.regenStam(team.getStartingName());
				btnTeam1.setEnabled(false);
				btnTeam2.setEnabled(false);
				btnTeam3.setEnabled(false);
				btnBackClub.setEnabled(false);
				btnNextWeek.setEnabled(true);
				lblSelectIndicator.setText("Bye Taken and Athlete Stamina Replenished! Proceed to the Next Week");
				
				trainGUI traingui = new trainGUI(team, game, market, player, frmClub, matchSelectionGUI);
				traingui.frmTrainPlayer.setVisible(true);
				matchSelectionGUI.frmMatchSelect.dispose();
			}
		});
		btnBye.setBounds(449, 427, 109, 23);
		frmMatchSelect.getContentPane().add(btnBye);
		
		JLabel lblNewLabel = new JLabel("Select your opponent:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 80, 655, 22);
		frmMatchSelect.getContentPane().add(lblNewLabel);
		

		btnBackClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.LaunchClubGUI(team, game, market, player);
				matchSelectionGUI.frmMatchSelect.setVisible(false);; // maybe dont use dispose ????
			}
		});
		btnBackClub.setBounds(10, 427, 109, 23);
		frmMatchSelect.getContentPane().add(btnBackClub);
		

		btnNextWeek.setEnabled(false);
		btnNextWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int guess = random.nextInt(100);
				if (guess > 95) {
					int playerLeavingIndex = random.nextInt(team.getReserveName().size());
					Athlete playerToQuit = team.getReserveName().get(playerLeavingIndex);
					team.removeReservePlayer(playerLeavingIndex);
					JOptionPane.showMessageDialog(frmMatchSelect, playerToQuit.getName(playerToQuit) + " has retired from your team.");
					
				} else if (guess > 80 && guess < 90) {
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
					//team.regenStam(team.getReserveName());
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
					game.LaunchGameEnd(game, player, team);
					matchSelectionGUI.frmMatchSelect.dispose();
				}
				
				
				
			}
		});
		btnNextWeek.setBounds(564, 427, 110, 23);
		frmMatchSelect.getContentPane().add(btnNextWeek);
		
		
		
	}

}
