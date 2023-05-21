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
	public MatchSelectionGUI(Team team, GameEnviroment game, Player player) {
		initialize(team, game, player, this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, Player player, MatchSelectionGUI matchSelectionGUI) {
		frmMatchSelect = new JFrame();
		frmMatchSelect.setTitle("Match Selection");
		frmMatchSelect.setBounds(100, 100, 700, 500);
		frmMatchSelect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatchSelect.getContentPane().setLayout(null);
		
		JLabel lblMatchSelection = new JLabel("Match Selection");
		lblMatchSelection.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMatchSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatchSelection.setBounds(205, 23, 252, 71);
		frmMatchSelect.getContentPane().add(lblMatchSelection);
		
		
		PotentialPlayers oppositionGenerator = new PotentialPlayers();
		
		JButton btnTeam1 = new JButton("teamOne");
		btnTeam1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opposingTeam = oppositionGenerator.createOpposingTeam(game, 1);
				game.LaunchMatchGUI(team, game, player, opposingTeam, frmMatchSelect);
				btnTeam1.setEnabled(false);
				frmMatchSelect.setVisible(false);
			}
		});
		btnTeam1.setBounds(35, 156, 154, 130);
		frmMatchSelect.getContentPane().add(btnTeam1);
		
		JButton btnTeam2 = new JButton("teamTwo");
		btnTeam2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opposingTeam = oppositionGenerator.createOpposingTeam(game, 2);
				game.LaunchMatchGUI(team, game, player, opposingTeam, frmMatchSelect);
				btnTeam2.setEnabled(false);
				frmMatchSelect.setVisible(false);
			}
		});
		btnTeam2.setBounds(263, 156, 154, 130);
		frmMatchSelect.getContentPane().add(btnTeam2);
		
		JButton btnTeam3 = new JButton("teamThree");
		btnTeam3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opposingTeam = oppositionGenerator.createOpposingTeam(game, 3);
				game.LaunchMatchGUI(team, game, player, opposingTeam, frmMatchSelect);
				btnTeam3.setEnabled(false);
				frmMatchSelect.setVisible(false);
			}
		});
		btnTeam3.setBounds(486, 156, 154, 130);
		frmMatchSelect.getContentPane().add(btnTeam3);
		
		JLabel lblNewLabel = new JLabel("Select your opponent:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(215, 105, 242, 22);
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
	}
}
