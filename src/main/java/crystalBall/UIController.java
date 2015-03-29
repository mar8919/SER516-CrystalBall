package crystalBall;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import crystalBall.UIController.Screen;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class UIController{
	
	
	public enum Screen {
		HUB, CLIMATE, LIGHTS, MEDIA, WINDOWS, WIPERS, CRUISE
	}

	Stage stage;
	Map<Screen, Scene> sceneDictionary = new HashMap<Screen, Scene>();
	
	public UIController(Stage stage){
		this.stage=stage;
		
		Parent hubRoot, climateRoot, lightsRoot, mediaRoot, windowsRoot, wipersRoot, cruiseRoot;
		try {
		hubRoot 	= FXMLLoader.load(getClass().getClassLoader().getResource("hub/hubView.fxml"));/*
		climateRoot = FXMLLoader.load(getClass().getClassLoader().getResource("climate/climateView.fxml"));
		lightsRoot 	= FXMLLoader.load(getClass().getClassLoader().getResource("lights/lightsView.fxml"));
		mediaRoot 	= FXMLLoader.load(getClass().getClassLoader().getResource("media/mediaView.fxml"));
		windowsRoot = FXMLLoader.load(getClass().getClassLoader().getResource("windows/windowsView.fxml"));
		wipersRoot 	= FXMLLoader.load(getClass().getClassLoader().getResource("wiper/wipersView.fxml"));
		cruiseRoot	= FXMLLoader.load(getClass().getClassLoader().getResource("cruise/cruiseView.fxml"));*/

		Scene hubScene = new Scene(hubRoot, 960, 540);
		addScene(Screen.HUB,hubScene);/*
		addScene(Screen.CLIMATE,new Scene(climateRoot, 900, 600));
		addScene(Screen.LIGHTS,new Scene(lightsRoot, 900, 600));
		addScene(Screen.MEDIA,new Scene(mediaRoot, 900, 600));
		addScene(Screen.WINDOWS,new Scene(windowsRoot, 900, 600));
		addScene(Screen.WIPERS,new Scene(wipersRoot, 900, 600));
		addScene(Screen.CRUISE,new Scene(cruiseRoot, 900, 600));*/
		
		
		this.stage.setScene(hubScene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addScene(Screen name, Scene scene){
		sceneDictionary.put(name, scene);
	}
	
	public void changeScene(final Screen name){
		final Scene scene = (Scene) sceneDictionary.get(name);
		System.out.println(scene);
		Task task = new Task<Void>() {
			@Override
			public void run() {
				stage.setScene(scene);
			}

			@Override
			protected Void call() throws Exception {
				// TODO Auto-generated method stub
				return null;
			}
		};
		Platform.runLater(task);
	}

	

}
