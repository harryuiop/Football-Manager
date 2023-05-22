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

public class SubstituionGUI {

	JFrame frame;
	

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
		frame = new JFrame();
		frame.setBounds(100, 100, 258, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		JList<Athlete> res = new JList<Athlete>(athleteListModel);
		res.setBounds(141, 43, 100, 186);
		frame.getContentPane().add(res);
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
		frame.getContentPane().add(start);
		frame.getContentPane().add(res);
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
				game.LaunchClubGUI(team, game, market, player);
				gui.frame.dispose();
				
			}
		});
		confirm.setBounds(69, 241, 117, 25);
		frame.getContentPane().add(confirm);
		
		JLabel Starting = new JLabel("Starting");
		Starting.setBounds(42, 15, 61, 16);
		frame.getContentPane().add(Starting);
		
		JLabel Reserves = new JLabel("Reserves");
		Reserves.setBounds(161, 15, 72, 16);
		frame.getContentPane().add(Reserves);
	}
	public void close() {
		this.frame.dispose();
	}
}
