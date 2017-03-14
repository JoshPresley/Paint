package mainPackage;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Eraser implements Brush {
	private int size;
	
	public Eraser (int size){
		this.size = size;
	}
	
	@Override
	public void draw() {
		Frame.canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
			           @Override
			           public void handle(MouseEvent e) {
			               Frame.gc.clearRect(e.getX() - 2, e.getY() - 2, size, size);
			           }
			       });
		Frame.canvas.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e){
				Frame.gc.clearRect(e.getX() - 2, e.getY() - 2, size, size);	
			}
		}); 
		
	}
	@Override
	public void setSize(int size){
		this.size = size;
	}
	@Override
	public void setColor(Color color){
		
	}
	@Override
	public Color getColor(){
		return Brush.DEFAULT_COLOR;
	}
}
