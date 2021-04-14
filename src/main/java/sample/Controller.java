package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    private Scene scene;
    private GraphicsContext gc;
    private Image fons;
    private Naruto naruto;
    private Kunai kunai;
    //public int score = 0;
    String c;
    String d;
    Media sonido;
    Media sonido2;
    MediaPlayer player;
    MediaPlayer player2;

    Temporizador temporizador = new Temporizador();
    Timer timer = new Timer();
    private boolean acabado = false;
    Random r = new Random();

    //Media media = new Media(getClass().getResource("music/SadnessAndSorrow.mp3").toURI().toString());
    ArrayList<Kunai> kunaiList = new ArrayList<Kunai>();
    @FXML
    Canvas mainCanvas;
    Image image = new Image("images/ianuk.png");

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.016), new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {

            int a = r.nextInt(300-1)+1;
            System.out.println(a);
            int bound = 285;
            if(temporizador.score >=30){
                bound = 260;
            }
            if(a>bound){
                kunai = new Kunai(image);
                kunaiList.add(kunai);
            }

            gc.drawImage(fons, 0,0,600,400);
            naruto.render(gc);

            for(Kunai kunai : kunaiList){

                kunai.move();
                kunai.render(gc);
               /*if(temporizador.score % 20 == 0 && temporizador.score >= 20){
                   kunai.num+=1;
               }*/

                if(temporizador.score>=20 && temporizador.score<39){
                    kunai.num=2;
                }else if(temporizador.score>40){
                    kunai.num=3;
                }
                if(kunai.getBoundary().intersects(naruto.getBoundary())){
                    fons = new Image("images/geimober.png");
                    acabado = true;
                }

            }
            gc.setFill(Color.YELLOW);
            gc.setFont(Font.font(16));
            gc.fillText("SCORE:",50,20);
            gc.fillText(String.valueOf(temporizador.score),120,20);

            if(acabado){
                player2.stop();
                gc.drawImage(fons,0,0,600,400);
                gc.setFill(Color.RED);
                gc.setFont(Font.font(46));


                gc.fillText("GAME OVER",300,300);
                gc.fillText("SCORE: "+ String.valueOf(temporizador.score),300,350);

                c = getClass().getClassLoader().getResource("music/SadnessAndSorrow.mp3").toExternalForm();
                sonido = new Media(c);
                player = new MediaPlayer(sonido);
                player.setVolume(1);
                player.setAutoPlay(true);
                player.play();


                timeline.stop();

            }



        }
    })
    );



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        naruto = new Naruto(new Image("images/NarutoVer3R.png"));
        fons = new Image("images/fondo.png");
        kunai = new Kunai(image);
        kunaiList.add(kunai);
        gc = mainCanvas.getGraphicsContext2D();
        gc.drawImage(fons, 0,0,600,400);
        naruto.render(gc);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        d = getClass().getClassLoader().getResource("music/NarutoBadFlute.mp3").toExternalForm();
        sonido2 = new Media(d);
        player2 = new MediaPlayer(sonido2);
        player2.setVolume(1);
        player2.setAutoPlay(true);
        player2.setCycleCount(MediaPlayer.INDEFINITE);
        player2.play();
        timer.scheduleAtFixedRate(temporizador, 0, 1000);

    }

    public void setScene(Scene sc) {
        scene = sc;
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                //gc.drawImage(fons,0,0,600,400);
                //kunai.render(gc);
                naruto.move(keyEvent.getCode().toString());


            }
        });
    }
}