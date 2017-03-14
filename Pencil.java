package mainPackage;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;

public class Pencil implements Brush {
	private int size;
	private Color color;
	final GraphicsContext graphicsContext = Frame.canvas.getGraphicsContext2D();
	public Pencil(int size){
		this.size = size;
	}
	public Pencil(int size, Color color){
		this.size=size;
		this.color=color;
		
	}
	@Override
	public void draw() {
		graphicsContext.setFill(this.color);
		Frame.gc.setFill(this.color);
		System.out.println(this.color);
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
							graphicsContext.beginPath();
							graphicsContext.moveTo(e.getX(), e.getY());
							graphicsContext.stroke();
			}
		}); 
		
	}
	@Override
	public void setSize(int size){
		this.size = size;
	}
	
	public void setColor(Color newColor){
		color = newColor;
	}
	public Color getColor(){
		return this.color;
	}
	
}