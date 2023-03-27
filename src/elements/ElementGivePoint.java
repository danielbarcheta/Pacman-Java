package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;

// Esta classe descreve quantos pontos são adquiridos por cada elemento consumido dentro de jogo.
public class ElementGivePoint extends Element {
    protected  int numberPoints=0;
    
	public int getNumberPoints(){
		return numberPoints;
	}

    public ElementGivePoint(String imageName) {
        super(imageName);
        this.isMortal = true;        
    }

    @Override
    public void autoDraw(Graphics g) {
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }
    
}
