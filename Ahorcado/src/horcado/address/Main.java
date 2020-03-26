package horcado.address;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {

	private Stage primaryStage;
	private AnchorPane rootLayout;
    private MediaPlayer music;
	private Media enlace;
	
	@Override
	public void start(Stage primaryStage)  {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("juego");
	    this.primaryStage.getIcons().add(new Image("file:Imangen/imagen/sinon.jpg"));
	    primaryStage.initStyle(StageStyle.UNDECORATED);
	    String dato = new File("Imangen/imagen/Neon.mp3").getAbsolutePath();
	    enlace = new Media(new File(dato).toURI().toString());
	    music = new MediaPlayer(enlace);
	    music.play();
	    Ancho();
	}
	
	public void Ancho() {
		  try {
		       FXMLLoader loader = new  FXMLLoader();
				loader.setLocation(Main.class.getResource("view/Diseño.fxml"));
			    rootLayout = (AnchorPane) loader.load();
			    Scene scene = new Scene(rootLayout);
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
