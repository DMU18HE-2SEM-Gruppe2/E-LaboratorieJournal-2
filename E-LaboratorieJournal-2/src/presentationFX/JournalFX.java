package presentationFX;

import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JournalFX {
	Scene journalScene;
	
	public void start(Stage journalStage) {
		journalStage.setTitle("Opret Journal");
		
		// VBox 
		VBox mainBox = new VBox();
		VBox refBox = new VBox();
		VBox resultBox = new VBox();
		VBox calcBox = new VBox();
		VBox obsBox = new VBox();
		
		// HBox 
		HBox calcImgBox = new HBox();
		HBox obsImgBox = new HBox();
		
		// Gridpane
		GridPane topGrid = new GridPane();
		GridPane infoGrid = new GridPane();
		GridPane titelGrid = new GridPane();
		GridPane traceGrid = new GridPane();
		GridPane btnGrid = new GridPane();
		
		// Tableview
		TableView refTable = new TableView();
		
		calcBox.getChildren().add(calcImgBox);
		obsBox.getChildren().add(obsImgBox);
		
		topGrid.add(infoGrid, 0, 0);
		mainBox.getChildren().addAll(topGrid, titelGrid, traceGrid, refBox, resultBox, calcBox, obsBox, btnGrid);
		
		journalStage.setScene(journalScene);
		journalStage.show();	
	}
}
