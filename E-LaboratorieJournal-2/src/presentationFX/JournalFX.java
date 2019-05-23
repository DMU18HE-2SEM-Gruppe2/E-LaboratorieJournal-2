package presentationFX;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JournalFX {
	Scene journalScene;
	Stage journalStage;
	
	public void start() {
		journalStage = new Stage();
		journalStage.setTitle("Opret Journal");
		journalStage.setWidth(820);
		journalStage.setHeight(1000);
		journalStage.setResizable(false);
		
		FactoryFX factory = new FactoryFX();
		
		// VBox 
		VBox mainBox = new VBox();
		mainBox.setPadding(new Insets(15, 15, 15, 15));
		mainBox.setSpacing(15);
		
		journalScene = new Scene(mainBox);
		
		// HBox 
		HBox calcImgBox = new HBox();
		HBox obsImgBox = new HBox();
		
		HBox btnBox = new HBox(15);
		HBox btnRightBox = new HBox(15);
		btnRightBox.setAlignment(Pos.CENTER_RIGHT);
		btnRightBox.setPrefWidth(800);
		
		// Gridpane
		GridPane topGrid = new GridPane();
		topGrid.setVgap(15);
		topGrid.getColumnConstraints().add(new ColumnConstraints(275));
		topGrid.getColumnConstraints().add(new ColumnConstraints(500));
		GridPane infoGrid = new GridPane();
		infoGrid.setVgap(10);
		infoGrid.getColumnConstraints().add(new ColumnConstraints(75));
		infoGrid.getColumnConstraints().add(new ColumnConstraints(200));
		GridPane nameGrid = new GridPane();
		nameGrid.setVgap(15);
		nameGrid.getColumnConstraints().add(new ColumnConstraints(275));
		nameGrid.getColumnConstraints().add(new ColumnConstraints(500));
		
		// Tableview
		TableView refTable = new TableView();
		refTable.setPrefHeight(150);
		
		// Logo Imag
		Image image = new Image("EAMV_Logo.png");
		ImageView imageView = new ImageView(image);
		imageView.setImage(image);
		imageView.setFitHeight(90); 
	    imageView.setFitWidth(420);
	    topGrid.setHalignment(imageView, HPos.RIGHT);
	    topGrid.setValignment(imageView, VPos.TOP);
		
		// Labels
	    Label lName = factory.labelFactory("Navn", 0, 0, 0, 0, 14, false);
	    Label lCourse = factory.labelFactory("Klasse", 0, 0, 0, 0, 14, false);
	    Label lDate = factory.labelFactory("Dato", 0, 0, 0, 0, 14, false);
	    Label lTheme = factory.labelFactory("Tema", 0, 0, 0, 0, 14, false);
	    Label lAnalyzeTitle = factory.labelFactory("Analyse Titel", 0, 0, 0, 0, 14, false);
	    Label lTraceability = factory.labelFactory("Sporbarhed", 0, 0, 0, 0, 14, false);
	    Label lReferences = factory.labelFactory("Henvisning til dokumentationsblanketter", 0, 0, 0, 0, 14, false);
	    Label lResult = factory.labelFactory("Rådata og Resultater", 0, 0, 0, 0, 14, false);
	    Label lCal = factory.labelFactory("Beregninger", 0, 0, 0, 0, 14, false);
	    Label lObs = factory.labelFactory("Observationer og Bemærkninger", 0, 0, 0, 0, 14, false);

		// Textfields
	    TextField tfName = factory.textFieldFactory("", 500, 14);
	    TextField tfCourse = factory.textFieldFactory("", 500, 14);
	    TextField tfDate = factory.textFieldFactory("", 500, 14);
	    TextField tfTheme = factory.textFieldFactory("", 500, 14);
	    TextField tfAnalyzeTitle = factory.textFieldFactory("", 500, 14);
	    TextField tfTraceability = factory.textFieldFactory("", 500, 14);
		
	    // TextAreas
	    TextArea taResults = factory.textAreaFactory(100, 800, 14, false);
	    TextArea taResultTabel = factory.textAreaFactory(100, 800, 14, true);
	    TextArea taCal = factory.textAreaFactory(100, 800, 14, false);
	    TextArea taObs = factory.textAreaFactory(100, 800, 14, false);
		
		// Buttons
	    Button addForm = factory.buttonFactory("Tilføj", 90, 14, false);
	    Button addCalcPics = factory.buttonFactory("Tilføj billed", 90, 14, false);
	    Button addObsPics = factory.buttonFactory("Tilføj billed", 90, 14, false);
		Button cancel = factory.buttonFactory("Annuller", 90, 14, false);
		Button invalid = factory.buttonFactory("Ugyldiggør", 90, 14, false);
		Button print = factory.buttonFactory("Print", 90, 14, false);
		Button saveLock = factory.buttonFactory("Gem og Lås", 90, 14, false);
		Button save = factory.buttonFactory("Gem", 90, 14, false);
		
		// Separators
		Separator sepTop = new Separator();
		Separator sepInfo = new Separator();
		Separator sepName = new Separator();
		Separator sepResult = new Separator();
		Separator sepCal = new Separator();
		Separator sepObs = new Separator();
		Separator sepButton = new Separator();
		
		topGrid.add(infoGrid, 0, 0);
		topGrid.add(imageView, 1, 0);
		
		infoGrid.add(lName, 0, 0);
		infoGrid.add(tfName, 1, 0);
		infoGrid.add(lCourse, 0, 1);
		infoGrid.add(tfCourse, 1, 1);
		infoGrid.add(lDate, 0, 2);
		infoGrid.add(tfDate, 1, 2);
		infoGrid.add(lTheme, 0, 3);
		infoGrid.add(tfTheme, 1, 3);
		
		nameGrid.add(lAnalyzeTitle, 0, 1);
		nameGrid.add(tfAnalyzeTitle, 1, 1);
		nameGrid.add(lTraceability, 0, 2);
		nameGrid.add(tfTraceability, 1, 2);
		
		btnRightBox.getChildren().addAll(print, saveLock, save);
		btnBox.getChildren().addAll(cancel, invalid, btnRightBox);
		mainBox.getChildren().addAll(topGrid, sepTop, nameGrid, sepInfo, lReferences, refTable, addForm, sepName, lResult, taResults, sepCal, lCal, taCal, addCalcPics, sepObs, lObs, taObs, addObsPics, sepButton, btnBox);
		
		// Action
		cancel.setOnAction(e -> cancelForm());
		
		journalStage.setScene(journalScene);
		journalStage.show();	
	}
	
	public void cancelForm() {
		journalStage.close();
	}
}
