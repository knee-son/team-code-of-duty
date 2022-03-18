module com.fifths {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.fifths to javafx.fxml;
    exports com.fifths;
}
