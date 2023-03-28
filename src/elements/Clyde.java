package elements;

import utils.Consts;
import utils.Drawing;
import utils.Position;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;

public class Clyde extends Ghost  {
     
	public Clyde(String imageName) {
	      super(imageName);
	}
	
	//  quando est� a uma dist�ncia grande Pacman (dist�ncia > DISTANCEGHOST), persegue o pacman.
	// Por�m, quando sua dist�ncia ao Pacman diminui (dist�ncia < DISTANCEGHOST), seu
	// movimento passa a ser aleat�rio.
    @Override
    public void autoDraw(Graphics g){
    	Pacman pacman=Drawing.getGameScreen().getPacman();
        Position posPacman=pacman.getPos();
        double distancia=posPacman.distance(this.pos);
        
        if(    pacman.getMoveDirection() == 0){
        	moveRandom();
        }
        
        else{
        	if(!this.isMortal){
        		if(distancia > Consts.DISTANCEGHOST) {
        		followPacman();
        	}
        	else{
        		moveRandom();
        	}
        	}
        		else {
        			escapePacman();
        		}
        }
        	

        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());

    }


}
