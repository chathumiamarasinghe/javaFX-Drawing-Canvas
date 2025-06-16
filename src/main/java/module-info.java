module com.drawingcanvas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.drawingcanvas to javafx.fxml;
    exports com.drawingcanvas;
    exports com.drawingcanvas.controller;
    opens com.drawingcanvas.controller to javafx.fxml;
}