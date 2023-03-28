package elements;

import utils.Consts;
import utils.Position;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
public abstract class Element implements Serializable {

    protected ImageIcon imageIcon;
    protected Position pos;
    protected boolean isTransposable; 
    protected boolean isMortal;       

    // Recebe a imagem do elemento. Inicializa os atributos e agrega a imagem ao seu endere�o com os metodos do Swing
    protected Element(String imageName) {
        this.pos = new Position(1, 1);
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
    
    // Metodo que sobrescreve os componentes de posi��o de um elemento, primeiramente pegando o valor absoluto das coordenadas X e Y
    // retornando TRUE caso a distancia entre essas coordenadas e o objeto  da classe for menor do que 1 e FALSE caso contr�rio
    public boolean overlap(Element elem) {
        double xDist = Math.abs(elem.pos.getX() - this.pos.getX());
        double yDist = Math.abs(elem.pos.getY() - this.pos.getY());
        
        if (xDist < 1.0 && yDist < 1.0)
            return true;
        else
            return false;
    }

    // M�todo que retorna uma string com as coordenadas X e Y do elemento.
    public String getStringPosition() {
        return ("(" + pos.getX() + ", " + pos.getY() + ")");
    }
    // M�todo que retorna um objeto da classe POSI��O correspondente ao elemento.
    public Position getPos(){
    	return pos;
    }
    
    // Seta posi��o (x/y) do elemento.
    public boolean setPosition(double x, double y) {
        return pos.setPosition(x, y);
    }

    // Descreve se o elemento � fixo ou m�vel
    public boolean isTransposable() {
        return isTransposable;
    }

    //Descreve se o elemento � mortal ou n�o.
    public boolean isMortal() {
        return isMortal;
    }
    
    public void setTransposable(boolean isTransposable) {
        this.isTransposable = isTransposable;
    }

    // M�todo abstrato a ser designado pelas classes herdadas para futuramente esbo�ar na tela o desenho correspondente a cada elemento.
    abstract public void autoDraw(Graphics g);

 
}
