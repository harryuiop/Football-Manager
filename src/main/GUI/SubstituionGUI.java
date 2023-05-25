package main.GUI;

import java.awt.Color;
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
		frmSubstitutions.setTitle("Match Subtitution");
		frmSubstitutions.setBounds(100, 100, 276, 465);
		frmSubstitutions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSubstitutions.getContentPane().setLayout(null);
		
		JLabel lblStartingSelected = new JLabel("Select a Starting player to view Stam");
		lblStartingSelected.setFont(new Font("Dialog", Font.BOLD, 10));
		lblStartingSelected.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartingSelected.setBounds(10, 240, 251, 40);
		frmSubstitutions.getContentPane().add(lblStartingSelected);
		
		JLabel lblReserveSelected = new JLabel("Select a Reserve player to view Stam");
		lblReserveSelected.setFont(new Font("Dialog", Font.BOLD, 10));
		lblReserveSelected.setHorizontalAlignment(SwingConstants.CENTER);
		lblReserveSelected.setBounds(10, 279, 251, 40);
		frmSubstitutions.getContentPane().add(lblReserveSelected);
		
		JLabel lblSelectIndi = new JLabel("");
		lblSelectIndi.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectIndi.setBounds(10, 326, 251, 25);
		frmSubstitutions.getContentPane().add(lblSelectIndi);
		
		
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
				if(res.getSelectedValue() == null && start.getSelectedValue() == null) {
					game.LaunchClubGUI(team, game, market, player);
					gui.frmSubstitutions.dispose();
				}
				else if(res.getSelectedValue() == null || start.getSelectedValue() == null) {
					lblSelectIndi.setText("Please select players to sub");
				}
				else {
					Athlete r = res.getSelectedValue();
					Athlete s = start.getSelectedValue();
					team.makeSubstituion(s, r);
					game.LaunchClubGUI(team, game, market, player);
					gui.frmSubstitutions.dispose();
				}

			}
		});
		confirm.setBounds(71, 400, 117, 25);
		frmSubstitutions.getContentPane().add(confirm);
		
		JLabel Starting = new JLabel("Starting");
		Starting.setBounds(42, 15, 61, 16);
		frmSubstitutions.getContentPane().add(Starting);
		
		JLabel Reserves = new JLabel("Reserves");
		Reserves.setBounds(161, 15, 72, 16);
		frmSubstitutions.getContentPane().add(Reserves);
		
		JButton btnClearSelections = new JButton("Clear Selections");
		btnClearSelections.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblReserveSelected.setText("");
				lblStartingSelected.setText("");

				res.clearSelection();
				start.clearSelection();
			}
		});
		btnClearSelections.setBounds(42, 363, 177, 25);
		frmSubstitutions.getContentPane().add(btnClearSelections);
	}
	public void close() {
		this.frmSubstitutions.dispose();
	}
}
