package sample;

import javafx.scene.image.Image;

import java.util.Random;

public class Kunai extends Sprite {
    Random r = new Random();
    int num =1;
    public Kunai(Image image) {
        super(image);
        setY(r.nextInt(380-20)+20);
        setX(620);
    }

    @Override
    public void move() {
        setX(getPosX()-num);
    }

}
