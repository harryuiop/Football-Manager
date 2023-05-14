package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;

public class AthleteSelectionGUI {

	JFrame frmAthleteSelection;

	/**
	 * Create the application.
	 */
	public AthleteSelectionGUI(Team team, GameEnviroment game) {
		initialize(team, game, this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, AthleteSelectionGUI athsel) {
		frmAthleteSelection = new JFrame();
		frmAthleteSelection.setTitle("Athlete Selection");
		frmAthleteSelection.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(79, 111, 388, 206);
		frmAthleteSelection.getContentPane().add(list);
		
	}
}
