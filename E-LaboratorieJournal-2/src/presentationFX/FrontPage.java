package presentationFX;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FrontPage {
	Scene mainScene;
	
	public void start(Stage mainStage) {
		mainStage.setTitle("ELJ v.1");
		
		FactoryFX factory = new FactoryFX();
		
		BorderPane mainPane = new BorderPane();
		mainScene = new Scene(mainPane);
		
		VBox vBoxMenu = factory.vBoxFactory(10, 10, 10, 10, 10, Pos.TOP_LEFT);

		
		TabPane tabs = new TabPane();
		tabs.setPrefWidth(500);
		Tab journalTab = new Tab("Journaler");
		Tab formTab = new Tab("Blanketter");
		journalTab.setClosable(false);
		formTab.setClosable(false);
		tabs.getTabs().addAll(journalTab, formTab);
		
		TableView journalTable = new TableView();
		TableView formTable = new TableView();
		
		// Searchbar¨
		TextField tfSearch = factory.textFieldFactory("Search...", 100, 14);
		
		// Buttons
		Button btnForm = factory.buttonFactory("Opret Form", 100, 14, false);
		Button btnJournal = factory.buttonFactory("Opret Journal", 100, 14, false);
		Button btnPrint	= factory.buttonFactory("Print", 100, 14, false);
		Button btnLock = factory.buttonFactory("Afslut", 100, 14, false);
		Button btnEdit = factory.buttonFactory("Rediger", 100, 14, false);
		Button btnInvalid = factory.buttonFactory("Ugyldiggør", 100, 14, false);
		Button btnDelete = factory.buttonFactory("Slet", 100, 14, false);
		
		vBoxMenu.getChildren().addAll(tfSearch, btnForm, btnJournal, btnPrint, btnLock, btnEdit, btnInvalid, btnDelete);
		
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
