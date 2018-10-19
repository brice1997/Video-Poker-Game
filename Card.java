
/** This class models what a card is and how it behaves.  
 * 
 * 
 * April 5, 2018
 * 
 * @Alex Brice Horimbere
 * 
 * Programming Java 1004
 * 
 **/

public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int rank; // use integers 1-13 to encode the rank
	
	public Card(int s, int r){
        
        suit = s; 
        rank = r; 
		
	}
	
	public int compareTo(Card c){
        
      /**This method compares cards
       * according to their rank
      **/
        
      int answer = 0; 
        if(this.rank > c.rank){
            answer = -1;  
        }
        if(this.rank < c.rank){
            answer = 1;
        }
        
        return answer; 
	}
	
	public String toString(){
        
        /**The player would likely want to know
         * what his cards are. 
         * so a brief description helps. 
       **/
        
        String description; 
        description = suit + " " + rank; 
        return description;
        
		
	}
    
    public int getSuit(){//returns the suit
        return suit; 
    }
    
    public int getRank(){//returns the rank
        return rank; 
    }
}
