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
        Image icon = new Image("enderpeal.png");
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setTitle("Circle of Fifths");
=======
        stage.setMaximized(true);
>>>>>>> parent of c62eac8 (changed resolution to 850x600; edited body.fxml in scenebuilder; wrapped contents into containers for convenience)
        stage.show();

        // //-- sample without using .fxml--
        // //Creating an image 
        // Image image = new Image(new FileInputStream("demo/src/main/resources/chart.png"));  
        // //Setting the image view 
        // ImageView imageView = new ImageView(image);
        // //setting the fit height and width of the image view 
        // imageView.setFitHeight(500); 
        // imageView.setFitWidth(500);
        // //Setting the preserve ratio of the image view 
        // imageView.setPreserveRatio(false);

        // //Creating a Button
        // Button button = new Button();
        // //Setting text to the button
        // button.setText("play sound");
        // //Setting the location of the button
        // button.setTranslateX(212);
        // button.setTranslateY(460);

        // //Creating a Group object  
        // Group root = new Group(imageView,button);
        // //Creating a scene object
        // Scene scene = new Scene(root);  
        // //Setting title to the Stage
        // stage.setTitle("Code of Dutyyy ✊😭");
        // //Adding scene to the stage 
        // stage.setScene(scene);
        // stage.setMaximized(true);
        // //Displaying the contents of the stage 
        // stage.show(); 
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