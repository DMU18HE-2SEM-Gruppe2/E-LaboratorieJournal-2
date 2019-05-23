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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BioReagentFormFX {
	private Scene bioReagentScene;
	private Stage bioReagentStage;
	
	public void start() {
		bioReagentStage = new Stage();
		bioReagentStage.setTitle("Opret Biologi Reagensfremstillingsblanket");
		bioReagentStage.setResizable(false);
		
		FactoryFX factory = new FactoryFX();
		
		// VBox
		VBox mainBox = new VBox();
		mainBox.setPrefWidth(400);
		mainBox.setPrefHeight(950);
		mainBox.setPadding(new Insets(15, 15, 15 ,15));
		mainBox.setSpacing(15);
		
		bioReagentScene = new Scene(mainBox);
		
		// HBox
		HBox btnBox = new HBox(15);
		HBox btnRightBox = new HBox(15);
		btnRightBox.setAlignment(Pos.CENTER_RIGHT);
		btnRightBox.setPrefWidth(800);
		
		// Gridpane
		GridPane topGrid = new GridPane();
		topGrid.setVgap(15);
		topGrid.getColumnConstraints().add(new ColumnConstraints(275));
		topGrid.getColumnConstraints().add(new ColumnConstraints(500));
		GridPane btmGrid = new GridPane();
		btmGrid.setVgap(15);
		btmGrid.getColumnConstraints().add(new ColumnConstraints(275));
		btmGrid.getColumnConstraints().add(new ColumnConstraints(500));
		GridPane infoGrid = new GridPane();
		infoGrid.setVgap(10);
		infoGrid.getColumnConstraints().add(new ColumnConstraints(75));
		infoGrid.getColumnConstraints().add(new ColumnConstraints(200));
		
		// Tableview
		TableView preparationTable = new TableView();
		preparationTable.setPrefHeight(150);
		
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
	    Label lAnalyzeTitle = factory.labelFactory("Analysetitel", 0, 0, 0, 0, 14, false);
	    Label lReagentName = factory.labelFactory("Reagensnavn og eventuel koncentration", 0, 0, 0, 0, 14, false);
	    Label lReference = factory.labelFactory("Henvisning: ", 0, 0, 0, 0, 14, true);
	    Label lPhSetting = factory.labelFactory("Indstilling af pH", 0, 0, 0, 0, 14, false);
	    Label lLiquid = factory.labelFactory("Væske ad", 0, 0, 0, 0, 14, false);
	    Label lTreatment = factory.labelFactory("Eventuel yderligere behandling", 0, 0, 0, 0, 14, false);
	    Label lTag = factory.labelFactory("Mærkning", 0, 0, 0, 0, 14, false);
	    Label lDurability = factory.labelFactory("Holdbarhed", 0, 0, 0, 0, 14, false);
	    Label lStorage = factory.labelFactory("Opbevaring", 0, 0, 0, 0, 14, false);
	    Label lComment = factory.labelFactory("Bemærkninger", 0, 0, 0, 0, 14, false);
		
		// Textfields
	    TextField tfName = factory.textFieldFactory("", 500, 14);
	    TextField tfCourse = factory.textFieldFactory("", 500, 14);
	    TextField tfDate = factory.textFieldFactory("", 500, 14);
	    TextField tfTheme = factory.textFieldFactory("", 500, 14);
	    TextField tfAnalyzeTitle = factory.textFieldFactory("", 500, 14);
	    TextField tfReagentName = factory.textFieldFactory("", 500, 14);
	    TextField tfPhSetting = factory.textFieldFactory("", 500, 14);
	    TextField tfLiquid = factory.textFieldFactory("", 500, 14);
	    TextField tfTreatment = factory.textFieldFactory("", 500, 14);
	    TextField tfTag = factory.textFieldFactory("", 500, 14);
	    TextField tfDurability = factory.textFieldFactory("", 500, 14);
	    TextField tfStorage = factory.textFieldFactory("", 500, 14);
	    TextField tfComment = factory.textFieldFactory("", 500, 14);
		
		// Buttons
		Button cancel = factory.buttonFactory("Annuller", 90, 14, false);
		Button invalid = factory.buttonFactory("Ugyldiggør", 90, 14, false);
		Button print = factory.buttonFactory("Print", 90, 14, false);
		Button saveLock = factory.buttonFactory("Gem og Lås", 90, 14, false);
		Button save = factory.buttonFactory("Gem", 90, 14, false);
		Button addPreparation = factory.buttonFactory("Tilføj Resultat", 90, 14, false);

		// Separators
		Separator sepTable = new Separator();
		Separator sepTop = new Separator();
		Separator sepButtons = new Separator();
		Separator sepInfo = new Separator();
		Separator sepInfo2 = new Separator();
		
		// Setup
		topGrid.add(infoGrid, 0, 0);
		topGrid.add(imageView, 1, 0);
		topGrid.add(lAnalyzeTitle, 0, 2);
		topGrid.add(tfAnalyzeTitle, 1, 2);
		topGrid.add(lReagentName, 0, 3);
		topGrid.add(tfReagentName, 1, 3);
		topGrid.add(sepInfo, 0, 1);
		topGrid.add(sepInfo2, 1, 1);

		infoGrid.add(lName, 0, 0);
		infoGrid.add(tfName, 1, 0);
		infoGrid.add(lCourse, 0, 1);
		infoGrid.add(tfCourse, 1, 1);
		infoGrid.add(lDate, 0, 2);
		infoGrid.add(tfDate, 1, 2);
		infoGrid.add(lTheme, 0, 3);
		infoGrid.add(tfTheme, 1, 3);
		
		btmGrid.add(lPhSetting, 0, 0);
		btmGrid.add(tfPhSetting, 1, 0);
		btmGrid.add(lLiquid, 0, 1);
		btmGrid.add(tfLiquid, 1, 1);
		btmGrid.add(lTreatment, 0, 2);
		btmGrid.add(tfTreatment, 1, 2);
		btmGrid.add(lTag, 0, 3);
		btmGrid.add(tfTag, 1, 3);
		btmGrid.add(lDurability, 0, 4);
		btmGrid.add(tfDurability, 1, 4);
		btmGrid.add(lStorage, 0, 5);
		btmGrid.add(tfStorage, 1, 5);
		btmGrid.add(lComment, 0, 6);
		btmGrid.add(tfComment, 1, 6);
		
		btnRightBox.getChildren().addAll(print, saveLock, save);
		btnBox.getChildren().addAll(cancel, invalid, btnRightBox);
		mainBox.getChildren().addAll(topGrid, sepTop, lReference, preparationTable, addPreparation, sepTable, btmGrid, sepButtons, btnBox);
		
		// Action
		addPreparation.setOnAction(e -> createPreparation());
		cancel.setOnAction(e -> cancelForm());
		
		bioReagentStage.setScene(bioReagentScene);
		bioReagentStage.show();
	}
	
	public void createPreparation() {
		PreparationForm preparationForm = new PreparationForm();
		preparationForm.Start();
	}
	
	public void cancelForm() {
		bioReagentStage.close();
	}
}
