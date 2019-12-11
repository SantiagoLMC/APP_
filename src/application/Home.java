package application;

import com.jfoenix.controls.JFXHamburger;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Home {

	@FXML
	private Pane pane1, pane2, pane3, menu, opacityPane;

	@FXML
	private ImageView img;
	
	@FXML
	private JFXHamburger burguer;

	public void initialize() {
		cargarListener();
		esconderMenu();
	}

	private void esconderMenu() {
		opacityPane.setVisible(false);
		TranslateTransition trans = new TranslateTransition(Duration.seconds(0.5), menu);
		trans.setByX(-200);
		trans.play();
	}

	private void mostrarMenu() {
		opacityPane.setVisible(true);
		TranslateTransition trans = new TranslateTransition(Duration.seconds(0.5), menu);
		trans.setByX(200);
		trans.play();
	}

	private void cargarListener() {
		opacityPane.setOnMouseClicked(event ->{
			esconderMenu();
		});
		burguer.setOnMouseClicked(event ->{
			mostrarMenu();
		});
	}

	public void animator() {
		FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), pane3);
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.play();

		fadeTransition.setOnFinished(event -> {
			FadeTransition fadeTransition1 = new FadeTransition(Duration.seconds(3), pane2);
			fadeTransition1.setFromValue(1);
			fadeTransition1.setToValue(0);
			fadeTransition1.play();

			fadeTransition1.setOnFinished(event1 -> {

				FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(3), pane1);
				fadeTransition2.setFromValue(1);
				fadeTransition2.setToValue(0);
				fadeTransition2.play();

				fadeTransition2.setOnFinished(event2 -> {

					FadeTransition fadeTransition00 = new FadeTransition(Duration.seconds(3), pane2);
					fadeTransition00.setFromValue(0);
					fadeTransition00.setToValue(1);
					fadeTransition00.play();

					fadeTransition00.setOnFinished(event3 -> {
						FadeTransition fadeTransition11 = new FadeTransition(Duration.seconds(3), pane3);
						fadeTransition11.setFromValue(0);
						fadeTransition11.setToValue(1);
						fadeTransition11.play();

						fadeTransition11.setOnFinished(event4 -> {

							animator();
						});
					});

				});
			});

		});
	}

}