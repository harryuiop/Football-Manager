package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class MatchSubGUI {

	JFrame frmMatchSub;


	/**
	 * Create the application.
	 */
	public MatchSubGUI(Team team, GameEnviroment game, Player player, JFrame frmMatch) {
		initialize(team, game, player, frmMatch, this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, Player player, JFrame frmMatch, MatchSubGUI subGUI) {
		frmMatchSub = new JFrame();
		frmMatchSub.setTitle("Match Subtitution");
		frmMatchSub.setBounds(100, 100, 258, 303);
		frmMatchSub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMatchSub.getContentPane().setLayout(null);
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		JList<Athlete> res = new JList<Athlete>(athleteListModel);
		res.setBounds(141, 43, 100, 186);
		frmMatchSub.getContentPane().add(res);
		res.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		res.setForeground(Color.DARK_GRAY);
		res.setBackground(Color.LIGHT_GRAY);
		res.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Athlete ath = res.getSelectedValue();
				if (ath != null) {
					//displayerInfo.setText(ath.printForSelection());
				}
			}
		});
		
		athleteListModel.addAll(team.getReserveName());
		res.setFont(new Font("Dialog", Font.BOLD, 15));

		
		
		DefaultListModel<Athlete> athleteListModel2 = new DefaultListModel<Athlete>();
		JList<Athlete> start = new JList<Athlete>(athleteListModel2);
		start.setBounds(17, 43, 100, 186);
		frmMatchSub.getContentPane().add(start);
		frmMatchSub.getContentPane().add(res);
		start.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		start.setForeground(Color.DARK_GRAY);
		start.setBackground(Color.LIGHT_GRAY);
		start.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Athlete ath = start.getSelectedValue();
				if (ath != null) {
					//displayerInfo.setText(ath.printForSelection());
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
				frmMatch.setVisible(true);
				subGUI.frmMatchSub.dispose();
				
			}
		});
		confirm.setBounds(69, 241, 117, 25);
		frmMatchSub.getContentPane().add(confirm);
		
		JLabel Starting = new JLabel("Starting");
		Starting.setBounds(42, 15, 61, 16);
		frmMatchSub.getContentPane().add(Starting);
		
		JLabel Reserves = new JLabel("Reserves");
		Reserves.setBounds(161, 15, 72, 16);
		frmMatchSub.getContentPane().add(Reserves);
	}

}
