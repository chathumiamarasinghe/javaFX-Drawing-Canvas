package com.drawingcanvas.controller;

import com.drawingcanvas.service.impl.DrawingServiceImpl;
import com.drawingcanvas.service.intf.DrawingService;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class CanvasController {

    @FXML private Canvas canvas;
    @FXML private Button lineTool, rectTool, ellipseTool, freehandTool;

    private final DrawingService drawingService = new DrawingServiceImpl();

    @FXML
    public void initialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawingService.setGraphicsContext(gc);

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, drawingService::handleMousePressed);
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, drawingService::handleMouseDragged);
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, drawingService::handleMouseReleased);
    }

    @FXML private void selectLineTool()     { drawingService.setTool("LINE"); }
    @FXML private void selectRectTool()     { drawingService.setTool("RECTANGLE"); }
    @FXML private void selectEllipseTool()  { drawingService.setTool("ELLIPSE"); }
    @FXML private void selectFreehandTool() { drawingService.setTool("FREEHAND"); }
    @FXML private void clearCanvas()        { drawingService.clearCanvas(); }
}
