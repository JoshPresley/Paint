package mainPackage;

/*
 * This class should set up the general layout of the frame. The goal of the class is to get a menu bar
 * on the left, which has buttons to select brush. 
 */
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


public class Frame extends Application {
	private BorderPane root = new BorderPane();
	
	private void initUI (Stage stage){
		VBox leftButtons = addVBox();
		root.setLeft(leftButtons);
		Scene scene = new Scene(root, 300, 300);
		Group canvas = createCanvas();
		root.setCenter(canvas);
		
		
		
		
		
		
		stage.setTitle("<Paint>");
		stage.setScene(scene);
		stage.show();
		
		
		
		
	}
	public static void main (String [] args){
		launch (args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		initUI(primaryStage);
	}
	
	private VBox addVBox (){
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(15, 12, 15, 12));
		vbox.setSpacing(5);
		vbox.setStyle("-fx-background-color: #84A3F6;");
		Button [] buttonList = new Button [10];
		for (int i=0;i<10;i++){
			buttonList[i] = new Button();
			buttonList[i].setAccessibleHelp("placeholder");
			vbox.getChildren().addAll(buttonList[i]);
		}
		return vbox;
	}
	
	private Group createCanvas(){
		Group root = new Group();
		Scene s = new Scene(root, 300, 300, Color.BLACK);

		final Canvas canvas = new Canvas(500,500);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, 
			       new EventHandler<MouseEvent>() {
			           @Override
			           public void handle(MouseEvent e) {
			               gc.fillRect(e.getX() - 2, e.getY() - 2, 5, 5);
			           }
			       });
		
		 
		root.getChildren().add(canvas);
		return root;
	}
	
}
