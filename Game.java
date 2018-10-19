/** This class models how the video Poker
 *  game is played. 
 * 
 * 
 * April 5, 2018
 * 
 * @Alex Brice Horimbere
 * 
 * Programming Java 1004
 * 
 **/ 


import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Collections; 

public class Game {
    
    /** instnace variables are player
     * the deck,
     *  the scanner that gets 
     * inputs from user,
     * a result used in the checkHand(),
     * arraylists handFortesting
     * array cardsForTest
     * for the game with string args. 
    **/
	
	private Player brice;
	private Deck cards;
    private Scanner input;
    private String result;
    private ArrayList<Card> handForTesting; 
    private Card[] cardsForTest; 
	
	
	
	public Game(String[] testHand){
		
        
        handForTesting = new ArrayList<Card>();
        cardsForTest = new Card[5];
        
        for (int i = 0; i < 5; i++){
            
           /** change strings into cards
            * using the encoding provided
            * in the problem
           **/
            
            cardsForTest = new Card[5]; 
            
            String one = testHand[i].substring(0,1); 
            if (one == "c" ){
                one = "1"; 
            }
            else if (one == "d"){
                one = "2"; 
            }
            else if (one == "h"){
                one = "3"; 
            }
            else {
                one = "4"; 
            }
            
            int suit = Integer.parseInt(one); 
            
            String two = testHand[i].substring(1); 
            int rank = Integer.parseInt(two); 
            
            cardsForTest[i] = new Card(suit, rank); 
        }
        
        /** Add the newly created cards
         * in the arraylist handForTesting
        **/
        
        handForTesting.add(cardsForTest[0]); 
        handForTesting.add(cardsForTest[1]);
        handForTesting.add(cardsForTest[2]); 
        handForTesting.add(cardsForTest[3]);
        handForTesting.add(cardsForTest[4]); 
        
     System.out.println(handForTesting.toString());
        
	}
	
	public Game(){ // This no-argument constructor is to actually play a normal game
		
        brice = new Player(); 
        cards = new Deck();
        input = new Scanner(System.in); 

        
	}
	
	public void play(){ // this method plays the game 
        
        int i = 0; 
        while (i < 10){ 
            
            /** The game asks the player ten times 
             * Whether he wants to play the 
             * game or not. 
            **/
            
        System.out.println("Do you like to play?0 (for no) or 1 (for yes)?"); 
        int yesRepeat = input.nextInt(); 
        if (yesRepeat == 1){
            System.out.println("Great! Let's make that money!");
            System.out.println("How much do you want to bet?");
            double amount = input.nextDouble();
            
            /**The player first bets
             * Then the deck is shuffled
             * Then the hand is constructed
             * and checked
            **/
            
            brice.bets(amount);
            cards.shuffle(); 
		    constructTheHand();
            cards.shuffle(); 
            i++; 
          }
        else{
            System.out.println("Thanks for playing!");
        }
	   }
      } 
    
