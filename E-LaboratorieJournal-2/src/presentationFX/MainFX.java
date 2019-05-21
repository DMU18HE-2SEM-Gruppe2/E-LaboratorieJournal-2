package presentationFX;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainFX extends Application {

	public static void main(String[] args) {
		launch(args);

	}
	
//		public void start(Stage mainStage) throws Exception {			
//			FrontPage frontpage = new FrontPage();
//			frontpage.start(mainStage);
//		}

	
//		public void start(Stage journalStage) throws Exception {			
//			JournalFX journal = new JournalFX();
//			journal.start(journalStage);
//		}
	
		public void start(Stage chemReagentStage) throws Exception {			
			ChemReagentFormFX chemReagentForm = new ChemReagentFormFX();
			chemReagentForm.start(chemReagentStage);
		}

}
