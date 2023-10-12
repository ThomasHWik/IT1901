module PadelApp.ui {
    requires PadelApp.core;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;

    opens PadelApp.ui to javafx.graphics, javafx.fxml;
}
