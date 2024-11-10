// import java.awt.event.ActionListener ;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Alert   {
    public  Alert(JFrame frame){
        
        int choice =   JOptionPane.showConfirmDialog(null, "do you want to play again", "play again ?",JOptionPane.YES_NO_CANCEL_OPTION);
        
        if(choice == 0 ){
            frame.dispose();
            TicTac newgame = new TicTac() ;
            System.out.println("new game ");
        }else{
            frame.dispose();
        }

    }
}
