package presentationFX;

import java.time.format.DateTimeFormatter;

import data.DBConnection;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import logicFormDB.ChemReagentDB;

public class FrontPage {
	Scene mainScene;
	
	DBConnection connection = new DBConnection();
	
	ChemReagentDB crDB = new ChemReagentDB(connection);
	
	ObservableList<FormPresentation> formList;
	
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
		TableView journalTable = new TableView();
		TableView formTable = new TableView();
		
		// Table columns
		TableColumn<FormPresentation, String> analyzeTitle = new TableColumn("Titel");
		TableColumn<FormPresentation, String> themeName = new TableColumn("Tema");
		TableColumn<FormPresentation, String> formName = new TableColumn("Blanket navn");
		TableColumn<FormPresentation, String> studentName = new TableColumn("Studerende");
		TableColumn<FormPresentation, String> date = new TableColumn("Dato");
		
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
		Button btnPrint	= factory.buttonFactory("Print", 200, 14, false);
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
}
