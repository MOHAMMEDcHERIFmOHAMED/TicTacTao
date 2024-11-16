import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Settings   {
     JTextField player1Symbole ;
     JTextField player2Symbole ;
    JMenuBar menuBar ;
    JMenu menu ;
    JMenuItem Setting ;

   
// Create components 
    public Settings(){
        menu = new JMenu("Menu") ;
         menuBar = new JMenuBar() ;
         Setting = new JMenuItem("Settings") ;

         menu.add(Setting);
         menuBar.add(menu);

    }
    // Method to Show Settings ( frame  ) ;
    public void showSettings(){
        JFrame frame = new JFrame() ;
        frame.setTitle("Settings");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JLabel player1Label = new JLabel("ENTER HERE A SYMBOL ");
        player1Label.setForeground(Color.BLUE);
        player1Symbole = new JTextField() ;
        player1Symbole.setForeground(Color.RED);
        frame.add(player1Label);
        frame.add(player1Symbole);
        


        System.out.println("this is from Settings class");
    }

    public JMenuBar  getMenuBar(){
        return menuBar ;
    }
    public void addSettingsListener(ActionListener listener) {
        Setting.addActionListener(listener);
    }
}