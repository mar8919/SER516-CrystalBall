package crystalBall;

import java.io.IOException;

import com.sun.javafx.css.StyleCache.Key;

import crystalBall.UIController.Screen;
import javafx.animation.FillTransition; 
import javafx.application.Application; 
import javafx.application.Platform;
import javafx.scene.Group; 
import javafx.scene.Parent;
import javafx.scene.Scene; 
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Rectangle; 
import javafx.stage.Stage; 
import javafx.stage.WindowEvent;
import javafx.animation.Timeline; 
import javafx.animation.ParallelTransition; 
import javafx.animation.RotateTransition; 
import javafx.animation.ScaleTransition; 
import javafx.animation.TranslateTransition; 
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.util.Duration; 
 
public class MainApplication extends Application { 
	
	public static UIController uiController;
	private VoiceRecognitionControl vrControl;
	private Stage stage;
 
    @SuppressWarnings("unchecked")
	@Override 
    public void start(Stage stage) { 
    	this.stage = stage;
    	
    	uiController = new UIController(this.stage);
    	vrControl = new VoiceRecognitionControl(this);
    	
    	EventHandler vrHandler = new EventHandler<KeyEvent>(){

			public void handle(KeyEvent event) {
                KeyCode key = event.getCode();
                if (key == KeyCode.SPACE) {
                	vrControl.triggerVoice();
                    event.consume();
                }
			}
    		
    	};
        Parent root;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("hub/hubView.fxml"));
	        stage.setTitle("CrystalBall");
	        stage.setScene(new Scene(root, 960, 540));
	        stage.show();
	        stage.setMaxHeight(540);
	        stage.setMaxWidth(960);
	        stage.setResizable(false);
	        stage.addEventHandler(KeyEvent.KEY_RELEASED, vrHandler);
	        
	        Thread th = new Thread(vrControl);
	        th.setDaemon(true);
	        th.start();
	        
	        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

	            public void handle(WindowEvent event) {
	                Platform.runLater(new Runnable() {

	                    public void run() {
	                        System.exit(0);
	                    }
	                });
	            }
	        });
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    } 
    
    /*
     * Want the uicontroller to be private, but need to figure out how to access hubcontroller(etc.)
     */
    public static void changeScene(Screen name){
    	uiController.changeScene(name);
    }
 
    public static void main(String[] args) { 
        launch(args); 
    } 
}
