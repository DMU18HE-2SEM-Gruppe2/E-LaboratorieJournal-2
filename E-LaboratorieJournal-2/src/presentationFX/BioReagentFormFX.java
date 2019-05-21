package presentationFX;

import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BioReagentFormFX {
	Scene bioReagentScene;
	
	public void start(Stage bioReagentStage) {
		bioReagentStage.setTitle("Opret Biologi Reagensfremstillingsblanket");
		
		// VBox
		VBox mainBox = new VBox();
		bioReagentScene = new Scene(mainBox);
		
		// HBox
		HBox btnBox = new HBox();
		
		// Gridpane
		GridPane topGrid = new GridPane();
		GridPane btmGrid = new GridPane();
		GridPane infoGrid = new GridPane();
		
		// Tableview
		TableView table = new TableView();
		
		mainBox.getChildren().addAll(topGrid, table, btmGrid, btnBox);
		topGrid.add(infoGrid, 0, 0);
		
		bioReagentStage.setScene(bioReagentScene);
		bioReagentStage.show();
	}
}
