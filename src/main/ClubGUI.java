package main;

import java.awt.Dimension;
import java.util.ArrayList;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.MenuElement;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClubGUI {

    JFrame frmClub;
    int counter = 0;
    boolean subOn;
    ArrayList<Athlete> holder = new ArrayList<Athlete>();
    ArrayList<JButton> allButtons = new ArrayList<JButton>();


    /**
     * Create the application.
     */
    public ClubGUI(Team team, GameEnviroment game, Market market, Player player) {
        initialize(team, game, market, player, this);
        this.subOn = false;
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
        lblWelcomeToThe.setBounds(27, 122, 241, 55);
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
        selMatchButton.setFont(new Font("Dialog", Font.BOLD, 14));
        selMatchButton.setBounds(12, 360, 162, 47);
        frmClub.getContentPane().add(selMatchButton);

        
        JLabel lblCurrentWeek = new JLabel("Current Week - " + game.getCurrentWeekNum() + "/" + game.getChoosenNumWeeks());
        lblCurrentWeek.setFont(new Font("Dialog", Font.PLAIN, 12));
        lblCurrentWeek.setBounds(12, 286, 168, 25);
        frmClub.getContentPane().add(lblCurrentWeek);
        

        
        DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
        DefaultListCellRenderer renderer = new DefaultListCellRenderer();
        athleteListModel.addAll(team.getReserveName());
        athleteListModel.addAll(team.getStartingName());
        renderer.setOpaque(true); // make the cell renderer background opaque
        renderer.setBackground(Color.WHITE);

        
        JLabel lblPlayerStats = new JLabel("");
        lblPlayerStats.setHorizontalAlignment(SwingConstants.CENTER);
        lblPlayerStats.setBounds(27, 162, 233, 128);
        frmClub.getContentPane().add(lblPlayerStats);
        									
        								
        JToggleButton subToggle = new JToggleButton("Substitution");
        subToggle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SubstituionGUI sub = new SubstituionGUI(team, game, market, player);
        		sub.frame.setVisible(true);
        		closeClubGUI(game);
        	}
        });
       
  
        subToggle.setBounds(548, 410, 134, 49);
        frmClub.getContentPane().add(subToggle);
        
        
        Athlete p1 = team.getStartingName().get(0);
        JButton player1 = new JButton(p1.getName(p1));
        player1.setBounds(348, 259, 117, 31);
        frmClub.getContentPane().add(player1);
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
        player3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lblPlayerStats.setText(p3.printForSelection());
                holder.add(p3);
                clubGUI.counter++;

            }
        });

        
        Athlete p4 = team.getStartingName().get(3);
        JButton player4 = new JButton(p4.getName(p4));
        player4.setBounds(464, 293, 117, 29);
        frmClub.getContentPane().add(player4);
        player4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lblPlayerStats.setText(p4.printForSelection());
                holder.add(p4);
                clubGUI.counter++;

            }
        });

        Athlete p5 = team.getReserveName().get(0);
        JButton player5 = new JButton(p5.getName(p5));
        player5.setBounds(297, 439, 117, 29);
        frmClub.getContentPane().add(player5);
        player5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lblPlayerStats.setText(p5.printForSelection());
                holder.add(p5);
                clubGUI.counter++;

            }
        });
        

        Athlete p6 = team.getReserveName().get(1);
        JButton player6 = new JButton(p6.getName(p6));
        player6.setBounds(412, 439, 117, 29);
        frmClub.getContentPane().add(player6);
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
        player7.setBounds(297, 409, 117, 29);
        player7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lblPlayerStats.setText(p7.printForSelection());
                holder.add(p7);
                clubGUI.counter++;

            }
        });

        
        Athlete p8 = team.getReserveName().get(3);
        JButton player8 = new JButton(p8.getName(p8));
        player8.setBounds(412, 409, 117, 29);
        frmClub.getContentPane().add(player8);
        player8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	lblPlayerStats.setText(p8.printForSelection());
                holder.add(p8);
                clubGUI.counter++;

            }
        });

        
        JLabel reserveLabel = new JLabel("Reserves");
        reserveLabel.setForeground(Color.WHITE);
        reserveLabel.setFont(new Font("Lucida Grande", Font.BOLD, 14));
        reserveLabel.setBounds(377, 382, 84, 25);
        frmClub.getContentPane().add(reserveLabel);

        JLabel background = new JLabel("");
        background.setIcon(new ImageIcon(ClubGUI.class.getResource("/main/images/clubroom.jpg")));
        background.setBounds(-52, -24, 793, 538);
        frmClub.getContentPane().add(background);

        JToggleButton tglbtnNewToggleButton = new JToggleButton("Info");
        tglbtnNewToggleButton.setBounds(12, 460, 162, 29);
        frmClub.getContentPane().add(tglbtnNewToggleButton);
        
        allButtons.clear();
        allButtons.add(player1);
        allButtons.add(player2);
        allButtons.add(player3);
        allButtons.add(player4);
        allButtons.add(player5);
        allButtons.add(player6);
        allButtons.add(player7);
        allButtons.add(player8);
    }
    public void closeClubGUI(GameEnviroment game) {
    	game.closeClubGUI(this);
    }
}

