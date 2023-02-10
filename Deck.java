import java.util.*;

public class Deck {
  ArrayList<Card> playerDeck = new ArrayList<Card>();
  ArrayList<Card> computerDeck = new ArrayList<Card>();
  ArrayList<Card> warDeck = new ArrayList<Card>();
  //52 cards
  ArrayList<Card> allDeck = new ArrayList<Card>();

  public Card getPlayerCard(){
    return warDeck.get(0);
  }
  public Card getComputerCard(){
    return warDeck.get(1);
  }
  public ArrayList<Card> getPlayerDeck(){
    return playerDeck;
  }
  public ArrayList<Card> getComputerDeck() {
    return computerDeck;
  }
  public ArrayList<Card> getWarDeck() {
    return warDeck;
  }

  public Deck(){
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 13; j++) {
          allDeck.add(new Card(i,j,false));
        }
    }
  }
  
  public void shuffle(){
    for (int i = 0; i < 200; i++) {
      int rand = (int) (Math.random()*52); //randomizing
      Card temp;
      temp = allDeck.get(rand); 
      allDeck.remove(rand); 
      rand = (int) (Math.random()*52); 
      allDeck.add(rand, temp);// putting back in deck
    }
  }

  public void split(){
    for (int i = 0; i < 26; i++) {
      //System.out.println(i);
      playerDeck.add(allDeck.get(i)); 
      playerDeck.get(i).setPlayer(true);
      allDeck.remove(i);
    }

    for (int i = 0; i < 26; i++) {
      computerDeck.add(allDeck.get(i));
    }
    
    allDeck.clear(); 
  }

  public void battle(){
    warDeck.add(playerDeck.get(0));
    playerDeck.remove(0);
    warDeck.add(computerDeck.get(0));
    computerDeck.remove(0);
  }
  
  public int realBattle(){
    if(warDeck.get(0).getPoint() < warDeck.get(1).getPoint()){
      if((int)(Math.random()*2) == 1){ // random
        computerDeck.add(warDeck.get(1));
        computerDeck.add(warDeck.get(0));
      } else {
        computerDeck.add(warDeck.get(0));
        computerDeck.add(warDeck.get(1));
      }

      warDeck.clear();
      return 0;
    }

    if(warDeck.get(0).getPoint() > warDeck.get(1).getPoint()){
      if((int)(Math.random()*2) == 1){
        playerDeck.add(warDeck.get(1));
        playerDeck.add(warDeck.get(0));
      } else {
        playerDeck.add(warDeck.get(0));
        playerDeck.add(warDeck.get(1));
      }
      
      warDeck.clear();
      return 1;
    }

    if(warDeck.get(0).getPoint() == warDeck.get(1).getPoint()){
      war();

      warDeck.clear();
      return 2;
    }

    return -1;
  }

  public void russia(){
    for (int i = 0; i < 4; i++) {
      if (playerDeck.size() == 0){
        break;
      }
      
      warDeck.add(playerDeck.get((0)));
      playerDeck.remove(0);
    }

    for (int i = 0; i < 4; i++) {
      if (computerDeck.size() == 0){
        break;
      }
      
      warDeck.add(computerDeck.get((0)));
      computerDeck.remove(0);
    }
  }

  public void war(){
    System.out.println("WAR!!");
    
    while (warDeck.get(warDeck.size()-2 ).getPoint() == warDeck.get(warDeck.size()-1).getPoint()) {
      russia();
    }

    if (warDeck.get(warDeck.size()-2 ).getPoint() <  warDeck.get(warDeck.size()-1).getPoint()) {
      for (int i = 0; i < warDeck.size(); i++) {
        computerDeck.add(warDeck.get(i));
      }
    } 
    else if (warDeck.get(warDeck.size()-2 ).getPoint() > warDeck.get(warDeck.size()-1).getPoint()) {
      for (int i = 0; i < warDeck.size(); i++) {
        playerDeck.add(warDeck.get(i));
      }
    }
  }

  public String toString() {
    String temp1 = "";
    String temp2 = "";
    String temp3 = "";
    
    for (int i = 0; i < playerDeck.size(); i++) {
      temp1 += " "+ i +": "+ playerDeck.get(i).toString();
    }
    
    for (int i = 0; i < computerDeck.size(); i++) {
      temp2 += " "+ i +": "+  computerDeck.get(i).toString();
    }
    
    for (int i = 0; i < warDeck.size(); i++) {
      temp3 += " "+ i +": "+  warDeck.get(i).toString() + ": "+ warDeck.get(i).getPlayer() ;
    }
    
  return temp1+ "\n"+ temp2 + "\n" + temp3;
  }
}
