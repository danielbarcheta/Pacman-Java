package utils;

import control.GameScreen;
import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Drawing {
    static GameScreen screen;

    public static GameScreen getGameScreen() {
        return screen;
    }

    public static void setGameScreen(GameScreen newScreen) {
        screen = newScreen;
    }    
    
    // Recebe um contexto gráfico acompanhado de uma imagem e seu tamanho (x e y) e ajusta, pintando o icone de acordo com o tamanho
    // parametrizado através da sub-rotina paintIcon
    public static void draw(Graphics g, ImageIcon imageIcon, double y, double x) {
        //System.out.println("y="+(y * Consts.CELL_SIZE)+", x="+(x * Consts.CELL_SIZE));
        imageIcon.paintIcon(screen, g, (int)Math.round(y * Consts.CELL_SIZE),(int)Math.round(x * Consts.CELL_SIZE));
    }
    
    
    public static void drawbackground(Graphics g, ImageIcon imageIcon, double y, double x) {
        //System.out.println("y="+(y * Consts.CELL_SIZE)+", x="+(x * Consts.CELL_SIZE));
        imageIcon.paintIcon(screen, g, (int)Math.round(y * Consts.CELL_SIZE),(int)Math.round(x * Consts.CELL_SIZE));
    }
}
