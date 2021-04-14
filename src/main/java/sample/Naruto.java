package sample;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public class Naruto  extends Sprite {



        public Naruto(Image image) {
            super(image);
            setY(400-getHeight());
        }

        @Override
        public void move(String direction) {

            switch (direction) {
                case "RIGHT":
                    if(getPosX() >=600-getWidth()){

                    }else {
                        setX(getPosX() + 10);
                        Image image = new Image("images/NarutoVer3R.png");
                        setImage(image);
                    }
                    break;
                case "LEFT":
                    if(getPosX() <= 0){

                    }else {
                        setX(getPosX() - 10);
                        Image image = new Image("images/NarutoVer3L.png");
                       setImage(image);
                    }
                    break;
                case "UP":
                    if(getPosY() <= 0){

                    }else{
                        setY(getPosY() - 10);
                    }

                    break;
                case "DOWN":
                    if(getPosY() >= 400-getHeight()){

                    }else{
                        setY(getPosY() + 10);
                    }
                    break;
            }
        }




    }