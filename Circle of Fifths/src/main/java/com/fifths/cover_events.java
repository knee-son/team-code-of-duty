package com.fifths;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Box;
import javafx.util.Duration;

public class cover_events implements Initializable{

    @FXML private Box mybox;
    
    @FXML
    private void button_pressed() throws IOException {
        App.setRoot("body_modified");
    }
   
    @Override
    public void initialize(URL u, ResourceBundle r) {
        // TODO Auto-generated method stub
        FadeTransition ft = new FadeTransition(Duration.millis(3000), mybox);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
    }
}
