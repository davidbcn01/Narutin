package sample;

import java.util.TimerTask;

public class Temporizador extends TimerTask{ //clase que se ocupa de controlar la puntuaciondel juego
    //La puntuacion del juego será la siguiente: cada segundo que se este vivo se sumará 1 a la puntuación
    //Esta  clase como su nombre indica es un temporizador que va sumando-


        public int score;

        public Temporizador() {
            score = 0;
        }

        @Override
        public void run() {

            score++;
        }

    }
