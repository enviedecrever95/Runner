import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.geometry.Rectangle2D;

public abstract class AnimatedThing {

    protected double x;
    protected double y=150;
    protected ImageView Spritehero;
    //Notre objet animé sur notre scene est caractérisé par sa position en x,y et son Image qui est ici nommé Spritehero pour tous les objets animés


    public AnimatedThing(double x, double y, String fileName) {
        this.x = x;
        this.y = y;
        Spritehero = new ImageView(new Image(fileName));
        Spritehero.setX(this.x);
        Spritehero.setY(this.y);}

    public ImageView getSprite() {
        Spritehero.setViewport(new Rectangle2D(88,0,40,90));
        return Spritehero;}

    public ImageView getSpriteVie() {
        Spritehero.setViewport(new Rectangle2D(0,40,160,75));
        return Spritehero;}


}


