package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		ViewLoader<GridPane, Controller> viewLoader = new ViewLoader<>("View.fxml");
		Scene scene = new Scene(viewLoader.getLayout());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Kalkulator równej raty hipotecznej");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
