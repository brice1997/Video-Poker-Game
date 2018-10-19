
/** This class models how a player behaves.  
 * 
 * 
 * April 5, 2018
 * 
 * @Alex Brice Horimbere
 * 
 * Programming Java 1004
 * 
 **/

 
import java.util.ArrayList;
import java.util.Collections; 
 

public class Player {
    
    /**The player keeps track of a bankroll
     * He bets, 
     * and he has a hand
    **/
    
	private double bankroll;
    private double bet;
    private ArrayList<Card> hand;
		
	public Player(){
       
	   /** At first, the player has bankroll 100(arbitrary)
	    * He hasn't bet anything
	   **/
        
	    bankroll = 100; 
        bet = 0;
        hand = new ArrayList<Card>();
         
	}

	public void addCard(Card c){
        
	    /** add the card c to the player's hand
	     **/
	   
        hand.add(c);
        
	}

	public void removeCard(Card c){
        
	    /** remove the card c from the player's hand
	     **/
        
	    hand.remove(c);
        }
		
    public void bets(double amt){ 
            
         /**The player bets
          * and the amount is 
          * deducted from the 
          * bankroll
         **/
        
         bet = amt; 
         bankroll = bankroll - bet; 
            
        }

    public void winnings(double odds){
           
         /** We adjust the bankroll if the player wins
          * Then the bet is multiplied by the payout 
          * then added to the bankroll
         **/
        
         odds = odds * bet; 
         bankroll = bankroll + odds;
        
        }

    public double getBankroll(){ //returns the bankroll. 
            return bankroll; 
        }
    
    public ArrayList<Card> getHand(){//returns the hand. 
        return hand; 
    }
 }

        



