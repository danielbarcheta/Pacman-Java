package elements;

import utils.Consts;
import utils.Drawing;
import java.awt.Graphics;

//Classe auxiliar para o Plano de fundo do elemento
public abstract class BackgroundElement extends Element{
    
	// Fun��o que passa para o pai (element) uma string com o nome da imagem do elemento
    public BackgroundElement(String imageName) {
        super(imageName);
    }
    
// Declara��o da classe abstrata herdada
    public abstract void autoDraw(Graphics g);
}
