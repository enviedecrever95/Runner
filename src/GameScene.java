
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class GameScene extends Scene {

    private StaticThing left;
    private int manu=1;
    private boolean Hit=false;
    private boolean mort=false;
    private StaticThing right;
    public Hero hero;
    private double duration = 100;
    private double duration2 = 50;
    private Camera camera;
    MediaPlayer mediaplayer;
    AudioClip clip;
    String filename="back.png";
    protected Vie life;
    private ArrayList<Foe> FoeList;
    private Parent parent;
    int inv=1;
    protected int j=0;
    protected int j2=0;
    private static int NumberOfLives;
    protected int NbEnnemi=50;
    protected Random rdn;
    protected JFrame f;
    protected Stage primaryStage;
    protected Scene Startscene;
    protected Group root;
    public GameScene(Parent parent, double HEIGHT, double WIDTH, Stage primaryStage,Scene StartScene,Group root) {
        super(parent, HEIGHT, WIDTH);
        this.right = new StaticThing(800, 0, this.filename);
        this.left = new StaticThing(0, 0, this.filename);
        this.parent = parent;
        this.primaryStage=primaryStage;
        this.Startscene=StartScene;
        this.root=root;
        FoeList =new ArrayList<Foe>();

        for(int j=0;j<NbEnnemi;j++){
            rdn=new Random();
            FoeList.add(new Foe(600+j*500+rdn.nextInt(5)*100, 250, "jotacap.png"));
        }
        this.hero = new Hero(178, 100, "sprite3.png");
        this.camera=new Camera(hero.getX(),hero.getY(),hero);
        NumberOfLives=3;
        this.life = new Vie(0, 3, "vie2.png");

        timer.start();
        timer2.start();
        timer3.start();

        playsound("debut.mp3.mp3");


    }

    Long lastT = new Long(System.nanoTime());
    Long lastT2 = new Long(System.nanoTime());
    Long lastT3 = new Long(System.nanoTime());

    //il s'agit de variable qui correspondent à l'instant t à laquelle on les lit
    AnimationTimer timer3 = new AnimationTimer() {
        @Override
        public void handle(long time) {
            long tempsInvincibilité = (time - lastT3.l) / 1000000;
            if (tempsInvincibilité >= 1500) {
                lastT3.l = time;
                inv=0;
            }
        }
    };
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            long diff = (time - lastT.l) / 1000000;
                if (diff >= duration / 1.4) {
                    lastT.l = time;
                        for(int j=0;j<FoeList.size();j++){
                            if (hero.getZawardo()==0) {
                                FoeList.get(j).update(time);
                            }
                            else{
                                FoeList.get(j).freeze();
                            }
                    }
                    hero.update(time);
                }
        }
    };
        AnimationTimer timer2 = new AnimationTimer() {
            @Override
            public void handle(long time2) {
                long diff2 = (time2 - lastT2.l) / 1000000;

                     if (diff2 <= 50) {
                         if(hero.getVxx()>0 & hero.getStart()==1) {
                             playsoundinf("bana.mp3");
                             hero.setStart(0);
                         }
                         hero.update2(diff2);
                         for(int j2=0;j2<FoeList.size();j2++){
                             FoeList.get(j2).update2(diff2);
                             FoeList.get(j2).setVx(hero.getVxx());
                             if(FoeList.get(j2).getHitBox().getBoundsInLocal().intersects(hero.getHitBox().getBoundsInLocal())==true & inv==0){
                                 inv=1;
                                 Hit=true;
                                 if(Hit==true){
                                    life.update(diff2);
                                    if(NumberOfLives==0){

                                     /*  for (int n=0;n<20;n++) {
                                          Icon icon = new ImageIcon("dioanim.gif");
                                          JLabel label = new JLabel(icon);
                                         f = new JFrame("IMPOSSIBLE!!!");
                                           double x= Math.random()*1000;
                                           double y= Math.random()*1000;
                                            f.setLocation((int)x,(int)y);
                                            f.getContentPane().add(label);
                                            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                            f.pack();
                                             f.setResizable(false);
                                            f.setVisible(true);
                                                }*/
                                        this.stop();
                                       playsound("mort.mp3.mp3");
                                       clip.stop();
                                        primaryStage.setScene(Startscene);
                                        //hello
                                        System.out.println("bakana");}
                                    Hit=false;
                                 }
                             }
                         }
                         if( hero.getVxx()>=8 & manu==1){
                             playsound("manukega.mp3.mp3");
                             manu=0;}
                         if(hero.getY()>=248 & hero.getSaut()==1){
                             playsound("sol.mp3");
                             hero.setSaut(0);
                             hero.setDoubleSaut(2);
                         }
                         camera.update(diff2);
                         left.getImgv().setViewport(new Rectangle2D(camera.getX() % 800, 0, 800, 800));
                         right.getImgv().setX(800 - camera.getX() % 800);
                     }
                lastT2.l = time2;


            }};
    public void playsoundinf(String filename)//méthode pour jouer un clip audio indéfiniment
        {
        this.clip = new AudioClip(getClass().getResource(filename).toString());
        clip.setCycleCount(AudioClip.INDEFINITE);
        //On fait ici en sorte que la musique fasse une boucle
        clip.play();
        }
    public void playsound(String filename) //méthode pour jouer un média audio juste une fois
        {
        String path = getClass().getResource(filename).getPath();
        Media media = new Media(new File(path).toURI().toString());
        mediaplayer = new MediaPlayer(media);
        mediaplayer.play();
        }

        public static int getNumberOfLives() {return NumberOfLives;}
        public static void setNumberOfLives(int v) {NumberOfLives=v;}
        public void setHit(){this.Hit=true;}
        public StaticThing getLeft() { return left; }
        public StaticThing getRight() {return right;}
        public Hero getHero() {return hero;}
        public ArrayList<Foe> getFoeList() {return FoeList;}
        public Vie getLife() {return life;}
        public AudioClip getClip() {return clip;}
        public JFrame getFrame() {return this.f;}

        public void setNeg()//méthode qui permet d'avoir le background en négatif
            {this.left = new StaticThing(0, 0, "backn.png");
            this.right = new StaticThing(800, 0, "backn.png");
            left.getImgv().setViewport(new Rectangle2D(camera.getX() % 800, 0, 800, 800));
            right.getImgv().setX(800 - camera.getX() % 800);}

        public void setPosi()//méthode qui permet d'avoir le background en positif
        {this.left = new StaticThing(0, 0, this.filename);
        this.right = new StaticThing(800, 0, this.filename);
            left.getImgv().setViewport(new Rectangle2D(camera.getX() % 800, 0, 800, 800));
            right.getImgv().setX(800 - camera.getX() % 800);}
}



