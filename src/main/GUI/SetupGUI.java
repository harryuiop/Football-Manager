package main.GUI;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import main.LOGIC.GameEnviroment;
import main.LOGIC.Market;
import main.LOGIC.Player;
import main.LOGIC.PotentialPlayers;
import main.LOGIC.Team;

import javax.swing.event.ChangeEvent;
import javax.swing.ImageIcon;
import javax.swing.JList;


public class SetupGUI{

	public JFrame frmSetupGUI;
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
		lblPleaseEnterYou.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPleaseEnterYou.setBounds(147, 51, 209, 24);
		frmSetupGUI.getContentPane().add(lblPleaseEnterYou);
		
		JSlider slider = new JSlider();
		slider.setBackground(Color.GRAY);
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
		slider.setBounds(229, 120, 251, 44);
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
		            
		        } else {
		            lblNewLabel.setForeground(new Color(139, 0, 0));
		            lblNewLabel.setText("Must be 3-15 characters and not contain special characters");
		        }
				
				
				if (isvalid == true && game.getDifficulty() == 1 | game.getDifficulty() == 2) {
					game.closeSetupGUI(team, game, setup, market, poplayers, player);
				} else if (game.getDifficulty() == 0) {
					lblNewLabel.setForeground(new Color(139, 0, 0));
					lblNewLabel.setText("Choose a difficulty");
				}
				
			}
		});
		
		btnConfirm.setBounds(247, 213, 109, 15);
		frmSetupGUI.getContentPane().add(btnConfirm);
		
		JLabel lblSeasonLength = new JLabel("Season Length: ");
		lblSeasonLength.setFont(new Font("Dialog", Font.BOLD, 11));
		lblSeasonLength.setForeground(new Color(0, 0, 0));
		lblSeasonLength.setBounds(129, 138, 209, 24);
		frmSetupGUI.getContentPane().add(lblSeasonLength);
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setForeground(new Color(0, 0, 0));
		lblDifficulty.setFont(new Font("Dialog", Font.BOLD, 11));
		lblDifficulty.setBounds(168, 176, 76, 24);
		frmSetupGUI.getContentPane().add(lblDifficulty);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Amature");
		tglbtnNewToggleButton.setBounds(247, 176, 105, 25);
		frmSetupGUI.getContentPane().add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnPro = new JToggleButton("Pro");
		tglbtnPro.setBounds(367, 175, 94, 25);
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
        list.setBounds(129, 104, 360, 136);
        frmSetupGUI.getContentPane().add(list);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(SetupGUI.class.getResource("/main/images/liverpool dub.jpeg")));
        lblNewLabel_2.setBounds(6, 0, 600, 372);
        frmSetupGUI.getContentPane().add(lblNewLabel_2);
        
      
        tglbtnNewToggleButton.addActionListener(e -> {
        	game.setDifficulty(1);
            if (tglbtnPro.isSelected()) {
            	tglbtnNewToggleButton.setSelected(false);
            	
            }
        });
        tglbtnPro.addActionListener(e -> {
        	game.setDifficulty(2);
            if (tglbtnNewToggleButton.isSelected()) {
            	tglbtnPro.setSelected(false);
            }
        });
		
		
	}
}
