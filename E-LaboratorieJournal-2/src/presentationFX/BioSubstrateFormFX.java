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

public class BioSubstrateFormFX {
	Scene bioSubstrateScene;
	private Stage bioSubstrateStage;
	
	public void start() {
		bioSubstrateStage = new Stage();
		bioSubstrateStage.setTitle("Opret Biologi Substratfremstillingsblanket");
		
		// VBox
		VBox mainBox = new VBox();
		bioSubstrateScene = new Scene(mainBox);
		mainBox.setPrefWidth(800);
		mainBox.setPrefHeight(950);
		mainBox.setPadding(new Insets(10, 10, 10 ,10));
		mainBox.setSpacing(10);
		
		// HBox
		HBox btnBox = new HBox();
		
		// Gridpane
		GridPane topGrid = new GridPane();
		GridPane btmGrid = new GridPane();
		GridPane infoGrid = new GridPane();
		GridPane sterileGrid = new GridPane();
		
		// Tableview
		TableView preparationTable = new TableView();
		
		// Labels
		Label namelbl = new Label("Navn");
		Label courselbl = new Label("Klasse");
		Label datelbl = new Label("Dato");
		Label themelbl = new Label("Tema");
		Label analyzeTitlelbl = new Label("Analyse Titel");
		Label substrateNamelbl = new Label("Substratnavn og eventuel forkortelse");
		Label phSubstrateLbl = new Label("pH i det færdige substrat skal være");
		Label phSterializedLbl = new Label("pH målt inden sterilisation");
		Label liquidLbl = new Label("Væske ad");
		Label sterializeTimeLbl = new Label("Sterilisationstid");
		Label sterializeCLbl = new Label("Sterilisationstemperatur");
		Label addAftSterializeLbl = new Label("Eventuel tilsætning efter sterilisation");
		Label phAftSterializeLbl = new Label("pH efter sterilisation");
		Label sterilLbl = new Label("Sterilt");
		Label posControlLbl = new Label("Positiv Kontrol");
		Label negControlLbl = new Label("Negativ Kontrol");
		Label commentLbl = new Label("Bemærkninnger");
		
		// Textfields / Textarea
		TextField nametxt = new TextField();
		TextField coursetxt = new TextField();
		TextField datetxt = new TextField();
		TextField themetxt = new TextField();
		TextField analyzeTitleTxt = new TextField();
		TextField substrateNameTxt = new TextField();
		TextField phSubstrateTxt = new TextField();
		TextField phSterializedTxt = new TextField();
		TextField liquidTxt = new TextField();
		TextField sterializeTimeTxt = new TextField();
		TextField sterializeCTxt = new TextField();
		TextField addAftSterializeTxt = new TextField();
		TextField phAftSterializeTxt = new TextField();
		TextField posControlTxt = new TextField();
		TextField negControlTxt = new TextField();
		TextField commentTxt = new TextField();
		
		// Buttons
		Button invalid = new Button("Ugyldiggør");
		Button print = new Button("Print");
		Button saveLock = new Button("Gem og Lås");
		Button save = new Button("Gem");
		Button addPreparation = new Button("Tilføj resultat");
		
		// Setup
		topGrid.add(infoGrid, 0, 0);
		topGrid.add(analyzeTitlelbl, 0, 1);
		topGrid.add(analyzeTitleTxt, 1, 1);
		topGrid.add(substrateNamelbl, 0, 2);
		topGrid.add(substrateNameTxt, 1, 2);
		
		infoGrid.add(namelbl, 0, 0);
		infoGrid.add(nametxt, 1, 0);
		infoGrid.add(courselbl, 0, 1);
		infoGrid.add(coursetxt, 1, 1);
		infoGrid.add(datelbl, 0, 2);
		infoGrid.add(datetxt, 1, 2);
		infoGrid.add(themelbl, 0, 3);
		infoGrid.add(themetxt, 1, 3);
		
		btmGrid.add(phSubstrateLbl, 0, 0);
		btmGrid.add(phSubstrateTxt, 1, 0);
		btmGrid.add(phSterializedLbl, 0, 1);
		btmGrid.add(phSterializedTxt, 1, 1);
		btmGrid.add(liquidLbl, 0, 2);
		btmGrid.add(liquidTxt, 1, 2);
		btmGrid.add(sterializeTimeLbl, 0, 3);
		btmGrid.add(sterializeTimeTxt, 1, 3);
		btmGrid.add(sterializeCLbl, 0, 4);
		btmGrid.add(sterializeCTxt, 1, 4);
		btmGrid.add(addAftSterializeLbl, 0, 5);
		btmGrid.add(addAftSterializeTxt, 1, 5);
		btmGrid.add(phAftSterializeLbl, 0, 6);
		btmGrid.add(phAftSterializeTxt, 1, 6);
		btmGrid.add(sterilLbl, 0, 7);
		btmGrid.add(sterileGrid, 1, 7);
		btmGrid.add(posControlLbl, 0, 8);
		btmGrid.add(posControlTxt, 1, 8);
		btmGrid.add(negControlLbl, 0, 9);
		btmGrid.add(negControlTxt, 1, 9);
		btmGrid.add(commentLbl, 0, 10);
		btmGrid.add(commentTxt, 1, 10);
		
		mainBox.getChildren().addAll(topGrid, preparationTable, addPreparation, btmGrid, btnBox);
		
		// Action
		addPreparation.setOnAction(e -> createPreparation());
		
		bioSubstrateStage.setScene(bioSubstrateScene);
		bioSubstrateStage.show();
	}
	
	public void createPreparation() {
		PreparationForm preparationForm = new PreparationForm();
		preparationForm.Start();
	}
}
