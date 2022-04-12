package com.fifths;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;

public class body_events implements Initializable {
    @FXML private GridPane arcs_container;
    @FXML private ImageView guide_View;
    @FXML private ImageView guide_LetterKey;
    @FXML private ImageView guide_Keyboard;
    @FXML private ToggleGroup instrument;

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
        is_neutral_5th = 0;
        // is_major_7th = 1;
    
    private byte[] current_chord = new byte[3];

    @FXML
    private void tina_pressed() throws IOException {
        App.setRoot("credits");
    }

    @Override
    public void initialize(URL u, ResourceBundle r){

        // loads mp3 into RAM on first use
        switch_instrument(instrument.getSelectedToggle().toString());

        // iterate on every circle segment:
        int j=0;
        for (Node arc : arcs_container.getChildrenUnmodifiable()){
            // makes each segment clickable
            final Integer final_j = j++;

            arc.setOnMousePressed(event -> {
                //to know if minor or major is selected

                if (event.getButton() == MouseButton.PRIMARY)
                    if (final_j<12) {is_major_3rd=1; play((final_j)*7%12);}
                    else {is_major_3rd=0; play((final_j)*7%12);}
                else if (event.getButton() == MouseButton.SECONDARY)
                    if (final_j<12) {is_major_3rd=0; play((final_j)*7%12);}
                    else {is_major_3rd=1; play((final_j*7-1)%12);}

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
        
        // determines if nichange ba ug piano or guitar
        instrument.selectedToggleProperty().addListener((a,b,c)->
            switch_instrument(c.toString()));
    }

    private void play(int key){
        // para ilis sa chord guide
        final String[] keystrings = {"C","Db","D","Eb","E","F","Gb","G","Ab","A","Bb","B"};
        String dir = "file:Circle of Fifths/src/main/resources/piano_guideKeys/";
        String keystring = keystrings[key] + (is_major_3rd==0 ? "m":"") + ".png";

        guide_View.setImage(new Image(dir+"pianoKey"+keystring));
        guide_LetterKey.setImage(new Image(dir+"guideKeys_Letters/letterKey"+keystring));
        guide_Keyboard.setImage(new Image(dir+"guideKeyboard/guideKeyboard"+keystring));

        if(current_chord[0] != 0)
            for(byte note: current_chord){
                note_array[note].stop();
                note_array[note].setVolume(1); }

        current_chord[0] = (byte)(key+octave);
        current_chord[1] = (byte)((key+3)%auto_inversion+is_major_3rd+octave);
        current_chord[2] = (byte)((key+7)%auto_inversion+is_neutral_5th+octave);
        
        if(fadeout != null) fadeout.stop();

        for(byte note: current_chord) note_array[note].play();
        
    }

    private void switch_instrument(String s){
        for(int i=0; i<note_array.length; i++) note_array[i]=null;
        
        String instrument_name = s.substring(s.indexOf("'"));

        if(instrument_name.equals("'Piano'")){
            for(int i=30; i<=97; i++)
                note_array[i] =
                    new MediaPlayer( new Media( new File(
                        "Circle of Fifths/src/main/"+
                        "resources/piano_notes/pno0"+
                        i+".mp3").toURI().toString()));
        }
        else if(instrument_name.equals("'Guitar'")){
            for(int i=40; i<=88; i++)
            note_array[i] =
                new MediaPlayer( new Media( new File(
                    "Circle of Fifths/src/main/"+
                    "resources/guitar_notes/guitar_"+
                    i+".wav").toURI().toString()));
        }

    }

    // private void octave_up(){if(octave!=84) octave+=12;}
    // private void octave_down(){if(octave!=36) octave-=12;}
}