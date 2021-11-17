import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {

    private double x ;
    private double y ;
    private ImageView imgv;

    StaticThing(double x, double y, String fileName){
        this.x=x;
        this.y=y;
          Image back = new Image(fileName);
          imgv = new ImageView(back);
          imgv.setX(x);
          imgv.setY(y);}

    public ImageView getImgv() {
        return imgv;
    }
}

