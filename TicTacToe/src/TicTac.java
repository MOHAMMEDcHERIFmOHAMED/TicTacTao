import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

import javax.swing.*;

public class TicTac implements ActionListener {
    Settings setting = new Settings() ;

    Random random = new Random();
    JFrame frame = new JFrame();
    JButton[] btns = new JButton[9] ;
    JPanel btnpanel = new JPanel() ;
    JPanel titlepanel = new JPanel() ;
    JLabel textlabel = new JLabel() ;
    boolean playerTurn ;
    String  player_one_sign  = "@" ;
    String  player_two_sign  = "#" ;
    String winner_color  = "red" ;
    String player_one_color = "yellow";
    String player_two_color = "Green";
    JMenuBar menuBar ;
    JMenu menu ;
    JMenuItem Setting ;

    
    public TicTac(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        // ____________
        // menu = new JMenu() ;
        // menuBar = new JMenuBar() ;
        // Setting = new JMenuItem() ;

        // menu.add(Setting);
        // menuBar.add(menu);
        // frame.setMenuBar(menuBar);
        // ____________

        textlabel.setBackground(Color.blue);
        textlabel.setForeground(Color.red);
        textlabel.setHorizontalAlignment(JLabel.CENTER);
        textlabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        textlabel.setText("THE GHOST");
        textlabel.setOpaque(true);
        textlabel.setPreferredSize(new Dimension(800, 100)); // Set the preferred width and height


        titlepanel.setBackground(Color.green);
        titlepanel.setLayout(new BorderLayout() );
        titlepanel.setBounds(0, 0, 800, 400);

        btnpanel.setBackground(Color.pink);
        btnpanel.setLayout(new GridLayout(3, 3));  // Use GridLayout to divide into a 3x3 grid

        for (int i = 0; i < 9; i++) {
            btns[i] = new JButton() ;
            btnpanel.add(btns[i]) ;
            btns[i].setFont(new Font("Times New Roman", Font.BOLD, 100));
            btns[i].setFocusPainted(false);
            btns[i].addActionListener(this);

        }

        titlepanel.add(textlabel);
        frame.add(titlepanel, BorderLayout.NORTH);
        frame.add(btnpanel);
                // Add the menu bar from the Settings class
                frame.setJMenuBar(setting.getMenuBar());

                // Add a listener for the Settings menu item
                setting.addSettingsListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Handle the settings menu item click event
                        System.out.println("Settings clicked!");
                        setting.showSettings() ;
                        // You can add code here to open a settings window or modify game settings
                    }
                });

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if(e.getSource() == btns[i]){
                if(playerTurn){
                    if(Objects.equals(btns[i].getText(), "")){
                        btns[i].setText(player_one_sign);
                         btns[i].setForeground(Color.green);
                        playerTurn = false;
                        textlabel.setText(player_two_sign + " TURN ");
                        checkWinner();
                    }
                }else{
                    if(Objects.equals(btns[i].getText(), "")){
                        btns[i].setText(player_two_sign);
                        playerTurn = true;
                        btns[i].setForeground(Color.yellow);
                        textlabel.setText(player_one_sign + " TURN ");
                        checkWinner();
                    }
                }
            }

        }
    }

    public void firstTurn(){
        if(random.nextInt(2)==0){
            System.out.println(player_one_sign + " turn");
            playerTurn = true;
            textlabel.setText(player_one_sign +" TURN");
        }else{
            playerTurn = false;
            System.out.println(player_two_sign + " turn");
            textlabel.setText(player_two_sign + " TURN");

        }

    }

    public void checkWinner(){
        if( btns[0].getText().equals(player_one_sign) && btns[1].getText().equals(player_one_sign) && btns[2].getText().equals(player_one_sign) )
            xWins(0,1,2);
        if( btns[0].getText().equals(player_one_sign) && btns[3].getText().equals(player_one_sign) && btns[6].getText().equals(player_one_sign) )
            xWins(0,3,6);
        if( btns[0].getText().equals(player_one_sign) && btns[4].getText().equals(player_one_sign) && btns[8].getText().equals(player_one_sign) )
            xWins(0,4,8);
        if( btns[1].getText().equals(player_one_sign) && btns[4].getText().equals(player_one_sign) && btns[7].getText().equals(player_one_sign) )
            xWins(1,4,7);
        if( btns[2].getText().equals(player_one_sign) && btns[5].getText().equals(player_one_sign) && btns[8].getText().equals(player_one_sign) )
            xWins(2,5,8);
        if( btns[6].getText().equals(player_one_sign) && btns[7].getText().equals(player_one_sign) && btns[8].getText().equals(player_one_sign) )
            xWins(6,7,8);
        if( btns[3].getText().equals(player_one_sign) && btns[4].getText().equals(player_one_sign) && btns[5].getText().equals(player_one_sign) )
            xWins(3,4,5);
        if( btns[2].getText().equals(player_one_sign) && btns[4].getText().equals(player_one_sign) && btns[6].getText().equals(player_one_sign) )
            xWins(2,4,6);
// ___________ O CHECKING FOR WIN
        if( btns[0].getText().equals(player_two_sign) && btns[1].getText().equals(player_two_sign) && btns[2].getText().equals(player_two_sign) )
            oWins(0,1,2);
        if( btns[0].getText().equals(player_two_sign) && btns[3].getText().equals(player_two_sign) && btns[6].getText().equals(player_two_sign) )
            oWins(0,3,6);
        if( btns[0].getText().equals(player_two_sign) && btns[4].getText().equals(player_two_sign) && btns[8].getText().equals(player_two_sign) )
            oWins(0,4,8);
        if( btns[1].getText().equals(player_two_sign) && btns[4].getText().equals(player_two_sign) && btns[7].getText().equals(player_two_sign) )
            oWins(1,4,7);
        if( btns[2].getText().equals(player_two_sign) && btns[5].getText().equals(player_two_sign) && btns[8].getText().equals(player_two_sign) )
            oWins(2,5,8);
        if( btns[6].getText().equals(player_two_sign) && btns[7].getText().equals(player_two_sign) && btns[8].getText().equals(player_two_sign) )
            oWins(6,7,8);
        if( btns[3].getText().equals(player_two_sign) && btns[4].getText().equals(player_two_sign) && btns[5].getText().equals(player_two_sign) )
            oWins(3,4,5);
        if( btns[2].getText().equals(player_two_sign) && btns[4].getText().equals(player_two_sign) && btns[6].getText().equals(player_two_sign) )
            oWins(2,4,6);

    }
// _____________ this function updated 
    public void xWins(int x , int y , int z){
        System.out.println(x +" "+ " " + y +" " + z);
        btns[x].setBackground(Color.red);
        btns[y].setBackground(Color.red);
        btns[z].setBackground(Color.red);
        for (int i = 0; i < 9; i++) {
            btns[i].setEnabled(false);
        }
        textlabel.setText(player_one_sign + " WON ");
        // this is the added call
        Alert playAgain = new Alert(frame) ;
    }
// _____________ this function updated 

    public void oWins(int x , int y , int z){
        System.out.println(x +" "+ " " + y +" " + z);
        btns[x].setBackground(Color.red);
        btns[y].setBackground(Color.red);
        btns[z].setBackground(Color.red);
        for (int i = 0; i < 9; i++) {
            btns[i].setEnabled(false);
        }
        textlabel.setText(player_two_sign + " WON ");
        // this is the added call
        Alert playAgain = new Alert(frame) ;

    }
}

