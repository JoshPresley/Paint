package mainPackage;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class BrushTool implements Brush {
	private int size=Brush.DEFAULT_SIZE;
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
		Frame.gc.setFill(this.color);
		Frame.canvas.setOnMouseDragged(new EventHandler<MouseEvent>() {
	           @Override
	           public void handle(MouseEvent e) {
	               Frame.gc.fillRoundRect(e.getX() - 2, e.getY() - 2, size+5, size+5, 20, 20);
	           }
	       });
		Frame.canvas.setOnMousePressed(new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent e){
					Frame.gc.fillRoundRect(e.getX() - 2, e.getY() - 2, size+5, size+5, 20, 20);	
				}
			}); 
		
	}

	@Override
	public void setSize(int size) {
		// TODO Auto-generated method stub

	}
	@Override
	public void setColor(Color color){
		this.color=color;
	}
	
	public Color getColor(){
		return this.color;
	}
}
