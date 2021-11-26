import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Rectangle;

public class Foe extends AnimatedThing{

    //un autre exemple de polymorphisme en Java en considérant qu'un ennemi est avant tout un objet animé sur la scene on peut directemetn récupérer les caractéristique de cette classe
    protected double xf;
    protected double yf;
    protected double vf=0;
    protected Rectangle HitBoxF;
    protected int ie;
    protected int lastIndexe=30;
    protected int LargeurWe=31;

    Hero hero;
    Foe(double posX, double posy, String fileName){
        super(posX, posy, fileName);

        this.xf=posX;
        this.yf=posy;
        this.HitBoxF= new Rectangle(this.getX()+30,this.getY(),40,120);


    }
    public void update(long time) {

//ce code sert à l'animation des ennemis
            ie++;
            if (ie < lastIndexe) {
                LargeurWe = ie * 80;
                Spritehero.setViewport(new Rectangle2D(LargeurWe, 0, 85, 150));
            } else {
                Spritehero.setViewport(new Rectangle2D(0, 0, 85, 150));
                ie = 0;

        }
    }
    public void update2(long time) {
        xf=xf-vf;
        //-vf les ennemis se deplacent vers la droite
        Spritehero.setX(xf);
        HitBoxF.setX(10+Spritehero.getX());
        HitBoxF.setY(10+Spritehero.getY());
        HitBoxF.setWidth(20);
    }
    public void freeze()//fige l'animation de l'ennemi
    {
        Spritehero.setViewport(new Rectangle2D(3*80, 0, 85, 150));
    }

    public double getVxx(){return vf;}
    public void setVx(double v){vf=v;}
    public double getX() {return xf;}
    public double getY() {return yf;}
    public Rectangle getHitBox() {return HitBoxF;}

}
