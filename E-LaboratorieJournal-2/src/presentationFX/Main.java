package presentationFX;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);

	}
		public void start(Stage journalStage) throws Exception {
//			FrontPage frontpage = new FrontPage();
//			frontpage.start(mainStage);
			
			JournalFX journal = new JournalFX();
			journal.start(journalStage);
		}

}
