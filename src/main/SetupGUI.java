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
		textField.setBounds(229, 111, 204, 35);
		frmSetupGUI.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblPleaseEnterYou = new JLabel("Teams Name: ");
		lblPleaseEnterYou.setBounds(136, 116, 209, 24);
		frmSetupGUI.getContentPane().add(lblPleaseEnterYou);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(192, 28, 40));
		lblNewLabel.setBounds(85, 140, 452, 35);
		frmSetupGUI.getContentPane().add(lblNewLabel);
		
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
		slider.setBounds(229, 158, 235, 44);
		frmSetupGUI.getContentPane().add(slider);
		
		
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
				
				if (isvalid == true && game.getDifficulty() == 1 | game.getDifficulty() == 0) {
					game.closeSetupGUI(team, game, setup, market, poplayers, player);
				}
				
			}
		});
		
		btnConfirm.setBounds(240, 313, 94, 16);
		frmSetupGUI.getContentPane().add(btnConfirm);
		
		JLabel lblSeasonLength = new JLabel("Season Length: ");
		lblSeasonLength.setBounds(111, 180, 209, 24);
		frmSetupGUI.getContentPane().add(lblSeasonLength);
		
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setBounds(161, 225, 76, 24);
		frmSetupGUI.getContentPane().add(lblDifficulty);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Amature");
		tglbtnNewToggleButton.setBounds(240, 225, 105, 25);
		frmSetupGUI.getContentPane().add(tglbtnNewToggleButton);
		
		JToggleButton tglbtnPro = new JToggleButton("Pro");
		tglbtnPro.setBounds(356, 224, 94, 25);
		frmSetupGUI.getContentPane().add(tglbtnPro);
		
		ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(tglbtnNewToggleButton);
        buttonGroup.add(tglbtnPro);
        
        JLabel lblFootballManager = new JLabel("Football Manager");
        lblFootballManager.setFont(new Font("Dialog", Font.BOLD, 32));
        lblFootballManager.setBounds(136, 34, 332, 40);
        frmSetupGUI.getContentPane().add(lblFootballManager);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBounds(12, 0, 70, 15);
        frmSetupGUI.getContentPane().add(lblNewLabel_1);
        
        
        tglbtnNewToggleButton.addActionListener(e -> {
            if (tglbtnPro.isSelected()) {
            	tglbtnNewToggleButton.setSelected(false);
            	game.setDifficulty(1);
            	
            }
        });
        tglbtnPro.addActionListener(e -> {
            if (tglbtnNewToggleButton.isSelected()) {
            	tglbtnPro.setSelected(false);
            	game.setDifficulty(0);
            }
        });
		
		
	}
}