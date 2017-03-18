package mainPackage;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class BrushTool implements Brush {
	private int size=Brush.DEFAULT_SIZE;
	final GraphicsContext graphicsContext = Frame.canvas.getGraphicsContext2D();
	private Color color;
	public BrushTool(int size){
		this.size=size;
	}
	public BrushTool(int size, Color color){
		this.size=size;
		this.color=color;
	}
	@Override
	public void draw() {
		graphicsContext.setStroke(this.color);
		graphicsContext.setLineWidth(size);
		Frame.canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
	           @Override
	           public void handle(MouseEvent e) {
	        	   graphicsContext.lineTo(e.getX(), e.getY());
	               graphicsContext.stroke();
	           }
	       });
		Frame.canvas.setOnMousePressed(new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent e){
					graphicsContext.setLineWidth(size);
					graphicsContext.beginPath();
                	graphicsContext.moveTo(e.getX(), e.getY());
                	graphicsContext.stroke();
				}
			}); 
		Frame.canvas.setOnMouseReleased(null);
	}

	@Override
	public void setSize(int size) {
		this.size = size;
		graphicsContext.setLineWidth(size);
	}
	@Override
	public void setColor(Color color){
		this.color=color;
	}
	@Override
	public Color getColor(){
		return this.color;
	}
}
