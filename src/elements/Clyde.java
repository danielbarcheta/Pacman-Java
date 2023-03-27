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
	
	//  quando está a uma distância grande Pacman (distância > DISTANCEGHOST), persegue o pacman.
	// Porém, quando sua distância ao Pacman diminui (distância < DISTANCEGHOST), seu
	// movimento passa a ser aleatório.
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
