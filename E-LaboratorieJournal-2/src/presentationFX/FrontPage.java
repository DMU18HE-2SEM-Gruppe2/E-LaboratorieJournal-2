package presentationFX;

import java.time.format.DateTimeFormatter;

import data.DBConnection;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.FormPresentation;
import logic.JournalPresentation;
import logicFormDB.ChemReagentDB;

public class FrontPage {
	Scene mainScene;

	DBConnection connection = new DBConnection();

	ChemReagentDB crDB = new ChemReagentDB();

	ObservableList<FormPresentation> formList;

	public TableView<JournalPresentation> journalTable = new TableView();
	public TableView<FormPresentation> formTable = new TableView();

	public void start(Stage mainStage) {
		mainStage.setTitle("ELJ v.1");

		FactoryFX factory = new FactoryFX();

		BorderPane mainPane = new BorderPane();
		mainScene = new Scene(mainPane);

		VBox vBoxMenu = factory.vBoxFactory(15, 15, 15, 15, 15, Pos.TOP_CENTER);
		vBoxMenu.setMinWidth(200);

		VBox btnBox = factory.vBoxFactory(15, 0, 0, 0, 0, Pos.BOTTOM_CENTER);
		btnBox.setPrefHeight(250);

		TabPane tabs = new TabPane();
		tabs.setPrefWidth(1000);
		tabs.setPrefHeight(700);
		Tab journalTab = new Tab("Journaler");
		Tab formTab = new Tab("Blanketter");
		journalTab.setClosable(false);
		formTab.setClosable(false);
		tabs.getTabs().addAll(journalTab, formTab);

		// Table view

		// Logo Imag
		Image image = new Image("EAMV_Logo.png");
		ImageView imageView = new ImageView(image);
		imageView.setImage(image);
		imageView.setFitHeight(45);
		imageView.setFitWidth(200);

		// Searchbar¨
		TextField tfSearch = factory.textFieldFactory("Søg...", 100, 14);

		// Buttons
		Button btnForm = factory.buttonFactory("Opret Blanket", 200, 14, false);
		Button btnJournal = factory.buttonFactory("Opret Journal", 200, 14, false);
		Button btnPrint = factory.buttonFactory("Print", 200, 14, false);
		Button btnLock = factory.buttonFactory("Afslut", 200, 14, false);
		Button btnEdit = factory.buttonFactory("Rediger", 200, 14, false);
		Button btnInvalid = factory.buttonFactory("Ugyldiggør", 200, 14, false);
		Button btnDelete = factory.buttonFactory("Slet", 200, 14, false);

		btnForm.setPrefHeight(50);
		btnJournal.setPrefHeight(50);
		btnPrint.setPrefHeight(50);
		btnLock.setPrefHeight(50);
		btnEdit.setPrefHeight(50);
		btnInvalid.setPrefHeight(50);
		btnDelete.setPrefHeight(50);

		btnBox.getChildren().addAll(btnInvalid, btnDelete);
		vBoxMenu.getChildren().addAll(imageView, tfSearch, btnForm, btnJournal, btnPrint, btnLock, btnEdit, btnBox);

		journalTab.setContent(journalTable);
		formTab.setContent(formTable);

		mainPane.setLeft(vBoxMenu);
		mainPane.setCenter(tabs);

		// Table columns
		TableColumn<FormPresentation, String> analyzeTitle = new TableColumn<FormPresentation, String>("Titel");
		TableColumn<FormPresentation, String> themeName = new TableColumn<FormPresentation, String>("Tema");
		TableColumn<FormPresentation, String> formName = new TableColumn<FormPresentation, String>("Blanket navn");
		TableColumn<FormPresentation, String> studentName = new TableColumn<FormPresentation, String>("Studerende");
		TableColumn<FormPresentation, String> date = new TableColumn<FormPresentation, String>("Dato");

		analyzeTitle.setCellValueFactory(e -> {
			FormPresentation fp = e.getValue();
			return new SimpleStringProperty(fp.getTitle());
		});

		themeName.setCellValueFactory(e -> {
			FormPresentation fp = e.getValue();
			return new SimpleStringProperty(fp.getThemeName());
		});

		formName.setCellValueFactory(e -> {
			FormPresentation fp = e.getValue();
			return new SimpleStringProperty(fp.getReagentName());
		});

		studentName.setCellValueFactory(e -> {
			FormPresentation fp = e.getValue();
			return new SimpleStringProperty(fp.getStudentName());
		});

		date.setCellValueFactory(e -> {
			FormPresentation fp = e.getValue();
			return new SimpleStringProperty(fp.getDate().format(DateTimeFormatter.ofPattern("dd MMMM - yyyy")));
		});

		formTable.getColumns().addAll(analyzeTitle, themeName, formName, studentName, date);

		formList = FXCollections.observableList(crDB.getAllProductsToPresentation());
		formTable.setItems(formList);

		// Search function
		FilteredList<FormPresentation> filteredData = new FilteredList<>(formList, p -> true);

		tfSearch.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(formSearch -> {

				// If a filter text (the text field) is empty, show all forms
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				// Compares the textfield to the object (the input) med the filter from above
				String lowerCaseFilter = newValue.toLowerCase();

				// Filter matches with Analyze Title
				if (formSearch.getTitle().toLowerCase().contains(lowerCaseFilter)) {
					return true;
					// Filter matches with date
				} else if (formSearch.getDate().format(DateTimeFormatter.ofPattern("dd MMMM - yyyy")).toLowerCase()
						.contains(lowerCaseFilter)) {
					return true;
					// Filter matches with Student name
				} else if (formSearch.getStudentName().toLowerCase().contains(lowerCaseFilter)) {
					return true;
					// Filter matches with Theme name
				} else if (formSearch.getThemeName().toLowerCase().contains(lowerCaseFilter)) {
					return true;
					// Filter matches with Reagent name
				} else if (formSearch.getReagentName().toLowerCase().contains(lowerCaseFilter)) {
					return true;

				}
				// No match at all
				return false;
			});
		});

		SortedList<FormPresentation> sortedData = new SortedList<>(filteredData);

		// Connect the SortedList comparator to the TableView comparator
		// 'The comparator that denotes the order of this SortedList'
		sortedData.comparatorProperty().bind(formTable.comparatorProperty());
		// Tilføjer sorteret og filtreret data til vores TableView
		formTable.setItems(sortedData);

		// Action
		btnJournal.setOnAction(e -> createJournal());
		btnForm.setOnAction(e -> createForm());

		mainStage.setScene(mainScene);
		mainStage.show();
	}

	public void createJournal() {
		JournalFX journal = new JournalFX();
		journal.start();
	}

	public void createForm() {
		ChooseFormFX form = new ChooseFormFX();
		form.start();
	}

	public TableView<FormPresentation> getTable() {
		System.out.println("??");
		return formTable;
	}

	public void updateList() {

		formList = FXCollections.observableList(crDB.getAllProductsToPresentation());
		formList.removeAll(formList);
		formTable.setItems(formList);

	}
}
