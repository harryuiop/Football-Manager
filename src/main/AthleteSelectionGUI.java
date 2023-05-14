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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AthleteSelectionGUI {
	
	
	JFrame frmAthleteSelection;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public AthleteSelectionGUI(Team team, GameEnviroment game, Market market, Player player) {
		initialize(team, game, this, market, player);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, AthleteSelectionGUI athsel, Market market, Player player) {
		frmAthleteSelection = new JFrame();
		frmAthleteSelection.getContentPane().setBackground(new Color(246, 245, 244));
		frmAthleteSelection.setSize(700, 500);
		frmAthleteSelection.setTitle("Athlete Selection");
		frmAthleteSelection.getContentPane().setLayout(null);
		
		JLabel displayerInfo = new JLabel();
		displayerInfo.setFont(new Font("Dialog", Font.PLAIN, 20));
		displayerInfo.setBounds(294, 64, 310, 217);
		frmAthleteSelection.getContentPane().add(displayerInfo);
		
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		JList<Athlete> athleteJList = new JList<Athlete>(athleteListModel);
		athleteJList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Athlete ath = athleteJList.getSelectedValue();
				if (ath != null) {
					displayerInfo.setText(ath.printForSelection());
				}
			}
		});
		
		athleteListModel.addAll(market.getWavierList());
		athleteJList.setBorder(UIManager.getBorder("DesktopIcon.border"));
		athleteJList.setFont(new Font("Dialog", Font.BOLD, 15));
		athleteJList.setBounds(18, 12, 258, 414);
		frmAthleteSelection.getContentPane().add(athleteJList);
		JLabel balance = new JLabel();
		balance.setFont(new Font("Dialog", Font.BOLD, 16));
		balance.setBounds(294, 27, 117, 25);
		frmAthleteSelection.getContentPane().add(balance);
		String balAsStr = "$" + player.getMoneyBalance();
		balance.setText(balAsStr);
		
		JLabel lblCurrentTeam = new JLabel();
		lblCurrentTeam.setBounds(294, 399, 384, 27);
		frmAthleteSelection.getContentPane().add(lblCurrentTeam);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
		int counter = 0;
			public void actionPerformed(ActionEvent e) {
				counter++;
				if (counter < 5) {
					Athlete athToBuy = athleteJList.getSelectedValue();
					market.BuyPlayerAndMoneyUpdater(player, athToBuy, team);
					athleteListModel.removeElement(athToBuy);
					String balAsStr = "$" + player.getMoneyBalance();
					balance.setText(balAsStr);	
					String athToStr = athToBuy.getName(athToBuy);
					lblCurrentTeam.setText(athToStr + " has been added to your starting team");
				
					
					
				} else if (counter > 3 && counter < 8) {
					Athlete athToBuy = athleteJList.getSelectedValue();
					market.reserveBuyPlayerAndMoneyUpdater(player, athToBuy, team);
					athleteListModel.removeElement(athToBuy);
					String balAsStr = "$" + player.getMoneyBalance();
					balance.setText(balAsStr);
					String athToStr = athToBuy.getName(athToBuy);
					lblCurrentTeam.setText(athToStr + " has been added to your reserves");
					
				} else {
					game.closeAthleteSelectionGUI(team, game, athsel, market, player);
				}
			}
		});
		
		
		btnPurchase.setBounds(18, 433, 117, 25);
		frmAthleteSelection.getContentPane().add(btnPurchase);
		
		textField = new JTextField();
		textField.setBounds(149, 436, 114, 19);
		frmAthleteSelection.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblOptionallyAddNickname = new JLabel("Optionally add nickname");
		lblOptionallyAddNickname.setBounds(270, 438, 181, 15);
		frmAthleteSelection.getContentPane().add(lblOptionallyAddNickname);
		
	
		
	}
}
