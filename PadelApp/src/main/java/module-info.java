module app {
    requires transitive com.fasterxml.jackson.databind;
    requires javafx.controls;
    requires javafx.fxml;

    exports Logic to com.fasterxml.jackson.databind, FileManaging;
    opens Logic to com.fasterxml.jackson.databind, FileManaging;

    opens app to javafx.graphics, javafx.fxml;
}
