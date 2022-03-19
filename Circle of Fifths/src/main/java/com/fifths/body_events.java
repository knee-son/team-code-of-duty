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
    
    //Piano Keys
    @FXML
    private void play_Ab(){
        play(30);
    }
    @FXML
    private void play_A(){
        play(33);
    }
    @FXML
    private void play_Bb(){}
    @FXML
    private void play_B(){}
    @FXML
    private void play_C(){}
    @FXML
    private void play_Db(){}
    @FXML
    private void play_D(){}
    @FXML
    private void play_Eb(){}
    @FXML
    private void play_E(){}
    @FXML
    private void play_F(){}
    @FXML
    private void play_Gb(){}
    @FXML
    private void play_G(){}

    private void play(int key){
        f = new File("Circle of Fifths/src/main/resources/piano_notes/pno0"+key+".mp3");
        hit = new Media(f.toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }
}
