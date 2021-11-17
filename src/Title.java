
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;

import javax.swing.*;

public class Title extends Scene {

    private StaticThing left;
    private Hero hero;
    private double duration = 100;
    private AudioClip clip;
    protected JFrame f;
    int k=0;

    public Title(Parent parent, double HEIGHT, double WIDTH) {

        super(parent, HEIGHT, WIDTH);

        for (int n=0;n<1;n++) {
            Icon icon = new ImageIcon("dioanim.gif");
            JLabel label = new JLabel(icon);

        }

        timer3.start();


        playsoundinf("bana.mp3");

    }
    public void playsoundinf(String filename) {

        this.clip = new AudioClip(getClass().getResource(filename).toString());
        clip.play();

    }
    Long lastT = new Long(System.nanoTime());
    AnimationTimer timer3 = new AnimationTimer() {
        @Override
        public void handle(long time) {
            long diff = (time - lastT.l) / 900000;
            if (diff >= duration / 0.9) {
                lastT.l = time;


            }
        }
    };
    public StaticThing getLeft() {
        return left;
    }

    public Hero getHero() {
        return hero;
    }
    public AudioClip getClip() {return clip;}
}
