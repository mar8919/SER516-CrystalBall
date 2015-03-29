

package hub;

import java.net.URL;
import java.util.ResourceBundle;

import crystalBall.UIController.Screen;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class HubController {

	private static HubController controller;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="windowsButton"
    private VBox windowsButton; // Value injected by FXMLLoader

    @FXML // fx:id="mediaButton"
    private VBox mediaButton; // Value injected by FXMLLoader

    @FXML // fx:id="climateButton"
    private VBox climateButton; // Value injected by FXMLLoader

    @FXML // fx:id="wipersButton"
    private VBox wipersButton; // Value injected by FXMLLoader

    @FXML // fx:id="cruiseButton"
    private VBox cruiseButton; // Value injected by FXMLLoader

    @FXML // fx:id="lightsButton"
    private VBox lightsButton; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert windowsButton != null : "fx:id=\"windowsButton\" was not injected: check your FXML file 'hubView.fxml'.";
        assert mediaButton != null : "fx:id=\"mediaButton\" was not injected: check your FXML file 'hubView.fxml'.";
        assert climateButton != null : "fx:id=\"climateButton\" was not injected: check your FXML file 'hubView.fxml'.";
        assert wipersButton != null : "fx:id=\"wipersButton\" was not injected: check your FXML file 'hubView.fxml'.";
        assert cruiseButton != null : "fx:id=\"cruiseButton\" was not injected: check your FXML file 'hubView.fxml'.";
        assert lightsButton != null : "fx:id=\"lightsButton\" was not injected: check your FXML file 'hubView.fxml'.";
/*
        windowsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {
				CrystalBallApp.changeScene(Screen.WINDOWS);
			}
        });
        
        mediaButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {
				CrystalBallApp.changeScene(Screen.MEDIA);
			}
        });
        
        climateButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {
				CrystalBallApp.changeScene(Screen.CLIMATE);
				
			}
        });
        
        wipersButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {
				CrystalBallApp.changeScene(Screen.WIPERS);
			}
        });
        
        cruiseButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {
				CrystalBallApp.changeScene(Screen.CRUISE);
			}
        });
        
        lightsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {
				CrystalBallApp.changeScene(Screen.LIGHTS);
			}
        });
        
        cruiseButton.setOnMousePressed(new EventHandler<MouseEvent>() {

			public void handle(MouseEvent arg0) {
				System.out.println("This should print");
				
			}
        });*/
    }
    
    public static HubController getInstance(){
    	return controller;
    }
}
