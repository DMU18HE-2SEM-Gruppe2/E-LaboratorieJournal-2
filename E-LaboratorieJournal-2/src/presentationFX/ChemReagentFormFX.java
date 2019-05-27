package presentationFX;

import java.time.LocalDate;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.ChemReagentForm;
import logic.Student;
import logicFormDB.ChemReagentDB;
import logicFormDB.DBFactory;

public class ChemReagentFormFX {
	Scene chemReagentScene;
	Stage chemReagentStage;
	
	TextField tfName, tfCourse, tfDate, tfTheme, tfAnalyzeTitle, tfReagentName, tfBatchNo, tfLotNo, tfSupplier, tfScaleNo, tfVolume, tfConcentration, tfShelfLife,
	tfStorage, tfComment, tfMeasurements; 
	
	int analyzeID, studentID, courseID, id;
	LocalDate date;
	String firstName, lastName, test;
	
	ComboBox cbStudent, cbCourse;
	private Button cancel, invalid, save, saveLock, print;
	ButtonType yesButton, noButton;
	private Alert cancelAlert, saveAndLockAlert;
	
	DBFactory dbf = new DBFactory();
	JavaWorldPrint jvPrint = new JavaWorldPrint();
	
	public void start() {
		chemReagentStage = new Stage();
		chemReagentStage.setTitle("Opret Kemi Reagentsfremstillingsblanket");
		chemReagentStage.setWidth(840);
		chemReagentStage.setHeight(700);
		chemReagentStage.setResizable(true);
		
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
		mainBox.setPrefHeight(835);
		mainBox.setPadding(new Insets(15, 15, 15 ,15));
		mainBox.setSpacing(15);
		
		chemReagentScene = new Scene(scrollPane);
		
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
		Label lName = factory.labelFactory("Navn*", 0, 0, 0, 0, 14, false);
	    Label lCourse = factory.labelFactory("Klasse*", 0, 0, 0, 0, 14, false);
	    Label lDate = factory.labelFactory("Dato*", 0, 0, 0, 0, 14, false);
	    Label lTheme = factory.labelFactory("Tema*", 0, 0, 0, 0, 14, false);
	    Label lAnalyzeTitle = factory.labelFactory("Analysetitel*", 0, 0, 0, 0, 14, false);
	    Label lReagentName = factory.labelFactory("Reagensnavn og eventuel koncentration*", 0, 0, 0, 0, 14, false);
	    Label lBatchNo = factory.labelFactory("Bathc Nr.", 0, 0, 0, 0, 14, false);
	    Label lLotNo = factory.labelFactory("Lot Nr.", 0, 0, 0, 0, 14, false);
	    Label lSupplier = factory.labelFactory("Leverandør", 0, 0, 0, 0, 14, false);
	    Label lMeasurements = factory.labelFactory("Afvejninger / Afmålinger", 0, 0, 0, 0, 14, false);
	    Label lScaleNo = factory.labelFactory("Vægt Nr. / Pipette Nr.", 0, 0, 0, 0, 14, false);
	    Label lVolume = factory.labelFactory("Fremstillet Volumen", 0, 0, 0, 0, 14, false);
	    Label lConcentration = factory.labelFactory("Angiv nøjagtig koncentration", 0, 0, 0, 0, 14, false);
	    Label lShelfLife = factory.labelFactory("Holdbarhed", 0, 0, 0, 0, 14, false);
	    Label lStorage = factory.labelFactory("Opbevaring", 0, 0, 0, 0, 14, false);
	    Label lComment = factory.labelFactory("Bemærkninger", 0, 0, 0, 0, 14, false);
		
		// Textfields
	    tfName = factory.textFieldFactory("", 500, 14);
	    tfCourse = factory.textFieldFactory("", 500, 14);
	    tfDate = factory.textFieldFactory("", 500, 14);
	    tfDate.setText(LocalDate.now().toString());
	    tfDate.setDisable(true);
	    tfTheme = factory.textFieldFactory("", 500, 14);
	    tfAnalyzeTitle = factory.textFieldFactory("", 500, 14);
	    tfReagentName = factory.textFieldFactory("", 500, 14);
	    tfBatchNo = factory.textFieldFactory("", 500, 14);
	    tfLotNo = factory.textFieldFactory("", 500, 14);
	    tfSupplier = factory.textFieldFactory("", 500, 14);
	    tfScaleNo = factory.textFieldFactory("", 500, 14);
	    tfVolume = factory.textFieldFactory("", 500, 14);
	    tfConcentration = factory.textFieldFactory("", 500, 14);
	    tfShelfLife = factory.textFieldFactory("", 500, 14);
	    tfStorage = factory.textFieldFactory("", 500, 14);
	    tfComment = factory.textFieldFactory("", 500, 14);
	    tfMeasurements = factory.textFieldFactory("", 500, 14);
	    
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
		Separator sepBatch = new Separator();
		Separator sepButton = new Separator();
	    
		// Textareas
		TextArea measurementstxt = new TextArea();
		TextArea notextxt = new TextArea();
		
		// Buttons
		cancel = factory.buttonFactory("Annuller", 90, 14, false);
		invalid = factory.buttonFactory("Ugyldiggør", 90, 14, true);
		print = factory.buttonFactory("Print", 90, 14, false);
		saveLock = factory.buttonFactory("Gem og Lås", 90, 14, true);
		save = factory.buttonFactory("Gem", 90, 14, true);
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
		mainGrid.add(lScaleNo, 0, 1);
		mainGrid.add(tfScaleNo, 1, 1);
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
		infoGrid.add(cbStudent, 1, 0);
		infoGrid.add(lCourse, 0, 1);
		infoGrid.add(cbCourse, 1, 1);
		infoGrid.add(lDate, 0, 2);
		infoGrid.add(tfDate, 1, 2);
		infoGrid.add(lTheme, 0, 3);
		infoGrid.add(tfTheme, 1, 3);
		
		btnRightBox.getChildren().addAll(print, save, saveLock);
		btnBox.getChildren().addAll(cancel, invalid, btnRightBox);
		mainBox.getChildren().addAll(topGrid, sepTop, nameGrid, sepName, batchGrid, sepBatch, mainGrid, sepButton, btnBox);
		borderPane.setCenter(mainBox);
		scrollPane.setContent(borderPane);
		
		// Check if TextField is focused, and if it should be disabled
		tfMeasurements.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue == false) {
				dataCheck();
			}
		});
		
		// Check if TextField is focused, and if it should be disabled
		tfVolume.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue == false) {
				dataCheck();
			}
		});
		
		// Listeners on all needed textfields. 
		// These are required to be filled, before you can save
		cbStudent.valueProperty().addListener((obersvable, oldValue, newValue) -> {
			saveCheck();
		});
		cbCourse.valueProperty().addListener((obersvable, oldValue, newValue) -> {
			saveCheck();
		});
		tfName.textProperty().addListener((obersvable, oldValue, newValue) -> {
			saveCheck();
		});
		tfDate.textProperty().addListener((obersvable, oldValue, newValue) -> {
			saveCheck();
		});
		tfAnalyzeTitle.textProperty().addListener((obersvable, oldValue, newValue) -> {
			saveCheck();
		});
		tfReagentName.textProperty().addListener((obersvable, oldValue, newValue) -> {
			saveCheck();
		});
		
		// Cancel alert box
		cancelAlert = new Alert(AlertType.CONFIRMATION);
		cancelAlert.setHeaderText("Er du sikker på at du vil annullere?");
		cancelAlert.setContentText("Blanketten vil ikke blive gemt.");
		cancelAlert.setTitle("Annuller");

		noButton = new ButtonType("Nej");
		yesButton = new ButtonType("Ja");
		
		cancelAlert.getButtonTypes().setAll(noButton, yesButton);
		
		// Save and Lock Alert Box
		saveAndLockAlert = new Alert(AlertType.CONFIRMATION);
		saveAndLockAlert.setHeaderText("Er du sikker på at du vil låse blanketten?");
		saveAndLockAlert.setContentText("Blanketten kan ikke redigeres bagefter");
		saveAndLockAlert.setTitle("Gem og Lås");
		
		saveAndLockAlert.getButtonTypes().setAll(noButton, yesButton);
		
		// Action
		cancel.setOnAction(e -> cancelForm());
		save.setOnAction(e -> createForm());
		saveLock.setOnAction(e -> lockForm());
		print.setOnAction(e -> print());
		
	    cbStudent.getValue();
	    System.out.println("getvalue: " + cbStudent);


		chemReagentStage.setScene(chemReagentScene);
		chemReagentStage.show();
	}
	
		// Checks the Raw Data, and invalidates buttons or textfields if incorrectly filled
	public void dataCheck() {
		// Disables Measurement textfield, if any raw data is filled in
		if (!tfMeasurements.getText().isEmpty()) {
			tfMeasurements.setDisable(true);
		}
		// Disables Volume textfield, if any raw data is filled in
		if (!tfVolume.getText().isEmpty()) {
			tfVolume.setDisable(true);
		}
		// Disables cancel button, if any raw data is filled in
		if (!cancel.isDisable()) {
			cancel.setDisable(true);
		}
		// Enables invalid button, if any raw data is filled in
		if (!tfMeasurements.getText().isEmpty() || !tfVolume.getText().isEmpty()) {
			invalid.setDisable(false);
		}
	}
	
	public void saveCheck() {
		if (!cbStudent.getSelectionModel().isEmpty() && !cbCourse.getSelectionModel().isEmpty() 
				&& !tfDate.getText().isEmpty() && !tfTheme.getText().isEmpty() && !tfAnalyzeTitle.getText().isEmpty() 
				&& !tfReagentName.getText().isEmpty()) {
			save.setDisable(false);
			saveLock.setDisable(false);
			
		} else {
			save.setDisable(true);
			saveLock.setDisable(true);
		}
	}
	
	public void cancelForm() {
		cancelAlert.showAndWait();		
		FrontPage frontpage = new FrontPage();
		if (cancelAlert.getResult() == yesButton) {
			chemReagentStage.close();
			frontpage.btnForm.setText("HEJ");
		}
	}
	
	public void lockForm() {
		saveAndLockAlert.showAndWait();
		if (saveAndLockAlert.getResult() == yesButton) {
			createForm();
			chemReagentStage.close();
		}
	}
	
	public void createForm() {
		int selectedIndex = cbStudent.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			Student student = (Student) cbStudent.getSelectionModel().getSelectedItem();
			id = student.getStudentID();
			System.out.println("id: " + id);
			studentID = dbf.makeInterfaceDB().getStudentById(id);	
		}

//		frontpage.status.setText("hej");

		ChemReagentForm crf = new ChemReagentForm(date.now(), tfTheme.getText(), tfAnalyzeTitle.getText(), tfComment.getText(), 
				analyzeID, studentID, tfScaleNo.getText(), tfVolume.getText(), tfConcentration.getText(), tfShelfLife.getText(), 
				tfStorage.getText(), tfReagentName.getText(), tfBatchNo.getText(), tfLotNo.getText(), tfSupplier.getText());
		ChemReagentDB crb = new ChemReagentDB();

		Student student = new Student(firstName, lastName, courseID, studentID);
		crb.addChemReagent(crf, student);
		chemReagentStage.close();
	}
	public void print() {
		createForm();
		
		jvPrint.JavaWorldPrint();
	}
	
}