package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MatchGUI{

	JFrame frmMatch;
	private int buttonPressCount;


	/**
	 * Create the application.
	 */
	public MatchGUI(Team team, GameEnviroment game, Player player, ArrayList<Athlete> opposingTeam, MatchSelectionGUI matchSelectionGUI) {
		this.buttonPressCount = 0;
		initialize(team, game, player, opposingTeam, matchSelectionGUI, this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, Player player, ArrayList<Athlete> opposingTeam, MatchSelectionGUI matchSelectionGUI, MatchGUI matchGUI) {
		Match match = new Match();
		
		
		frmMatch = new JFrame();
		frmMatch.setTitle("Match");
		frmMatch.setBounds(100, 100, 900, 600);
		frmMatch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatch.getContentPane().setLayout(null);
		
		JLabel lblScore = new JLabel("0-0");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(391, 11, 108, 89);
		frmMatch.getContentPane().add(lblScore);
		
		JLabel lblAthlete1 = new JLabel("athlete1");
		lblAthlete1.setText(team.getStartingName().get(0).getName(team.getStartingName().get(0)));
		lblAthlete1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAthlete1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthlete1.setBounds(116, 111, 167, 47);
		frmMatch.getContentPane().add(lblAthlete1);
		
		JLabel lblAthlete2 = new JLabel("athlete2");
		lblAthlete2.setText(team.getStartingName().get(1).getName(team.getStartingName().get(1)));
		lblAthlete2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthlete2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAthlete2.setBounds(116, 184, 167, 47);
		frmMatch.getContentPane().add(lblAthlete2);
		
		JLabel lblAthlete3 = new JLabel("athlete3");
		lblAthlete3.setText(team.getStartingName().get(2).getName(team.getStartingName().get(2)));
		lblAthlete3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthlete3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAthlete3.setBounds(116, 256, 167, 47);
		frmMatch.getContentPane().add(lblAthlete3);
		
		JLabel lblAthlete4 = new JLabel("athlete4");
		lblAthlete4.setText(team.getStartingName().get(3).getName(team.getStartingName().get(3)));
		lblAthlete4.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthlete4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAthlete4.setBounds(116, 329, 167, 47);
		frmMatch.getContentPane().add(lblAthlete4);
		
		JLabel lblOpp1 = new JLabel("Opp1");
		lblOpp1.setText(opposingTeam.get(0).getName(opposingTeam.get(0)));
		lblOpp1.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpp1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOpp1.setBounds(587, 111, 182, 47);
		frmMatch.getContentPane().add(lblOpp1);
		
		JLabel lblOpp2 = new JLabel("Opp2");
		lblOpp2.setText(opposingTeam.get(1).getName(opposingTeam.get(1)));
		lblOpp2.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpp2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOpp2.setBounds(587, 184, 182, 47);
		frmMatch.getContentPane().add(lblOpp2);
		
		JLabel lblOpp3 = new JLabel("Opp3");
		lblOpp3.setText(opposingTeam.get(2).getName(opposingTeam.get(2)));
		lblOpp3.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpp3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOpp3.setBounds(587, 256, 182, 47);
		frmMatch.getContentPane().add(lblOpp3);
		
		JLabel lblOpp4 = new JLabel("Opp4");
		lblOpp4.setText(opposingTeam.get(3).getName(opposingTeam.get(3)));
		lblOpp4.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpp4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOpp4.setBounds(587, 329, 182, 47);
		frmMatch.getContentPane().add(lblOpp4);
		
		
		JLabel lblLineup1 = new JLabel("Lineup Result");
		lblLineup1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLineup1.setBounds(347, 111, 195, 31);
		frmMatch.getContentPane().add(lblLineup1);
		
		JLabel lblLineup2 = new JLabel("Lineup Result");
		lblLineup2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLineup2.setBounds(347, 184, 195, 31);
		frmMatch.getContentPane().add(lblLineup2);
		
		JLabel lblLineup3 = new JLabel("Lineup Result");
		lblLineup3.setHorizontalAlignment(SwingConstants.CENTER);
		lblLineup3.setBounds(347, 256, 195, 31);
		frmMatch.getContentPane().add(lblLineup3);
		
		JLabel lblLineup4 = new JLabel("Lineup Result");
		lblLineup4.setHorizontalAlignment(SwingConstants.CENTER);
		lblLineup4.setBounds(347, 339, 195, 31);
		frmMatch.getContentPane().add(lblLineup4);
		
		JLabel lblWinResult = new JLabel("");
		lblWinResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinResult.setBounds(347, 405, 195, 31);
		frmMatch.getContentPane().add(lblWinResult);
		
		
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				player.setMoneyBalance(player.getMoneyBalance()+1000);
				team.weekPlayed(team);
				frmMatch.dispose();
				matchSelectionGUI.frmMatchSelect.setVisible(true);
			}
		});
		btnContinue.setBounds(785, 527, 89, 23);
		frmMatch.getContentPane().add(btnContinue);
		
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPressCount += 1;
				switch(buttonPressCount) {
					case 1:
						String matchUpResult = match.matchUp(game, player, team, team.getStartingName().get(buttonPressCount - 1), opposingTeam.get(buttonPressCount - 1), "player");
						switch(matchUpResult) {
						case "Won":
							lblLineup1.setText(team.getStartingName().get(buttonPressCount - 1) + " won their match up");
							lblLineup1.setForeground(Color.green);
							break;
						case "Lost":
							lblLineup1.setText(team.getStartingName().get(buttonPressCount - 1) + " lost their match up");
							lblLineup1.setForeground(Color.red);
							break;
						case "Draw":
							lblLineup1.setText(team.getStartingName().get(buttonPressCount - 1) + " drew their match up");
							lblLineup1.setForeground(Color.gray);	
							break;
						}
						lblScore.setText(match.getPlayersScore() + "-" + match.getOpposingScore());
						break;
					case 2:
						matchUpResult = match.matchUp(game, player, team, team.getStartingName().get(buttonPressCount - 1), opposingTeam.get(buttonPressCount - 1), "player");
						switch(matchUpResult) {
						case "Won":
							lblLineup2.setText(team.getStartingName().get(buttonPressCount - 1) + " won their match up");
							lblLineup2.setForeground(Color.green);
							break;
						case "Lost":
							lblLineup2.setText(team.getStartingName().get(buttonPressCount - 1) + " lost their match up");
							lblLineup2.setForeground(Color.red);
							break;
						case "Draw":
							lblLineup2.setText(team.getStartingName().get(buttonPressCount - 1) + " drew their match up");
							lblLineup2.setForeground(Color.gray);
							break;
						}
						lblScore.setText(match.getPlayersScore() + "-" + match.getOpposingScore());
						break;
						
					case 3:
						matchUpResult = match.matchUp(game, player, team, team.getStartingName().get(buttonPressCount - 1), opposingTeam.get(buttonPressCount - 1), "opp");
						switch(matchUpResult) {
						case "Won":
							lblLineup3.setText(team.getStartingName().get(buttonPressCount - 1) + " won their match up");
							lblLineup3.setForeground(Color.green);
							break;
						case "Lost":
							lblLineup3.setText(team.getStartingName().get(buttonPressCount - 1) + " lost their match up");
							lblLineup3.setForeground(Color.red);
							break;
						case "Draw":
							lblLineup3.setText(team.getStartingName().get(buttonPressCount - 1) + " drew their match up");
							lblLineup3.setForeground(Color.gray);
							break;
						}
						lblScore.setText(match.getPlayersScore() + "-" + match.getOpposingScore());
						break;
						
					case 4:
						matchUpResult = match.matchUp(game, player, team, team.getStartingName().get(buttonPressCount - 1), opposingTeam.get(buttonPressCount - 1), "opp");
						switch(matchUpResult) {
						case "Won":
							lblLineup4.setText(team.getStartingName().get(buttonPressCount - 1) + " won their match up");
							lblLineup4.setForeground(Color.green);
							btnPlay.setEnabled(false);
							break;
						case "Lost":
							lblLineup4.setText(team.getStartingName().get(buttonPressCount - 1) + " lost their match up");
							lblLineup4.setForeground(Color.red);
							btnPlay.setEnabled(false);
							break;
						case "Draw":
							lblLineup4.setText(team.getStartingName().get(buttonPressCount - 1) + " drew their match up");
							lblLineup4.setForeground(Color.gray);
							btnPlay.setEnabled(false);
							break;
						}
						
						lblScore.setText(match.getPlayersScore() + "-" + match.getOpposingScore());
						lblWinResult.setText(match.winnerString());
						break;
				}

				
				lblScore.setText(match.getPlayersScore() + "-" + match.getOpposingScore());
				btnContinue.setEnabled(true);
				
			}
		});
		btnPlay.setBounds(399, 461, 89, 23);
		frmMatch.getContentPane().add(btnPlay);
		
		

		

		

	}

}
