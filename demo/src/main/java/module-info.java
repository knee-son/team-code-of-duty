module com.fifths {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.fifths to javafx.fxml;
    exports com.fifths;
}
