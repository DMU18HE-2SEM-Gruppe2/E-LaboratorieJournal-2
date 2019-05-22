package presentationFX;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PreparationForm {
	private Stage stage;
	private Scene scene;
	
	public void Start() {
		stage = new Stage();
		stage.setTitle("Resultat Tabel");
		stage.setResizable(false);
		
		HBox mainBox = new HBox();
		mainBox.setPadding(new Insets(10, 10, 10, 10));
		mainBox.setAlignment(Pos.CENTER);
		mainBox.setPrefWidth(350);
		mainBox.setPrefHeight(400);
		VBox leftBox = new VBox(24);
		leftBox.setAlignment(Pos.CENTER_LEFT);
		VBox rightBox = new VBox(15);
		
		// Labels
		Label lChemical = new Label("Kemikalie");
		Label lCasNo = new Label("CAS nr.");
		Label lProductNo = new Label("Produkt nr.");
		Label lBatchNo = new Label("Batch nr.");
		Label lLotNo = new Label("Lot nr.");
		Label lSupplier = new Label("Firma");
		Label lWeighed = new Label("Afvejet");
		Label lMeasured = new Label("Afmålt");
		Label lScaleNo = new Label("Vægt nr.");
		Label lPipetteNo = new Label("Pipette nr.");
		Label lEndConcentration = new Label("Slutkoncentration");
		Label lFluidAdd = new Label();
		
		// TextFields
		TextField tfChemical = new TextField();
		TextField tfCasNo = new TextField();
		TextField tfProductNo = new TextField();
		TextField tfBatchNo = new TextField();
		TextField tfLotNo = new TextField();
		TextField tfSupplier = new TextField();
		TextField tfWeighed = new TextField();
		TextField tfMeasured = new TextField();
		TextField tfScaleNo = new TextField();
		TextField tfPipetteNo = new TextField();
		TextField tfEndConcentration = new TextField();
		TextField tfFluidAdd = new TextField();
		
		// Buttons
		Button btnCreate = new Button("Tilføj");
		Button btnCancel = new Button("Annuller");
		
		// Setup
		mainBox.getChildren().addAll(leftBox, rightBox);
		leftBox.getChildren().addAll(lChemical, lCasNo, lSupplier, lProductNo, lBatchNo, lLotNo, lWeighed, lMeasured, lScaleNo, lPipetteNo, lEndConcentration);
		rightBox.getChildren().addAll(tfChemical, tfCasNo, tfSupplier, tfProductNo, tfBatchNo, tfLotNo, tfWeighed, tfMeasured, tfScaleNo, tfPipetteNo, tfEndConcentration);
		
		
		scene = new Scene(mainBox);
		stage.setScene(scene);
		stage.show();
	}

	private Object Label() {
		// TODO Auto-generated method stub
		return null;
	}
}
