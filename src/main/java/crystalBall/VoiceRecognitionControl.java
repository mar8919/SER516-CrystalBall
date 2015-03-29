package crystalBall;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import crystalBall.UIController.Screen;
import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.frontend.util.Microphone;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.ConfigurationManager;
import javafx.application.Platform;
import javafx.concurrent.Task;

public class VoiceRecognitionControl extends Task {
	static ConfigurationManager cm;
	private boolean canListen = false;
	private boolean programIsRunning = true;
	Map<String, Runnable> commands = new HashMap<>();
	
	Configuration configuration;
	MainApplication app;
	LiveSpeechRecognizer recognizer;

	public VoiceRecognitionControl(MainApplication app) {
		this.app = app;

		configuration = new Configuration();

		// Set path to acoustic model.
		configuration
				.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		// Set path to dictionary.
		configuration
				.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		// Set language model.
		configuration
				.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.dmp");
		configuration.setGrammarPath("resource:/");
		configuration.setGrammarName("crystal");
		configuration.setUseGrammar(true);
		
		try {
			recognizer = new LiveSpeechRecognizer(configuration);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		commands.put("climate", ()->CrystalBallApp.changeScene(Screen.CLIMATE));
		commands.put("lights", ()->CrystalBallApp.changeScene(Screen.LIGHTS));
		commands.put("cruise control", ()->CrystalBallApp.changeScene(Screen.CRUISE));
		commands.put("radio", ()->CrystalBallApp.changeScene(Screen.MEDIA));
		commands.put("windows", ()->CrystalBallApp.changeScene(Screen.WINDOWS));
		commands.put("wipers", ()->CrystalBallApp.changeScene(Screen.WIPERS));
		
		commands.put("lights off", ()->LightsController.getInstance().changeLightMode(LightMode.OFF));
		commands.put("low beam lights", ()->LightsController.getInstance().changeLightMode(LightMode.LOW));
		commands.put("high beam lights", ()->LightsController.getInstance().changeLightMode(LightMode.HIGH));
		commands.put("parking lights", ()->LightsController.getInstance().changeLightMode(LightMode.PARKING));
		
		commands.put("emergency light on", ()->LightsController.getInstance().turnEmergencyLightOn());
		commands.put("emergency light off", ()->LightsController.getInstance().turnEmergencyLightOff());
		*/
	}

	@Override
	protected Object call() throws Exception {
		createVR();
		// TODO Auto-generated method stub
		return null;
	}

	public void triggerVoice() {
		canListen = true;
		//ResetScreenTimerHandler.getInstance().cancelTimer();
		System.out.println("triggered");
	}

	public void createVR() {
		System.out.println("created and in VR");
		while (programIsRunning){
			if (canListen){
				//ResetScreenTimerHandler.getInstance().cancelTimer();
				System.out.println("is listening");
				canListen = false;
				
				System.out.println("before rec");
				recognizer.startRecognition(true);
				System.out.println("started rec");
	
				SpeechResult result = recognizer.getResult();
				
				System.out.println("getting result");
				// Pause recognition process. It can be resumed then with
				// startRecognition(false).
				recognizer.stopRecognition();
				
				System.out.println("stopped rec");
				
				if (result != null) {
					String resultText = result.getResult().getBestFinalResultNoFiller();//.toString();//.getHypothesis();// ..getBestFinalResultNoFiller();
					System.out.println("You said: " + resultText + '\n');
					this.checkStringAndRun(resultText);
				} else {
					System.out.println("I can't hear what you said.\n");
				}
				resetTimer();
			}
		}
	}

	private void checkStringAndRun(String s){

		System.out.println("before run");
		Runnable r = commands.get(s);
		if (r != null){
			Platform.runLater(r);
		}
		System.out.println("after run");
			
	}
	
	public void resetTimer(){
		//ResetScreenTimerHandler.getInstance().startTimer();
	}
}
