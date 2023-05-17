package main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MarketGUI {

	JFrame frmTheMarket;
	
	private ArrayList<Item> items = new ArrayList<>();
	private ArrayList<Athlete> athletes = new ArrayList<>();
	private int cartAmount;

	/**
	 * Create the application.
	 */
	public MarketGUI(Team team, GameEnviroment game, Market market, Player player) {
		items = market.getCatalog();
		athletes = market.getWavierList();
		cartAmount = 0;
		initialize(team, game, market, player, this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, Market market, Player player, MarketGUI marketGUI) {
		frmTheMarket = new JFrame();
		frmTheMarket.setTitle("The Market");
		frmTheMarket.setMinimumSize(new Dimension(700,500));
		frmTheMarket.setBounds(100, 100, 600, 400);
		frmTheMarket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheMarket.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Market");
		lblWelcomeToThe.setBounds(266, 12, 181, 15);
		frmTheMarket.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblCartAmount = new JLabel("Cart Amount: $0");
		lblCartAmount.setBounds(542, 369, 136, 15);
		frmTheMarket.getContentPane().add(lblCartAmount);
		
		JLabel lblSuccessPurchase = new JLabel("");
		lblSuccessPurchase.setBounds(147, 396, 531, 25);
		frmTheMarket.getContentPane().add(lblSuccessPurchase);
		
		JLabel lblAvailableMoney = new JLabel("Available Money: $" + player.getMoneyBalance());
		lblAvailableMoney.setBounds(515, 342, 198, 15);
		frmTheMarket.getContentPane().add(lblAvailableMoney);
		
		JLabel lblItems = new JLabel("Items:");
		lblItems.setBounds(331, 46, 70, 15);
		frmTheMarket.getContentPane().add(lblItems);
		
		JLabel lblPlayers = new JLabel("Players:");
		lblPlayers.setBounds(101, 46, 70, 15);
		frmTheMarket.getContentPane().add(lblPlayers);
		
		JLabel lblItemStats = new JLabel("Selected Item Stats");
		lblItemStats.setBounds(281, 159, 215, 130);
		frmTheMarket.getContentPane().add(lblItemStats);
		
		DefaultListModel<Item> itemListModel = new DefaultListModel<>();
		itemListModel.addAll(items);
		
		JList<Item> itemList = new JList<>(itemListModel);
		itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		itemList.setBounds(271, 73, 225, 86);

		frmTheMarket.getContentPane().add(itemList);
		
		itemList.getSelectedValue();
		
		JLabel lblAthleteStats = new JLabel("Selected Athlete Stats");
		lblAthleteStats.setBounds(27, 282, 215, 130);
		frmTheMarket.getContentPane().add(lblAthleteStats);
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<>();
		athleteListModel.addAll(athletes);
		JList<Athlete> athleteList = new JList<>(athleteListModel);
		athleteList.setBounds(23, 73, 225, 207);

		frmTheMarket.getContentPane().add(athleteList);
		
		athleteList.getSelectedValue();
		
		itemList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Item item = itemList.getSelectedValue();
				if (item != null) {
					lblItemStats.setText(item.printForSelection());
					cartAmount = 0;
					if (athleteList.getSelectedValue()!=null) {
						cartAmount += itemList.getSelectedValue().getItemPrice() + athleteList.getSelectedValue().getContractPrice(athleteList.getSelectedValue());
					}
					else {
						cartAmount += itemList.getSelectedValue().getItemPrice();
					}
					lblCartAmount.setText("Cart Amount: $" + cartAmount);
				}
			}
		});
		
		athleteList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Athlete ath = athleteList.getSelectedValue();
				if (ath != null) {
					lblAthleteStats.setText(ath.printForSelection());
					cartAmount = 0;
					if (itemList.getSelectedValue()!=null) {
						cartAmount += itemList.getSelectedValue().getItemPrice() + athleteList.getSelectedValue().getContractPrice(athleteList.getSelectedValue());
					}
					else {
						cartAmount += athleteList.getSelectedValue().getContractPrice(athleteList.getSelectedValue());
					}
					lblCartAmount.setText("Cart Amount: $" + cartAmount);
				}
			}
		});
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (athleteList.getSelectedValue()!=null && itemList.getSelectedValue()!= null) {
					Athlete athToBuy = athleteList.getSelectedValue();
					market.BuyPlayerAndMoneyUpdater(player, athToBuy, team);
					athleteListModel.removeElement(athToBuy);
					Item itemToBuy = itemList.getSelectedValue();
					market.BuyItemAndMoneyUpdater(player, itemToBuy, team);
					athleteListModel.removeElement(itemToBuy);
					lblSuccessPurchase.setText(athToBuy.getName(athToBuy) + " and the item " + itemToBuy.getName() + " have been added");
					itemList.clearSelection();
					athleteList.clearSelection();
				}
				else if (itemList.getSelectedValue()== null) {
					Athlete athToBuy = athleteList.getSelectedValue();
					market.BuyPlayerAndMoneyUpdater(player, athToBuy, team);
					athleteListModel.removeElement(athToBuy);
					lblSuccessPurchase.setText(athToBuy.getName(athToBuy) + " has been added to your team");
					itemList.clearSelection();
					athleteList.clearSelection();
				}
				else if (athleteList.getSelectedValue()==null) {
					Item itemToBuy = itemList.getSelectedValue();
					market.BuyItemAndMoneyUpdater(player, itemToBuy, team);
					athleteListModel.removeElement(itemToBuy);
					lblSuccessPurchase.setText(itemToBuy.getName() + " has been added to your inventory");
					itemList.clearSelection();
					athleteList.clearSelection();
				}
				
				else {
					lblSuccessPurchase.setText("Select a Player and/or an Item");
				}
			}
		});
		btnBuy.setBounds(543, 433, 117, 25);
		frmTheMarket.getContentPane().add(btnBuy);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(12, 433, 117, 25);
		frmTheMarket.getContentPane().add(btnBack);
		
		JButton btnClear = new JButton("Clear Selections");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemList.clearSelection();
				athleteList.clearSelection();
				
			}
		});
		btnClear.setBounds(382, 433, 149, 25);
		frmTheMarket.getContentPane().add(btnClear);
		
		
		

		
		
		

	}
}
