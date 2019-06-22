package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
	@FXML
	private TextField kwotaKredytu;
	@FXML
	private TextField okresKredytu;
	@FXML
	private TextField stopaProcentowa;
	@FXML
	private Button oblicz;
	@FXML
	private Label miesiecznaRataKredytu;

	@FXML
	public void handleButtonAction(ActionEvent event) {
		double kK = Double.parseDouble(kwotaKredytu.getText());
		double oK = Double.parseDouble(okresKredytu.getText());
		double sP = Double.parseDouble(stopaProcentowa.getText());
		
		double miesiecznaStopaProcentowa = sP / 1200;
		double rata = (kK * miesiecznaStopaProcentowa) 
				/ (1 - Math.pow(1 + miesiecznaStopaProcentowa, -oK*12));
		miesiecznaRataKredytu.setText(String.format("%.2f", rata));
	}
}
