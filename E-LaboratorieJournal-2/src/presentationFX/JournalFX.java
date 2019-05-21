package presentationFX;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JournalFX {
	Scene journalScene;
	
	public void start(Stage journalStage) {
		journalStage.setTitle("Opret Journal");
		journalStage.setWidth(800);
		journalStage.setHeight(1000);
		
		// VBox 
		VBox mainBox = new VBox();
		mainBox.setPadding(new Insets(10, 10, 10, 10));
		mainBox.setSpacing(10);
		journalScene = new Scene(mainBox);
		
		// HBox 
		HBox calcImgBox = new HBox();
		HBox obsImgBox = new HBox();
		HBox btnBox = new HBox();
		
		// Gridpane
		GridPane topGrid = new GridPane();
		GridPane infoGrid = new GridPane();
		
		// Tableview
		TableView refTable = new TableView();
		
		// Labels
		Label namelbl = new Label("Navn");
		Label courselbl = new Label("Klasse");
		Label datelbl = new Label("Dato");
		Label themelbl = new Label("Tema");
		Label analyzeTitlelbl = new Label("Analyse Titel");
		Label traceabilitylbl = new Label("Sporbarhed");
		Label referenceslbl = new Label("Henvisning til dokumentationsblanketter");
		Label resultslbl = new Label("Rådata og Resultater");
		Label calcslbl = new Label("Beregninger");
		Label obslbl = new Label("Observationer og Bemærkninger");
		
		// Textfields
		TextField nametxt = new TextField();
		TextField coursetxt = new TextField();
		TextField datetxt = new TextField();
		TextField themetxt = new TextField();
		TextField analyzeTxt = new TextField();
		TextField traceabilityTxt = new TextField();
		
		// TextAreas
		TextArea resultstxt = new TextArea();
		TextArea resultstxttabel = new TextArea();
		resultstxttabel.setStyle("-fx-font-family: 'monospaced';");
		TextArea calcstxt = new TextArea();
		TextArea obstxt = new TextArea();
		
		// Buttons
		Button addForm = new Button("Tilføj Blanketter");
		Button addCalcPics = new Button("Tilføj billeder");
		Button addObsPics = new Button("Tilføj billeder");
		Button invalid = new Button("Ugyldiggør");
		Button print = new Button("Print");
		Button saveLock = new Button("Gem og Lås");
		Button save = new Button("Gem");
		
		mainBox.getChildren().addAll(topGrid, referenceslbl, refTable, addForm, resultslbl, resultstxt, resultstxttabel, calcslbl, calcstxt, addCalcPics, calcImgBox, obslbl, obstxt, addObsPics, obsImgBox, btnBox);
		
		btnBox.getChildren().addAll(invalid, print, saveLock, save);
		
		infoGrid.add(namelbl, 0, 0);
		infoGrid.add(nametxt, 1, 0);
		infoGrid.add(courselbl, 0, 1);
		infoGrid.add(coursetxt, 1, 1);
		infoGrid.add(datelbl, 0, 2);
		infoGrid.add(datetxt, 1, 2);
		infoGrid.add(themelbl, 0, 3);
		infoGrid.add(themetxt, 1, 3);
		
		topGrid.add(infoGrid, 0, 0);
		topGrid.add(analyzeTitlelbl, 0, 1);
		topGrid.add(analyzeTxt, 1, 1);
		topGrid.add(traceabilitylbl, 0, 2);
		topGrid.add(traceabilityTxt, 1, 2);
		
		journalStage.setScene(journalScene);
		journalStage.show();	
	}
}
