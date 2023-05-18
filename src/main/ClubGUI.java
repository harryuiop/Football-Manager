package main;
import java.awt.Dimension;
import java.util.ArrayList;

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
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class ClubGUI {

	JFrame frmClub;
	int counter = 0;
	boolean subOn = false;
	ArrayList<Athlete> holder = new ArrayList<Athlete>();

	/**
	 * Create the application.
	 */
	public ClubGUI(Team team, GameEnviroment game, Market market, Player player) {
		initialize(team,game,market,player, this);
	}

	public void canSub(ClubGUI clubGUI, Team team) {			

		if (clubGUI.counter == 2 && clubGUI.subOn == false) {
			System.out.println("churrrrr");
			team.makeSubstituion(holder.get(0), holder.get(1));
			clubGUI.counter = 0;
			holder.clear();
			
		} else if (clubGUI.counter > 2 && clubGUI.subOn == true) {
			clubGUI.counter = 0;
			holder.clear();
		}
	}	
	
	public void setTag() {
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 * @param clubGUI 
	 */
	public void initialize(Team team, GameEnviroment game, Market market, Player player, ClubGUI clubGUI) {
		System.out.println(team.getReserveName());
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
				frmClub.dispose();
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
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(207, 375, 117, 32);
		
		frmClub.getContentPane().add(lblNewLabel_1);
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		DefaultListCellRenderer renderer = new DefaultListCellRenderer();
		athleteListModel.addAll(team.getReserveName());
		athleteListModel.addAll(team.getStartingName());
		renderer.setOpaque(true); // make the cell renderer background opaque
		renderer.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(562, 402, 101, 16);
		frmClub.getContentPane().add(lblNewLabel_2);
		
		JLabel playerStats = new JLabel("");
		playerStats.setHorizontalAlignment(SwingConstants.CENTER);
		playerStats.setBounds(27, 162, 233, 128);
		frmClub.getContentPane().add(playerStats);
		
		JButton btnNewButton_5 = new JButton("sub");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String submode = " " + clubGUI.subOn;
				lblNewLabel_2.setText(submode);
				clubGUI.counter = 0;
				holder.clear();
				if (clubGUI.subOn == false) {
					clubGUI.subOn = true;
				} else {
					clubGUI.subOn = false;
				}
				
				
			}
		});
		

		btnNewButton_5.setBounds(546, 420, 117, 29);
		frmClub.getContentPane().add(btnNewButton_5);
		
		Athlete p1 = team.getStartingName().get(0);
		JButton player1 = new JButton(p1.getName(p1));
		player1.setBounds(348, 261, 117, 25);
		frmClub.getContentPane().add(player1);
		player1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStats.setText(p1.printForSelection());
				holder.add(p1);
				clubGUI.counter++;
				canSub(clubGUI, team);
				Athlete p11 = team.getStartingName().get(0);
				player1.setText(p11.getName(p11));
			}
		});
	
		
		Athlete p2 = team.getStartingName().get(1);
		JButton player2 = new JButton(p2.getName(p2));
		player2.setBounds(464, 259, 117, 29);
		frmClub.getContentPane().add(player2);
		player2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStats.setText(p2.printForSelection());
				holder.add(p2);
				clubGUI.counter++;
				canSub(clubGUI, team);
				Athlete p22 = team.getStartingName().get(1);
				player2.setText(p22.getName(p22));

			}
		});
		
		Athlete p3 = team.getStartingName().get(2);
		JButton player3 = new JButton(p3.getName(p3));
		player3.setBounds(348, 293, 117, 29);
		frmClub.getContentPane().add(player3);
		player3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStats.setText(p3.printForSelection());
				holder.add(p3);
				clubGUI.counter++;
				canSub(clubGUI, team);
				player3.setText(p3.getName(p3));

			}
		});
		
		Athlete p4 = team.getStartingName().get(3);
		JButton player4 = new JButton(p4.getName(p4));
		player4.setBounds(464, 293, 117, 29);
		frmClub.getContentPane().add(player4);
		player4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStats.setText(p4.printForSelection());
				holder.add(p4);
				clubGUI.counter++;
				canSub(clubGUI, team);
				player4.setText(p4.getName(p4));

			}
		});
		
		Athlete p5 = team.getReserveName().get(0);
		JButton btnNewButton_1 = new JButton(p5.getName(p5));
		btnNewButton_1.setBounds(297, 439, 117, 29);
		frmClub.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStats.setText(p5.printForSelection());
				holder.add(p5);
				clubGUI.counter++;
				canSub(clubGUI, team);
				btnNewButton_1.setText(p5.getName(p5));

			}
		});
		
		Athlete p6 = team.getReserveName().get(1);
		JButton btnNewButton_2 = new JButton(p6.getName(p6));
		btnNewButton_2.setBounds(412, 439, 117, 29);
		frmClub.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStats.setText(p6.printForSelection());
				holder.add(p6);
				clubGUI.counter++;
				canSub(clubGUI, team);
				btnNewButton_2.setText(p6.getName(p6));


			}
		});
		
		Athlete p7 = team.getReserveName().get(2);
		JButton btnNewButton_3 = new JButton(p7.getName(p7));
		frmClub.getContentPane().add(btnNewButton_3);
		btnNewButton_3.setBounds(297, 409, 117, 29);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStats.setText(p7.printForSelection());
				holder.add(p7);
				clubGUI.counter++;
				canSub(clubGUI, team);
				btnNewButton_3.setText(p7.getName(p7));


			}
		});
		
		
		Athlete p8 = team.getReserveName().get(3);
		JButton btnNewButton_4 = new JButton(p8.getName(p8));
		btnNewButton_4.setBounds(412, 409, 117, 29);
		frmClub.getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerStats.setText(p8.printForSelection());
				holder.add(p8);
				clubGUI.counter++;
				canSub(clubGUI, team);
				btnNewButton_4.setText(p8.getName(p8));


				
			}
		});
	
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
