
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.awt.geom.Rectangle2D;

public class Camera {
    public static final double f = 0.0001;
    public static final double k = 0.000001;
    private double x;
    private double y;
    private StaticThing left;
    private Hero hero1;
    private Camera camera;
    private double acx;
    private double vcx;

    public Camera(double x, double y, Hero hero){
        this.hero1=hero;
        this.x= x;
        this.y=y;

    }

    public double getY() {
        return y;
    }
    public double getX() {
        return x;
    }
    @Override
    public String toString() {
        return x+ " , "+y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void update(long time) {

       // acx= k *(hero1.Spritehero.getX()-this.x)-f*vcx;
       // vcx=vcx+acx*(time);
        x=hero1.getX();

    }
}
