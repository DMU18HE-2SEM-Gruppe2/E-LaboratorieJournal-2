package presentationFX;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import data.DBConnection;
import dataFormDB.ChemReagentDB;
import dataFormDB.DBFactory;
import dataFormDB.ImplDB;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.ChemReagentForm;
import logic.DocumentChemReagent;
import logic.FormPresentation;
import logic.JournalPresentation;

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
	ObservableList<JournalPresentation> journalList;

	public TableView<JournalPresentation> journalTable = new TableView<JournalPresentation>();
	public TableView<FormPresentation> formTable = new TableView<FormPresentation>();

	@SuppressWarnings("unchecked")
	public void start(Stage mainStage) {
		mainStage.setTitle("ELJ v.1");
		
		FactoryFX factory = new FactoryFX();

		lStatus = factory.labelFactory("", 6, 6, 6, 6, 12, false);

		BorderPane mainPane = new BorderPane();
		mainScene = new Scene(mainPane);
		mainPane.setStyle("-fx-background-color: rgba(132, 132, 132, 0.4);");

		StackPane stackPane = new StackPane();
		StackPane.setAlignment(lStatus, Pos.TOP_RIGHT);

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
		tabs.setStyle("-fx-tab-header-background: rgba(155, 0, 0, 1);");

		// Table view
		journalTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		formTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		// Formtable Register Double Click on row
		formTable.setRowFactory(tv -> {
			TableRow<FormPresentation> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					rowData = row.getItem().getAnalyzeID();
					rowDatastring = Integer.toString(rowData);
					readChemForm();
				}
			});
			return row;
		});
		journalTable.setRowFactory(tv -> {
			TableRow<JournalPresentation> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					rowData = row.getItem().getAnalyzeID();
					rowDatastring = Integer.toString(rowData);
					readChemForm();
				}
			});
			return row;
		});

		// Logo Image
		Image image = new Image("EAMV_Logo.png");
		ImageView imageView = new ImageView(image);
		imageView.setImage(image);
		imageView.setFitHeight(45);
		imageView.setFitWidth(200);

		// Searchbar
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

		TableColumn<JournalPresentation, String> analyzeTitleJ = new TableColumn<JournalPresentation, String>("Titel");
		TableColumn<JournalPresentation, String> themeNameJ = new TableColumn<JournalPresentation, String>("Tema");
		TableColumn<JournalPresentation, String> traceability = new TableColumn<JournalPresentation, String>(
				"Blanket navn");
		TableColumn<JournalPresentation, String> studentNameJ = new TableColumn<JournalPresentation, String>(
				"Studerende");
		TableColumn<JournalPresentation, String> dateJ = new TableColumn<JournalPresentation, String>("Dato");
		TableColumn<JournalPresentation, String> conditionJ = new TableColumn<JournalPresentation, String>("Status");

		analyzeTitleJ.setCellValueFactory(e -> {
			JournalPresentation jp = e.getValue();
			return new SimpleStringProperty(jp.getAnalyzeTitle());
		});

		themeNameJ.setCellValueFactory(e -> {
			JournalPresentation jp = e.getValue();
			return new SimpleStringProperty(jp.getThemeName());
		});

		traceability.setCellValueFactory(e -> {
			JournalPresentation jp = e.getValue();
			return new SimpleStringProperty(jp.getTraceability());
		});

		studentNameJ.setCellValueFactory(e -> {
			JournalPresentation jp = e.getValue();
			return new SimpleStringProperty(jp.getStudentNames());
		});

		dateJ.setCellValueFactory(e -> {
			JournalPresentation fp = e.getValue();
			return new SimpleStringProperty(fp.getDate().format(DateTimeFormatter.ofPattern("dd MMMM - yyyy")));
		});

		conditionJ.setCellValueFactory(e -> {
			JournalPresentation fp = e.getValue();
			return new SimpleStringProperty(fp.getCondition());
		});

		journalTable.getColumns().addAll(analyzeTitleJ, themeNameJ, traceability, studentNameJ, dateJ, conditionJ);

		journalList = FXCollections.observableList(dbf.makeInterfaceDB().getAllJournalsToPresentation());
		journalTable.setItems(journalList);

		// Table columns for FormPresentation
		TableColumn<FormPresentation, String> analyzeTitleF = new TableColumn<FormPresentation, String>("Titel");
		TableColumn<FormPresentation, String> themeNameF = new TableColumn<FormPresentation, String>("Tema");
		TableColumn<FormPresentation, String> formNameF = new TableColumn<FormPresentation, String>("Blanket navn");
		TableColumn<FormPresentation, String> studentNameF = new TableColumn<FormPresentation, String>("Studerende");
		TableColumn<FormPresentation, String> dateF = new TableColumn<FormPresentation, String>("Dato");
		TableColumn<FormPresentation, String> conditionF = new TableColumn<FormPresentation, String>("Status");

		analyzeTitleF.setCellValueFactory(e -> {
			FormPresentation fp = e.getValue();
			return new SimpleStringProperty(fp.getTitle());
		});

		themeNameF.setCellValueFactory(e -> {
			FormPresentation fp = e.getValue();
			return new SimpleStringProperty(fp.getThemeName());
		});

		formNameF.setCellValueFactory(e -> {
			FormPresentation fp = e.getValue();
			return new SimpleStringProperty(fp.getReagentName());
		});

		studentNameF.setCellValueFactory(e -> {
			FormPresentation fp = e.getValue();
			return new SimpleStringProperty(fp.getStudentName());
		});

		dateF.setCellValueFactory(e -> {
			FormPresentation fp = e.getValue();
			return new SimpleStringProperty(fp.getDate().format(DateTimeFormatter.ofPattern("dd MMMM - yyyy")));
		});
		conditionF.setCellValueFactory(e -> {
			FormPresentation fp = e.getValue();
			return new SimpleStringProperty(fp.getCondition());
		});

		formTable.getColumns().addAll(analyzeTitleF, themeNameF, formNameF, studentNameF, dateF, conditionF);
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
		btnPrint.setOnAction(e -> printForm());
		btnDelete.setOnAction(e -> deleteForm());

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

	public void deleteForm() {
		ChemReagentForm crf = readChemToPrint();

		ChemReagentDB crDB = new ChemReagentDB();

		String analyzeID = Integer.toString(crf.getAnalyzeID());
		crDB.deleteAnalyzeInformation(analyzeID, crf);
	}

	public ChemReagentForm readChemToPrint() {
		int id = 0, analyzeIDForSearch = 0;

		int selectedIndex = formTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			FormPresentation crf = (FormPresentation) formTable.getSelectionModel().getSelectedItem();
			id = crf.getAnalyzeID();
			analyzeIDForSearch = implDB.getAnalyzeIDByID(id);
		}
		List<ChemReagentForm> crf = implDB.getAllChemReagentWhere("analyzeInformation.analyzeID=" + analyzeIDForSearch);
		ChemReagentForm cmr = new ChemReagentForm(LocalDate.now(), "", "", "", 0, 0, "", "", "", "", "", "", 0, "", "",
				"", "", "");
		LocalDate date = LocalDate.now();
		String themeName = "";
		String analyzeTitle = "";
		String comments = "";
		int analyzeID = 0;
		int studentID = 0;
		String scaleNo = "";
		String volume = "";
		String concentration = "";
		String lifeTimeF = "";
		String storage = "";
		String reagentName = "";
		int formID = 0;
		String batchNo = "";
		String lotNo = "";
		String supplier = "";
		String measurements = "";
		String condition = "";

		for (int i = 0; i < crf.size(); i++) {
			ChemReagentForm l = crf.get(i);
			date = l.getDate();
			themeName = l.getThemeName().toString();
			analyzeTitle = l.getAnalyzeTitle().toString();
			comments = l.getComments().toString();
			analyzeID = l.getAnalyzeID();
			studentID = l.getStudentID();
			scaleNo = l.getScaleNo().toString();
			volume = l.getVolume().toString();
			concentration = l.getConcentration().toString();
			lifeTimeF = l.getLifeTimeF().toString();
			storage = l.getStorage().toString();
			reagentName = l.getReagentName().toString();
			formID = l.getFormID();
			batchNo = l.getBatchNo().toString();
			lotNo = l.getLotNo().toString();
			supplier = l.getSupplier().toString();
			measurements = l.getMeasured().toString();
			condition = l.getCondition().toString();

			cmr.setDate(date);
			cmr.setThemeName(themeName);
			cmr.setAnalyzeTitle(analyzeTitle);
			cmr.setComments(comments);
			cmr.setAnalyzeID(analyzeID);
			cmr.setStudentID(studentID);
			cmr.setScaleNo(scaleNo);
			cmr.setVolume(volume);
			cmr.setConcentration(concentration);
			cmr.setLifeTimeF(lifeTimeF);
			cmr.setStorage(storage);
			cmr.setReagentName(reagentName);
			cmr.setFormID(formID);
			cmr.setBatchNo(batchNo);
			cmr.setLotNo(lotNo);
			cmr.setSupplier(supplier);
			cmr.setMeasured(measurements);
			cmr.setCondition(condition);

		}

		return cmr;
	}

	public void readChemForm() {
		List<ChemReagentForm> crf = implDB.getAllChemReagentWhere("analyzeInformation.analyzeID=" + rowDatastring);

		String date = "";
		String themeName = "";
		String analyzeTitle = "";
		String comments = "";
		String scaleNo = "";
		String volume = "";
		String concentration = "";
		String lifeTimeF = "";
		String storage = "";
		String reagentName = "";
		String batchNo = "";
		String lotNo = "";
		String supplier = "";
		String measurements = "";
		String condition = "";

		for (int i = 0; i < crf.size(); i++) {
			ChemReagentForm l = crf.get(i);
			date = l.getDate().toString();
			themeName = l.getThemeName().toString();
			analyzeTitle = l.getAnalyzeTitle().toString();
			comments = l.getComments().toString();
			scaleNo = l.getScaleNo().toString();
			volume = l.getVolume().toString();
			concentration = l.getConcentration().toString();
			lifeTimeF = l.getLifeTimeF().toString();
			storage = l.getStorage().toString();
			reagentName = l.getReagentName().toString();
			batchNo = l.getBatchNo().toString();
			lotNo = l.getLotNo().toString();
			supplier = l.getSupplier().toString();
			measurements = l.getMeasured().toString();
			condition = l.getCondition().toString();

		}

		chemForm.start();

		if (condition.equals("Låst")) {
			chemForm.tfDate.setDisable(true);
			chemForm.tfTheme.setDisable(true);
			chemForm.tfAnalyzeTitle.setDisable(true);
			chemForm.tfScaleNo.setDisable(true);
			chemForm.tfVolume.setDisable(true);
			chemForm.tfConcentration.setDisable(true);
			chemForm.tfShelfLife.setDisable(true);
			chemForm.tfStorage.setDisable(true);
			chemForm.tfReagentName.setDisable(true);
			chemForm.tfBatchNo.setDisable(true);
			chemForm.tfLotNo.setDisable(true);
			chemForm.tfSupplier.setDisable(true);
			chemForm.tfMeasurements.setDisable(true);
		}

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
		return formTable;
	}

	public String selectForm() {
		formTable.setRowFactory(tv -> {
			TableRow<FormPresentation> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (event.getClickCount() == 2 && (!row.isEmpty())) {
					rowData = row.getItem().getAnalyzeID();
					rowDatastring = Integer.toString(rowData);
					readChemForm();
				}
			});
			return row;
		});
		return rowDatastring;
	}

	public void printForm() {

		ChemReagentForm crf = readChemToPrint();

		DocumentChemReagent dcr = new DocumentChemReagent();
		dcr.setThemeName(crf.getThemeName().trim());
		dcr.setAnalyzeTitle(crf.getAnalyzeTitle().trim());
		dcr.setComments(crf.getComments());
		dcr.setScaleNo(crf.getScaleNo());
		dcr.setVolume(crf.getVolume());
		dcr.setConcentration(crf.getConcentration());
		dcr.setLifeTimeF(crf.getLifeTimeF());
		dcr.setStorage(crf.getStorage());
		dcr.setReagentName(crf.getReagentName());
		dcr.setBatchNo(crf.getBatchNo());
		dcr.setLotNo(crf.getLotNo());
		dcr.setSupplier(crf.getSupplier());
		dcr.setMeasured(crf.getMeasured());
		dcr.setCondition(crf.getCondition());

		JavaWorldPrint jwp = new JavaWorldPrint();

		jwp.JavaWorldPrint();
		Thread thread = new Thread(new JavaWorldPrint());
		thread.start();
	}

	public void updateList() {

		formTable.refresh();

	}
}
