package com.fifths;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class cover_events implements Initializable{

    //@FXML private Box mybox;

    @FXML
    private void button_pressed() throws IOException {
        App.setRoot("body_modified");
    }

    @Override
    public void initialize(URL u, ResourceBundle r) {
        // TODO Auto-generated method stub
        
    }
}
