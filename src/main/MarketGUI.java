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
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListModel;

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
		frmTheMarket.setBounds(100, 100, 818, 710);
		frmTheMarket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheMarket.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Market");
		lblWelcomeToThe.setBounds(317, 12, 181, 15);
		frmTheMarket.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblCartAmount = new JLabel("Cart Amount: $0");
		lblCartAmount.setBounds(86, 513, 136, 15);
		frmTheMarket.getContentPane().add(lblCartAmount);
		
		JLabel lblSuccessPurchase = new JLabel("");
		lblSuccessPurchase.setBounds(12, 577, 531, 25);
		frmTheMarket.getContentPane().add(lblSuccessPurchase);
		
		JLabel lblAvailableMoney = new JLabel("Available Money: $" + player.getMoneyBalance());
		lblAvailableMoney.setBounds(329, 39, 198, 15);
		frmTheMarket.getContentPane().add(lblAvailableMoney);
		
		JLabel lblItems = new JLabel("Items:");
		lblItems.setBounds(23, 348, 70, 15);
		frmTheMarket.getContentPane().add(lblItems);
		
		JLabel lblPlayers = new JLabel("Players:");
		lblPlayers.setBounds(23, 85, 70, 15);
		frmTheMarket.getContentPane().add(lblPlayers);
		
		JLabel lblItemStats = new JLabel("");
		lblItemStats.setBounds(266, 348, 215, 130);
		frmTheMarket.getContentPane().add(lblItemStats);
		
		JLabel lblStartingPlayers = new JLabel("Starters:");
		lblStartingPlayers.setBounds(552, 85, 70, 15);
		frmTheMarket.getContentPane().add(lblStartingPlayers);
		
		JLabel lblReservePlayers = new JLabel("Reserves:");
		lblReservePlayers.setBounds(552, 224, 80, 15);
		frmTheMarket.getContentPane().add(lblReservePlayers);
		
		JLabel lblTeamAthleteStats = new JLabel("");
		lblTeamAthleteStats.setBounds(562, 364, 215, 130);
		frmTheMarket.getContentPane().add(lblTeamAthleteStats);
		
		JLabel lblAthleteStats = new JLabel("");
		lblAthleteStats.setBounds(266, 109, 215, 130);
		frmTheMarket.getContentPane().add(lblAthleteStats);
		
		
		DefaultListModel<Item> itemListModel = new DefaultListModel<>();
		itemListModel.addAll(items);
		JList<Item> itemList = new JList<>(itemListModel);
		itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		itemList.setBounds(23, 375, 225, 86);
		frmTheMarket.getContentPane().add(itemList);
		itemList.getSelectedValue();
		
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<>();
		JList<Athlete> athleteList = new JList<>(athleteListModel);
		athleteListModel.addAll(athletes);
		athleteList.setBounds(23, 112, 225, 207);
		frmTheMarket.getContentPane().add(athleteList);
		athleteList.getSelectedValue();
		
		DefaultListModel<Athlete> startingPlayerTeamListModel = new DefaultListModel<>();
		JList<Athlete> startingAthleteList = new JList<Athlete>(startingPlayerTeamListModel);
		startingPlayerTeamListModel.addAll(team.getStartingName());
		startingAthleteList.setBounds(552, 112, 225, 100);
		frmTheMarket.getContentPane().add(startingAthleteList);
		startingAthleteList.getSelectedValue();
		
		DefaultListModel<Athlete> reservePlayerTeamListModel = new DefaultListModel<>();
		JList<Athlete> reserveAthleteList = new JList<Athlete>(reservePlayerTeamListModel);
		reservePlayerTeamListModel.addAll(team.getReserveName());

		reserveAthleteList.setBounds(552, 253, 225, 100);
		frmTheMarket.getContentPane().add(reserveAthleteList);
		
		
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
		
		startingAthleteList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Athlete ath = startingAthleteList.getSelectedValue();
				if (ath != null) {
					lblTeamAthleteStats.setText(ath.printForSelection());
					reserveAthleteList.clearSelection();
				}
			}
		});
		
		reserveAthleteList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Athlete ath = reserveAthleteList.getSelectedValue();
				if (ath != null) {
					lblTeamAthleteStats.setText(ath.printForSelection());
					startingAthleteList.clearSelection();

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
					if(team.getStartingName().size() == 4 && team.getReserveName().size() == 4) {
						lblSuccessPurchase.setText("You have a full team, sell a player in order to buy another");
					}
					else {
						if(team.getStartingName().size() < 4){
							market.BuyPlayerAndMoneyUpdater(player, athToBuy, team, false);
							startingPlayerTeamListModel.addElement(athToBuy);
						}
						else {
							market.BuyPlayerAndMoneyUpdater(player, athToBuy, team, true);
							reservePlayerTeamListModel.addElement(athToBuy);
						}
						Item itemToBuy = itemList.getSelectedValue();
						market.BuyItemAndMoneyUpdater(player, itemToBuy, team);
						athleteListModel.removeElement(itemToBuy);
						lblSuccessPurchase.setText(athToBuy.getName(athToBuy) + " and the item " + itemToBuy.getName() + " have been added");
						athleteListModel.removeElement(athToBuy);
						lblAvailableMoney.setText("Available Money: $" + player.getMoneyBalance());
					}


				}
				
				
				else if (athleteList.getSelectedValue()!=null) {
					Athlete athToBuy = athleteList.getSelectedValue();
					
					if(team.getStartingName().size() == 4 && team.getReserveName().size() == 4) {
						lblSuccessPurchase.setText("You have a full team, sell a player in order to buy another");
					}
					else {
						if(team.getStartingName().size() < 4){
							market.BuyPlayerAndMoneyUpdater(player, athToBuy, team, false);
							startingPlayerTeamListModel.addElement(athToBuy);
						}
						else {
							market.BuyPlayerAndMoneyUpdater(player, athToBuy, team, true);
							reservePlayerTeamListModel.addElement(athToBuy);
						}

						athleteListModel.removeElement(athToBuy);
						lblSuccessPurchase.setText(athToBuy.getName(athToBuy) + " has been added to your team");
						lblAvailableMoney.setText("Available Money: $" + player.getMoneyBalance());
					}

				}
				else if (itemList.getSelectedValue()!= null) {
					Item itemToBuy = itemList.getSelectedValue();
					market.BuyItemAndMoneyUpdater(player, itemToBuy, team);
					athleteListModel.removeElement(itemToBuy);
					lblSuccessPurchase.setText(itemToBuy.getName() + " has been added to your inventory");
					lblAvailableMoney.setText("Available Money: $" + player.getMoneyBalance());
				}
				else {
					lblSuccessPurchase.setText("Select a Player and/or an Item");
				}
				
				athleteList.clearSelection();
				itemList.clearSelection();
				lblItemStats.setText("");
				lblAthleteStats.setText("");
				lblCartAmount.setText("Cart Amount: $0");
				lblAvailableMoney.setText("Available Money: $" + player.getMoneyBalance());
			}
		});
		btnBuy.setBounds(86, 540, 117, 25);
		frmTheMarket.getContentPane().add(btnBuy);
		
		
		
		JButton btnSell = new JButton("Sell");
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (startingAthleteList.getSelectedValue()!=null) {
					Athlete athToSell = startingAthleteList.getSelectedValue();
					lblSuccessPurchase.setText(athToSell.getName(athToSell) + " has been sold from your team");
					market.SellPlayerAndMoneyUpdater(player, athToSell, team);
					startingPlayerTeamListModel.removeElement(athToSell);
					startingAthleteList.clearSelection();
					lblAvailableMoney.setText("Available Money: $" + player.getMoneyBalance());
					lblTeamAthleteStats.setText("");
				}
				else if (reserveAthleteList.getSelectedValue()!=null) {
					Athlete athToSell = reserveAthleteList.getSelectedValue();
					lblSuccessPurchase.setText(athToSell.getName(athToSell) + " has been sold from your team");
					market.SellPlayerAndMoneyUpdater(player, athToSell, team);
					reservePlayerTeamListModel.removeElement(athToSell);
					reserveAthleteList.clearSelection();
					lblAvailableMoney.setText("Available Money: $" + player.getMoneyBalance());
					lblTeamAthleteStats.setText("");
				}
				else {
					lblSuccessPurchase.setText("No player selected to sell");
				}
			}
		});
		btnSell.setBounds(604, 540, 117, 25);
		frmTheMarket.getContentPane().add(btnSell);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (team.getStartingName().size() < 4 || team.getReserveName().size() < 4) {
					JOptionPane.showMessageDialog(frmTheMarket, "Your team is not full! Buy players to fill your team");
				}
				else {
					frmTheMarket.dispose();
					game.LaunchClubGUI(team, game, market, player);
				}
			}
		});
		btnBack.setBounds(12, 645, 117, 25);
		frmTheMarket.getContentPane().add(btnBack);
		
		JButton btnClear = new JButton("Clear Selections");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemList.clearSelection();
				athleteList.clearSelection();
				startingAthleteList.clearSelection();
				reserveAthleteList.clearSelection();
				lblItemStats.setText("");
				lblAthleteStats.setText("");
				lblTeamAthleteStats.setText("");
				
			}
		});
		btnClear.setBounds(160, 645, 149, 25);
		frmTheMarket.getContentPane().add(btnClear);
		
		JLabel lblSellplayer = new JLabel("Sell:");
		lblSellplayer.setBounds(646, 49, 98, 15);
		frmTheMarket.getContentPane().add(lblSellplayer);
		

		
		JLabel lblBuyLabel = new JLabel("Buy:");
		lblBuyLabel.setBounds(103, 49, 70, 15);
		frmTheMarket.getContentPane().add(lblBuyLabel);
		

		
		
		
		

		
		
		

	}
}
