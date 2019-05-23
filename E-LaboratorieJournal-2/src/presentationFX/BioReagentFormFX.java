package presentationFX;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	Scene bioReagentScene;
	private Stage bioReagentStage;
	
	public void start() {
		bioReagentStage = new Stage();
		bioReagentStage.setTitle("Opret Biologi Reagensfremstillingsblanket");
		bioReagentStage.setResizable(false);
		
		// VBox
		VBox mainBox = new VBox();
		mainBox.setPrefWidth(600);
		mainBox.setPrefHeight(950);
		mainBox.setPadding(new Insets(15, 15, 15 ,15));
		mainBox.setSpacing(15);
		
		bioReagentScene = new Scene(mainBox);
		
		// HBox
		HBox btnBox = new HBox(15);
		HBox btnRightBox = new HBox(15);
		btnRightBox.setAlignment(Pos.CENTER_RIGHT);
		
		// Gridpane
		GridPane topGrid = new GridPane();
		topGrid.setVgap(15);
		topGrid.getColumnConstraints().add(new ColumnConstraints(300));
		topGrid.getColumnConstraints().add(new ColumnConstraints(500));
		GridPane btmGrid = new GridPane();
		btmGrid.setVgap(15);
		btmGrid.getColumnConstraints().add(new ColumnConstraints(300));
		btmGrid.getColumnConstraints().add(new ColumnConstraints(500));
		GridPane infoGrid = new GridPane();
		infoGrid.setPadding(new Insets(0, 0, 30, 0));
		infoGrid.setVgap(10);
		infoGrid.getColumnConstraints().add(new ColumnConstraints(100));
		infoGrid.getColumnConstraints().add(new ColumnConstraints(200));
		GridPane btnGrid = new GridPane();
		btnGrid.getColumnConstraints().add(new ColumnConstraints(400));
		btnGrid.getColumnConstraints().add(new ColumnConstraints(100));
		btnGrid.getColumnConstraints().add(new ColumnConstraints(100));
		btnGrid.getColumnConstraints().add(new ColumnConstraints(100));
		
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
		Label namelbl = new Label("Navn");
		Label courselbl = new Label("Klasse");
		Label datelbl = new Label("Dato");
		Label themelbl = new Label("Tema");
		Label analyzeTitleLbl = new Label("Analysetitel");
		Label reagentNameLbl = new Label("Reagensnavn og eventuel koncentration");
		Label referenceLbl = new Label("Henvisning:");
		Label phSettingLbl = new Label("Indstilling af pH");
		Label liquidLbl = new Label("Væske ad");
		Label treatmentLbl = new Label("Eventuel yderligere behandling");
		Label tagLbl = new Label("Mærkning");
		Label durabilityLbl = new Label("Holdbarhed");
		Label storageLbl = new Label("Opbevaring");
		Label commentLbl = new Label("Bemærkninger");
		
		// Textfields
		TextField nametxt = new TextField();
		TextField coursetxt = new TextField();
		TextField datetxt = new TextField();
		TextField themetxt = new TextField();
		TextField analyzeTitleTxt = new TextField();
		TextField reagentNameTxt = new TextField();
		TextField phSettingTxt = new TextField();
		TextField liquidTxt = new TextField();
		TextField treatmentTxt = new TextField();
		TextField tagTxt = new TextField();
		TextField durabilityTxt = new TextField();
		TextField storageTxt = new TextField();
		TextField commentTxt = new TextField();
		
		// Buttons
		Button invalid = new Button("Ugyldiggør");
		Button print = new Button("Print");
		Button saveLock = new Button("Gem og Lås");
		Button save = new Button("Gem");
		Button addPreparation = new Button("Tilføj resultat");
		
		// Setup
		topGrid.add(infoGrid, 0, 0);
		topGrid.add(imageView, 1, 0);
		topGrid.add(analyzeTitleLbl, 0, 1);
		topGrid.add(analyzeTitleTxt, 1, 1);
		topGrid.add(reagentNameLbl, 0, 2);
		topGrid.add(reagentNameTxt, 1, 2);
		
		infoGrid.add(namelbl, 0, 0);
		infoGrid.add(nametxt, 1, 0);
		infoGrid.add(courselbl, 0, 1);
		infoGrid.add(coursetxt, 1, 1);
		infoGrid.add(datelbl, 0, 2);
		infoGrid.add(datetxt, 1, 2);
		infoGrid.add(themelbl, 0, 3);
		infoGrid.add(themetxt, 1, 3);
		
		btmGrid.add(phSettingLbl, 0, 0);
		btmGrid.add(phSettingTxt, 1, 0);
		btmGrid.add(liquidLbl, 0, 1);
		btmGrid.add(liquidTxt, 1, 1);
		btmGrid.add(treatmentLbl, 0, 2);
		btmGrid.add(treatmentTxt, 1, 2);
		btmGrid.add(tagLbl, 0, 3);
		btmGrid.add(tagTxt, 1, 3);
		btmGrid.add(durabilityLbl, 0, 4);
		btmGrid.add(durabilityTxt, 1, 4);
		btmGrid.add(storageLbl, 0, 5);
		btmGrid.add(storageTxt, 1, 5);
		btmGrid.add(commentLbl, 0, 6);
		btmGrid.add(commentTxt, 1, 6);
		
		btnGrid.getChildren().addAll(invalid, print, saveLock, save);
		
		btnRightBox.getChildren().addAll(print, saveLock, save);
		btnBox.getChildren().addAll(invalid, btnRightBox);
		mainBox.getChildren().addAll(topGrid, referenceLbl, preparationTable, addPreparation, btmGrid, btnGrid);
		
		// Action
		addPreparation.setOnAction(e -> createPreparation());
		
		bioReagentStage.setScene(bioReagentScene);
		bioReagentStage.show();
	}
	
	public void createPreparation() {
		PreparationForm preparationForm = new PreparationForm();
		preparationForm.Start();
	}
}
