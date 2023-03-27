package elements;

import utils.Drawing;
import utils.Position;

import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;

public abstract class ElementMove extends Element  {
    
	// Declaramos aqui constantes que definem o movimento para que seja possível randomizar o movimento de alguns elementos.
    public static final int STOP = 0;
    public static final int MOVE_LEFT = 1;
    public static final int MOVE_RIGHT = 2;
    public static final int MOVE_UP = 3;
    public static final int MOVE_DOWN = 4;
    
    private int movDirection = STOP;
    
    public int getMoveDirection(){
    	return movDirection;
    }
    
    // Passa para a classe pai (Element) o nome da imagem do elemento a ser movimentado.
    public ElementMove(String imageName) {
        super(imageName);
    }
    
     
    // Declaração do método abstrato herdado
    abstract public void autoDraw(Graphics g);
    
    
// Retorna o elemento para sua ultima posição ocupada.
    public void backToLastPosition(){
        this.pos.comeBack();
    }
    
  
    public void setMovDirection(int direction) {
        movDirection = direction;
    }
    
    // Seta a direção do movimento de acordo com a direção recebida (de 0 a 4). 
    public void move() {
        switch (movDirection) {
            case MOVE_LEFT:
                this.moveLeft();
                break;
            case MOVE_RIGHT:
                this.moveRight();
                break;
            case MOVE_UP:
                this.moveUp();
                break;
            case MOVE_DOWN:
                this.moveDown();
                break;
            default:
                break;
        }
    }
    
    
    
    public void triplemove() {
        switch (movDirection) {
            case MOVE_LEFT:
                this.moveLeft();
                this.moveLeft();
                this.moveLeft();
                break;
            case MOVE_RIGHT:
                this.moveRight();
                this.moveRight();
                this.moveRight();
                break;
            case MOVE_UP:
                this.moveUp();
                this.moveUp();
                this.moveUp();
                break;
            case MOVE_DOWN:
                this.moveDown();
                this.moveDown();
                this.moveDown();
                break;
            default:
                break;
        }
    }
    
    // Métodos auxiliares para movimentar a posição do elemento
    
    public boolean moveUp() {
        return this.pos.moveUp();
    }

    public boolean moveDown() {
        return this.pos.moveDown();
    }

    public boolean moveRight() {
        return this.pos.moveRight();
    }

    public boolean moveLeft() {
        return this.pos.moveLeft();
    }
   
 

}
