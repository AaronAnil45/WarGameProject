public class Card {
    public static String values = "23456789TJQKA";
    public static String suits = "♣❖♥♠";
    private boolean isPlayer = false;

    private char suit;
    private char val;
    private int point;
    
    public Card(){
        int index = randomInt(0,13);
        val = values.charAt(index);
        index = randomInt(0,4);
        suit = suits.charAt(index);
        if(index < 8){
            point = index + 2;
        } else if (index == 12) {   //ACE
            point = 1;
        } else {
            point = 10;     //FACES & 10
        }
        
    }
    
    public int getPoint(){
        return point;
    }
    
    public Card(int s, int v){
        val = values.charAt(v);
        suit = suits.charAt(s);
        if(v < 8){
            point = v + 2;
        } else if (v == 12) {   //ACE
            point = 1;
        } else {
            point = 10;     //FACES & 10
        }
    }
    public Card(int s, int v, boolean player){
        isPlayer = player;
        val = values.charAt(v);
        suit = suits.charAt(s);
        point = v;
//        if(v < 8){
//            point = v;
//        } else if (v == 11) {   //ACE
//            point = 1;
//        } else {
//            point = 10;     //FACES & 10
//        }
    }

    public void setPlayer(boolean player) {
        isPlayer = player;
    }

    public boolean getPlayer(){
        return isPlayer;
    }

    public String toString(){
        return "" + val + suit;
    }
    
    public int randomInt(int lower, int higher){
        return (int)(Math.random()*(higher-lower))+lower;
    }
}
