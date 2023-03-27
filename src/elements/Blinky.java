package elements;

import utils.Consts;
import utils.Drawing;
import utils.Position;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;
public class Blinky extends Ghost  {
     
	public Blinky(String imageName) {
	      super(imageName);
	}
	
	// É o fantasma mais perigoso, que segue constantemente Pacman. No entanto, há uma probabilidade (25%) dele se movimentar de maneira
	// Randômica a cada movimentação do pacman, que foi dado pela variável aleatória "gerador".
    @Override
    public void autoDraw(Graphics g){
    	Pacman pacman=Drawing.getGameScreen().getPacman();
        Position posPacman=pacman.getPos();
        double distancia=posPacman.distance(this.pos);
   
       if(!this.isMortal && pacman.getMoveDirection()==0) {
    	  moveRandom();
       }
       
        	if(!this.isMortal){
        		 Random gerador = new Random();
        	    	if(gerador.nextInt(3)>2){
        		moveRandom();
        	}
        	    	else {
        	    		followPacman();
        	    	}
        	
        	}
        	else{
        		escapePacman();
        	}
        	
        	
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());


}
}
