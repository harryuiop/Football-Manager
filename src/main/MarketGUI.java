package main;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class MarketGUI {

	JFrame frmTheMarket;
	
	private ArrayList<Item> items = new ArrayList<>();
	private ArrayList<Athlete> athletes = new ArrayList<>();

	/**
	 * Create the application.
	 */
	public MarketGUI(Team team, GameEnviroment game, Market market, Player player) {
		items = market.getCatalog();
		athletes = market.getWavierList();
		initialize(team, game, market, this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, Market market, MarketGUI marketGUI) {
		frmTheMarket = new JFrame();
		frmTheMarket.setTitle("The Market");
		frmTheMarket.setMinimumSize(new Dimension(700,500));
		frmTheMarket.setBounds(100, 100, 600, 400);
		frmTheMarket.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTheMarket.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Market");
		lblWelcomeToThe.setBounds(205, 12, 181, 15);
		frmTheMarket.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblItems = new JLabel("Items:");
		lblItems.setBounds(100, 62, 70, 15);
		frmTheMarket.getContentPane().add(lblItems);
		
		JLabel lblPlayers = new JLabel("Players:");
		lblPlayers.setBounds(412, 62, 70, 15);
		frmTheMarket.getContentPane().add(lblPlayers);
		
		DefaultListModel<Item> itemListModel = new DefaultListModel<>();
		itemListModel.addAll(items);
		
		JList<Item> itemList = new JList<>(itemListModel);
		itemList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		itemList.setBounds(62, 250, 123, -159);
		frmTheMarket.getContentPane().add(itemList);
		
		itemList.getSelectedValue();
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<>();
		athleteListModel.addAll(athletes);
		
		JList<Athlete> athleteList = new JList<>(athleteListModel);
		athleteList.setBounds(380, 85, 123, -159);
		frmTheMarket.getContentPane().add(athleteList);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.setBounds(239, 333, 117, 25);
		frmTheMarket.getContentPane().add(btnBuy);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(12, 333, 117, 25);
		frmTheMarket.getContentPane().add(btnBack);
		
		JLabel lblCartAmount = new JLabel("Cart Amount: $0");
		lblCartAmount.setBounds(239, 306, 136, 15);
		frmTheMarket.getContentPane().add(lblCartAmount);
		

	}
}
