package presentationFX;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChemReagentFormFX {
	Scene chemReagentScene;
	Stage chemReagentStage;
	
	public void start() {
		chemReagentStage = new Stage();
		chemReagentStage.setTitle("Opret Kemi Reagentsfremstillingsblanket");
		
		// VBox
		VBox mainBox = new VBox();
		chemReagentScene = new Scene(mainBox);
		mainBox.setPrefWidth(800);
		mainBox.setPrefHeight(950);
		mainBox.setPadding(new Insets(10, 10, 10 ,10));
		mainBox.setSpacing(10);
		
		// HBox
		HBox btnBox = new HBox();
		
		// Gridpane
		GridPane mainGrid = new GridPane();
		mainGrid.setPadding(new Insets(10, 10, 10, 10));
		GridPane infoGrid = new GridPane();
		GridPane deliverlblGrid = new GridPane();
		GridPane delivertxtGrid = new GridPane();
		
		// Labels
		Label namelbl = new Label("Navn");
		Label courselbl = new Label("Klasse");
		Label datelbl = new Label("Dato");
		Label themelbl = new Label("Tema");
		Label analyzeTitlelbl = new Label("Analyse Titel");
		Label reagentNamelbl = new Label("Reagensnavn og koncentration");
		Label batchNolbl = new Label("Batch Nr.");
		Label lotNolbl = new Label("Lot Nr.");
		Label supplierlbl = new Label("Leverandør");
		Label measurementslbl = new Label("Afvejninger/afmålinger");
		Label weigthNolbl = new Label("Vægtnr./pipettenr. mm.");
		Label volumelbl = new Label("Fremstillet volumen");
		Label concentrationlbl = new Label("Angiv nøjagtig koncentration");
		Label shelfLifelbl = new Label("Holdbarhed");
		Label storagelbl = new Label("Opbevaring");
		Label noteslbl = new Label("Bemærkninger");
		
		// Textfields
		TextField nametxt = new TextField();
		TextField coursetxt = new TextField();
		TextField datetxt = new TextField();
		TextField themetxt = new TextField();
		TextField analyzeTitleTxt = new TextField();
		TextField reagentNametxt = new TextField();
		TextField batchNotxt = new TextField();
		TextField lotNotxt = new TextField();
		TextField suppliertxt = new TextField();
		TextField weigthNotxt = new TextField();
		TextField volumetxt = new TextField();
		TextField concentrationtxt = new TextField();
		TextField shelfLifetxt = new TextField();
		TextField storagetxt = new TextField();
		
		// Textareas
		TextArea measurementstxt = new TextArea();
		TextArea notextxt = new TextArea();
		
		// Buttons
		Button invalid = new Button("Ugyldiggør");
		Button print = new Button("Print");
		Button saveLock = new Button("Gem og Lås");
		Button save = new Button("Gem");
		
		mainBox.getChildren().addAll(mainGrid, btnBox);
		mainGrid.add(infoGrid, 0, 0);
		mainGrid.add(analyzeTitlelbl, 0, 1);
		mainGrid.add(analyzeTitleTxt, 1, 1);
		mainGrid.add(reagentNamelbl, 0, 2);
		mainGrid.add(reagentNametxt, 1, 2);
		mainGrid.add(deliverlblGrid, 0, 4);
		mainGrid.add(delivertxtGrid, 1, 4);
		mainGrid.add(measurementslbl, 0, 5);
		mainGrid.add(measurementstxt, 1, 5);
		mainGrid.add(weigthNolbl, 0, 6);
		mainGrid.add(weigthNotxt, 1, 6);
		mainGrid.add(volumelbl, 0, 7);
		mainGrid.add(volumetxt, 1, 7);
		mainGrid.add(concentrationlbl, 0, 8);
		mainGrid.add(concentrationtxt, 1, 8);
		mainGrid.add(shelfLifelbl, 0, 9);
		mainGrid.add(shelfLifetxt, 1, 9);
		mainGrid.add(storagelbl, 0, 10);
		mainGrid.add(storagetxt, 1, 10);
		mainGrid.add(noteslbl, 0, 11);
		mainGrid.add(notextxt, 1, 11);
		
		infoGrid.add(namelbl, 0, 0);
		infoGrid.add(nametxt, 1, 0);
		infoGrid.add(courselbl, 0, 1);
		infoGrid.add(coursetxt, 1, 1);
		infoGrid.add(datelbl, 0, 2);
		infoGrid.add(datetxt, 1, 2);
		infoGrid.add(themelbl, 0, 3);
		infoGrid.add(themetxt, 1, 3);
		
		deliverlblGrid.add(batchNolbl, 0, 0);
		deliverlblGrid.add(lotNolbl, 0, 1);
		deliverlblGrid.add(supplierlbl, 0, 2);
		
		delivertxtGrid.add(batchNotxt, 0, 0);
		delivertxtGrid.add(lotNotxt, 0, 1);
		delivertxtGrid.add(suppliertxt, 0, 2);
		
		btnBox.getChildren().addAll(invalid, print, saveLock, save);
		
		chemReagentStage.setScene(chemReagentScene);
		chemReagentStage.show();
	}
	
}
