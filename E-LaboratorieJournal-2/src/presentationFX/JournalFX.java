package presentationFX;

import java.time.LocalDate;

import data.DBConnection;
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
import logic.Journal;
import logic.Student;
import logicFormDB.DBFactory;

public class JournalFX {
	private Scene journalScene;
	private Stage journalStage;
	private ComboBox cbStudent, cbCourse;
	
	DBConnection connection = new DBConnection();

	DBFactory dbf = new DBFactory();

	private TextField tfName;
	private TextField tfCourse;
	private TextField tfDate;
	private TextField tfTheme;
	private TextField tfAnalyzeTitle;
	private TextField tfTraceability;
	private TextField tfCoworker;

	private TextArea taResults;
	private TextArea taResultTabel;
	private TextArea taCal;
	private TextArea taObs;

	public void start() {
		journalStage = new Stage();
		journalStage.setTitle("Opret Journal");
		journalStage.setWidth(840);
		journalStage.setHeight(700);
		journalStage.setResizable(true);

		FactoryFX factory = new FactoryFX();

		// Scrollpane
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setFitToWidth(true);
		scrollPane.setPannable(true);

		// BorderPane
		BorderPane borderPane = new BorderPane();

		// VBox
		VBox mainBox = new VBox();
		mainBox.setPadding(new Insets(15, 15, 15, 15));
		mainBox.setSpacing(15);
		mainBox.setMaxWidth(820);

		journalScene = new Scene(scrollPane);

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
		refTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		refTable.setPrefHeight(150);
		refTable.setMaxWidth(775);

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
		Label lCoworker = factory.labelFactory("Observationer og Bemærkninger", 0, 0, 0, 0, 14, false);

		// Textfields
		tfName = factory.textFieldFactory("", 500, 14);
		tfCourse = factory.textFieldFactory("", 500, 14);
		tfDate = factory.textFieldFactory("", 500, 14);
		tfTheme = factory.textFieldFactory("", 500, 14);
		tfAnalyzeTitle = factory.textFieldFactory("", 500, 14);
		tfTraceability = factory.textFieldFactory("", 500, 14);
		tfCoworker = factory.textFieldFactory("", 500, 14);

		// TextAreas
		taResults = factory.textAreaFactory(100, 800, 14, false);
		taResultTabel = factory.textAreaFactory(100, 800, 14, true);
		taCal = factory.textAreaFactory(100, 800, 14, false);
		taObs = factory.textAreaFactory(100, 800, 14, false);

		// Buttons
		Button addForm = factory.buttonFactory("Tilføj", 90, 14, false);
		Button addCalcPics = factory.buttonFactory("Tilføj billed", 90, 14, false);
		Button addObsPics = factory.buttonFactory("Tilføj billed", 90, 14, false);
		Button cancel = factory.buttonFactory("Annuller", 90, 14, false);
		Button invalid = factory.buttonFactory("Ugyldiggør", 90, 14, false);
		Button print = factory.buttonFactory("Print", 90, 14, false);
		Button saveLock = factory.buttonFactory("Gem og Lås", 90, 14, false);
		Button save = factory.buttonFactory("Gem", 90, 14, false);

		// ChoiceBox
		cbStudent = new ComboBox();
		cbStudent.setPrefWidth(350);
		cbStudent.getItems().setAll(dbf.makeInterfaceDB().getAllStudents());
		cbCourse = new ComboBox();
		cbCourse.setPrefWidth(350);
		cbCourse.getItems().setAll(dbf.makeInterfaceDB().getAllCourses());

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
		infoGrid.add(cbStudent, 1, 0);
		infoGrid.add(lCourse, 0, 1);
		infoGrid.add(cbCourse, 1, 1);
		infoGrid.add(lDate, 0, 2);
		infoGrid.add(tfDate, 1, 2);
		infoGrid.add(lTheme, 0, 3);
		infoGrid.add(tfTheme, 1, 3);

		nameGrid.add(lAnalyzeTitle, 0, 1);
		nameGrid.add(tfAnalyzeTitle, 1, 1);
		nameGrid.add(lTraceability, 0, 2);
		nameGrid.add(tfTraceability, 1, 2);
		nameGrid.add(lCoworker, 0, 3);
		nameGrid.add(tfCoworker, 1, 3);

		btnRightBox.getChildren().addAll(print, saveLock, save);
		btnBox.getChildren().addAll(cancel, invalid, btnRightBox);
		mainBox.getChildren().addAll(topGrid, sepTop, nameGrid, sepInfo, lReferences, refTable, addForm, sepName,
				lResult, taResults, sepCal, lCal, taCal, addCalcPics, sepObs, lObs, taObs, addObsPics, sepButton,
				btnBox);
		borderPane.setCenter(mainBox);
		scrollPane.setContent(borderPane);

		// Action
		cancel.setOnAction(e -> cancelForm());
		addForm.setOnAction(e -> openReferenceTable());

		journalStage.setScene(journalScene);
		journalStage.show();
	}

	public void openReferenceTable() {
//		public Journal(LocalDate date, String themeName, String analyzeTitle, String comments, int studentID, int analyzeID,
//				String coworker, String traceability, String results, String calculations, String image, int journalID,
//				int formID, String condition)

		int studentID = 0, courseID = 0, formID = 0, id = 0;

		String firstName = "", lastName = "", fullName = "";

		int selectedIndex = cbStudent.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			Student student = (Student) cbStudent.getSelectionModel().getSelectedItem();
			id = student.getStudentID();
			firstName = student.getFirstName();
			lastName = student.getLastName();
			fullName = firstName + " " + lastName;
			System.out.println("id: " + id);
			studentID = dbf.makeInterfaceDB().getStudentById(id);

		}
		Journal journal = new Journal(LocalDate.now(), tfTheme.getText(), tfAnalyzeTitle.getText(), taObs.getText(), studentID,
				0, tfCoworker.getText(), tfTraceability.getText(), taResults.getText(), taCal.getText(), taResultTabel.getText(), 0, 0, "Gemt");
		
		Student student = new Student(firstName, lastName, courseID, studentID);
		
		dbf.makeInterfaceDB().addStudentForm(student, journal);
		ReferenceTable rt = new ReferenceTable();
		rt.Start();
	}

	public void cancelForm() {
		journalStage.close();
	}
}
