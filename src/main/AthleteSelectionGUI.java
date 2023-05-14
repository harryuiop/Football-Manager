package main;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class AthleteSelectionGUI {
	
	
	JFrame frmAthleteSelection;

	/**
	 * Create the application.
	 */
	public AthleteSelectionGUI(Team team, GameEnviroment game, Market market) {
		initialize(team, game, this, market);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, AthleteSelectionGUI athsel, Market market) {
		frmAthleteSelection = new JFrame();
		frmAthleteSelection.getContentPane().setBackground(new Color(246, 245, 244));
		frmAthleteSelection.setSize(700, 500);
		frmAthleteSelection.setTitle("Athlete Selection");
		frmAthleteSelection.getContentPane().setLayout(null);
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		JList<Athlete> athleteJList = new JList<Athlete>(athleteListModel);
		athleteJList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				athleteJList.getSelectedValue();
			}
		});
		athleteJList.setBorder(UIManager.getBorder("DesktopIcon.border"));
		athleteJList.setFont(new Font("Dialog", Font.BOLD, 15));
		athleteJList.setBounds(12, 26, 258, 414);
		frmAthleteSelection.getContentPane().add(athleteJList);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(294, 26, 365, 280);
		frmAthleteSelection.getContentPane().add(lblNewLabel);
		athleteListModel.addAll(market.getWavierList());
		
	}
}
