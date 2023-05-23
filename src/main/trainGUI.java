package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class trainGUI {

	JFrame frame;

	/**
	 * Create the application.
	 */
	public trainGUI(Team team, GameEnviroment game, Market market, Player player, JFrame frmClub, MatchSelectionGUI matchSelectionGUI) {
		initialize(team, game, market, player, frmClub, matchSelectionGUI, this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, Market market, Player player, JFrame frmClub, MatchSelectionGUI matchSelectionGUI, trainGUI traingui) {
		frame = new JFrame();
		frame.setBounds(100, 100, 322, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel playerStats = new JLabel("");
		playerStats.setBounds(140, 41, 176, 186);
		frame.getContentPane().add(playerStats);
		
		DefaultListModel<Athlete> athleteListModel2 = new DefaultListModel<Athlete>();
		JList<Athlete> list = new JList<Athlete>(athleteListModel2);
		list.setBounds(17, 41, 100, 186);
		frame.getContentPane().add(list);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Athlete ath = list.getSelectedValue();
				if (ath != null) {
					playerStats.setText(ath.printForSelection());
				}
			}
		});
		frame.getContentPane().add(list);
		athleteListModel2.addAll(team.getReserveName());
		athleteListModel2.addAll(team.getStartingName());

		
		JButton btnNewButton = new JButton("Train");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete ath = list.getSelectedValue();
				if (ath != null) {
					ath.setOffence(ath.getOffence() + 10);
					ath.setDefence(ath.getDefence() + 10);
					JOptionPane.showMessageDialog(frame, ath.getName(ath) + "'s Offence and Defence has been increased.");
					game.LaunchClubGUI(team, game, market, player);
					traingui.frame.dispose();
					
				}
			}
		});
		btnNewButton.setBounds(106, 239, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel instructionlbl = new JLabel("Choose a player to train");
		instructionlbl.setHorizontalAlignment(SwingConstants.CENTER);
		instructionlbl.setBounds(19, 0, 297, 29);
		frame.getContentPane().add(instructionlbl);
	}
}