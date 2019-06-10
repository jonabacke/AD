package ab_10;

		import java.io.IOException;
		import javafx.application.Application;
		import javafx.fxml.FXMLLoader;
		import javafx.scene.Scene;
		import javafx.scene.layout.AnchorPane;
		import javafx.stage.Stage;

public class Main extends Application {
	private AnchorPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		try {
			//Setzt den Titel der Anwendung
			primaryStage.setTitle("HAW cipher");

			//Erstellt einen neuen FXML Loader und laed die Datei
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Ui.fxml"));
			rootLayout = (AnchorPane) loader.load();

			//Laed den Controller des Loaders
			Controller controller = loader.getController();

			//Erstellt eine neue Scene mit dem Layout und zeigt sie an
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
