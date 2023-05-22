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
		frmInventory.setTitle("Inventory");
		frmInventory.setBounds(100, 100, 652, 304);
		frmInventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmInventory.getContentPane().setLayout(null);
		
		
		JLabel itemInfo = new JLabel("");
		itemInfo.setBounds(139, 6, 146, 264);
		frmInventory.getContentPane().add(itemInfo);
		
		
		JLabel playerStats = new JLabel("");
		playerStats.setBounds(433, 6, 200, 223);
		frmInventory.getContentPane().add(playerStats);
		
		
		DefaultListModel<Item> items = new DefaultListModel<Item>();
		JList itemJlist = new JList(items);
		itemJlist.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
            	itemInfo.setText(itemJlist.getSelectedValue() + "");
			}
		});
		
		
		itemJlist.setBounds(6, 6, 124, 264);
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
            	playerStats.setText(playerJlist.getSelectedValue()+ "");
			}
		});
		
		
		playerJlist.setBounds(297, 6, 124, 264);
		frmInventory.getContentPane().add(playerJlist);
		playerJlist.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		playerJlist.setForeground(Color.DARK_GRAY);
		playerJlist.setBackground(Color.LIGHT_GRAY);
		athletes.addAll(team.getStartingName());
		athletes.addAll(team.getReserveName());
		playerJlist.setFont(new Font("Dialog", Font.BOLD, 15));
		
		
		JButton applyButton = new JButton("Apply");
		applyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.LaunchClubGUI(team, game, market, player);
				gui.frmInventory.dispose();
			}
		});
		applyButton.setBounds(546, 241, 100, 29);
		frmInventory.getContentPane().add(applyButton);
		
	}
	
	public void close() {
		this.frmInventory.dispose();
	}
	
}
