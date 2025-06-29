package com.drawingcanvas.service.impl;

import com.drawingcanvas.service.intf.DrawingService;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class DrawingServiceImpl implements DrawingService {

    private GraphicsContext gc;
    private String currentTool = "FREEHAND";
    private double startX, startY;

    @Override
    public void setGraphicsContext(GraphicsContext gc) {
        this.gc = gc;
        this.gc.setStroke(Color.BLACK);
        this.gc.setLineWidth(2.0);
    }

    @Override
    public void setTool(String tool) {
        this.currentTool = tool;
    }

    @Override
    public void handleMousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();

        if ("FREEHAND".equals(currentTool)) {
            gc.beginPath();
            gc.moveTo(startX, startY);
            gc.stroke();
        }
    }

    @Override
    public void handleMouseDragged(MouseEvent e) {
        if ("FREEHAND".equals(currentTool)) {
            gc.lineTo(e.getX(), e.getY());
            gc.stroke();
        }
    }

    @Override
    public void handleMouseReleased(MouseEvent e) {
        double endX = e.getX();
        double endY = e.getY();

        switch (currentTool) {
            case "LINE" -> gc.strokeLine(startX, startY, endX, endY);
            case "RECTANGLE" -> gc.strokeRect(Math.min(startX, endX), Math.min(startY, endY),
                    Math.abs(endX - startX), Math.abs(endY - startY));
            case "ELLIPSE" -> gc.strokeOval(Math.min(startX, endX), Math.min(startY, endY),
                    Math.abs(endX - startX), Math.abs(endY - startY));
        }
    }

    @Override
    public void clearCanvas() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }
}
