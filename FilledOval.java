package mainPackage;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class FilledOval implements Brush {
	private int size=Brush.DEFAULT_SIZE;
	private Color color;
	private double x1, x2, y1, y2;
	
	
	public FilledOval(){
		
	}
	
	@Override
	public void draw() {
		Frame.gc.setStroke(this.color);
		Frame.gc.setFill(this.color);
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
				if (x1<x2&&y1<y2)
					Frame.gc.fillOval(x1, y1, Math.abs(x2-x1), Math.abs(y2-y1));
				else if (x2<x1&&y1<y2)
					Frame.gc.fillOval(x2, y1, Math.abs(x2-x1), Math.abs(y2-y1));
				else if (x2<x1&&y2<y1)
					Frame.gc.fillOval(x2, y2, Math.abs(x2-x1), Math.abs(y2-y1));
				else if (x1<x2&&y2<y1)
					Frame.gc.fillOval(x1, y2, Math.abs(x2-x1), Math.abs(y2-y1));
			}
		});

	}

	@Override
	public void setSize(int size) {
		// TODO Auto-generated method stub
		this.size=size;
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		this.color=color;
	}

	@Override
	public Color getColor() {
		return this.color;
		
	}
}
