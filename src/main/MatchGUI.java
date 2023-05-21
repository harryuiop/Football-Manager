package main;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MatchGUI {

	JFrame frmMatch;
	


	/**
	 * Create the application.
	 */
	public MatchGUI(Team team, GameEnviroment game, Player player, ArrayList<Athlete> opposingTeam, JFrame matchSelectionGUI) {
		initialize(team, game, player, opposingTeam, matchSelectionGUI, this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, Player player, ArrayList<Athlete> opposingTeam, JFrame matchSelectionGUI, MatchGUI matchGUI) {
		Match match = new Match();
		
		frmMatch = new JFrame();
		frmMatch.setTitle("Match");
		frmMatch.setBounds(100, 100, 900, 600);
		frmMatch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatch.getContentPane().setLayout(null);
		
		JLabel lblScore = new JLabel("0-0");
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(384, 87, 108, 89);
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
		
		
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMatch.dispose();
				matchSelectionGUI.setVisible(true);
			}
		});
		btnContinue.setBounds(785, 527, 89, 23);
		frmMatch.getContentPane().add(btnContinue);
		
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (team.getStartingName().get(0).getOffence() > opposingTeam.get(0).getDefence()) {
					match.setPlayersScore(match.getPlayersScore() + 1);
				}
				if (team.getStartingName().get(1).getOffence() > opposingTeam.get(1).getDefence()) {
					match.setPlayersScore(match.getPlayersScore() + 1);
				}
				if (team.getStartingName().get(2).getOffence() > opposingTeam.get(2).getDefence()) {
					match.setPlayersScore(match.getPlayersScore() + 1);
				}
				if (team.getStartingName().get(3).getOffence() > opposingTeam.get(3).getDefence()) {
					match.setPlayersScore(match.getPlayersScore() + 1);
				}
				lblScore.setText(match.getPlayersScore() + "-" + match.getOpposingScore());
				btnPlay.setEnabled(false);
				btnContinue.setEnabled(true);
				
			}
		});
		btnPlay.setBounds(399, 417, 89, 23);
		frmMatch.getContentPane().add(btnPlay);
		

		

	}

}
