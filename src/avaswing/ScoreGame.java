package avaswing;

public class ScoreGame {
     private int score;
     public ScoreGame() {
    	 score=100;
     }
     public int getScore() {
    	 return score;
     }
     public void decrementScore() {
    	 score= score-10;
     }
     public boolean isGameOver(){
    	 return (score==0);
     }
}
