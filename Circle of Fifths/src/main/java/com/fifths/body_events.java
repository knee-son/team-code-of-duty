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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

public class body_events implements Initializable{
    @FXML private GridPane arcs_container;
    @FXML private ImageView guide_View;

    private static MediaPlayer[] note_array = new MediaPlayer[98];

    // para fadeout
    private Timeline fadeout;

    // auto inversion: used to do the % operator
    // para ma fit sa octave kada key
    // for the neutral fifth variable:
    // -1:diminished, 0:neutral, 1:augmented
    private byte
        auto_inversion = 12,
        octave = 48,
        is_major_3rd = 1,
        is_neutral_5th = 0,
        is_major_7th = 1;
    
    private byte[] current_chord = new byte[3];

    @Override
    public void initialize(URL u, ResourceBundle r){

        // reads mp3 into RAM
        for(int i=30; i<=97; i++)
            note_array[i] =
                new MediaPlayer( new Media( new File(
                    "Circle of Fifths/src/main/"+
                    "resources/piano_notes/pno0"+
                    i+".mp3").toURI().toString()));

        // iterate on every circle segment:
        int j=0;
        for (Node arc : arcs_container.getChildrenUnmodifiable()){
        // makes each segment clickable
            final Integer key = Integer.valueOf(j++*7%12);

            arc.setOnMousePressed(event -> {
                //to know if minor or major is selected
                int keySelect = 0;

                if (event.getButton() == MouseButton.PRIMARY){
                    is_major_3rd = 1;
                    keySelect = 1;
                }
                else if (event.getButton() == MouseButton.SECONDARY){
                    is_major_3rd = 0;
                    keySelect = 2;
                }       
                play(key, keySelect);
            // andamon daan ang para fadeout
                fadeout = new Timeline(
                    new KeyFrame(Duration.millis(200), new KeyValue(
                        note_array[current_chord[0]].volumeProperty(),0)),
                    new KeyFrame(Duration.millis(200), new KeyValue(
                        note_array[current_chord[1]].volumeProperty(),0)),
                    new KeyFrame(Duration.millis(200), new KeyValue(
                        note_array[current_chord[2]].volumeProperty(),0)));
            });

        // fades out sound once mouse isn't clicked
            arc.setOnMouseReleased(event -> { fadeout.play(); });            
        }
    }

    private void play(int key, int keySelected){
        // para ilis sa chord guide
        String[] keystringMajor = {"C","Db","D","Eb","E","F","Gb","G","Ab","A","Bb","B"};
        String[] keystringMinor = {"Cm","Dbm","Dm","Ebm","Em","Fm","Gbm","Gm","Abm","Am","Bbm","Bm"};

        if(keySelected == 1){
            //show major key
            Image pianoImage = new Image(
                "file:Circle of Fifths/src/main/resources/piano_guideKeys/pianoKey"+keystringMajor[key]+".png");
            guide_View.setImage(pianoImage);
        }
        else if(keySelected == 2){
            //show minor key
            Image pianoImage = new Image(
                "file:Circle of Fifths/src/main/resources/piano_guideKeys/pianoKey"+keystringMinor[key]+".png");
            guide_View.setImage(pianoImage);
        }
        
        if(current_chord[0] != 0){
            for(byte note: current_chord){
                note_array[note].stop();
                note_array[note].setVolume(1); }}

        current_chord[0] = (byte)(key+octave);
        current_chord[1] = (byte)((key+3)%auto_inversion+is_major_3rd+octave);
        current_chord[2] = (byte)((key+7)%auto_inversion+is_neutral_5th+octave);
        
        if(fadeout != null) fadeout.stop();

        for(byte note: current_chord) note_array[note].play();
        
    }

    private void octave_up(){if(octave!=84) octave+=12;}
    private void octave_down(){if(octave!=36) octave-=12;}

    // //guide panel
    // public void displayImageGuide() {   
    //     Image pianoImage = new Image(getClass().getResourceAsStream("Circle of Fifths/src/main/resources/piano_guideKeys/pianoKeyC.png"));
    //     guide_View.setImage(pianoImage); 
    // }
}