import com.sun.jdi.event.MonitorWaitEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.shape.Rectangle;

public class Hero extends AnimatedThing {

    protected double xh;
    protected double yh;
    protected double vx=0;
    protected double ax;
    protected double ay=0;
    protected double vy=0;
    protected int i=0;
    protected int i2=0 ;
    protected int i3=0;
    protected int atd;
    protected int s=0 ;
    protected int lastIndex = 4;
    protected int lastIndex2 = 16;
    protected int lastIndex3 = 2;
    protected int LargeurW=85;
    protected int LargeurW2=85;
    protected int LargeurW3=85;
    protected int saut=0;
    protected int start=1;
    protected int zawardo=0;
    protected int iz;
    protected int lastIndexz=6;
    protected int LargeurWz=85;
    protected int DoubleSaut=2;
    protected Rectangle HitBoxH;
    int speed=0;
    int coeur=GameScene.getNumberOfLives();


    Hero(double x, double y, String fileName) {
        super(x, y, fileName);
        this.HitBoxH= new Rectangle(10+this.getX(),this.getY(),40,120);
    }

    public void update(long time) {

        //ici on affiche des sprites différentes en fonction de son altitude lorsque notre heros saute
            if (ay>0 & yh<250 & yh>230)
            {
                Spritehero.setViewport(new Rectangle2D(12,260,120,120));
            }
            if (ay>0 & yh<=230 & yh>=190){
                Spritehero.setViewport(new Rectangle2D(132,250,120,120));
             }
            if (ay>0 & yh<190 & yh>=50){
                Spritehero.setViewport(new Rectangle2D(120+132,240,120,150));
         }


            if (vx<8 & yh>=250 ) //la varible speed sert à modifier la hitbox du heros slon qu'il cour ou marche
            {
                speed=0;
            }
            if (vx>=8 & yh>=250) {
                speed=1;
            i++;

            //les codes suivants concerne l'animation du héros
            if (i < lastIndex) {
                LargeurW = i * 120;
                Spritehero.setViewport(new Rectangle2D(2 + LargeurW, 120, 119, 120));
            }
            else {
                Spritehero.setViewport(new Rectangle2D(2, 120, 119, 120));
                i = 0;}
            }
            if (yh<250 & ay==0) {
                i3++;
                if (i3 < lastIndex3) {
                    LargeurW3 = i3 * 126;
                    Spritehero.setViewport(new Rectangle2D(4*120+25-LargeurW3,260,90,120));}
                else{Spritehero.setViewport(new Rectangle2D(4*120+25,260,90,120));i3 = 0;
                }
            }
            if(vx==0 & yh>=250 & xh==0){
                Spritehero.setViewport(new Rectangle2D(11*88, 0, 85, 120));
            }
            if( vx<8 & yh>=250 & xh!=0 & zawardo==0){
                i2++;
                if (i2 < lastIndex2) {
                    LargeurW2 = i2 * 88;
                    Spritehero.setViewport(new Rectangle2D(LargeurW2, 0, 85, 120));
                }
                else {
                    Spritehero.setViewport(new Rectangle2D(0, 0, 85, 120));
                    i2 = 0;}
                }
                if( vx<8 & yh>=250 & xh!=0 & zawardo==1){
                iz++;
                if (iz < lastIndexz) {LargeurWz = iz * 67;
                    Spritehero.setViewport(new Rectangle2D(640+LargeurWz,265,65,150));
                    }
                else {Spritehero.setViewport(new Rectangle2D(640,265,65,150));
                iz = 0;}
                }
    }
    public void jump()//pour le saut il suffit d'appliquer un pic d'accélération sur l'axe des y
    {ay=5;
        DoubleSaut=(DoubleSaut - 1);

    }

    public void update2(long time) //update de la position du héros
    {
        vy=vy+ay*time/1000;
        yh=yh-vy*time;
        xh=xh+vx*(time)/10;
        if (yh<=50){ ay=0;vy=0;saut=1; }
        if((yh<250)){
            speed=0;
            yh=yh+6;
            Spritehero.setY(yh);
        }
        if(speed==0)//update de la hitbox en fonction de la vitesse de l'état de notre héros
        {
            HitBoxH.setX(30 + Spritehero.getX());
            HitBoxH.setY(Spritehero.getY());
            HitBoxH.setHeight(110);
        }
        if(speed==1) {
            HitBoxH.setX(70+ Spritehero.getX());
            HitBoxH.setY(40+Spritehero.getY());
            HitBoxH.setHeight(60);

        }
    }

    public double getVxx(){return vx;}

    public int geti(){return i;}
    public int getDoubleSaut(){return DoubleSaut;}
    public int getSaut(){return saut;}
    public int getStart(){return start;}
    public int getZawardo(){return zawardo;}
    public void setZawardo(int x){this.zawardo = x;}
    public void setStart(int x) {this.start = x;}
    public void setSaut(int x) {this.saut = x;}
    public void setVx(double v){vx=v;}
    public void setDoubleSaut(int v){DoubleSaut=v;}
    public double getX() {return xh;}
    public int getCoeur() {return coeur;}
    public double getY() {return yh;}
    public void setX(double x) {this.xh = x;}
    public Rectangle getHitBox() {return HitBoxH;}


}
