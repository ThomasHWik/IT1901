module app {
    requires transitive com.fasterxml.jackson.databind;
    requires javafx.controls;
    requires javafx.fxml;

    opens app to javafx.graphics, javafx.fxml;
}
