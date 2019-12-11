package application;

import java.io.IOException;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControllerWizard {

	@FXML
	private Pane pane1;

	@FXML
	private Pane pane2;

	@FXML
	private Pane pane3;

	@FXML
	private Label countLabel, ant, desp;

	private int showSlide;

	public void translateAnimation(double duration, Node node, double byX) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();

	}

	public void initialize() {
		showSlide = 1;
	}

	@FXML
	void nextAction() {

		if (showSlide == 1) {
			translateAnimation(0.5, pane1, -600);
			showSlide++; // showSlide=1
			countLabel.setText("2/3");
		} else if (showSlide == 2) {

			translateAnimation(0.5, pane2, -600);
			showSlide++; // showSlide=2
			countLabel.setText("3/3");

		} else {
			Stage cerrarVent = (Stage) pane1.getScene().getWindow();
			cerrarVent.close();
			try {
				toLogin();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@FXML
	void backAction() {

		if (showSlide == 3) {
			translateAnimation(0.5, pane2, 600);
			showSlide--;
			countLabel.setText("2/3");
		} else if (showSlide == 2) {
			translateAnimation(0.5, pane1, 600);
			showSlide--; // showSlide=0
			countLabel.setText("1/3");
		}
	}
	private void toLogin() throws IOException {
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
		AnchorPane pane = (AnchorPane) loader.load();
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Home page");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}