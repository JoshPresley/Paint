package mainPackage;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LineTool implements Brush {
	double x1, y1, x2, y2;
	
	private Color color;
	public LineTool(){
		
	}
	@Override
	public void draw() {
		Frame.gc.setStroke(this.color);
		// TODO Auto-generated method stub
		Frame.canvas.setOnMousePressed(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e){
				x1 = e.getX();
				y1 = e.getY();
			}
		});
		Frame.canvas.setOnMouseDragged(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e){
				
			}
		});
		Frame.canvas.setOnMouseReleased(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent e){
				x2 = e.getX();
				y2 = e.getY();
				Frame.gc.strokeLine(x1,y1,x2,y2);
			}
		});

	}

	@Override
	public void setSize(int size) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColor(Color color) {
		this.color=color;

	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

}
