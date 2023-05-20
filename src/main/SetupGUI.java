package main;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.ImageIcon;
import javax.swing.JList;


public class SetupGUI{

	JFrame frmSetupGUI;
	private JTextField textField;
	private JLabel lblPleaseEnterYou;


	/**
	 * Create the application.
	 */
	public SetupGUI(Team team, GameEnviroment game,  Market market, PotentialPlayers poplayers, Player player) {
		initialize(team, game, this, market, poplayers, player);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Team team, GameEnviroment game, SetupGUI setup, Market market, PotentialPlayers poplayers, Player player) {
		frmSetupGUI = new JFrame();
		frmSetupGUI.setSize(600, 400);
		frmSetupGUI.setBackground(new Color(255, 255, 255));
		frmSetupGUI.getContentPane().setForeground(new Color(255, 255, 255));
		frmSetupGUI.setTitle("Setup");
		frmSetupGUI.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBackground(Color.GRAY);
		textField.setBounds(247, 46, 204, 35);
		frmSetupGUI.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblPleaseEnterYou = new JLabel("Teams Name: ");
		lblPleaseEnterYou.setBounds(147, 51, 209, 24);
		frmSetupGUI.getContentPane().add(lblPleaseEnterYou);
		
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int value = slider.getValue();
				game.setChoosenNumWeeks(value);
			}
		});
		slider.setFont(new Font("Dialog", Font.BOLD, 12));
		slider.setMinorTickSpacing(5);
		slider.setPaintTrack(false);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		slider.setMinimum(5);
		slider.setMaximum(15);
		slider.setBounds(239, 120, 235, 44);
		frmSetupGUI.getContentPane().add(slider);
		
		 JLabel lblNewLabel = new JLabel("");
		 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
	        lblNewLabel.setBounds(141, 104, 333, 23);
	        frmSetupGUI.getContentPane().add(lblNewLabel);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				boolean isvalid = false;	
				isvalid = game.chooseTeamName(team, name);
				if (isvalid) {
		            team.setName(name);
		            lblNewLabel.setText("Name Updated");
		            lblNewLabel.setForeground(new Color(0, 200, 0));
		            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		        } else {
		            lblNewLabel.setForeground(new Color(139, 0, 0));
		            lblNewLabel.setText("Must be 3-15 characters and not contain special characters");
		        }
				
				if (isvalid == true && (game.getDifficulty() == 1 | game.getDifficulty() == 0)) {
					game.closeSetupGUI(team, game, setup, market, poplayers, player);
				}
				
			}
		});
		
		btnConfirm.setBounds(247, 212, 94, 16);
		frmSetupGUI.getContentPane().add(btnConfirm);
		
		JLabel lblSeasonLength = new JLabel("Season Length: ");
		lblSeasonLength.setForeground(Color.BLACK);
		lblSeasonLength.setBounds(147, 139, 209, 24);
		frmSetupGUI.getContentPane().add(lblSeasonLength);
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setBounds(156, 174, 76, 24);
		frmSetupGUI.getContentPane().add(lblDifficulty);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Amature");
		tglbtnNewToggleButton.setBounds(221, 175, 105, 25);
		frmSetupGUI.getContentPane().add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnPro = new JToggleButton("Pro");
		tglbtnPro.setBounds(338, 175, 94, 25);
		frmSetupGUI.getContentPane().add(tglbtnPro);
		
		ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(tglbtnNewToggleButton);
        buttonGroup.add(tglbtnPro);
        
        JLabel lblFootballManager = new JLabel("Football Manager");
        lblFootballManager.setFont(new Font("Dialog", Font.BOLD, 32));
        lblFootballManager.setBounds(156, 6, 332, 40);
        frmSetupGUI.getContentPane().add(lblFootballManager);
        
        JList list = new JList();
        list.setBackground(Color.GRAY);
        list.setBounds(142, 104, 332, 136);
        frmSetupGUI.getContentPane().add(list);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(SetupGUI.class.getResource("/main/images/liverpool dub.jpeg")));
        lblNewLabel_2.setBounds(6, 0, 600, 372);
        frmSetupGUI.getContentPane().add(lblNewLabel_2);
        
       
        
        
        tglbtnNewToggleButton.addActionListener(e -> {
            if (tglbtnPro.isSelected()) {
            	tglbtnNewToggleButton.setSelected(false);
            	game.setDifficulty(1);
            	
            }
        });
        tglbtnPro.addActionListener(e -> {
            if (tglbtnNewToggleButton.isSelected()) {
            	tglbtnPro.setSelected(false);
            	game.setDifficulty(2);
            }
        });
		
		
	}
}
