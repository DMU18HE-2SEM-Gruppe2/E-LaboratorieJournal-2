package presentationFX;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import data.DBConnection;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.ChemReagentForm;
import logic.FormPresentation;
import logic.JournalPresentation;
import logicFormDB.DBFactory;
import logicFormDB.ImplDB;

public class FrontPage extends Application {
	Scene mainScene;
	public Label lStatus;
	public Button btnForm;

	DBConnection connection = new DBConnection();

	DBFactory dbf = new DBFactory();
	int rowData;
	String rowDatastring;
	ChooseFormFX form = new ChooseFormFX();
	ChemReagentFormFX chemForm = new ChemReagentFormFX();
	ImplDB implDB = new ImplDB();
	
	ObservableList<FormPresentation> formList;

	public TableView<JournalPresentation> journalTable = new TableView();
	public TableView<FormPresentation> formTable = new TableView();

	public void start(Stage mainStage) {
		mainStage.setTitle("ELJ v.1");
		
		FactoryFX factory = new FactoryFX();

		lStatus = factory.labelFactory("", 6, 6, 6, 6, 12, false);

		BorderPane mainPane = new BorderPane();
		mainScene = new Scene(mainPane);
		
		StackPane stackPane = new StackPane();
		stackPane.setAlignment(lStatus, Pos.TOP_RIGHT);

		VBox vBoxMenu = factory.vBoxFactory(15, 15, 15, 15, 15, Pos.TOP_CENTER);
		vBoxMenu.setMinWidth(200);

		VBox btnBox = factory.vBoxFactory(15, 0, 0, 0, 0, Pos.BOTTOM_CENTER);
		btnBox.setPrefHeight(250);

		TabPane tabs = new TabPane();
		tabs.setPrefWidth(1000);
		tabs.setPrefHeight(700);
		Tab journalTab = new Tab("Journaler");
		Tab formTab = new Tab("Blanketter");
		Tab invalidTab = new Tab("Ugyldige");
		journalTab.setClosable(false);
		formTab.setClosable(false);
		invalidTab.setClosable(false);
		tabs.getTabs().addAll(journalTab, formTab, invalidTab);

		// Table view
		journalTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		formTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
	
			// Formtable Register Double Click on row
		formTable.setRowFactory(tv -> {
			TableRow<FormPresentation> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
					rowData = row.getItem().getAnalyzeID();
					rowDatastring = Integer.toString(rowData);
					readChemForm2();
				}
			});
			return row ;
		});
	
//			// Journaltable Register Double Click on row
//		journalTable.setRowFactory(tv -> {
//			TableRow<JournalPresentation> row = new TableRow<>();
//			row.setOnMouseClicked(event -> {
//				if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
//					JournalPresentation rowData = row.getItem();
//					System.out.println("Double click on: " + rowData.getClass());
//				}
//			});
//			return row ;
//		});
	
		// Logo Imag
		Image image = new Image("EAMV_Logo.png");
		ImageView imageView = new ImageView(image);
		imageView.setImage(image);
		imageView.setFitHeight(45);
		imageView.setFitWidth(200);

		// Searchbar¨
		TextField tfSearch = factory.textFieldFactory("Søg...", 100, 14);

		// Buttons
		btnForm = factory.buttonFactory("Opret Blanket", 200, 14, false);
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
		stackPane.getChildren().addAll(tabs, lStatus);
		vBoxMenu.getChildren().addAll(imageView, tfSearch, btnForm, btnJournal, btnPrint, btnLock, btnEdit, btnBox);

		journalTab.setContent(journalTable);
		formTab.setContent(formTable);
		

		mainPane.setLeft(vBoxMenu);
		mainPane.setCenter(stackPane);

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
		formTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		journalTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

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

				// Compares the textfield to the object (the input) with the filter from above
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
		form = new ChooseFormFX();
		form.start();
	}
	
//	public void readChemForm() {
////		System.out.println(rowData);
//		
//		ArrayList l = new ArrayList();
//		l.add(implDB.getAllChemReagentWhere("analyzeInformation.analyzeID=" + rowDatastring));
//		for(int i = 0; i < l.size(); i++) {
//			Object s = l.get(i);
//			System.out.println(l.get(i));
//			System.out.println(s);
//		}
//		
//		
////		chemForm.start();
//		
//	}
	
	public void readChemForm2() {
		List<ChemReagentForm> crf = implDB.getAllChemReagentWhere("analyzeInformation.analyzeID=" + rowDatastring);
		
		String date = "";
		String themeName = "";
		String analyzeTitle = "";
		String comments = "";
		String analyzeID = "";
		String studentID = "";
		String scaleNo = "";
		String volume = "";
		String concentration = "";
		String lifeTimeF = "";
		String storage = "";
		String reagentName = "";
		String formID = "";
		String batchNo = "";
		String lotNo = "";
		String supplier = "";
		String measurements = "";
		
		for (int i = 0; i < crf.size(); i++) {
			ChemReagentForm l = crf.get(i);
			date = l.getDate().toString();
			themeName = l.getThemeName().toString();
			analyzeTitle = l.getAnalyzeTitle().toString();
			comments = l.getComments().toString();
			analyzeID = Integer.toString(l.getAnalyzeID());
			studentID = Integer.toString(l.getStudentID());
			scaleNo = l.getScaleNo().toString();
			volume = l.getVolume().toString();
			concentration = l.getConcentration().toString();
			lifeTimeF = l.getLifeTimeF().toString();
			storage = l.getStorage().toString();
			reagentName = l.getReagentName().toString();
			formID = Integer.toString(l.getFormID());
			batchNo = l.getBatchNo().toString();
			lotNo = l.getLotNo().toString();
			supplier = l.getSupplier().toString();
			measurements = l.getMeasured().toString();
			System.out.println("hej");
		}
		
		chemForm.start();
		
		chemForm.tfDate.setText(date);
		chemForm.tfTheme.setText(themeName);
		chemForm.tfAnalyzeTitle.setText(analyzeTitle);
		chemForm.tfComment.setText(comments);
		chemForm.tfScaleNo.setText(scaleNo);
		chemForm.tfVolume.setText(volume);
		chemForm.tfConcentration.setText(concentration);
		chemForm.tfShelfLife.setText(lifeTimeF);
		chemForm.tfStorage.setText(storage);
		chemForm.tfReagentName.setText(reagentName);
		chemForm.tfBatchNo.setText(batchNo);
		chemForm.tfLotNo.setText(lotNo);
		chemForm.tfSupplier.setText(supplier);
		chemForm.tfMeasurements.setText(measurements);
		
		chemForm.tfVolume.setDisable(true);
		chemForm.tfMeasurements.setDisable(true);		
	}

	public TableView<FormPresentation> getTable() {
		System.out.println("??");
		return formTable;
	}
	
	public String selectForm() {
		formTable.setRowFactory(tv -> {
			TableRow<FormPresentation> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
					rowData = row.getItem().getAnalyzeID();
					rowDatastring = Integer.toString(rowData);
					readChemForm2();
				}
			});
			return row ;
		});
		return rowDatastring;
	}

	public void updateList() {

		formTable.refresh();
		
//		formList = FXCollections.observableList(dbf.makeInterfaceDB().getAllFormsToPresentation());
//		formList.removeAll(formList);
//		formTable.setItems(formList);

	}
}
