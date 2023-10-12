module PadelApp.ui {
    requires PadelApp.core;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    exports PadelApp.ui;

    opens PadelApp.ui to javafx.graphics, javafx.fxml;
}
