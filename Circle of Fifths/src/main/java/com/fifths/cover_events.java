package com.fifths;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class cover_events implements Initializable{

    @FXML private Pane pane;
    
    @FXML
    private void button_pressed() throws IOException {
        App.setRoot("body");
    }
   
    @Override
    public void initialize(URL u, ResourceBundle r) {
        FadeTransition ft = new FadeTransition(Duration.millis(3000), pane);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }
}
