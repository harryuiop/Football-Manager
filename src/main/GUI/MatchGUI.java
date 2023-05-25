package main.GUI;
import main.LOGIC.Athlete;
import main.LOGIC.GameEnviroment;

import main.LOGIC.Player;
import main.LOGIC.Team;
import main.LOGIC.Match;

import java.awt.Color;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Mostly label/button setters. Outsourced the main game logic and game values that need to be set to the logic classes
 * General idea of gameplay is that an athlete does not know who they are going to match up against so attack and defending positions are neglected as players need both stats. Is reflected in a flip of the team at half time
 * First-half play: Press play 4 times, teams' athlete loses stamina on a match up loss
 * Half-time: Sub team or forfeit
 * Second-half: Same as first
 * Full-time: Match results in the player losing, drawing or winning. Money awarded for winning and added to player total
 */

public class MatchGUI{

	public JFrame frmMatch;
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
		frmMatch.setBounds(100, 100, 900, 708);
		frmMatch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatch.getContentPane().setLayout(null);
		
		JLabel lblScore = new JLabel("0-0");
		lblScore.setForeground(new Color(0, 0, 0));
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(333, 31, 215, 89);
		frmMatch.getContentPane().add(lblScore);
		
		JLabel lblHalf = new JLabel("First Half");
		lblHalf.setHorizontalAlignment(SwingConstants.CENTER);
		lblHalf.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblHalf.setBounds(333, 388, 215, 62);
		frmMatch.getContentPane().add(lblHalf);
		
		JLabel lblAthlete1 = new JLabel("athlete1");
		lblAthlete1.setForeground(new Color(0, 0, 0));
		lblAthlete1.setText(team.getStartingName().get(0).getName(team.getStartingName().get(0)) + " STM: " + team.getStartingName().get(0).getStamina() + "/100");
		lblAthlete1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAthlete1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthlete1.setBounds(116, 111, 167, 47);
		frmMatch.getContentPane().add(lblAthlete1);
		
		JLabel lblAthlete2 = new JLabel("athlete2");
		lblAthlete2.setForeground(new Color(0, 0, 0));
		lblAthlete2.setText(team.getStartingName().get(1).getName(team.getStartingName().get(1)) + " STM: " + team.getStartingName().get(1).getStamina() + "/100");
		lblAthlete2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthlete2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAthlete2.setBounds(116, 184, 167, 47);
		frmMatch.getContentPane().add(lblAthlete2);
		
		JLabel lblAthlete3 = new JLabel("athlete3");
		lblAthlete3.setForeground(new Color(0, 0, 0));
		lblAthlete3.setText(team.getStartingName().get(2).getName(team.getStartingName().get(2)) + " STM: " + team.getStartingName().get(2).getStamina() + "/100");
		lblAthlete3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthlete3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAthlete3.setBounds(116, 256, 167, 47);
		frmMatch.getContentPane().add(lblAthlete3);
		
		JLabel lblAthlete4 = new JLabel("athlete4");
		lblAthlete4.setForeground(new Color(0, 0, 0));
		lblAthlete4.setText(team.getStartingName().get(3).getName(team.getStartingName().get(3)) + " STM: " + team.getStartingName().get(3).getStamina() + "/100");
		lblAthlete4.setHorizontalAlignment(SwingConstants.CENTER);
		lblAthlete4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAthlete4.setBounds(116, 329, 167, 47);
		frmMatch.getContentPane().add(lblAthlete4);
		
		JLabel lblOpp1 = new JLabel("Opp1");
		lblOpp1.setForeground(new Color(0, 0, 0));
		lblOpp1.setText(opposingTeam.get(0).getName(opposingTeam.get(0)));
		lblOpp1.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpp1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOpp1.setBounds(587, 111, 182, 47);
		frmMatch.getContentPane().add(lblOpp1);
		
		JLabel lblOpp2 = new JLabel("Opp2");
		lblOpp2.setForeground(new Color(0, 0, 0));
		lblOpp2.setText(opposingTeam.get(1).getName(opposingTeam.get(1)));
		lblOpp2.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpp2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOpp2.setBounds(587, 184, 182, 47);
		frmMatch.getContentPane().add(lblOpp2);
		
