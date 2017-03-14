package mainPackage;

/*
 * This class should set up the general layout of the frame. The goal of the class is to get a menu bar
 * on the left, which has buttons to select brush. 
 */


/*
 * 
 */
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
/*
 * the above imports are mostly from the javaFX API that has been used to create the GUI.
 * V0.05 - a very early working version. Still in the process of creating more brushes/tools. 
 * lines look better, added a menubar, and can change color
 * 
 * 
 * 
 */

public class Frame extends Application {
	/*
	 * The border pane will be the main pane where everything is laid out. on the left, buttons will appear *temporarily removed while working with imageView* 
	 * used to select tools
	 */
	private BorderPane root1 = new BorderPane();
	
	//variable used to set the current brush object.
	public Brush currentBrush = new Pencil(Brush.DEFAULT_SIZE, Brush.DEFAULT_COLOR);
	
	/*
	 * declaring the canvas and graphicsContext up here as static allows the brushes to access them statically, 
	 * this makes it a lot easier to have different brushes do different things.
	 */
	
	static final Canvas canvas = new Canvas(500,500);
	public static GraphicsContext gc = canvas.getGraphicsContext2D();
	
	
	/*
	 * initUI
	 * purpose: to position everything properly on the screen
	 * input: a stage-part of the javaFX API
	 * output: the organised screen to run
	 */
	private void initUI (Stage stage){
		Stage stage1=new Stage();
		stage.setTitle("<Paint>");
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500, Color.WHITE);
		
		MenuBar menu = new MenuBar();
		Menu File, Edit, Help;
		
		File = new Menu("file");
		Edit = new Menu("edit");
		Help = new Menu("help");
		
		menu.getMenus().addAll(File, Edit, Help);
		
		VBox leftButtons = addVBox();
		Group canvas = createCanvas();
		
		
		
	   
		MenuItem colorPick = new MenuItem("select Color", null);
		colorPick.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e){
				colorScreen(stage1);
			}
		});
		
		Edit.getItems().add(colorPick);
		
		
		root1.setTop(menu);
		root1.setCenter(canvas);
		root1.setLeft(leftButtons);
		root.getChildren().add(root1);
		stage.setTitle("<Paint>");
		stage.setScene(scene);
		stage.show();
		
		
		
		
	}
	
	private void colorScreen(Stage stage){
		stage.setTitle("Choose Color");
		FlowPane flow = new FlowPane();
		
		Scene scene = new Scene(flow, 50, 50, Color.HONEYDEW);
		final ColorPicker colorPicker = new ColorPicker();
	    colorPicker.setValue(Brush.DEFAULT_COLOR);
	    flow.getChildren().add(colorPicker);
	    colorPicker.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e){
				currentBrush.setColor(colorPicker.getValue());
				currentBrush.draw();
				stage.close();
			}
		});
	    stage.setScene(scene);
	    stage.show();
	    
	}
	/*
	 * main
	 * launches the program
	 */
	public static void main (String [] args){
		launch (args);
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		initUI(primaryStage);
	}
	/*
	 * addVBox
	 * purpose: this is the buttons section on the left hand side of the screen.
	 * input: nothing
	 * output: returns a vbox filled with buttons
	 */
	private VBox addVBox (){
		//this section is to set up the layout of the vbox
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(15, 12, 15, 12));
		vbox.setSpacing(5);
		vbox.setStyle("-fx-background-color: #84A3F6;");
		//vbox layout done here
		//creating buttons
		//pencil button
			Image pencilImage = null;
			pencilImage = new Image(getClass().getResourceAsStream("stock-tool-pencil-22.png"));
			Button pencilTool = new Button ();
			pencilTool.setGraphic(new ImageView(pencilImage));
			pencilTool.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle (ActionEvent e){
					setBrush(new Pencil(Brush.DEFAULT_SIZE));
				}
			});
		//eraser button
			Image eraserImage = new Image(getClass().getResourceAsStream("stock-tool-eraser-22.png"));
			Button eraserTool = new Button();
			eraserTool.setGraphic(new ImageView(eraserImage));
			eraserTool.setOnAction(new EventHandler<ActionEvent>(){
				@Override 
				public void handle(ActionEvent e){
					setBrush(new Eraser(Brush.DEFAULT_SIZE));
				}
			});
		//brushTool tool
			Image brushImage = new Image(getClass().getResourceAsStream("stock-tool-paintbrush-22.png"));
			Button brushTool = new Button();
			brushTool.setGraphic(new ImageView(brushImage));
			brushTool.setOnAction(new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent e){
					setBrush(new BrushTool(Brush.DEFAULT_SIZE));
				}
			});
		
			
			
		vbox.getChildren().addAll(pencilTool, brushTool, eraserTool);
		return vbox;
	}
	
	/*
	 * createCanvas
	 * purpose: this creates the drawing area in the center of the screen
	 * input: nothing
	 * output: a canvas that you can draw on
	 * 
	 * problems: no clearly defined border, look into finding a way to define that, maybe change the background of the borderlayout
	 */
	private Group createCanvas(){
		Group root = new Group();
		Scene s = new Scene(root, 300, 300, Color.BLACK);
		currentBrush.draw();
		root.getChildren().add(canvas);
		return root;
	}
	
	
	
	
	
	
	/*
	 * setBrush
	 * purpose: to switch the current brush to the desired new brush
	 * input: the new Brush object
	 * output: the current brush will be set to the new brush
	 * 
	 */
	
	public void setBrush(Brush newBrush){
		currentBrush = newBrush;
		currentBrush.draw();
	}
	
}
