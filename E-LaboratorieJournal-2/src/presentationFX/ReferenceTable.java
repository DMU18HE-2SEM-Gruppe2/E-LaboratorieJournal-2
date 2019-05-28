package presentationFX;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.ChemReagentForm;
import logic.FormPresentation;
import logic.Student;
import logicFormDB.DBFactory;

public class ReferenceTable {
	private Stage stage;
	private Scene scene;
	private VBox mainBox;
	private HBox btnBox;
	private Button btnAdd, btnCancel;
	private TextField tfSearch;

	DBFactory dbf = new DBFactory();

	ObservableList<FormPresentation> formList;

	TableView<FormPresentation> formTable = new TableView();

	FactoryFX factory = new FactoryFX();

	public void Start() {
		stage = new Stage();
		stage.setTitle("Resultat Tabel");
		stage.setResizable(false);

		mainBox = factory.vBoxFactory(15, 10, 10, 10, 10, Pos.CENTER);
		mainBox.setMaxWidth(500);
		mainBox.setMaxHeight(500);
		btnBox = factory.hBoxFactory(50, 0, 0, 0, 0, Pos.CENTER);

		btnAdd = factory.buttonFactory("Tilføj", 90, 14, true);
		btnCancel = factory.buttonFactory("Tilbage", 90, 14, false);

		tfSearch = factory.textFieldFactory("Søg...", 200, 14);

		// TableView

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

		formList = FXCollections.observableList(dbf.makeInterfaceDB().getAllFormsToPresentation());
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

		formTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		btnBox.getChildren().addAll(btnAdd, btnCancel);
		mainBox.getChildren().addAll(tfSearch, formTable, btnBox);

		// Actions
		btnCancel.setOnAction(e -> cancelRefTable());

		scene = new Scene(mainBox);
		stage.setScene(scene);
		stage.show();
	}

	public int getFormReference() {

		int formID = 0, id = 0;

		int selectedIndex = formTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			FormPresentation fp = formTable.getSelectionModel().getSelectedItem();
			id = fp.getAnalyzeID();
			formID = dbf.makeInterfaceDB().getFormIDByID(id);

		}
		return formID;
	}
	
	public int getAnalyzeReference() {
		int analyzeID = 0, id = 0;

		int selectedIndex = formTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			FormPresentation fp = formTable.getSelectionModel().getSelectedItem();
			id = fp.getAnalyzeID();
			analyzeID = dbf.makeInterfaceDB().getFormIDByID(id);

		}
		return analyzeID;
	}

	public void cancelRefTable() {
		stage.close();
	}
}
