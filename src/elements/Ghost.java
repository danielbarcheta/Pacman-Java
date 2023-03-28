package elements;

import utils.Consts;
import utils.Drawing;
import utils.Position;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

import javax.swing.ImageIcon;

public abstract class Ghost extends ElementMove implements Serializable{
    
    
    public Ghost(String imageName) {
        super(imageName);
    }
    

     
    // Declaração do método abstrato herdado
    abstract public void autoDraw(Graphics g);
    
    // Função para alterar a imagem do fantasma para azul, recebendo como parâmetro o nome da imagem do elemento, tornando-o mortal.
    public void changeGhosttoBlue(String imageName) {
        this.isTransposable = true;
        this.isMortal = true;
        
        try {
            imageIcon = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + imageName);
            Image img = imageIcon.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIZE, Consts.CELL_SIZE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIZE, Consts.CELL_SIZE, null);
            imageIcon = new ImageIcon(bi);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Função para alterar a imagem do fantasma azul para normal, recebendo como parâmetro o nome da imagem do elemento, 
    // tornando-o imortal novamente.
    public void changeGhosttoNormal(String imageName) {
        this.isTransposable = true;
        this.isMortal = false;
        
        try {
            imageIcon = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + imageName);
            Image img = imageIcon.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIZE, Consts.CELL_SIZE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIZE, Consts.CELL_SIZE, null);
            imageIcon = new ImageIcon(bi);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // Função para que o elemento possa seguir o pacman, com base em seu movimento vertical e horizontal, aproximando-se dele.
    // Note que são utilizadas as sub-rotinas auxiliares followPacmanVertical e followPacmanHorizontal
    protected void followPacman() {
    	Pacman pacman=Drawing.getGameScreen().getPacman();
        Position posPacman=pacman.getPos();
        int movDirectionPacman=pacman.getMoveDirection();
        
        if (movDirectionPacman==MOVE_LEFT ||movDirectionPacman==MOVE_RIGHT){
        	followPacmanHorizontal(movDirectionPacman, posPacman);
        }
        else if(movDirectionPacman==MOVE_DOWN ||movDirectionPacman==MOVE_UP){
        	followPacmanVertical(movDirectionPacman, posPacman);
        }		
	}
    
   
    

    // Função para seguir o pacman no eixo horizontal. Funciona dessa forma:
    // Geramos um número aleatório de 0 a 11. Caso seja maior que 8, será dada uma direção aleatória.
    // Caso contrário, temos a seguinte situação:
    //  -Se a coordenada Y do pacman for menor do que a do elemento, vá para esquerda
    //  -Caso contrário, mova para direita.
	protected void followPacmanHorizontal(int movDirectionPacman,Position posPacman) {
       	Random gerador = new Random();
    	if(gerador.nextInt(11)>8){
    		this.setMovDirection(gerador.nextInt(5));
    	}
    	else{
    		if (posPacman.getY()<this.getPos().getY()){
    			this.setMovDirection(Pacman.MOVE_LEFT);
    		}
    		else{
    			this.setMovDirection(Pacman.MOVE_RIGHT);	
    		} 
    	}
	}
	  // Função para seguir o pacman no eixo vertical. Funciona dessa forma:
    // Geramos um número aleatório de 0 a 11. Caso seja maior que 8, será dada uma direção aleatória.
    // Caso contrário, temos a seguinte situação:
    //  -Se a coordenada X do pacman for menor do que a do elemento, vá para CIMA.
    //  -Caso contrário, mova para BAIXO.
	protected void followPacmanVertical(int movDirectionPacman, Position posPacman) {
    	Random gerador = new Random();
    	if(gerador.nextInt(11)>8){
    		this.setMovDirection(gerador.nextInt(5));
    	}
    	else{
    		if (posPacman.getX()<this.getPos().getX()){
    			this.setMovDirection(Pacman.MOVE_UP);
    		}
    		else{
    			this.setMovDirection(Pacman.MOVE_DOWN);	
    		} 
    	}		
	} 
	
	// Método projetado para o elemento "fugir" do pacman, isso é, andar majoritariamente na direção contrária a ele.
    protected void escapePacman() {
    	Pacman pacman=Drawing.getGameScreen().getPacman();
        Position posPacman=pacman.getPos();
        int movDirectionPacman=pacman.getMoveDirection();
        
        if (movDirectionPacman==MOVE_LEFT ||movDirectionPacman==MOVE_RIGHT){
        	escapePacmanHorizontal(movDirectionPacman, posPacman);
        }
        else if(movDirectionPacman==MOVE_DOWN ||movDirectionPacman==MOVE_UP){
        	escapePacmanVertical(movDirectionPacman, posPacman);
        }		
	}
    
    

    // Função auxiliar para fugir do pacman no eixo horizontal. Funciona dessa forma:
    // Geramos um número aleatório de 0 a 11. Caso seja maior que 8, será dada uma direção aleatória.
    // Caso contrário, temos a seguinte situação:
    //  -Se a coordenada Y do pacman for menor do que a do elemento, vá para DIREITA
    //  -Caso contrário, mova para ESQUERDA.
    protected void escapePacmanHorizontal(int movDirectionPacman,Position posPacman) {
       	Random gerador = new Random();
    	if(gerador.nextInt(11)>8){
    		this.setMovDirection(gerador.nextInt(5));
    	}
    	else{
    		if (posPacman.getY()<this.getPos().getY()){
    			this.setMovDirection(Pacman.MOVE_RIGHT);
    		}
    		else{
    			this.setMovDirection(Pacman.MOVE_LEFT);	
    		} 
    	}
	}
	
	  // Função para FUGIR o pacman no eixo vertical. Funciona dessa forma:
    // Geramos um número aleatório de 0 a 11. Caso seja maior que 8, será dada uma direção aleatória.
    // Caso contrário, temos a seguinte situação:
    //  -Se a coordenada X do pacman for menor do que a do elemento, vá para BAIXO.
    //  -Caso contrário, mova para CIMA.
	protected void escapePacmanVertical(int movDirectionPacman, Position posPacman) {
    	Random gerador = new Random();
    	if(gerador.nextInt(11)>8){
    		this.setMovDirection(gerador.nextInt(5));
    	}
    	else{
    		if (posPacman.getX()<this.getPos().getX()){
    			this.setMovDirection(Pacman.MOVE_DOWN);
    		}
    		else{
    			this.setMovDirection(Pacman.MOVE_UP);	
    		} 
    	}		
	} 
	// Método para simplsemente mover o elemento de maneira aleatória
	protected void moveRandom() {
    	Random gerador = new Random();
    	this.setMovDirection(gerador.nextInt(5));		
	}

	protected void triplemoveRandom() {
    	Random gerador = new Random();
    	this.setMovDirection(gerador.nextInt(5));		
	}

   
	
	
}
