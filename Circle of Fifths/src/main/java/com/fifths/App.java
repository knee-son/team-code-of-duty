package com.fifths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("cover"));
        stage.setScene(scene);
<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> parent of edb2dc5 (revert to main)
=======
>>>>>>> parent of a9fec6b (Revert "changed resolution to 850x600; edited body.fxml in scenebuilder; wrapped contents into containers for convenience")
        Image icon = new Image("enderpeal.png");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setTitle("Circle of Fifths");
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
        stage.setMaximized(true);
>>>>>>> parent of c62eac8 (changed resolution to 850x600; edited body.fxml in scenebuilder; wrapped contents into containers for convenience)
>>>>>>> parent of edb2dc5 (revert to main)
=======
>>>>>>> parent of a9fec6b (Revert "changed resolution to 850x600; edited body.fxml in scenebuilder; wrapped contents into containers for convenience")
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}