package presentationFX;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ReferenceTable {
	private Stage stage;
	private Scene scene;
	private VBox mainBox;
	private HBox btnBox;
	private Button btnAdd, btnCancel;
	private TextField tfSearch;
	
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
		TableView formTable = new TableView();
		formTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		btnBox.getChildren().addAll(btnAdd, btnCancel);
		mainBox.getChildren().addAll(tfSearch, formTable, btnBox);
		
		// Actions
		btnCancel.setOnAction(e -> cancelRefTable());
		
		scene = new Scene(mainBox);
		stage.setScene(scene);
		stage.show();
	}
	
	public void cancelRefTable() {
		stage.close();
	}
}
