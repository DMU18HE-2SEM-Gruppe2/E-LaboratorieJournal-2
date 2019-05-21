package presentationFX;

import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BioSubstrateFormFX {
	Scene bioSubstrateScene;
	
	public void start(Stage bioSubstrateStage) {
		bioSubstrateStage.setTitle("Opret Biologi Substratfremstillingsblanket");
		
		// VBox
		VBox mainBox = new VBox();
		bioSubstrateScene = new Scene(mainBox);
		
		// HBox
		HBox btnBox = new HBox();
		
		// Gridpane
		GridPane topGrid = new GridPane();
		GridPane btmGrid = new GridPane();
		GridPane infoGrid = new GridPane();
		GridPane sterileGrid = new GridPane();
		
		// Tableview
		TableView table = new TableView();
		
		mainBox.getChildren().addAll(topGrid, table, btmGrid, btnBox);
		topGrid.add(infoGrid, 0, 0);
		btmGrid.add(sterileGrid, 1, 9);
		
		bioSubstrateStage.setScene(bioSubstrateScene);
		bioSubstrateStage.show();
	}
}
