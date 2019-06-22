package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class Main extends Application {
	private TextField tfKwotaKredytu = new TextField();
	private TextField tfOkresKredytu = new TextField();
	private TextField tfStopaProcentowa = new TextField();
	private Button btOblicz = new Button("Oblicz");
	private Label lbMiesiecznaRata = new Label();

	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			root.add(new Label("Kwota kredytu:"), 0, 0);
			root.add(tfKwotaKredytu, 1, 0);
			root.add(new Label("Okres kredytu (w latach):"), 0, 1);
			root.add(tfOkresKredytu, 1, 1);
			root.add(new Label("Stopa procentowa (w %):"), 0, 2);
			root.add(tfStopaProcentowa, 1, 2);
			root.add(btOblicz, 1, 3);
			root.add(new Label(""), 0, 4);
			root.add(new Label("Miesięczna rata równa kredytu:"), 0, 5);
			root.add(lbMiesiecznaRata, 1, 5);
			root.setPadding(new Insets(10));
			root.getColumnConstraints().add(new ColumnConstraints(200));
			root.setVgap(5);

			btOblicz.setOnAction(e -> handleButtonAction());

			Scene scene = new Scene(root, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Kalkulator raty hipotecznej");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void handleButtonAction() {
		double kK = Double.parseDouble(tfKwotaKredytu.getText());
		int oK = Integer.parseInt(tfOkresKredytu.getText());
		double sP = Double.parseDouble(tfStopaProcentowa.getText());
		double miesiecznaStopaProcentowa = sP / 1200;
		double rata = (kK * miesiecznaStopaProcentowa) / (1 - Math.pow(1 + miesiecznaStopaProcentowa, -oK * 12));
		lbMiesiecznaRata.setText(String.format("%.2f", rata));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
