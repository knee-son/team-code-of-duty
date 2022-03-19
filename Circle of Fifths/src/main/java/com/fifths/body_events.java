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
    
    //Piano Keys
    @FXML
    private void play_Ab(){
    }
    @FXML
    private void play_A(){}
    @FXML
    private void play_Bb(){}
    @FXML
    private void play_B(){}
    @FXML
    private void play_C(){
        File f = new File("Circle of Fifths/src/main/resources/piano_notes/pno057.mp3");
        Media hit;
        MediaPlayer mediaPlayer;
        System.out.println("C is pressed | "+f.toURI().toString());
        hit = new Media(f.toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }
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
}
