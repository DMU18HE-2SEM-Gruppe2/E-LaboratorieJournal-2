package presentationFX;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
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
		chemReagentStage.setResizable(false);
		
		FactoryFX factory = new FactoryFX();
		
		// VBox
		VBox mainBox = new VBox();
		mainBox.setPrefWidth(800);
		mainBox.setPrefHeight(835);
		mainBox.setPadding(new Insets(15, 15, 15 ,15));
		mainBox.setSpacing(15);
		
		chemReagentScene = new Scene(mainBox);
		
		// HBox
		HBox btnBox = new HBox(15);
		HBox btnRightBox = new HBox(15);
		btnRightBox.setAlignment(Pos.CENTER_RIGHT);
		btnRightBox.setPrefWidth(800);
		
		// Gridpane
		GridPane mainGrid = new GridPane();
		mainGrid.setVgap(15);
		mainGrid.getColumnConstraints().add(new ColumnConstraints(275));
		mainGrid.getColumnConstraints().add(new ColumnConstraints(500));
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
		GridPane batchGrid = new GridPane();
		batchGrid.setVgap(15);
		batchGrid.getColumnConstraints().add(new ColumnConstraints(275));
		batchGrid.getColumnConstraints().add(new ColumnConstraints(500));
		
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
	    Label lBatchNo = factory.labelFactory("Bathc Nr.", 0, 0, 0, 0, 14, false);
	    Label lLotNo = factory.labelFactory("Lot Nr.", 0, 0, 0, 0, 14, false);
	    Label lSupplier = factory.labelFactory("Leverandør", 0, 0, 0, 0, 14, false);
	    Label lMeasurements = factory.labelFactory("Afvejninger / Afmålinger", 0, 0, 0, 0, 14, false);
	    Label lWeightNo = factory.labelFactory("Vægt Nr. / Pipette Nr.", 0, 0, 0, 0, 14, false);
	    Label lVolume = factory.labelFactory("Fremstillet Volumen", 0, 0, 0, 0, 14, false);
	    Label lConcentration = factory.labelFactory("Angiv nøjagtig koncentration", 0, 0, 0, 0, 14, false);
	    Label lShelfLife = factory.labelFactory("Holdbarhed", 0, 0, 0, 0, 14, false);
	    Label lStorage = factory.labelFactory("Opvevaring", 0, 0, 0, 0, 14, false);
	    Label lComment = factory.labelFactory("Bemærkninger", 0, 0, 0, 0, 14, false);
		
		// Textfields
	    TextField tfName = factory.textFieldFactory("", 500, 14);
	    TextField tfCourse = factory.textFieldFactory("", 500, 14);
	    TextField tfDate = factory.textFieldFactory("", 500, 14);
	    TextField tfTheme = factory.textFieldFactory("", 500, 14);
	    TextField tfAnalyzeTitle = factory.textFieldFactory("", 500, 14);
	    TextField tfReagentName = factory.textFieldFactory("", 500, 14);
	    TextField tfBatchNo = factory.textFieldFactory("", 500, 14);
	    TextField tfLotNo = factory.textFieldFactory("", 500, 14);
	    TextField tfSupplier = factory.textFieldFactory("", 500, 14);
	    TextField tfWeightNo = factory.textFieldFactory("", 500, 14);
	    TextField tfVolume = factory.textFieldFactory("", 500, 14);
	    TextField tfConcentration = factory.textFieldFactory("", 500, 14);
	    TextField tfShelfLife = factory.textFieldFactory("", 500, 14);
	    TextField tfStorage = factory.textFieldFactory("", 500, 14);
	    TextField tfComment = factory.textFieldFactory("", 500, 14);
	    TextField tfMeasurements = factory.textFieldFactory("", 500, 14);

	    // Separators
	    Separator sepName = new Separator();
		Separator sepTop = new Separator();
		Separator sepBatch = new Separator();
		Separator sepButton = new Separator();
	    
		// Textareas
		TextArea measurementstxt = new TextArea();
		TextArea notextxt = new TextArea();
		
		// Buttons
		Button cancel = factory.buttonFactory("Annuller", 90, 14, false);
		Button invalid = factory.buttonFactory("Ugyldiggør", 90, 14, false);
		Button print = factory.buttonFactory("Print", 90, 14, false);
		Button saveLock = factory.buttonFactory("Gem og Lås", 90, 14, false);
		Button save = factory.buttonFactory("Gem", 90, 14, false);
		Button addPreparation = factory.buttonFactory("Tilføj Resultat", 90, 14, false);
				
		topGrid.add(infoGrid, 0, 0);
		topGrid.add(imageView, 1, 0);
		
		nameGrid.add(lAnalyzeTitle, 0, 0);
		nameGrid.add(tfAnalyzeTitle, 1, 0);
		nameGrid.add(lReagentName, 0, 1);
		nameGrid.add(tfReagentName, 1, 1);
		
		batchGrid.add(lBatchNo, 0, 0);
		batchGrid.add(tfBatchNo, 1, 0);
		batchGrid.add(lLotNo, 0, 1);
		batchGrid.add(tfLotNo, 1, 1);
		batchGrid.add(lSupplier, 0, 2);
		batchGrid.add(tfSupplier, 1, 2);

		mainGrid.add(lMeasurements, 0, 0);
		mainGrid.add(tfMeasurements, 1, 0);
		mainGrid.add(lWeightNo, 0, 1);
		mainGrid.add(tfWeightNo, 1, 1);
		mainGrid.add(lVolume, 0, 2);
		mainGrid.add(tfVolume, 1, 2);
		mainGrid.add(lConcentration, 0, 3);
		mainGrid.add(tfConcentration, 1, 3);
		mainGrid.add(lShelfLife, 0, 4);
		mainGrid.add(tfShelfLife, 1, 4);
		mainGrid.add(lStorage, 0, 5);
		mainGrid.add(tfStorage, 1, 5);
		mainGrid.add(lComment, 0, 6);
		mainGrid.add(tfComment, 1, 6);
		
		infoGrid.add(lName, 0, 0);
		infoGrid.add(tfName, 1, 0);
		infoGrid.add(lCourse, 0, 1);
		infoGrid.add(tfCourse, 1, 1);
		infoGrid.add(lDate, 0, 2);
		infoGrid.add(tfDate, 1, 2);
		infoGrid.add(lTheme, 0, 3);
		infoGrid.add(tfTheme, 1, 3);
		
		btnRightBox.getChildren().addAll(print, saveLock, save);
		btnBox.getChildren().addAll(cancel, invalid, btnRightBox);
		mainBox.getChildren().addAll(topGrid, sepTop, nameGrid, sepName, batchGrid, sepBatch, mainGrid, sepButton, btnBox);

		// Action
		cancel.setOnAction(e -> cancelForm());
		
		chemReagentStage.setScene(chemReagentScene);
		chemReagentStage.show();
	}
	
	public void cancelForm() {
		chemReagentStage.close();
	}
	
}
