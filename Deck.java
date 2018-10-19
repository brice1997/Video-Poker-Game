
/** This class models the deck composed of 52 cards. 
 * 
 * 
 * April 5, 2018
 * 
 * @Alex Brice Horimbere
 * 
 * Programming Java 1004
 * 
 **/

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections; 

public class Deck {
    
    /**The deck has an arraylist of cards
     * a instance called top that gives 
     * the index of the top card. 
    **/
    
	
	private Card[] cards;
	private int top; // the index of the top of the deck
    private ArrayList<Card> deck; 

	
	
	public Deck(){// a 52 card here. 
        
        
        int suit, rank; 
        cards = new Card[52];
        deck = new ArrayList<Card>(); 
        int i = 0; 
          for (suit = 1; suit < 5;){
              for(rank = 1; rank < 14 ;){
                  
                  // We make new cards with suit and rank
                  
                    cards[i] = new Card(suit, rank); 
                    i++; 
                    rank++; 
                }
              suit++; 
            }
        
        System.out.println(Arrays.toString(cards));//we print the deck
                                                    
        // Then we add the cards to the arraylist deck
         
        for(int j = 0; j < 52; j++){
            Card cardDeck = cards[j]; 
            deck.add(cardDeck);     
        }
        
        top = 0; //We decided that the top card had index 0. 
		
	}
	
	public void shuffle(){  
        
        /** We shuffle the deck here
         * five times to ensure that 
         * randomness is respected. 
        **/
        
       for (int i = 1; i < 5; i++) {
        Collections.shuffle(deck);
       }
	}
    
	
	public Card deal(){
		
        /**This method deals the top card
         * to the player and then form the 
         * hand
        **/
		
		Card firstCard = deck.get(top); 
        return firstCard;              
	}
}
