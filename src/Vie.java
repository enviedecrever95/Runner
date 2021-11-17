import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Rectangle;

public class Vie extends AnimatedThing{


    Vie(double x, double y, String fileName) {
        super(x, y, fileName);
        Spritehero.setViewport(new Rectangle2D(0,0,120,120));
    }
    public void update(long time) {
        GameScene.setNumberOfLives(GameScene.getNumberOfLives()   - 1);
        System.out.println("Il vous reste " + GameScene.getNumberOfLives() + " points de vie");

        if (GameScene.getNumberOfLives()== 2) {
            Spritehero.setViewport(new Rectangle2D(0, 40, 110, 75));
        }
        if (GameScene.getNumberOfLives() == 1) {
            Spritehero.setViewport(new Rectangle2D(0, 40, 65, 75));
        }
        if (GameScene.getNumberOfLives()== 0) {
            Spritehero.setViewport(new Rectangle2D(0, 40, 10, 75));
        }


    }


}
