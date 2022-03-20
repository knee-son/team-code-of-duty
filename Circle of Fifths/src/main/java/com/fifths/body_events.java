package com.fifths;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;

public class body_events implements Initializable{
    @FXML private GridPane arcs_container;

    private static Media[] note_array = new Media[98];
    private MediaPlayer mp_root;
    private MediaPlayer mp_third;
    private MediaPlayer mp_fifth;

    // para fadeout
    private Timeline fadeout;

    // for the neutral fifth variable:
    // -1:diminished, 0:neutral, 1:augmented
    private byte
        octave = 48,
        is_major_3rd = 1,
        is_neutral_5th = 0,
        is_major_7th = 1;

    @Override
    public void initialize(URL u, ResourceBundle r){
        // reads mp3 into RAM
        for(int i=30; i<=97; i++)
            note_array[i] = new Media(new File("Circle of Fifths/src/main/"+
                "resources/piano_notes/pno0"+i+".mp3").toURI().toString());
        
        // iterate on every circle segment:
        int j=0;
        for (Node arc : arcs_container.getChildrenUnmodifiable()){
        //makes each segment clickable
            final Integer concrete_integer = Integer.valueOf(j++*7%12);

            arc.setOnMousePressed(event -> {
                if (event.getButton() == MouseButton.PRIMARY)
                    is_major_3rd = 1;
                else if (event.getButton() == MouseButton.SECONDARY)
                    is_major_3rd = 0;
                play(concrete_integer);
            //andamon daan ang para fadeout
                fadeout = new Timeline(
                    new KeyFrame(Duration.millis(250), new KeyValue(
                        mp_root.volumeProperty(), 0)),
                    new KeyFrame(Duration.millis(250), new KeyValue(
                        mp_third.volumeProperty(), 0)),
                    new KeyFrame(Duration.millis(250), new KeyValue(
                        mp_fifth.volumeProperty(), 0)) );
            });

        //fades out sound once mouse isn't clicked
            arc.setOnMouseReleased(event -> {
                 fadeout.play(); });
        }
    }

    private void play(int key_without_octave){
        int key = key_without_octave+octave;
        mp_root = new MediaPlayer(note_array[key]);
        mp_third = new MediaPlayer(note_array[key+3+is_major_3rd]);
        mp_fifth = new MediaPlayer(note_array[key+7+is_neutral_5th]); 
        mp_root.play(); mp_third.play(); mp_fifth.play();
    }

    private void octave_up(){if(octave!=84) octave+=12;}
    private void octave_down(){if(octave!=36) octave-=12;}
}