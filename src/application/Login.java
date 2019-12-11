package application;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Login {
	@FXML
	TextField user;
	
	@FXML
	PasswordField passwd;
	
	@FXML
	Label logoLabel;

	@FXML
	Pane spinnerPane;

	@FXML
	AnchorPane rootPane;

	@FXML
	Label helloLabel;

	@FXML
	Label nameLabel;

	@FXML
	Pane img1;

	@FXML
	Pane img2;

	@FXML
	Pane img3;
//	Main main;
//	Stage stage;
//
//	public void main(Stage stage, Main main) {
//		this.main = main;
//		this.stage = stage;
//	}

	public void showHome() {
		try {
			// Load the fxml file and create a new stage for the popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("menu.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage homeStage = new Stage();
			homeStage.setTitle("Main Menu");
			Scene scene = new Scene(page);
			homeStage.setScene(scene);
			homeStage.setMaximized(true);
			homeStage.show();
			System.out.println("second stage ok");

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("second stage ko");
		}
	}

	public void initialize() {
		backgroundAnimation();
	}

	@FXML
	public void hacerLogin() {
		if (user.getText().equals("admin") && passwd.getText().equals("1234")) {
			Stage cerrarvent = (Stage) passwd.getScene().getWindow();
			cerrarvent.close();
			try {
				toHomepage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void toHomepage() throws IOException {
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Homepage.fxml"));
		AnchorPane pane = (AnchorPane) loader.load();
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Home page");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	private void backgroundAnimation() {
		FadeTransition trans1 = new FadeTransition(Duration.seconds(3), img3);
		trans1.setFromValue(1);
		trans1.setToValue(0);
		trans1.play();
		System.out.println("trans1");
		trans1.setOnFinished(event1 -> {
			FadeTransition trans2 = new FadeTransition(Duration.seconds(3), img2);
			trans2.setFromValue(1);
			trans2.setToValue(0);
			trans2.play();
			trans2.setOnFinished(event2 -> {
				FadeTransition trans3 = new FadeTransition(Duration.seconds(3), img1);
				trans3.setFromValue(1);
				trans3.setToValue(0);
				trans3.play();
				trans3.setOnFinished(event3 -> {
					backgroundAnimation();
				});
			});
		});
	}
}
