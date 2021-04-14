package sample;

import java.util.TimerTask;

public class Temporizador extends TimerTask{


        public int score;

        public Temporizador() {
            score = 0;
        }

        @Override
        public void run() {

            score++;
        }

    }
