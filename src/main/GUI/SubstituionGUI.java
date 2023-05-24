package main.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.LOGIC.GameEnviroment;
import main.LOGIC.Market;
import main.LOGIC.Player;
import main.LOGIC.Team;
import main.LOGIC.Athlete;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SubstituionGUI {

	JFrame frmSubstitutions;
	

	/**
	 * Create the application.
	 */
	public SubstituionGUI(Team team, GameEnviroment game, Market market, Player player) {
		initialize(team, game, market, player, this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, Market market, Player player, SubstituionGUI gui) {
		frmSubstitutions = new JFrame();
		frmSubstitutions.getContentPane().setBackground(Color.GRAY);
		frmSubstitutions.setTitle("Substitutions");
		frmSubstitutions.setBounds(100, 100, 294, 418);
		frmSubstitutions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSubstitutions.getContentPane().setLayout(null);
		
		
		JLabel lblStartingSelected = new JLabel("Select a Starting player to view Stam");
		lblStartingSelected.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStartingSelected.setForeground(new Color(255, 255, 255));
		lblStartingSelected.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartingSelected.setBounds(10, 240, 258, 40);
		frmSubstitutions.getContentPane().add(lblStartingSelected);
		
		JLabel lblReserveSelected = new JLabel("Select a Reserve player to view Stam");
		lblReserveSelected.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReserveSelected.setForeground(new Color(255, 255, 255));
		lblReserveSelected.setHorizontalAlignment(SwingConstants.CENTER);
		lblReserveSelected.setBounds(10, 292, 258, 40);
		frmSubstitutions.getContentPane().add(lblReserveSelected);
		
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		JList<Athlete> res = new JList<Athlete>(athleteListModel);
		res.setBounds(149, 43, 100, 186);
		frmSubstitutions.getContentPane().add(res);
		res.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		res.setForeground(Color.DARK_GRAY);
		res.setBackground(Color.LIGHT_GRAY);
		res.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Athlete ath = res.getSelectedValue();
				if (ath != null) {
					lblReserveSelected.setText(ath.getName(ath) + " has " + ath.getStamina() + "/100 Stamina");
				}
			}
		});
		
		athleteListModel.addAll(team.getReserveName());
		res.setFont(new Font("Dialog", Font.BOLD, 15));

		
		
		DefaultListModel<Athlete> athleteListModel2 = new DefaultListModel<Athlete>();
		JList<Athlete> start = new JList<Athlete>(athleteListModel2);
		start.setBounds(25, 43, 100, 186);
		frmSubstitutions.getContentPane().add(start);
		frmSubstitutions.getContentPane().add(res);
		start.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		start.setForeground(Color.DARK_GRAY);
		start.setBackground(Color.LIGHT_GRAY);
		start.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Athlete ath = start.getSelectedValue();
				if (ath != null) {
					lblStartingSelected.setText(ath.getName(ath) + " has " + ath.getStamina() + "/100 Stamina");
				}
			}
		});
		
		athleteListModel2.addAll(team.getStartingName());
		start.setFont(new Font("Dialog", Font.BOLD, 15));

		
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete r = res.getSelectedValue();
				Athlete s = start.getSelectedValue();
				team.makeSubstituion(s, r);
				game.LaunchClubGUI(team, game, market, player);
				gui.frmSubstitutions.dispose();
				
			}
		});
		confirm.setBounds(79, 343, 117, 25);
		frmSubstitutions.getContentPane().add(confirm);
		
		JLabel Starting = new JLabel("Starting");
		Starting.setForeground(new Color(255, 255, 255));
		Starting.setFont(new Font("Tahoma", Font.BOLD, 12));
		Starting.setBounds(50, 15, 61, 16);
		frmSubstitutions.getContentPane().add(Starting);
		
		JLabel Reserves = new JLabel("Reserves");
		Reserves.setForeground(new Color(255, 255, 255));
		Reserves.setFont(new Font("Tahoma", Font.BOLD, 12));
		Reserves.setBounds(169, 15, 72, 16);
		frmSubstitutions.getContentPane().add(Reserves);
		

	}
	public void close() {
		this.frmSubstitutions.dispose();
	}
}
