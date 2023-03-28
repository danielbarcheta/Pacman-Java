package elements;

import utils.Drawing;
import utils.Position;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;
public class Pinky extends Ghost  {
     
	public Pinky(String imageName) {
	      super(imageName);
	}
	
	// paralelamente a ele. A movimentação na outra direção (perpendicular)
	//é aleatória. Assim como todos os outros, caso o pacman fique parado, ele se moverá de maneira aleatória
    @Override
    public void autoDraw(Graphics g){
    	Pacman pacman=Drawing.getGameScreen().getPacman();
        Position posPacman=pacman.getPos();
        int movDirectionPacman=pacman.getMoveDirection();
        Random gerador = new Random();
    	
        if(    pacman.getMoveDirection() == 0){
        	moveRandom();
        }
        if (movDirectionPacman==MOVE_LEFT ||movDirectionPacman==MOVE_RIGHT){
        	
        	if(!this.isMortal){
        		if(gerador.nextInt(5)>=3){   // Acrescentamos aqui, conforme descrito pelo Prof Luiz, um componente randômico,
        			// Para que Pinky não seguisse completamente o pacman na direção paralela. A chance de seguir
        			// Em cada iteração é de 50%
        		followPacmanHorizontal(movDirectionPacman, posPacman);
        		}
        	
        		else {
        			moveRandom();
        		}
        		
        		}
        	else{
        		escapePacmanHorizontal(movDirectionPacman, posPacman);
        	}
        }
        else if(movDirectionPacman==MOVE_DOWN ||movDirectionPacman==MOVE_UP){
        	moveRandom();

        	}
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());

    }



}