		JLabel lblOpp3 = new JLabel("Opp3");
		lblOpp3.setForeground(new Color(0, 0, 0));
		lblOpp3.setText(opposingTeam.get(2).getName(opposingTeam.get(2)));
		lblOpp3.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpp3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOpp3.setBounds(587, 256, 182, 47);
		frmMatch.getContentPane().add(lblOpp3);
		
		JLabel lblOpp4 = new JLabel("Opp4");
		lblOpp4.setForeground(new Color(0, 0, 0));
		lblOpp4.setText(opposingTeam.get(3).getName(opposingTeam.get(3)));
		lblOpp4.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpp4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOpp4.setBounds(587, 329, 182, 47);
		frmMatch.getContentPane().add(lblOpp4);
		
		
		JLabel lblLineup1 = new JLabel("Lineup Result");
		lblLineup1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLineup1.setForeground(new Color(0, 0, 0));
		lblLineup1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLineup1.setBounds(331, 118, 230, 31);
		frmMatch.getContentPane().add(lblLineup1);
		
		JLabel lblLineup2 = new JLabel("Lineup Result");
		lblLineup2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLineup2.setForeground(new Color(0, 0, 0));
		lblLineup2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLineup2.setBounds(331, 191, 230, 31);
		frmMatch.getContentPane().add(lblLineup2);
		
		JLabel lblLineup3 = new JLabel("Lineup Result");
		lblLineup3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLineup3.setForeground(new Color(0, 0, 0));
		lblLineup3.setHorizontalAlignment(SwingConstants.CENTER);
		lblLineup3.setBounds(331, 263, 230, 31);
		frmMatch.getContentPane().add(lblLineup3);
		
		JLabel lblLineup4 = new JLabel("Lineup Result");
		lblLineup4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLineup4.setForeground(new Color(0, 0, 0));
		lblLineup4.setHorizontalAlignment(SwingConstants.CENTER);
		lblLineup4.setBounds(331, 346, 230, 31);
		frmMatch.getContentPane().add(lblLineup4);
		
		JLabel lblWinResult = new JLabel("");
		lblWinResult.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblWinResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinResult.setBounds(10, 528, 864, 31);
		frmMatch.getContentPane().add(lblWinResult);
		
