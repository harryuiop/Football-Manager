package main;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClubGUI {

	JFrame frmClub;


	/**
	 * Create the application.
	 */
	public ClubGUI(Team team, GameEnviroment game, Market market, Player player) {
		initialize(team,game,market,player);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, Market market, Player player) {
		frmClub = new JFrame();
		frmClub.setMinimumSize(new Dimension(700,500));
		frmClub.getContentPane().setEnabled(false);
		frmClub.setTitle("Club");
		frmClub.setResizable(true);
		frmClub.setSize(440,648);
		frmClub.setPreferredSize(new Dimension(700,500));
		frmClub.setBounds(100, 100, 450, 300);
		frmClub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmClub.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Clubroom");
		lblWelcomeToThe.setForeground(new Color(0, 0, 0));
		lblWelcomeToThe.setFont(new Font("Accanthis ADF Std No3", Font.BOLD, 15));
		lblWelcomeToThe.setBounds(28, 137, 241, 55);
		frmClub.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblStartingLineup = new JLabel("Starting Lineup");
		lblStartingLineup.setForeground(new Color(0, 0, 0));
		lblStartingLineup.setFont(new Font("Accanthis ADF Std No3", Font.BOLD, 14));
		lblStartingLineup.setBounds(427, 234, 134, 15);
		frmClub.getContentPane().add(lblStartingLineup);
		
		JButton btnNewButton = new JButton("Market");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.LaunchMarketGUI(team, game, market, player);
				game.cl
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 11));
		btnNewButton.setBounds(12, 433, 117, 25);
		frmClub.getContentPane().add(btnNewButton);
		
		JButton btnSelectMatch = new JButton("Select Match");
		btnSelectMatch.setFont(new Font("Dialog", Font.BOLD, 11));
		btnSelectMatch.setBounds(12, 396, 117, 25);
		frmClub.getContentPane().add(btnSelectMatch);
		
		JLabel lblCurrentWeek = new JLabel("Current Week -");
		lblCurrentWeek.setFont(new Font("Accanthis ADF Std No3", Font.BOLD, 14));
		lblCurrentWeek.setBounds(38, 189, 168, 25);
		frmClub.getContentPane().add(lblCurrentWeek);
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		DefaultListCellRenderer renderer = new DefaultListCellRenderer();
		athleteListModel.addAll(team.getReserveName());
		athleteListModel.addAll(team.getStartingName());
		renderer.setOpaque(true); // make the cell renderer background opaque
		renderer.setBackground(Color.WHITE);
		
		JButton btnMakeSubstituion = new JButton("Make Substituion");
		btnMakeSubstituion.setBounds(510, 433, 168, 25);
		frmClub.getContentPane().add(btnMakeSubstituion);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ClubGUI.class.getResource("/main/images/clubroom.jpg")));
		lblNewLabel.setBounds(-52, -24, 793, 538);
		frmClub.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ClubGUI.class.getResource("/main/images/whiteboard.jpg")));
		lblNewLabel_1.setBounds(509, 417, 270, 173);
		frmClub.getContentPane().add(lblNewLabel_1);
		
		
		
	}
}
