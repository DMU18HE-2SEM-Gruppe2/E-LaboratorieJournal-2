package presentationFX;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logicFormDB.DBFactory;

public class BioSubstrateFormFX {
	private Scene bioSubstrateScene;
	private Stage bioSubstrateStage;
	private ComboBox cbStudent, cbCourse;
	
	DBFactory dbf = new DBFactory();
	PopupFX popup = new PopupFX();
	
	public void start() {
		bioSubstrateStage = new Stage();
		bioSubstrateStage.setTitle("Opret Biologi Substratfremstillingsblanket");
		bioSubstrateStage.setWidth(840);
		bioSubstrateStage.setHeight(700);
		bioSubstrateStage.setResizable(true);
		
		FactoryFX factory = new FactoryFX();
		
		// Scrollpane
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setFitToWidth(true);
		scrollPane.setPannable(true);
		
		// BorderPane
		BorderPane borderPane = new BorderPane();
		
		// VBox
		VBox mainBox = new VBox();
		mainBox.setMaxWidth(820);
		mainBox.setPrefHeight(950);
		mainBox.setPadding(new Insets(15, 15, 15 ,15));
		mainBox.setSpacing(15);
		
		bioSubstrateScene = new Scene(scrollPane);
		
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
		GridPane nameGrid = new GridPane();
		nameGrid.setVgap(15);
		nameGrid.getColumnConstraints().add(new ColumnConstraints(275));
		nameGrid.getColumnConstraints().add(new ColumnConstraints(500));
		GridPane mainGrid = new GridPane();
		mainGrid.setVgap(15);
		mainGrid.getColumnConstraints().add(new ColumnConstraints(275));
		mainGrid.getColumnConstraints().add(new ColumnConstraints(500));
		GridPane infoGrid = new GridPane();
		infoGrid.setVgap(10);
		infoGrid.getColumnConstraints().add(new ColumnConstraints(75));
		infoGrid.getColumnConstraints().add(new ColumnConstraints(200));
		GridPane controlGrid = new GridPane();
		controlGrid.setVgap(15);
		controlGrid.getColumnConstraints().add(new ColumnConstraints(275));
		controlGrid.getColumnConstraints().add(new ColumnConstraints(500));
		
		// Tableview
		TableView preparationTable = new TableView();
		preparationTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		preparationTable.setMinHeight(150);
		
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
	    Label lSubstrateName = factory.labelFactory("Substratnavn og eventuel forkortelse", 0, 0, 0, 0, 14, false);
	    Label lPreparationTable = factory.labelFactory("Henvisninger", 0, 0, 0, 0, 14, true);
	    Label lPhSubstrate = factory.labelFactory("pH i det færdige substrat skal være", 0, 0, 0, 0, 14, false);
	    Label lPhSterialized = factory.labelFactory("pH målt inden sterilisation", 0, 0, 0, 0, 14, false);
	    Label lLiquid = factory.labelFactory("Væske ad", 0, 0, 0, 0, 14, false);
	    Label lSterializedTime = factory.labelFactory("Sterilisationstid", 0, 0, 0, 0, 14, false);
	    Label lSterializedC = factory.labelFactory("Sterilisationstemperatur", 0, 0, 0, 0, 14, false);
	    Label lAddAftSterialize = factory.labelFactory("Eventuel tilsætning efter sterilisation", 0, 0, 0, 0, 14, false);
	    Label lPhAftSterialize = factory.labelFactory("pH efter sterilisation", 0, 0, 0, 0, 14, false);
	    Label lSterile = factory.labelFactory("Sterilt", 0, 0, 0, 0, 14, false);
	    Label lPosControl = factory.labelFactory("Positiv Kontrol", 0, 0, 0, 0, 14, false);
	    Label lNegControl = factory.labelFactory("Negativ Kontrol", 0, 0, 0, 0, 14, false);
	    Label lComment = factory.labelFactory("Bemærkninger", 0, 0, 0, 0, 14, false);
		
		// Textfields / Textarea
	    TextField tfName = factory.textFieldFactory("", 500, 14);
	    TextField tfCourse = factory.textFieldFactory("", 500, 14);
	    TextField tfDate = factory.textFieldFactory("", 500, 14);
	    TextField tfTheme = factory.textFieldFactory("", 500, 14);
	    TextField tfAnalyzeTitle = factory.textFieldFactory("", 500, 14);
	    TextField tfSubstrateName = factory.textFieldFactory("", 500, 14);
	    TextField tfPhSubstrate = factory.textFieldFactory("", 500, 14);
	    TextField tfPhSterialized = factory.textFieldFactory("", 500, 14);
	    TextField tfLiquid = factory.textFieldFactory("", 500, 14);
	    TextField tfSterializedTime = factory.textFieldFactory("", 500, 14);
	    TextField tfSterializedC = factory.textFieldFactory("", 500, 14);
	    TextField tfAddAftSterialize = factory.textFieldFactory("", 500, 14);
	    TextField tfPhAftSterialize = factory.textFieldFactory("", 500, 14);
	    TextField tfPosControl = factory.textFieldFactory("", 500, 14);
	    TextField tfNegControl = factory.textFieldFactory("", 500, 14);
	    TextField tfComment = factory.textFieldFactory("", 500, 14);
		
	    // ChoiceBox
	    cbStudent = new ComboBox();
	    cbStudent.setPrefWidth(350);
	    cbStudent.getItems().setAll(dbf.makeInterfaceDB().getAllStudents());
	    cbCourse = new ComboBox();
	    cbCourse.setPrefWidth(350);
	    cbCourse.getItems().setAll(dbf.makeInterfaceDB().getAllCourses());
	    
	    // Separators
	    Separator sepName = new Separator();
		Separator sepTop = new Separator();
		Separator sepPreparation = new Separator();
		Separator sepMain = new Separator();
		Separator sepButton = new Separator();
		
		// Buttons
		Button cancel = factory.buttonFactory("Annuller", 90, 14, false);
		Button invalid = factory.buttonFactory("Ugyldiggør", 90, 14, false);
		Button print = factory.buttonFactory("Print", 90, 14, false);
		Button saveLock = factory.buttonFactory("Gem og Lås", 90, 14, false);
		Button save = factory.buttonFactory("Gem", 90, 14, false);
		Button addPreparation = factory.buttonFactory("Tilføj Resultat", 90, 14, false);
		
		// Setup
		topGrid.add(infoGrid, 0, 0);
		topGrid.add(imageView, 1, 0);
		
		infoGrid.add(lName, 0, 0);
		infoGrid.add(cbStudent, 1, 0);
		infoGrid.add(lCourse, 0, 1);
		infoGrid.add(cbCourse, 1, 1);
		infoGrid.add(lDate, 0, 2);
		infoGrid.add(tfDate, 1, 2);
		infoGrid.add(lTheme, 0, 3);
		infoGrid.add(tfTheme, 1, 3);
		
		nameGrid.add(lAnalyzeTitle, 0, 1);
		nameGrid.add(tfAnalyzeTitle, 1, 1);
		nameGrid.add(lSubstrateName, 0, 2);
		nameGrid.add(tfSubstrateName, 1, 2);
		
		mainGrid.add(lPhSubstrate, 0, 0);
		mainGrid.add(tfPhSubstrate, 1, 0);
		mainGrid.add(lPhSterialized, 0, 1);
		mainGrid.add(tfPhSterialized, 1, 1);
		mainGrid.add(lLiquid, 0, 2);
		mainGrid.add(tfLiquid, 1, 2);
		mainGrid.add(lSterializedTime, 0, 3);
		mainGrid.add(tfSterializedTime, 1, 3);
		mainGrid.add(lSterializedC, 0, 4);
		mainGrid.add(tfSterializedC, 1, 4);
		mainGrid.add(lAddAftSterialize, 0, 5);
		mainGrid.add(tfAddAftSterialize, 1, 5);
		
		controlGrid.add(lPhAftSterialize, 0, 0);
		controlGrid.add(tfPhAftSterialize, 1, 0);
		controlGrid.add(lSterile, 0, 1);
		controlGrid.add(lPosControl, 0, 2);
		controlGrid.add(tfPosControl, 1, 2);
		controlGrid.add(lNegControl, 0, 3);
		controlGrid.add(tfNegControl, 1, 3);
		controlGrid.add(lComment, 0, 4);
		controlGrid.add(tfComment, 1, 4);
		
		btnRightBox.getChildren().addAll(print, saveLock, save);
		btnBox.getChildren().addAll(cancel, invalid, btnRightBox);
		mainBox.getChildren().addAll(topGrid, sepTop, nameGrid, sepName, lPreparationTable, preparationTable, addPreparation, sepPreparation, mainGrid, sepMain, controlGrid, sepButton, btnBox);
		borderPane.setCenter(mainBox);
		scrollPane.setContent(borderPane);
		
		// Action
		addPreparation.setOnAction(e -> createPreparation());
		cancel.setOnAction(e -> cancelForm());
		
		bioSubstrateStage.setScene(bioSubstrateScene);
		bioSubstrateStage.show();
	}
	
	public void createPreparation() {
		PreparationForm preparationForm = new PreparationForm();
		preparationForm.Start();
	}
	
	public void cancelForm() {
		popup.startCancel();
	}
}
