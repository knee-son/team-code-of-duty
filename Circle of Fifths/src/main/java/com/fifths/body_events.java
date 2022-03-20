package com.fifths;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class body_events implements Initializable{
    @FXML private GridPane arcs_container;

    private static Media[] note_array = new Media[98];
    private MediaPlayer mp_root;
    private MediaPlayer mp_third;
    private MediaPlayer mp_fifth;

    private int octave = 48;
    private int is_major_3rd = 1;
    private int is_major_7th = 1;
    // -1:diminished, 0:neutral, 1:augmented
    private byte is_neutral_5th = 0;

    @Override
    public void initialize(URL u, ResourceBundle r)
    {
        for(int i=30; i<=97; i++){
            note_array[i] = new Media( new File(
                "Circle of Fifths/src/main/"+
                "resources/piano_notes/pno0"+
                i+".mp3").toURI().toString()); }
        
    }

    private void play(int key_without_octave){
        int key = key_without_octave+octave;
        mp_root = new MediaPlayer(note_array[key]);
        mp_third = new MediaPlayer(note_array[key+3+is_major_3rd]);
        mp_fifth = new MediaPlayer(note_array[key+7+is_neutral_5th]); 
        mp_root.play(); mp_third.play(); mp_fifth.play();
    }

    private void octave_up(){octave+=12;}
    private void octave_down(){if(octave!=0) octave-=12;}
}