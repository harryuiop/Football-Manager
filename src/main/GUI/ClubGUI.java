package main.GUI;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;


import main.LOGIC.Athlete;
import main.LOGIC.GameEnviroment;
import main.LOGIC.Market;
import main.LOGIC.Player;
import main.LOGIC.Team;

import javax.swing.JButton;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;

public class ClubGUI {

    public JFrame frmClub;
    int counter = 0;
    boolean subOn;
    ArrayList<Athlete> holder = new ArrayList<Athlete>();
    ArrayList<JButton> allButtons = new ArrayList<JButton>();
    private MatchSelectionGUI matchSelectionGUI;
    private boolean isMatchSelectCreated;

    /**
     * Create the application.
     */
    public ClubGUI(Team team, GameEnviroment game, Market market, Player player) {
        initialize(team, game, market, player, this);
        this.subOn = false;
        this.isMatchSelectCreated = false;
    }



    /**
     * Initialize the contents of the frame.
     * 
     * @param clubGUI
     */
    public void initialize(Team team, GameEnviroment game, Market market, Player player, ClubGUI clubGUI) {
    	
        frmClub = new JFrame();
        frmClub.setMinimumSize(new Dimension(700, 500));
        frmClub.getContentPane().setEnabled(false);
        frmClub.setTitle("Club");
        frmClub.setResizable(true);
        frmClub.setSize(440, 648);
        frmClub.setPreferredSize(new Dimension(700, 500));
        frmClub.setBounds(100, 100, 450, 300);
        frmClub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmClub.getContentPane().setLayout(null);
        
        
        
        JLabel lblWelcomeToThe = new JLabel("Welcome to the Clubroom");
        lblWelcomeToThe.setForeground(new Color(0, 0, 0));
        lblWelcomeToThe.setFont(new Font("Accanthis ADF Std No3", Font.BOLD, 15));
        lblWelcomeToThe.setBounds(19, 115, 241, 55);
        frmClub.getContentPane().add(lblWelcomeToThe);

        
        JLabel lblStartingLineup = new JLabel("Starting Lineup");
        lblStartingLineup.setForeground(Color.WHITE);
        lblStartingLineup.setFont(new Font("Accanthis ADF Std No3", Font.BOLD, 14));
        lblStartingLineup.setBounds(427, 234, 134, 15);
        frmClub.getContentPane().add(lblStartingLineup);

        
        JButton marketButton = new JButton("Market");
        marketButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmClub.dispose();
                game.LaunchMarketGUI(team, game, market, player);
            }
        });
        marketButton.setFont(new Font("Dialog", Font.BOLD, 14));
        marketButton.setBounds(12, 409, 162, 49);
        frmClub.getContentPane().add(marketButton);

        
        JButton selMatchButton = new JButton("Select Match");
        selMatchButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (isMatchSelectCreated) {
        			matchSelectionGUI.frmMatchSelect.setVisible(true);
        			frmClub.setVisible(false);
        		}
        		else {
            		matchSelectionGUI = game.LaunchMatchSelectionGUI(team, game, market, player, frmClub, clubGUI);
        			frmClub.setVisible(false);
            		isMatchSelectCreated = true;
        		}
        	}
        });
        selMatchButton.setFont(new Font("Dialog", Font.BOLD, 14));
        selMatchButton.setBounds(12, 360, 162, 47);
        frmClub.getContentPane().add(selMatchButton);

        
        JLabel lblCurrentWeek = new JLabel("Current Week - " + game.getCurrentWeekNum() + "/" + game.getChoosenNumWeeks());
        lblCurrentWeek.setFont(new Font("Dialog", Font.BOLD, 12));
        lblCurrentWeek.setBounds(12, 294, 168, 25);
        frmClub.getContentPane().add(lblCurrentWeek);
        

        
        DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        athleteListModel.addAll(team.getReserveName());
        athleteListModel.addAll(team.getStartingName());
        renderer.setOpaque(true); // make the cell renderer background opaque
        renderer.setBackground(Color.WHITE);

        
        JLabel lblPlayerStats = new JLabel("Select a Player to view their stats");
        lblPlayerStats.setFont(new Font("Dialog", Font.BOLD, 11));
        lblPlayerStats.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayerStats.setBounds(19, 154, 233, 147);
        frmClub.getContentPane().add(lblPlayerStats);
        									
        								
        JToggleButton subToggle = new JToggleButton("Substitution");
        subToggle.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        subToggle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SubstituionGUI sub = new SubstituionGUI(team, game, market, player);
        		sub.frmSubstitutions.setVisible(true);
        		closeClubGUI(game);
        	}
        });
       
  
        subToggle.setBounds(548, 410, 134, 49);
        frmClub.getContentPane().add(subToggle);
        
        
        Athlete p1 = team.getStartingName().get(0);
        JButton player1 = new JButton(p1.getName(p1));
        
        
        player1.setBounds(348, 259, 117, 31);
        frmClub.getContentPane().add(player1);
        if (p1.getInjuryStatus() == true) {

        	player1.setForeground(new Color(200, 0, 0));
        } else  {
        	player1.setForeground(new Color(0, 0, 0));
        }
        player1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lblPlayerStats.setText(p1.printForSelection());
                holder.add(p1);
                clubGUI.counter++;
                

            }
        });

        
        Athlete p2 = team.getStartingName().get(1);
        JButton player2 = new JButton(p2.getName(p2));        
        player2.setBounds(464, 259, 117, 31);
        frmClub.getContentPane().add(player2);
        if (p2.getInjuryStatus() == true) {
        	player2.setForeground(new Color(200, 0, 0));
        } else {
        	player2.setForeground(new Color(0, 0, 0));
        }
        player2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lblPlayerStats.setText(p2.printForSelection());
                holder.add(p2);
                clubGUI.counter++;
                

            }
        });

        
        Athlete p3 = team.getStartingName().get(2);
        JButton player3 = new JButton(p3.getName(p3));
        
        
        player3.setBounds(348, 293, 117, 29);
        frmClub.getContentPane().add(player3);
        clubGUI.counter++;
        if (p3.getInjuryStatus() == true) {
        	player3.setForeground(new Color(200, 0, 0));
        } else {
        	player3.setForeground(new Color(0, 0, 0));
        }
        player3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lblPlayerStats.setText(p3.printForSelection());
                holder.add(p3);
                

            }
        });

        
        Athlete p4 = team.getStartingName().get(3);
        JButton player4 = new JButton(p4.getName(p4));
        player4.setBounds(464, 293, 117, 29);
        frmClub.getContentPane().add(player4);
        if (p4.getInjuryStatus() == true) {
        	player4.setForeground(new Color(200, 0, 0));
        } else {
        	player4.setForeground(new Color(0, 0, 0));
        }
        player4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lblPlayerStats.setText(p4.printForSelection());
                holder.add(p4);
                clubGUI.counter++;
                

            }
        });

        Athlete p5 = team.getReserveName().get(0);
        JButton player5 = new JButton(p5.getName(p5));
        player5.setBounds(254, 420, 117, 29);
        frmClub.getContentPane().add(player5);
        if (p5.getInjuryStatus() == true) {
        	player5.setForeground(new Color(200, 0, 0));
        } else {
        	player5.setForeground(new Color(0, 0, 0));
        }
        player5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lblPlayerStats.setText(p5.printForSelection());
                holder.add(p5);
                clubGUI.counter++;
                

            }
        });
        

        Athlete p6 = team.getReserveName().get(1);
        JButton player6 = new JButton(p6.getName(p6));
        player6.setBounds(363, 420, 117, 29);
        frmClub.getContentPane().add(player6);
        if (p6.getInjuryStatus() == true) {
        	player6.setForeground(new Color(200, 0, 0));
        } else {
        	player6.setForeground(new Color(0, 0, 0));
        }
        player6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lblPlayerStats.setText(p6.printForSelection());
                holder.add(p6);
                clubGUI.counter++;
                

            }
        });
        

        Athlete p7 = team.getReserveName().get(2);
        JButton player7 = new JButton(p7.getName(p7));
        frmClub.getContentPane().add(player7);
        player7.setBounds(254, 386, 117, 29);
        if (p7.getInjuryStatus() == true) {
        	player7.setForeground(new Color(200, 0, 0));
        } else {
        	player7.setForeground(new Color(0, 0, 0));
        }
        player7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lblPlayerStats.setText(p7.printForSelection());
                holder.add(p7);
                clubGUI.counter++;
                

            }
        });

        if (team.getReserveName().size() == 4) {
	        Athlete p8 = team.getReserveName().get(3);
	        JButton player8 = new JButton(p8.getName(p8));
	        player8.setBounds(363, 386, 117, 29);
	        frmClub.getContentPane().add(player8);
	        if (p8.getInjuryStatus() == true) {
	        	player8.setForeground(new Color(200, 0, 0));
	        } else {
	        	player8.setForeground(new Color(0, 0, 0));
	        }
	        player8.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	lblPlayerStats.setText(p8.printForSelection());
	                holder.add(p8);
	                clubGUI.counter++;
	                

	        	}
	    	});
	    }
        
        JLabel reserveLabel = new JLabel("Reserves");
        reserveLabel.setForeground(Color.WHITE);
        reserveLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        reserveLabel.setBounds(335, 360, 84, 25);
        frmClub.getContentPane().add(reserveLabel);
        
        JToggleButton inventory = new JToggleButton("Inventory");
        inventory.setFont(new Font("Lucida Grande", Font.BOLD, 13));
        inventory.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		InventoryGUI invgui = new InventoryGUI(team, game, market, player);
        		invgui.frmInventory.setVisible(true);
        		closeClubGUI(game);
        	}
        });
        
        inventory.setBounds(548, 358, 134, 49);
        frmClub.getContentPane().add(inventory);
        
        JLabel moneylbl = new JLabel("Balance: ");
        moneylbl.setFont(new Font("Lucida Grande", Font.BOLD, 12));
        moneylbl.setForeground(new Color(0, 0, 0));
        moneylbl.setBounds(167, 294, 105, 20);
        frmClub.getContentPane().add(moneylbl);
        moneylbl.setText("Balance: $" + player.getMoneyBalance()+"");
        
        JLabel background = new JLabel("");
        background.setIcon(new ImageIcon(ClubGUI.class.getResource("/main/images/clubroom.jpg")));
        background.setBounds(-52, -24, 793, 538);
        frmClub.getContentPane().add(background);

      
     
    }
    public void closeClubGUI(GameEnviroment game) {
    	game.closeClubGUI(this);
    }
}

