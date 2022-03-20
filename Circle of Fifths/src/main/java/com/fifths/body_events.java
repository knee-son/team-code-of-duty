package com.fifths;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class body_events implements Initializable{
    @FXML private Circle circle_outline;
    @FXML private Pane fingering_guide;

    private static Media[] note_array = new Media[98];
    private MediaPlayer mp_root;
    private MediaPlayer mp_third;
    private MediaPlayer mp_fifth;

    private int octave = 48;
    private boolean is_major_3rd = true;
    private boolean is_major_7th = true;
    // -1:diminished, 0:neutral, 1:augmented
    private byte is_neutral_5th = 0;

    @Override
    public void initialize(URL u, ResourceBundle r)
    {
        for(int i=30; i<=97; i++){
            note_array[i] = new Media(
                new File(
                    "Circle of Fifths/src/main/"+
                    "resources/piano_notes/pno0"+
                    i+".mp3").toURI().toString());
        }
    }
    
    @FXML private void play_C()  { play(0);  }
    @FXML private void play_Db() { play(1);  }
    @FXML private void play_D()  { play(2);  }
    @FXML private void play_Eb() { play(3);  }
    @FXML private void play_E()  { play(4);  }
    @FXML private void play_F()  { play(5);  }
    @FXML private void play_Gb() { play(6);  }
    @FXML private void play_G()  { play(7);  }
    @FXML private void play_Ab() { play(8);  }
    @FXML private void play_A()  { play(9);  }
    @FXML private void play_Bb() { play(10); }
    @FXML private void play_B()  { play(11); }

    private void play(int key_without_octave){
        int key = key_without_octave+octave;
        mp_root = new MediaPlayer(note_array[key]);
        mp_root.play();
    }

    // private void octave_up(){octave+=12;}
    // private void octave_down(){if(octave!=0) octave-=12;}
}
