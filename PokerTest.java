/* This is a test class for the video Poker game. 
 * 
 * April 5, 2018
 * 
 * @Alex Brice Horimbere
 * 
 * Programming Java 1004
 * 
 **/ 

public class PokerTest{

    //this class must remain unchanged
    //your code must work with this test class
 
    public static void main(String[] args){
        if (args.length<1){
            Game g = new Game();
            g.play();
        }
        else{
            Game g = new Game(args);
            g.play();
        }
    }

}