	public String checkHand(ArrayList<Card> handTocheck){
        
		/** this method takes an ArrayList of cards
		 * as input and then determine what evaluates to and
		 * return that as a String
		**/
        
        
        /** First, the if statements check the hand. 
         * Then, the winnings are added to the bankroll.
         * The bankroll is updated and the hand is cleared
        **/
        
        
        Collections.sort(handTocheck); 
        
        for (int i = 0; i < handTocheck.size();){
            if (handTocheck.get(i).getSuit() == handTocheck.get(i+1).getSuit()
               && 
             handTocheck.get(i+1).getSuit() == handTocheck.get(i+2).getSuit()
               &&
             handTocheck.get(i+2).getSuit() == handTocheck.get(i+3).getSuit()
               &&
             handTocheck.get(i+3).getSuit() == handTocheck.get(i+4).getSuit()){
                
                if (handTocheck.get(i).getRank() == 1 
                    &&
                    handTocheck.get(i+1).getRank() == 10
                    &&
                    handTocheck.get(i+2).getRank() == 11 
                    &&
                    handTocheck.get(i+3).getRank() == 12 
                    &&
                    handTocheck.get(i+4).getRank() == 13){
                    
                    String royalFlush = "It is a Royal Flush!";
                  
                    brice.winnings(250); //update the winnings
                    System.out.println(royalFlush); //Print the result.
                    System.out.println("The Bankroll is now  "
                                       + brice.getBankroll()); 
                    
                    result = royalFlush;
                    
                    /**The hand is cleared,
                     * so it doesn't continue
                     * to be checked
                     * same below for all if statements. 
                    **/ 
           
                    handTocheck.clear();  
                }
                else if (handTocheck.get(i).getRank()< 
                         handTocheck.get(i+1).getRank()
                   && 
               handTocheck.get(i+1).getRank() < handTocheck.get(i+2).getRank()
                   &&      
               handTocheck.get(i+2).getRank() < handTocheck.get(i+3).getRank()
                   &&
               handTocheck.get(i+3).getRank() < handTocheck.get(i+4).getRank()){
                    
                    String straightFlush = "It is a Straight Flush!"; 
                    
                    System.out.println(straightFlush); 
                    brice.winnings(50); 
                    System.out.println("The Bankroll is now "
                                       + brice.getBankroll());
                    
                    result = straightFlush;
                    handTocheck.clear(); 
                    
               }
               else{
                   String flush = "It is a Flush!"; 
                    
                   brice.winnings(5); 
                   System.out.println(flush); 
                   System.out.println("The Bankroll is now "
                                      +brice.getBankroll());
                   
                   result = flush;
                   handTocheck.clear(); 
                   
               }
            }
            else if ((handTocheck.get(i).getRank() ==
                     handTocheck.get(i+1).getRank()
                     &&
                     handTocheck.get(i+1).getRank() ==
                     handTocheck.get(i+2).getRank())
                     &&
                    (handTocheck.get(i+2).getRank() ==
                     handTocheck.get(i+3).getRank())
                     ||
                    ((handTocheck.get(i+1).getRank() ==
                     handTocheck.get(i+2).getRank()
                     &&
                     handTocheck.get(i+2).getRank() ==
                     handTocheck.get(i+3).getRank())
                     &&
                    (handTocheck.get(i+3).getRank() ==
                     handTocheck.get(i+4).getRank()))){
                
                String fourKind = "It is a Four of a Kind!"; 
                 
                System.out.println(fourKind);
                brice.winnings(25); 
                System.out.println("The Bankroll is now "
                                   + brice.getBankroll()); 
                
                result = fourKind;
                handTocheck.clear(); 
            }
            else if ((handTocheck.get(i).getRank() ==
                     handTocheck.get(i+1).getRank() 
                     &&
                     handTocheck.get(i+1).getRank() ==
                     handTocheck.get(i+2).getRank())
                     &&
                    (handTocheck.get(i+3).getRank() ==
                     handTocheck.get(i+4).getRank())
                     ||
                     ((handTocheck.get(i).getRank() ==
                     handTocheck.get(i+1).getRank())
                     &&
                    (handTocheck.get(i+2).getRank() ==
                     handTocheck.get(i+3).getRank()
                     &&
                     handTocheck.get(i+3).getRank() ==
                     handTocheck.get(i+4).getRank()))){
                
                String fullHouse = "It is a full house!"; 
                 
                System.out.println(fullHouse); 
                brice.winnings(6); 
                System.out.println("The Bankroll is now " 
                                   + brice.getBankroll()); 
                
                result = fullHouse;
                handTocheck.clear(); 
            } 
            else if ((handTocheck.get(i).getRank() < 
                      handTocheck.get(i+1).getRank()
                      &&
               handTocheck.get(i+1).getRank() < handTocheck.get(i+2).getRank())
                      &&
               (handTocheck.get(i+2).getRank() < handTocheck.get(i+3).getRank()
                     &&
              handTocheck.get(i+3).getRank() < handTocheck.get(i+4).getRank())){
                
                String straight = "It is a Straight!"; 
                 
                System.out.println(straight); 
                brice.winnings(4); 
                System.out.println("The Bankroll is now "
                                   + brice.getBankroll());
                
                result = straight;
                handTocheck.clear(); 
                
            }
            else if ((handTocheck.get(i).getRank() ==
                     handTocheck.get(i+1).getRank()
                     &&
                     handTocheck.get(i+1).getRank()==
                     handTocheck.get(i+2).getRank())
                     ||
                    (handTocheck.get(i+1).getRank() ==
                     handTocheck.get(i+2).getRank() 
                     &&
                     handTocheck.get(i+2).getRank()==
                     handTocheck.get(i+3).getRank())
                     ||
                    (handTocheck.get(i+2).getRank()==
                     handTocheck.get(i+3).getRank()
                     &&
                     handTocheck.get(i+3).getRank()==
                     handTocheck.get(i+4).getRank())){
                
                String threeKind = "It is a three of a kind!"; 
                 
                System.out.println(threeKind); 
                brice.winnings(3); 
                System.out.println("The Bankroll is now "
                                   + brice.getBankroll()); 
                
                result = threeKind;
                handTocheck.clear(); 
            }
            else if (handTocheck.get(i).getRank() ==
                     handTocheck.get(i+1).getRank() &&
                     handTocheck.get(i+1).getRank() ==
                     handTocheck.get(i+2).getRank() ||
                     handTocheck.get(i+2).getRank() ==
                     handTocheck.get(i+3).getRank() &&
                     handTocheck.get(i+3).getRank() ==
                     handTocheck.get(i+4).getRank()){
                
                String twoPairs = "It is two pairs!"; 
                 
                System.out.println(twoPairs); 
                brice.winnings(2); 
                System.out.println("The Bankroll is now "
                                   + brice.getBankroll());
                
                result = twoPairs;
                handTocheck.clear(); 
            }
            else if (handTocheck.get(i).getRank() ==
                     handTocheck.get(i+1).getRank() ||
                     handTocheck.get(i+1).getRank() ==
                     handTocheck.get(i+2).getRank() ||
                     handTocheck.get(i+2).getRank() ==
                     handTocheck.get(i+3).getRank() ||
                     handTocheck.get(i+3).getRank() ==
                     handTocheck.get(i+4).getRank()){
                
                String onePair = "It is a pair!"; 
                 
                System.out.println(onePair); 
                brice.winnings(1);
                System.out.println("The Bankroll is now " 
                                   + brice.getBankroll()); 
                
                result = onePair;
                handTocheck.clear();  
            }
            else{
                String noPair = "You got nothing! Sorry"; 
                result = noPair;
                handTocheck.clear(); 
            }
 	
	}
        return result; //This is the string that the method returns. 
  }
    
