package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Splash {

	@FXML
	ImageView cruz;

	@FXML
	Pane nube;

	public void initialize() {
		rotarCruz();
		rotarNube();
	}

	private void toWizard() throws IOException {
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Wizard.fxml"));
		AnchorPane pane = (AnchorPane) loader.load();
		Scene scene = new Scene(pane);
//		primaryStage.setTitle("Home page");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void rotarNube() {
		RotateTransition rotar = new RotateTransition(Duration.seconds(0.7), nube);
		rotar.setByAngle(-360);
		rotar.setCycleCount(2);
		rotar.play();
		/*
		 * Cuando termina la animación se cerrará la ventana actual y se pasará al Wizard 
		 */
		rotar.setOnFinished(event -> {
			Stage sala = (Stage) nube.getScene().getWindow();
			sala.close();
			try {
				toWizard();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

	private void rotarCruz() {
		RotateTransition rotar = new RotateTransition(Duration.seconds(0.7), cruz);
		rotar.setByAngle(360);
		rotar.setCycleCount(2);
		rotar.play();
	}
}