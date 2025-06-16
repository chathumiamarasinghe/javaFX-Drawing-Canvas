module com.drawingcanvas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.drawingcanvas to javafx.fxml;
    exports com.drawingcanvas;
}