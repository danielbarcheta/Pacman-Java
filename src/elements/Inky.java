package elements;

import utils.Consts;
import utils.Drawing;
import utils.Position;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;

public class Inky extends Ghost  {
     
	public Inky(String imageName) {
	      super(imageName);
	}
	
	//este fantasma movimenta-se aleatoriamente enquanto o
	//Blinky estiver distante dele (distância > D). Quando o Blinky se
	//aproxima dele (distância < D), ele se encoraja e passa a perseguir o
	//Pacman de maneira similar ao Blinky.
    @Override
    public void autoDraw(Graphics g){
    	Pacman pacman=Drawing.getGameScreen().getPacman();
        Position posPacman=pacman.getPos();
        double distancia=posPacman.distance(this.pos);
        
      if(pacman.getMoveDirection()==0) { 
    	  moveRandom();
      }
      else {
    	  if(!this.isMortal) {
    	  if (distancia>Consts.DISTANCEGHOST) {
    		  moveRandom();
    	  }
    	  else followPacman();
    	  
    	  
    	  
    	  }
    	  else escapePacman();
      }
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());

    }


}