    public void constructTheHand(){
        
        /**This method constructs the hand.
         * It deals cards, shuffles them
         * and then assigns them to the 
         * player. 
         * Also, the player has the option
         * of changing some or all or none 
         * of his cards. 
         * At the end, the checkHand()
         * is called upon to check 
         * the hand constructed. 
        **/
        
        brice.addCard(cards.deal());
        cards.shuffle(); 
        brice.addCard(cards.deal());
        cards.shuffle(); 
        brice.addCard(cards.deal());
        cards.shuffle(); 
        brice.addCard(cards.deal()); 
        cards.shuffle(); 
        brice.addCard(cards.deal());
        cards.shuffle(); 
        
        System.out.println(brice.getHand().toString()); 
        
        System.out.println("Would you like to change any of the cards? (Y/N)");
        
        /**Ask them whether they want to keep their cards,
         * if yes, how many? 
         * Then, proceed to replace those cards
         * with new ones. 
        **/
        
        String response = input.next(); 
        if (response == "Y"){
            
        System.out.println("How many would you like to replace?input a number");
        int number = input.nextInt(); 
        ArrayList<Card> temporaryHand = new ArrayList<Card>(); 
        temporaryHand = brice.getHand();
        
        
        if (response=="Y" && number == 5){
            
            /** Remove the cards they want to replace
             * Deal them new ones. 
            **/
            
            brice.removeCard(temporaryHand.get(0)); 
            brice.removeCard(temporaryHand.get(1)); 
            brice.removeCard(temporaryHand.get(2)); 
            brice.removeCard(temporaryHand.get(3)); 
            brice.removeCard(temporaryHand.get(4)); 
            
            brice.addCard(cards.deal());
            cards.shuffle(); 
            brice.addCard(cards.deal());
            cards.shuffle(); 
            brice.addCard(cards.deal()); 
            cards.shuffle(); 
            brice.addCard(cards.deal());
            cards.shuffle(); 
            brice.addCard(cards.deal()); 
            cards.shuffle(); 
        
       
        }
        else if (response == "Y" && number == 4){
            System.out.println("Which are you discarding? Enter 2 integers");
            
            /** Here since they want to change specific cards
             * Ask them to input the cards they want to replace
             * specifying the suit and the rank
             * Then remove that(those) cards.
             * Same as the else if statements below
             *  
            **/
            
            System.out.println("The suit 1-4: ");
            int suitNumber1 = input.nextInt(); 
            System.out.println("The rank 1-13: "); 
            int rankNumber1 = input.nextInt(); 
            Card firstCard = new Card(suitNumber1, rankNumber1);
            
            for (int i = 0; i < temporaryHand.size(); i++){
                if (temporaryHand.get(i) == firstCard){
                    brice.removeCard(temporaryHand.get(i)); 
                }
                
            }
            
            
            System.out.println("The suit: ");
            int suitNumber2 = input.nextInt(); 
            System.out.println("The rank: "); 
            int rankNumber2 = input.nextInt(); 
            Card secondCard = new Card(suitNumber2, rankNumber2); 
            
            for (int i = 0; i < temporaryHand.size(); i++){
                if (temporaryHand.get(i) == secondCard){
                    brice.removeCard(temporaryHand.get(i)); 
                }
            }
            
            System.out.println("The suit: "); 
            int suitNumber3 = input.nextInt(); 
            System.out.println("The rank: ");
            int rankNumber3 = input.nextInt(); 
            Card thirdCard = new Card(suitNumber3, rankNumber3); 
            
            for (int i = 0; i < temporaryHand.size(); i++){
                if (temporaryHand.get(i) == thirdCard){
                    brice.removeCard(temporaryHand.get(i));
                }
            }
            
            System.out.println("The suit: "); 
            int suitNumber4 = input.nextInt(); 
            System.out.println("The rank: "); 
            int rankNumber4 = input.nextInt(); 
            Card fourthCard = new Card(suitNumber4, rankNumber4);
            
            for (int i = 0; i < temporaryHand.size(); i++){
                if (temporaryHand.get(i) == fourthCard){
                    brice.removeCard(temporaryHand.get(i)); 
                }
            }
            brice.addCard(cards.deal());
            cards.shuffle(); 
            brice.addCard(cards.deal());
            cards.shuffle(); 
            brice.addCard(cards.deal()); 
            cards.shuffle(); 
            brice.addCard(cards.deal());
            cards.shuffle(); 
            
       
            
        }
        else if (response == "Y" && number == 3){
            
            System.out.println("Which don't you want?"); 
            System.out.println("The suit: ");
            int suitNumber5 = input.nextInt(); 
            System.out.println("The rank: "); 
            int rankNumber5 = input.nextInt(); 
            Card firstCard1 = new Card(suitNumber5, rankNumber5); 
            
            for (int i = 0; i < temporaryHand.size(); i++){
                if (temporaryHand.get(i) == firstCard1){
                    brice.removeCard(temporaryHand.get(i)); 
                }
            }
            
            System.out.println("The suit: "); 
            int suitNumber6 = input.nextInt(); 
            System.out.println("The rank: "); 
            int rankNumber6 = input.nextInt(); 
            Card secondCard1 = new Card(suitNumber6, rankNumber6); 
            
            for (int i = 0; i < temporaryHand.size(); i++){
                if (temporaryHand.get(i) == secondCard1){
                    brice.removeCard(temporaryHand.get(i)); 
                }
            }
            
            System.out.println("The suit: "); 
            int suitNumber7 = input.nextInt(); 
            System.out.println("The rank: "); 
            int rankNumber7 = input.nextInt(); 
            Card thirdCard1 = new Card(suitNumber7, rankNumber7); 
            
            for (int i = 0; i < temporaryHand.size(); i++){
                if (temporaryHand.get(i) == thirdCard1){
                    brice.removeCard(temporaryHand.get(i)); 
                }
            }
            
            brice.addCard(cards.deal());
            cards.shuffle(); 
            brice.addCard(cards.deal());
            cards.shuffle(); 
            brice.addCard(cards.deal()); 
            cards.shuffle(); 
          

        }
        else if (response == "Y" && number == 2){
            
            System.out.println("The suit: "); 
            int suitNumber8 = input.nextInt(); 
            System.out.println("The rank: "); 
            int rankNumber8 = input.nextInt(); 
            Card firstCard2 = new Card(suitNumber8, rankNumber8); 
            
            for (int i = 0; i < temporaryHand.size(); i++){
                if (temporaryHand.get(i) == firstCard2){
                    brice.removeCard(temporaryHand.get(i)); 
                }
            }
            
            System.out.println("The suit: "); 
            int suitNumber9 = input.nextInt(); 
            System.out.println("The rank: "); 
            int rankNumber9 = input.nextInt(); 
            Card secondCard2 = new Card(suitNumber9, rankNumber9); 
            
            for (int i = 0; i < temporaryHand.size(); i++){
                if (temporaryHand.get(i) == secondCard2){
                    brice.removeCard(temporaryHand.get(i)); 
                }
            }
            brice.addCard(cards.deal());
            cards.shuffle(); 
            brice.addCard(cards.deal());
            cards.shuffle(); 
            
   
        }
        else if (response == "Y" && number == 1){
            System.out.println("The suit: "); 
            int suitNumber10 = input.nextInt(); 
            System.out.println("The rank: "); 
            int rankNumber10 = input.nextInt(); 
            Card firstCard3 = new Card(suitNumber10, rankNumber10); 
            
            for (int i = 0; i < temporaryHand.size(); i++){
                if (temporaryHand.get(i) == firstCard3){
                    brice.removeCard(temporaryHand.get(i)); 
                }
            }
            
            brice.addCard(cards.deal());
            cards.shuffle();  
        }
        else {
            brice.getHand(); //if not, just get the hand!
        }
       }
        
        /** After the hand is constructed,
         * check it. 
         * call checkHand()
        **/
        
      checkHand(brice.getHand());  
    }
}
