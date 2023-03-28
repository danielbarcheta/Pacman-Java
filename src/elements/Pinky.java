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
	
	// paralelamente a ele. A movimenta��o na outra dire��o (perpendicular)
	//� aleat�ria. Assim como todos os outros, caso o pacman fique parado, ele se mover� de maneira aleat�ria
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
        		if(gerador.nextInt(5)>=3){   // Acrescentamos aqui, conforme descrito pelo Prof Luiz, um componente rand�mico,
        			// Para que Pinky n�o seguisse completamente o pacman na dire��o paralela. A chance de seguir
        			// Em cada itera��o � de 50%
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
