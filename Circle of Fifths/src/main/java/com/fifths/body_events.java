package com.fifths;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class body_events {
    @FXML private Circle circle_outline;
    @FXML private Pane fingering_guide;
    private File f;
    private Media hit;
    private MediaPlayer mediaPlayer;
    private static double note_down = Math.pow(2, -1.0/12.0);
    private static double note_up = Math.pow(2, 1.0/12.0);
    
    //Piano Keys
    @FXML
    private void play_Ab(){
        play(63, note_down);
    }
    @FXML
    private void play_A(){
        play(63, 1.0);
    }
    @FXML
    private void play_Bb(){
        play(63, note_up);
    }
    @FXML
    private void play_B(){
        play(66, note_down);
    }
    @FXML
    private void play_C(){
        play(66, 1.0);
    }
    @FXML
    private void play_Db(){
        play(66, note_up);
    }
    @FXML
    private void play_D(){
        play(69, note_down);
    }
    @FXML
    private void play_Eb(){
        play(69, 1.0);
    }
    @FXML
    private void play_E(){
        play(66, note_up);
    }
    @FXML
    private void play_F(){
        play(60, note_down);
    }
    @FXML
    private void play_Gb(){
        play(60, 1.0);
    }
    @FXML
    private void play_G(){
        play(60, note_up);
    }

    private void play(int key, double pitch){
        f = new File("Circle of Fifths/src/main/resources/piano_notes/pno0"+key+".mp3");
        hit = new Media(f.toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setRate(pitch);
        mediaPlayer.play();
    }
}
