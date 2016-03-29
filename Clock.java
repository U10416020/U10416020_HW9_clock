package clock;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.animation.*;
import javafx.util.Duration;
import javafx.event.*;

public class Clock extends Application{
	@Override
	public void start(Stage primaryStage){
		//Create a clockpane
		ClockPane clockPane = new ClockPane();
		
		//New two buttons and set size
		Button start = new Button("Start");
		Button stop = new Button("Stop");
		start.setPrefSize(120,50);
		stop.setPrefSize(120,50);
		
		HBox h1 = new HBox(10);
		BorderPane pane = new BorderPane();
		h1.getChildren().addAll(start, stop);
		pane.setCenter(clockPane);
		pane.setBottom(h1);		
		
		//EventHandler to set current time
		EventHandler<ActionEvent> eventHandler = e -> {
			clockPane.setCurrentTime();
		};
		
		//New timeline named animation with keyFrame to set duration
		Timeline animation = new Timeline(
			new KeyFrame(Duration.millis(1000), eventHandler));
			
		//Set timeline to run indefinite
		animation.setCycleCount(Timeline.INDEFINITE);
		//Play animation
		animation.play();
		
		//Set button action
		start.setOnAction(e -> {
			//Play animation
			animation.play();
		});
		
		//Set button action
		stop.setOnAction(e -> {
			//Stop animation
			animation.stop();
		});		
		
		//Set scene 
		Scene scene = new Scene(pane, 250, 250);		
		primaryStage.setTitle("U10416020");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//Main method
    public static void main(String[] args) {
        launch(args);
    }    
}
