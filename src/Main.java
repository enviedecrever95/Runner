import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Math.random;


public class Main extends Application {
    private ImageView vie;

        @Override
    public void start(Stage primaryStage) throws Exception{

            primaryStage.setTitle("Dio Brando");
            Image image = new Image(new FileInputStream("images\\intro.gif"));
            ImageView imagevieww = new ImageView(image);
            imagevieww.setPreserveRatio(true);
            Group welcome =new Group(imagevieww);
            Title scene = new Title(welcome, 500, 280);

            Button btn = new Button("START THE GAME");
            btn.setLayoutX(80);
            btn.setLayoutY(170);
            welcome.getChildren().add(btn);

            primaryStage.setScene(scene);

           btn.setOnMouseClicked( (event)->{

               scene.getClip().stop();
               Group root = new Group();
               GameScene scene1 = new GameScene(root,800,400,primaryStage,scene,root);//pour pouvoir reset la scene on met notre start secen en argumant
               //scene1.getFrame().removeAll();
               root.getChildren().add(scene1.getRight().getImgv());
               root.getChildren().add(scene1.getLeft().getImgv());
               root.getChildren().add(scene1.getHero().getSprite());
              // root.getChildren().add(scene1.getHero().getHitBox());
               for(int n=0;n<scene1.getFoeList().size();n++) {
                   root.getChildren().add(scene1.getFoeList().get(n).getSprite());
                  // root.getChildren().add(scene1.getFoeList().get(n).getHitBox());
               }
               root.getChildren().add(scene1.getLife().getSpriteVie());
               vie=scene1.getLife().getSpriteVie();
               //on fait une sauvegarde de l'affichage de la vie de notre personnage qui peut etre clear lors des changements de fonds


               primaryStage.setScene(scene1);

               scene1.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
                   if(key.getCode()== KeyCode.SPACE) //on appuie sur Barre espace on saute (double saut)
                   {
                       if(scene1.getHero().getDoubleSaut()>0) {
                           scene1.getHero().jump();
                           scene1.playsound("shine.mp3.mp3");
                       }
                   }
                   if(key.getCode()== KeyCode.Z)// appuie sur Z= fond passe en négatif les enemis sont figés et notre héros s'arrete
                   {
                       scene1.setNeg();
                       root.getChildren().removeAll();
                       root.getChildren().clear();
                       root.getChildren().add(scene1.getRight().getImgv());
                       root.getChildren().add(scene1.getLeft().getImgv());
                       root.getChildren().add(scene1.getHero().getSprite());
                      // root.getChildren().add(scene1.getHero().getHitBox());
                       for(int n=0;n<scene1.getFoeList().size();n++) {
                           root.getChildren().add(scene1.getFoeList().get(n).getSprite());
                          // root.getChildren().add(scene1.getFoeList().get(n).getHitBox());

                       }
                       root.getChildren().add(vie);
                       scene1.getHero().setVx(0);
                       scene1.getClip().stop();
                       scene1.playsound("ZaWardo.mp3");
                       scene1.getHero().setStart(1);
                       scene1.getHero().setZawardo(1);
                   }
                   if(key.getCode()== KeyCode.S) // S comme speed pour faire gagner de la vitesse à notre heros

                   {
                       scene1.getHero().setVx(scene1.getHero().getVxx() + 3);
                        if(scene1.getHero().getZawardo()==1) {
                            scene1.setPosi();
                            root.getChildren().removeAll();
                            root.getChildren().clear();
                            root.getChildren().add(scene1.getRight().getImgv());
                            root.getChildren().add(scene1.getLeft().getImgv());
                            root.getChildren().add(scene1.getHero().getSprite());
                            for(int n=0;n<scene1.getFoeList().size();n++) {
                                root.getChildren().add(scene1.getFoeList().get(n).getSprite());
                                //root.getChildren().add(scene1.getFoeList().get(n).getHitBox());
                                }

                            root.getChildren().add(vie);
                            scene1.getHero().setZawardo(0);

                        }
                   }
               });

            });

         primaryStage.show();
        }

        public static void main(String[] args) {
        launch(args);

        }
 }






