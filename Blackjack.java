import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Blackjack
{
    private int dealerCards = (int)((Math.random())*21);
    private int playerCards = (int)((Math.random())*21);
    private JLabel score1 = new JLabel("The dealer has "+dealerCards);
    private JLabel score2 = new JLabel("You have "+playerCards);
    private JFrame window = new JFrame("Game");
    public Blackjack()
    {
        JLabel dealer = new JLabel("Would you like to hit or stay?");
        
        JButton hit = new JButton(new AbstractAction("Hit"){
        @Override
        public void actionPerformed(ActionEvent e){
            playerCards += (int)((Math.random())*15);
            score2.setText("You have "+playerCards);
            if(dealerCards != 21){
                dealerCards += (int)((Math.random())*10);
                score1.setText("The dealer has "+dealerCards);
            }
            if(dealerCards > 21){
                System.out.println("The dealer went bust, you won!");
                System.exit(0);
            }
            if(playerCards > 21){
                System.out.println("You went bust! Game Over.");
                System.exit(0);
            }
           }
        });
        JButton stay = new JButton(new AbstractAction("Stay"){
            @Override
          public void actionPerformed(ActionEvent e){
            if(dealerCards != 21){
              dealerCards += (int)((Math.random())*14);
              score1.setText("The dealer has "+dealerCards);
            }
            if(dealerCards > 21){
                System.out.println("The dealer went bust, you won!");
                System.exit(0);
            }
          } 
        });
        
        JPanel board = new JPanel();
        board.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        board.setLayout(new GridLayout(0, 1));
        board.add(dealer);
        board.add(score1);
        board.add(score2); 
        board.add(hit);
        board.add(stay);
        
        window.add(board, BorderLayout.CENTER);
        window.setSize(500, 500);
        window.setTitle("Blackjack");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setVisible(true);
    }
    public static void main(String[] args){
        new Blackjack();
    }
}