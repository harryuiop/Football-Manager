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
		lblWelcomeToThe.setBounds(27, 122, 241, 55);
		frmClub.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblStartingLineup = new JLabel("Starting Lineup");
		lblStartingLineup.setForeground(Color.WHITE);
		lblStartingLineup.setFont(new Font("Accanthis ADF Std No3", Font.BOLD, 14));
		lblStartingLineup.setBounds(427, 234, 134, 15);
		frmClub.getContentPane().add(lblStartingLineup);
		
		JButton btnNewButton = new JButton("Market");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.LaunchMarketGUI(team, game, market, player);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.setBounds(12, 409, 162, 49);
		frmClub.getContentPane().add(btnNewButton);
		
		JButton btnSelectMatch = new JButton("Select Match");
		btnSelectMatch.setFont(new Font("Dialog", Font.BOLD, 14));
		btnSelectMatch.setBounds(12, 360, 162, 47);
		frmClub.getContentPane().add(btnSelectMatch);
		
		JLabel lblCurrentWeek = new JLabel("Current Week ");
		lblCurrentWeek.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblCurrentWeek.setBounds(6, 297, 168, 25);
		frmClub.getContentPane().add(lblCurrentWeek);
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		DefaultListCellRenderer renderer = new DefaultListCellRenderer();
		athleteListModel.addAll(team.getReserveName());
		athleteListModel.addAll(team.getStartingName());
		renderer.setOpaque(true); // make the cell renderer background opaque
		renderer.setBackground(Color.WHITE);
		
		JButton btnMakeSubstituion = new JButton("Make Substituion");
		btnMakeSubstituion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMakeSubstituion.setBounds(526, 441, 168, 25);
		frmClub.getContentPane().add(btnMakeSubstituion);
		
		JLabel playerStats = new JLabel("");
		playerStats.setBounds(12, 162, 256, 128);
		frmClub.getContentPane().add(playerStats);
		
		JButton player1 = new JButton("Player 1");
		player1.setBounds(348, 261, 117, 25);
		frmClub.getContentPane().add(player1);
		
		JButton player2 = new JButton("Player 2");
		player2.setBounds(464, 259, 117, 29);
		frmClub.getContentPane().add(player2);
		
		JButton player3 = new JButton("Player 3");
		player3.setBounds(348, 293, 117, 29);
		frmClub.getContentPane().add(player3);
		
		JButton player4 = new JButton("Player 4");
		player4.setBounds(464, 293, 117, 29);
		frmClub.getContentPane().add(player4);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(297, 439, 117, 29);
		frmClub.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(412, 439, 117, 29);
		frmClub.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(297, 409, 117, 29);
		frmClub.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(412, 409, 117, 29);
		frmClub.getContentPane().add(btnNewButton_4);
		
		JLabel reserveLabel = new JLabel("Reserves");
		reserveLabel.setForeground(Color.WHITE);
		reserveLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		reserveLabel.setBounds(377, 382, 84, 25);
		frmClub.getContentPane().add(reserveLabel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ClubGUI.class.getResource("/main/images/clubroom.jpg")));
		lblNewLabel.setBounds(-52, -24, 793, 538);
		frmClub.getContentPane().add(lblNewLabel);
		
		
		
	}
}
