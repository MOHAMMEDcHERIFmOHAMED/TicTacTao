import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

import javax.swing.*;

public class TicTac implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JButton[] btns = new JButton[9] ;
    JPanel btnpanel = new JPanel() ;
    JPanel titlepanel = new JPanel() ;
    JLabel textlabel = new JLabel() ;
    boolean playerTurn ;


    public TicTac(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

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

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if(e.getSource() == btns[i]){
                if(playerTurn){
                    if(Objects.equals(btns[i].getText(), "")){
                        btns[i].setText("X");
                         btns[i].setForeground(Color.green);
                        playerTurn = false;
                        textlabel.setText("O TURN ");
                        checkWinner();
                    }
                }else{
                    if(Objects.equals(btns[i].getText(), "")){
                        btns[i].setText("O");
                        playerTurn = true;
                        btns[i].setForeground(Color.yellow);
                        textlabel.setText("X TURN ");
                        checkWinner();
                    }
                }
            }

        }
    }

    public void firstTurn(){
        if(random.nextInt(2)==0){
            System.out.println("X turn");
            playerTurn = true;
            textlabel.setText("X TURN");
        }else{
            playerTurn = false;
            System.out.println("O turn");
            textlabel.setText("O TURN");

        }

    }

    public void checkWinner(){
        if( btns[0].getText().equals("X") && btns[1].getText().equals("X") && btns[2].getText().equals("X") )
            xWins(0,1,2);
        if( btns[0].getText().equals("X") && btns[3].getText().equals("X") && btns[6].getText().equals("X") )
            xWins(0,3,6);
        if( btns[0].getText().equals("X") && btns[4].getText().equals("X") && btns[8].getText().equals("X") )
            xWins(0,4,8);
        if( btns[1].getText().equals("X") && btns[4].getText().equals("X") && btns[7].getText().equals("X") )
            xWins(1,4,7);
        if( btns[2].getText().equals("X") && btns[5].getText().equals("X") && btns[8].getText().equals("X") )
            xWins(2,5,8);
        if( btns[6].getText().equals("X") && btns[7].getText().equals("X") && btns[8].getText().equals("X") )
            xWins(6,7,8);
        if( btns[3].getText().equals("X") && btns[4].getText().equals("X") && btns[5].getText().equals("X") )
            xWins(3,4,5);
        if( btns[2].getText().equals("X") && btns[4].getText().equals("X") && btns[6].getText().equals("X") )
            xWins(2,4,6);
// ___________ O CHECKING FOR WIN
        if( btns[0].getText().equals("O") && btns[1].getText().equals("O") && btns[2].getText().equals("O") )
            oWins(0,1,2);
        if( btns[0].getText().equals("O") && btns[3].getText().equals("O") && btns[6].getText().equals("O") )
            oWins(0,3,6);
        if( btns[0].getText().equals("O") && btns[4].getText().equals("O") && btns[8].getText().equals("O") )
            oWins(0,4,8);
        if( btns[1].getText().equals("O") && btns[4].getText().equals("O") && btns[7].getText().equals("O") )
            oWins(1,4,7);
        if( btns[2].getText().equals("O") && btns[5].getText().equals("O") && btns[8].getText().equals("O") )
            oWins(2,5,8);
        if( btns[6].getText().equals("O") && btns[7].getText().equals("O") && btns[8].getText().equals("O") )
            oWins(6,7,8);
        if( btns[3].getText().equals("O") && btns[4].getText().equals("O") && btns[5].getText().equals("O") )
            oWins(3,4,5);
        if( btns[2].getText().equals("O") && btns[4].getText().equals("O") && btns[6].getText().equals("O") )
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
        textlabel.setText("X WON ");
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
        textlabel.setText("Y WON ");
        // this is the added call
        Alert playAgain = new Alert(frame) ;

    }
}
