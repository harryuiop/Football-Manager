package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class InventoryGUI {

	JFrame frmInventory;

	/**
	 * Create the application.
	 */
	public InventoryGUI(Team team, GameEnviroment game, Market market, Player player) {
		initialize(team, game, market, player, this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, Market market, Player player, InventoryGUI gui) {
		frmInventory = new JFrame();
		frmInventory.getContentPane().setBackground(Color.GRAY);
		frmInventory.setTitle("Inventory");
		frmInventory.setBounds(100, 100, 652, 304);
		frmInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventory.getContentPane().setLayout(null);
		
		
		JLabel itemInfo = new JLabel("");
		itemInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		itemInfo.setBounds(453, -41, 200, 264);
		frmInventory.getContentPane().add(itemInfo);
		
		
		JLabel playerStats = new JLabel("");
		playerStats.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		playerStats.setBounds(142, 24, 200, 223);
		frmInventory.getContentPane().add(playerStats);
		
		
		DefaultListModel<Item> items = new DefaultListModel<Item>();
		JList itemJlist = new JList(items);
		itemJlist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Item item = (Item) itemJlist.getSelectedValue();
				if (item != null) {
					itemInfo.setText(item.printForSelection());
			}
		}		
	});
		
		
		itemJlist.setBounds(317, 36, 124, 234);
		frmInventory.getContentPane().add(itemJlist);
		itemJlist.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		itemJlist.setForeground(Color.DARK_GRAY);
		itemJlist.setBackground(Color.LIGHT_GRAY);
		items.addAll(player.getInventory());
		itemJlist.setFont(new Font("Dialog", Font.BOLD, 15));
		
		DefaultListModel<Athlete> athletes = new DefaultListModel<Athlete>();
		JList playerJlist = new JList(athletes);
		playerJlist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Athlete choosen = (Athlete) playerJlist.getSelectedValue();
				if (choosen != null) {
					playerStats.setText(choosen.printForSelection());
			}
		}
	});
		
		
		playerJlist.setBounds(6, 36, 124, 234);
		frmInventory.getContentPane().add(playerJlist);
		playerJlist.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		playerJlist.setForeground(Color.DARK_GRAY);
		playerJlist.setBackground(Color.LIGHT_GRAY);
		athletes.addAll(team.getStartingName());
		athletes.addAll(team.getReserveName());
		playerJlist.setFont(new Font("Dialog", Font.BOLD, 15));
		
		
		JLabel itemSaleText = new JLabel("");
		itemSaleText.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		itemSaleText.setBounds(411, 6, 235, 29);
		frmInventory.getContentPane().add(itemSaleText);
		
		
		JButton sellButton = new JButton("Sell Item");
		sellButton.setBounds(546, 202, 100, 29);
		frmInventory.getContentPane().add(sellButton);
		sellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item item = (Item) itemJlist.getSelectedValue();
				if (item != null) {
					player.sellItem(item, items.indexOf(item));
					items.clear();
					items.addAll(player.getInventory());
					itemInfo.setText("");
					itemSaleText.setText("You have sold " + item.getName() + " For $" + item.getSellBackPriceprivate());
					
				}
			}
		});
		
		
		JButton applyButton = new JButton("Apply");
		applyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete choosen = (Athlete) playerJlist.getSelectedValue();
				Item item = (Item) itemJlist.getSelectedValue();
				if (item != null && choosen != null) {
					player.useItem(choosen, item);
					player.removeItem(items.indexOf(item));
					game.LaunchClubGUI(team, game, market, player);
					close();
				} else {
					
				}
			}
		});
		applyButton.setBounds(546, 241, 100, 29);
		frmInventory.getContentPane().add(applyButton);
		
	
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.LaunchClubGUI(team, game, market, player);
				close();		
			}
		});
		btnBack.setBounds(443, 241, 100, 29);
		frmInventory.getContentPane().add(btnBack);
		
		JLabel lblPlayers = new JLabel("Players");
		lblPlayers.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblPlayers.setBounds(39, 8, 61, 16);
		frmInventory.getContentPane().add(lblPlayers);
		
		JLabel lblNewLabel = new JLabel("Items");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel.setBounds(357, 8, 61, 16);
		frmInventory.getContentPane().add(lblNewLabel);
		

		
		
}
	
	public void close() {
		this.frmInventory.dispose();
	}
	
}
