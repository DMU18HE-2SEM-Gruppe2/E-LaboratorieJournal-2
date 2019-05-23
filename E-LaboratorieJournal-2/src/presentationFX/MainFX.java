package presentationFX;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainFX extends Application {

	public static void main(String[] args) {
		launch(args);

	}
		public void start(Stage testStage) throws Exception {			
			FrontPage test = new FrontPage();
			test.start(testStage);
		}
}
