//package mainPackage;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

public class BrushTool implements Brush {
	private int size=Brush.DEFAULT_SIZE;
	final GraphicsContext graphicsContext = Frame.canvas.getGraphicsContext2D();
	private Color color = Brush.DEFAULT_COLOR;
	public BrushTool(int size){
		this.size=size;
	}
	public BrushTool(int size, Color color){
		this.size=size;
		this.color=color;
	}
	@Override
	public void draw() {
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
		
	}

	@Override
	public void setSize(int size) {
		// TODO Auto-generated method stub

	}

}
