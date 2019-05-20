package presentationFX;

import javafx.geometry.Insets;
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
		
		BorderPane mainPane = new BorderPane();
		mainScene = new Scene(mainPane);
		
		VBox vBoxMenu = new VBox();
		vBoxMenu.setPadding(new Insets(10, 10, 10, 10));
		vBoxMenu.setSpacing(10);
		vBoxMenu.setPrefWidth(150);
		
		TabPane tabs = new TabPane();
		tabs.setPrefWidth(500);
		Tab journalTab = new Tab("Journaler");
		Tab formTab = new Tab("Blanketter");
		journalTab.setClosable(false);
		formTab.setClosable(false);
		tabs.getTabs().addAll(journalTab, formTab);
		
		TableView journalTable = new TableView();
		TableView formTable = new TableView();
		
		// Searchbar
		TextField searchbar = new TextField();
		
		// Buttons
		Button crtFrm = new Button("Opret Form");
		
		Button crtJrn = new Button("Opret Journal");
		
		
		Button print = new Button("Print");
		
		Button lock = new Button("Afslut");
		
		Button edit = new Button("Rediget");
		
		Button invalid = new Button("Ugyldiggør");
		
		Button delete = new Button("Slet");
		
		vBoxMenu.getChildren().addAll(searchbar, crtFrm, crtJrn, print, lock, edit, invalid, delete);
		
		journalTab.setContent(journalTable);
		formTab.setContent(formTable);
		
		mainPane.setLeft(vBoxMenu);
		mainPane.setCenter(tabs);
	
		mainStage.setScene(mainScene);
		mainStage.show();		
	}
	
}
