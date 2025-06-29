package com.drawingcanvas.service.intf;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public interface DrawingService {
    void setTool(String tool);
    void handleMousePressed(MouseEvent e);
    void handleMouseDragged(MouseEvent e);
    void handleMouseReleased(MouseEvent e);
    void clearCanvas();
    void setGraphicsContext(GraphicsContext gc);
}