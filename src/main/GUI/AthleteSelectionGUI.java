package main.GUI;

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

import main.LOGIC.Athlete;
import main.LOGIC.GameEnviroment;
import main.LOGIC.Market;
import main.LOGIC.Player;
import main.LOGIC.Team;

import javax.swing.event.ListSelectionEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

public class AthleteSelectionGUI {
	
	
	public JFrame frmAthleteSelection;
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
		displayerInfo.setForeground(Color.DARK_GRAY);
		displayerInfo.setBackground(Color.GRAY);
		displayerInfo.setFont(new Font("Dialog", Font.PLAIN, 20));
		displayerInfo.setBounds(179, 12, 232, 261);
		frmAthleteSelection.getContentPane().add(displayerInfo);
		
		
		JLabel lblPlayerCondition = new JLabel("");
		lblPlayerCondition.setBounds(179, 328, 216, 67);
		frmAthleteSelection.getContentPane().add(lblPlayerCondition);
		
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(149, 436, 114, 19);
		frmAthleteSelection.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		JList<Athlete> athleteJList = new JList<Athlete>(athleteListModel);
		athleteJList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		athleteJList.setForeground(Color.DARK_GRAY);
		athleteJList.setBackground(Color.LIGHT_GRAY);
		athleteJList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Athlete ath = athleteJList.getSelectedValue();
				if (ath != null) {
					displayerInfo.setText(ath.printForSelection());
					textField.setText("");
				}
			}
		});
		
		
		athleteListModel.addAll(market.getWavierList());
		athleteJList.setFont(new Font("Dialog", Font.BOLD, 15));
		athleteJList.setBounds(18, 12, 144, 414);
		frmAthleteSelection.getContentPane().add(athleteJList);
		JLabel balance = new JLabel();
		balance.setFont(new Font("Dialog", Font.BOLD, 15));
		balance.setBounds(532, 433, 117, 25);
		frmAthleteSelection.getContentPane().add(balance);
		String balAsStr = "$" + player.getMoneyBalance();
		balance.setText(balAsStr);
		
		
		JLabel lblOptionallyAddNickname = new JLabel("Optionally add nickname");
		lblOptionallyAddNickname.setBounds(270, 438, 181, 15);
		frmAthleteSelection.getContentPane().add(lblOptionallyAddNickname);
		
		
		JLabel lblCurrentTeam = new JLabel();
		lblCurrentTeam.setBounds(204, 391, 384, 27);
		frmAthleteSelection.getContentPane().add(lblCurrentTeam);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setBackground(Color.GRAY);
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblPlayerCondition.setText("");
				lblCurrentTeam.setText("");
				
				String nickname = textField.getText();
				if (athleteJList.getSelectedValue() == null){
					lblPlayerCondition.setText("Please Select a player for purchase");
				}
				
				else if (team.getStartingName().size() < 4) {
					Athlete athToBuy = athleteJList.getSelectedValue();
					market.BuyPlayerAndMoneyUpdater(player, athToBuy, team, false);
					athleteListModel.removeElement(athToBuy);
					String balAsStr = "$" + player.getMoneyBalance();
					balance.setText(balAsStr);	
					String athToStr = athToBuy.getName(athToBuy);
					lblCurrentTeam.setText(athToStr + " has been added to your starting team");	
					if (!nickname.isBlank()) {
						athToBuy.setName(athToBuy.getName(athToBuy) + " (" + textField.getText() + ")");

					}
					if (team.getStartingName().size() == 4 && team.getReserveName().size() == 4) {
						game.closeAthleteSelectionGUI(team, game, athsel, market, player);			
					
					} 
					
				} else if (team.getStartingName().size() > 3 && team.getReserveName().size() < 4) {
					Athlete athToBuy = athleteJList.getSelectedValue();
					market.reserveBuyPlayerAndMoneyUpdater(player, athToBuy, team);
					athleteListModel.removeElement(athToBuy);
					String balAsStr = "$" + player.getMoneyBalance();
					balance.setText(balAsStr);
					String athToStr = athToBuy.getName(athToBuy);
					lblCurrentTeam.setText(athToStr + " has been added to your reserves");
					if (!nickname.isBlank()) {
						athToBuy.setName(athToBuy.getName(athToBuy) + " (" + textField.getText() + ")");
					}
					if (team.getStartingName().size() == 4 && team.getReserveName().size() == 4) {
						game.closeAthleteSelectionGUI(team, game, athsel, market, player);			
					} 
				} 
			}
		});
		
		
		btnPurchase.setBounds(18, 433, 117, 25);
		frmAthleteSelection.getContentPane().add(btnPurchase);
		
		
		JList list = new JList();
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		list.setBackground(Color.LIGHT_GRAY);
		list.setBounds(174, 12, 221, 261);
		frmAthleteSelection.getContentPane().add(list);
		
		JLabel balancelbl = new JLabel("Balance :");
		balancelbl.setBounds(533, 411, 97, 25);
		frmAthleteSelection.getContentPane().add(balancelbl);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AthleteSelectionGUI.class.getResource("/main/images/anfield.jpeg")));
		lblNewLabel.setBounds(-234, -215, 934, 687);
		frmAthleteSelection.getContentPane().add(lblNewLabel);
		
	
		
	}
}
