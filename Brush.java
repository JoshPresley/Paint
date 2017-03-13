package mainPackage;

import javafx.scene.paint.Color;

public interface Brush {
	//the default size of a brush on the drawing area. may change depending on how it looks.
	public static final int DEFAULT_SIZE = 5;
	public static final Color DEFAULT_COLOR = Color.BLACK;
	//when the paint method is called in graphics 2d, 
	//this method should be called to carry out the paint actions.
	public void draw();
	public void setSize(int size);
	
}
