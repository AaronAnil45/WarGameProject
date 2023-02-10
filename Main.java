import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Deck deck = new Deck();

    boolean inGame = true;

    deck.shuffle();
    
    deck.split();

    char playerNum;
    char playerSuit;
    
    char compNum;
    char compSuit;

    while(inGame) {
      System.out.println(" ");
      System.out.println("          < Player >         < Computer >");
      System.out.println(" ");
      System.out.println("           ? ——— ?             ? ——— ?   ");
      System.out.println("           |  ?  |             |  ?  |   ");
      System.out.println("           |  ?  |             |  ?  |   ");
      System.out.println("           ? ——— ?             ? ——— ?   ");

      System.out.println("\n Press Enter to flip");
      scanner.nextLine();

      deck.battle();

      playerNum = deck.getPlayerCard().toString().charAt(0);
      playerSuit = deck.getPlayerCard().toString().charAt(1);

      compNum = deck.getComputerCard().toString().charAt(0);
      compSuit = deck.getComputerCard().toString().charAt(1);
      
      System.out.println("           " + playerNum + " ——— " + playerSuit + "             " + compNum + " ——— " + compSuit + "   ");
      System.out.println("           |  " + playerNum + "  |             |  " + compNum + "  | ");
      System.out.println("           |  " + playerSuit + "  |             |  " + compSuit + "  | ");
      System.out.println("           " + playerSuit + " ——— " + playerNum + "             " + compSuit + " ——— " + compNum + "   ");

      
      
      int winner = deck.realBattle();

      if(winner == 0) {
        System.out.println("                               COMPUTER WON!! 🤣🤣 - 👾🤖");
      } else if(winner == 1) {
        System.out.println("           PLAYER WON!! 👍👌🙌😃😁🤩🤑🤡  ");
      } else {
        System.out.println("Putting 3 cards Down...");
      }

      System.out.println("\n        Player cards: " + deck.getPlayerDeck().size() + "     Computer cards: " + deck.getComputerDeck().size() + "\n");
      
      // System.out.println("\n    Player cards: " + deck.getPlayerDeck().size() + "   computer cards: " + deck.getComputerDeck().size() + "\n");


      System.out.println("============= Enter to go to the next round =============");
      scanner.nextLine();

      if(deck.getPlayerDeck().size() == 0 || deck.getComputerDeck().size() == 0) {
        inGame = false;
      }


      
    }


    

    //System.out.println(deck.toString());

    // System.out.println((deck.getWarDeck().get(0).toString() + "VS" + 
    //  deck.getWarDeck().get(1).toString());

    // System.out.println("      { " + deck.getPlayerCard() + " : VS : " + deck.getComputerCard() + " }");

    
  }
}