		JButton btnHalfTime = new JButton("Inspect Team");
		btnHalfTime.setEnabled(false);
		JButton btnForfeit = new JButton("Forfeit");
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.setEnabled(false);
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gameResult;
				player.setMoneyBalance(player.getMoneyBalance()+100);
				team.gamePlayedStamDecr(team);
				frmMatch.dispose();
				matchSelectionGUI.frmMatchSelect.setVisible(true);
				if (match.getPlayersScore() > match.getOpposingScore()) {
					gameResult = "You Win " + match.getPlayersScore() + "-" + match.getOpposingScore() + "... $100 won. New balance: $" + player.getMoneyBalance();
				}
				else if (match.getPlayersScore() < match.getOpposingScore()){
					gameResult = "You Lose: " + match.getPlayersScore() + "-" + match.getOpposingScore() + "... No money won";
				}
				else {
					gameResult = "Draw: " + match.getPlayersScore() + "-" + match.getOpposingScore() + "... No money won";
				}
				JOptionPane.showMessageDialog(frmMatch,gameResult);
			}
		});
		btnContinue.setBounds(785, 635, 89, 23);
		frmMatch.getContentPane().add(btnContinue);
		
		/**
		 * main game logic: mostly label/button setters. Outsourced the main game logic and game values that need to be set to the logic classes
		 * General idea of gameplay is that an athlete does not know who they are going to match up against so attack and defending positions are neglected as players need both stats
		 * First-half play: Press play 4 times
		 * Half-time: Sub team or forfeit
		 * Full-time: Match results in the player losing, drawing or winning. Money awarded for winning and added to player total
		 */
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPressCount += 1;
				switch(buttonPressCount) {
					case 1:
						String matchUpResult = match.matchUp(game, player, team, team.getStartingName().get((buttonPressCount - 1)), opposingTeam.get((buttonPressCount - 1)), "player");
						switch(matchUpResult) {
						case "Won":
							lblLineup1.setText(team.getStartingName().get((buttonPressCount - 1)) + " scored!");
							lblLineup1.setForeground(Color.green);
							break;
						case "Lost":
							lblLineup1.setText(team.getStartingName().get((buttonPressCount - 1)) + " lost their match up");
							lblLineup1.setForeground(Color.red);
							break;
						case "Draw":
							lblLineup1.setText(team.getStartingName().get((buttonPressCount - 1)) + " drew their match up");
							lblLineup1.setForeground(Color.DARK_GRAY);	
							break;
						}
						lblAthlete1.setText(team.getStartingName().get(0).getName(team.getStartingName().get(0)) + " STM: " + team.getStartingName().get(0).getStamina() + "/100");
						lblAthlete2.setText(team.getStartingName().get(1).getName(team.getStartingName().get(1)) + " STM: " + team.getStartingName().get(1).getStamina() + "/100");
						lblAthlete3.setText(team.getStartingName().get(2).getName(team.getStartingName().get(2)) + " STM: " + team.getStartingName().get(2).getStamina() + "/100");
						lblAthlete4.setText(team.getStartingName().get(3).getName(team.getStartingName().get(3)) + " STM: " + team.getStartingName().get(3).getStamina() + "/100");
						lblScore.setText(match.getPlayersScore() + "-" + match.getOpposingScore());
						break;
					case 2:
						matchUpResult = match.matchUp(game, player, team, team.getStartingName().get((buttonPressCount - 1)), opposingTeam.get((buttonPressCount - 1)), "player");
						switch(matchUpResult) {
						case "Won":
							lblLineup2.setText(team.getStartingName().get((buttonPressCount - 1)) + " scored!");
							lblLineup2.setForeground(Color.green);
							break;
						case "Lost":
							lblLineup2.setText(team.getStartingName().get((buttonPressCount - 1)) + " lost their match up");
							lblLineup2.setForeground(Color.red);
							break;
						case "Draw":
							lblLineup2.setText(team.getStartingName().get((buttonPressCount - 1)) + " drew their match up");
							lblLineup2.setForeground(Color.DARK_GRAY);
							break;
						}
						lblAthlete1.setText(team.getStartingName().get(0).getName(team.getStartingName().get(0)) + " STM: " + team.getStartingName().get(0).getStamina() + "/100");
						lblAthlete2.setText(team.getStartingName().get(1).getName(team.getStartingName().get(1)) + " STM: " + team.getStartingName().get(1).getStamina() + "/100");
						lblAthlete3.setText(team.getStartingName().get(2).getName(team.getStartingName().get(2)) + " STM: " + team.getStartingName().get(2).getStamina() + "/100");
						lblAthlete4.setText(team.getStartingName().get(3).getName(team.getStartingName().get(3)) + " STM: " + team.getStartingName().get(3).getStamina() + "/100");
						lblScore.setText(match.getPlayersScore() + "-" + match.getOpposingScore());
						break;
						
					case 3:
						matchUpResult = match.matchUp(game, player, team, team.getStartingName().get((buttonPressCount - 1)), opposingTeam.get((buttonPressCount - 1)), "opp");
						switch(matchUpResult) {
						case "Won":
							lblLineup3.setText(team.getStartingName().get((buttonPressCount - 1)) + " defended against " + opposingTeam.get((buttonPressCount - 1)));
							lblLineup3.setForeground(Color.green);
							break;
						case "Lost":
							lblLineup3.setText(team.getStartingName().get((buttonPressCount - 1)) + " lost their match up");
							lblLineup3.setForeground(Color.red);
							break;
						case "Draw":
							lblLineup3.setText(team.getStartingName().get((buttonPressCount - 1)) + " drew their match up");
							lblLineup3.setForeground(Color.DARK_GRAY);
							break;
						}
						lblAthlete1.setText(team.getStartingName().get(0).getName(team.getStartingName().get(0)) + " STM: " + team.getStartingName().get(0).getStamina() + "/100");
						lblAthlete2.setText(team.getStartingName().get(1).getName(team.getStartingName().get(1)) + " STM: " + team.getStartingName().get(1).getStamina() + "/100");
						lblAthlete3.setText(team.getStartingName().get(2).getName(team.getStartingName().get(2)) + " STM: " + team.getStartingName().get(2).getStamina() + "/100");
						lblAthlete4.setText(team.getStartingName().get(3).getName(team.getStartingName().get(3)) + " STM: " + team.getStartingName().get(3).getStamina() + "/100");
						lblScore.setText(match.getPlayersScore() + "-" + match.getOpposingScore());
						break;
						
					case 4:
						matchUpResult = match.matchUp(game, player, team, team.getStartingName().get((buttonPressCount - 1)), opposingTeam.get((buttonPressCount - 1)), "opp");
						switch(matchUpResult) {
						case "Won":
							lblLineup4.setText(team.getStartingName().get((buttonPressCount - 1)) + " defended against " + opposingTeam.get((buttonPressCount - 1)));
							lblLineup4.setForeground(Color.green);
							btnPlay.setEnabled(false);
							break;
						case "Lost":
							lblLineup4.setText(team.getStartingName().get((buttonPressCount - 1)) + " lost their match up");
							lblLineup4.setForeground(Color.red);
							btnPlay.setEnabled(false);
							break;
						case "Draw":
							lblLineup4.setText(team.getStartingName().get((buttonPressCount - 1)) + " drew their match up");
							lblLineup4.setForeground(Color.DARK_GRAY);
							btnPlay.setEnabled(false);
							break;
						}
						lblAthlete1.setText(team.getStartingName().get(0).getName(team.getStartingName().get(0)) + " STM: " + team.getStartingName().get(0).getStamina() + "/100");
						lblAthlete2.setText(team.getStartingName().get(1).getName(team.getStartingName().get(1)) + " STM: " + team.getStartingName().get(1).getStamina() + "/100");
						lblAthlete3.setText(team.getStartingName().get(2).getName(team.getStartingName().get(2)) + " STM: " + team.getStartingName().get(2).getStamina() + "/100");
						lblAthlete4.setText(team.getStartingName().get(3).getName(team.getStartingName().get(3)) + " STM: " + team.getStartingName().get(3).getStamina() + "/100");
						lblHalf.setText("Half-Time");

						lblScore.setText(match.getPlayersScore() + "-" + match.getOpposingScore());
						btnHalfTime.setEnabled(true);
						if (team.startingTeamHealthy(team)) {
							lblWinResult.setText("Starting Team is healthy enough, continue play or make subs");
							btnPlay.setEnabled(true);
							Collections.reverse(team.getStartingName());
						}
						else if (team.howManyInjured(team.getStartingName()) >= team.howManyInjured(team.getReserveName())) {
							JOptionPane.showMessageDialog(frmMatch,"Player on your team is injured, please make a sub");
						}
						else {
							btnHalfTime.setEnabled(false);
							JOptionPane.showMessageDialog(frmMatch,"Players injured and not enough healthy subs. Forfeit Match");
						}
						break;
						
					case 5:
						System.out.println(team.startingTeamHealthy(team));
						if (team.startingTeamHealthy(team) == false) {
							lblWinResult.setText("Starting team is not healthy, please make a Sub");
							buttonPressCount -= 1;
						}
						else {
							btnHalfTime.setEnabled(false);
							lblOpp1.setText(opposingTeam.get(0).getName(opposingTeam.get(0)));
							lblOpp2.setText(opposingTeam.get(1).getName(opposingTeam.get(1)));
							lblOpp3.setText(opposingTeam.get(2).getName(opposingTeam.get(2)));
							lblOpp4.setText(opposingTeam.get(3).getName(opposingTeam.get(3)));
							lblLineup1.setText("");
							lblLineup2.setText("");
							lblLineup3.setText("");
							lblLineup4.setText("");
							lblAthlete1.setText("");
							lblAthlete2.setText("");
							lblAthlete3.setText("");
							lblAthlete4.setText("");
							lblWinResult.setText("");
							lblHalf.setText("Second Half");
							matchUpResult = match.matchUp(game, player, team, team.getStartingName().get((buttonPressCount - 5)), opposingTeam.get((buttonPressCount - 5)), "player");
							switch(matchUpResult) {
							case "Won":
								lblLineup1.setText(team.getStartingName().get((buttonPressCount - 5)) + " scored!");
								lblLineup1.setForeground(Color.green);
								break;
							case "Lost":
								lblLineup1.setText(team.getStartingName().get((buttonPressCount - 5)) + " lost their match up");
								lblLineup1.setForeground(Color.red);
								break;
							case "Draw":
								lblLineup1.setText(team.getStartingName().get((buttonPressCount - 5)) + " drew their match up");
								lblLineup1.setForeground(Color.DARK_GRAY);	
								break;
							}
							lblAthlete1.setText(team.getStartingName().get(0).getName(team.getStartingName().get(0)) + " STM: " + team.getStartingName().get(0).getStamina() + "/100");
							lblAthlete2.setText(team.getStartingName().get(1).getName(team.getStartingName().get(1)) + " STM: " + team.getStartingName().get(1).getStamina() + "/100");
							lblAthlete3.setText(team.getStartingName().get(2).getName(team.getStartingName().get(2)) + " STM: " + team.getStartingName().get(2).getStamina() + "/100");
							lblAthlete4.setText(team.getStartingName().get(3).getName(team.getStartingName().get(3)) + " STM: " + team.getStartingName().get(3).getStamina() + "/100");
							lblScore.setText(match.getPlayersScore() + "-" + match.getOpposingScore());
							lblWinResult.setText("");
							break;
						}

						break;
					case 6:
						matchUpResult = match.matchUp(game, player, team, team.getStartingName().get((buttonPressCount - 5)), opposingTeam.get((buttonPressCount - 5)), "player");
						switch(matchUpResult) {
						case "Won":
							lblLineup2.setText(team.getStartingName().get((buttonPressCount - 5)) + " scored!");
							lblLineup2.setForeground(Color.green);
							break;
						case "Lost":
							lblLineup2.setText(team.getStartingName().get((buttonPressCount - 5)) + " lost their match up");
							lblLineup2.setForeground(Color.red);
							break;
						case "Draw":
							lblLineup2.setText(team.getStartingName().get((buttonPressCount - 5)) + " drew their match up");
							lblLineup2.setForeground(Color.DARK_GRAY);
							break;
						}
						lblAthlete1.setText(team.getStartingName().get(0).getName(team.getStartingName().get(0)) + " STM: " + team.getStartingName().get(0).getStamina() + "/100");
						lblAthlete2.setText(team.getStartingName().get(1).getName(team.getStartingName().get(1)) + " STM: " + team.getStartingName().get(1).getStamina() + "/100");
						lblAthlete3.setText(team.getStartingName().get(2).getName(team.getStartingName().get(2)) + " STM: " + team.getStartingName().get(2).getStamina() + "/100");
						lblAthlete4.setText(team.getStartingName().get(3).getName(team.getStartingName().get(3)) + " STM: " + team.getStartingName().get(3).getStamina() + "/100");
						lblScore.setText(match.getPlayersScore() + "-" + match.getOpposingScore());
						break;
					case 7:
						matchUpResult = match.matchUp(game, player, team, team.getStartingName().get((buttonPressCount - 5)), opposingTeam.get((buttonPressCount - 5)), "opp");
						switch(matchUpResult) {
						case "Won":
							lblLineup3.setText(team.getStartingName().get((buttonPressCount - 5)) + " defended against " + opposingTeam.get((buttonPressCount - 5)));
							lblLineup3.setForeground(Color.green);
							break;
						case "Lost":
							lblLineup3.setText(team.getStartingName().get((buttonPressCount - 5)) + " lost their match up");
							lblLineup3.setForeground(Color.red);
							break;
						case "Draw":
							lblLineup3.setText(team.getStartingName().get((buttonPressCount - 5)) + " drew their match up");
							lblLineup3.setForeground(Color.DARK_GRAY);
							break;
						}
						lblAthlete1.setText(team.getStartingName().get(0).getName(team.getStartingName().get(0)) + " STM: " + team.getStartingName().get(0).getStamina() + "/100");
						lblAthlete2.setText(team.getStartingName().get(1).getName(team.getStartingName().get(1)) + " STM: " + team.getStartingName().get(1).getStamina() + "/100");
						lblAthlete3.setText(team.getStartingName().get(2).getName(team.getStartingName().get(2)) + " STM: " + team.getStartingName().get(2).getStamina() + "/100");
						lblAthlete4.setText(team.getStartingName().get(3).getName(team.getStartingName().get(3)) + " STM: " + team.getStartingName().get(3).getStamina() + "/100");
						lblScore.setText(match.getPlayersScore() + "-" + match.getOpposingScore());
						break;
					case 8:
						matchUpResult = match.matchUp(game, player, team, team.getStartingName().get((buttonPressCount - 5)), opposingTeam.get((buttonPressCount - 5)), "opp");
						switch(matchUpResult) {
						case "Won":
							lblLineup4.setText(team.getStartingName().get((buttonPressCount - 5)) + " defended against " + opposingTeam.get((buttonPressCount - 5)));
							lblLineup4.setForeground(Color.green);
							break;
						case "Lost":
							lblLineup4.setText(team.getStartingName().get((buttonPressCount - 5)) + " lost their match up");
							lblLineup4.setForeground(Color.red);
							break;
						case "Draw":
							lblLineup4.setText(team.getStartingName().get((buttonPressCount - 5)) + " drew their match up");
							lblLineup4.setForeground(Color.DARK_GRAY);
							break;
						}
						lblAthlete1.setText(team.getStartingName().get(0).getName(team.getStartingName().get(0)) + " STM: " + team.getStartingName().get(0).getStamina() + "/100");
						lblAthlete2.setText(team.getStartingName().get(1).getName(team.getStartingName().get(1)) + " STM: " + team.getStartingName().get(1).getStamina() + "/100");
						lblAthlete3.setText(team.getStartingName().get(2).getName(team.getStartingName().get(2)) + " STM: " + team.getStartingName().get(2).getStamina() + "/100");
						lblAthlete4.setText(team.getStartingName().get(3).getName(team.getStartingName().get(3)) + " STM: " + team.getStartingName().get(3).getStamina() + "/100");
						btnContinue.setEnabled(true);
						btnForfeit.setEnabled(false);
						btnPlay.setEnabled(false);
						match.gameWin(game, match);
						btnHalfTime.setEnabled(false);
						lblHalf.setText("Full-Time");
						lblScore.setText(match.getPlayersScore() + "-" + match.getOpposingScore());
						lblWinResult.setText(match.winnerString());
						btnContinue.setEnabled(true);
						break;


				}

			
				
			}
		});
		btnPlay.setBounds(399, 460, 89, 23);
		frmMatch.getContentPane().add(btnPlay);
		
		btnHalfTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPlay.setEnabled(true);
        		MatchSubGUI sub = new MatchSubGUI(team, game, player, frmMatch);
        		sub.frmMatchSub.setVisible(true);
        		frmMatch.setVisible(false);
			}
		});
		
		

		btnForfeit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				team.gamePlayedStamDecr(team);
				frmMatch.dispose();
				matchSelectionGUI.frmMatchSelect.setVisible(true);
				JOptionPane.showMessageDialog(frmMatch,"Match Forfeited");
			}
		});
		btnForfeit.setBounds(680, 635, 89, 23);
		frmMatch.getContentPane().add(btnForfeit);
		btnHalfTime.setBounds(366, 494, 149, 23);
		frmMatch.getContentPane().add(btnHalfTime);
		
		
        JLabel background = new JLabel("");
        background.setIcon(new ImageIcon(MatchGUI.class.getResource("/main/images/anfield.jpeg")));
        background.setBounds(-1593, -848, 2551, 1540);
        frmMatch.getContentPane().add(background);
		

		

		

	}
}
