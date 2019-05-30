package presentationFX;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
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

		FactoryFX factory = new FactoryFX();

		VBox mainBox = new VBox(15);
		mainBox.setPadding(new Insets(15, 15, 15, 15));
		mainBox.setAlignment(Pos.CENTER);
		mainBox.setPrefWidth(350);
		mainBox.setPrefHeight(400);
		HBox btnBox = factory.hBoxFactory(100, 0, 0, 0, 0, Pos.CENTER);

		GridPane mainGrid = new GridPane();
		mainGrid.setVgap(15);
		mainGrid.getColumnConstraints().add(new ColumnConstraints(150));
		mainGrid.getColumnConstraints().add(new ColumnConstraints(200));

		// Labels
		Label lCemical = factory.labelFactory("Kemikalie", 0, 0, 0, 0, 14, false);
		Label lCasNo = factory.labelFactory("Cas Nr.", 0, 0, 0, 0, 14, false);
		Label lProductNo = factory.labelFactory("Produkt Nr.", 0, 0, 0, 0, 14, false);
		Label lBatchNo = factory.labelFactory("Batch Nr.", 0, 0, 0, 0, 14, false);
		Label lLotNo = factory.labelFactory("Lot Nr.", 0, 0, 0, 0, 14, false);
		Label lSupplier = factory.labelFactory("Firma", 0, 0, 0, 0, 14, false);
		Label lWeighed = factory.labelFactory("Afvejet", 0, 0, 0, 0, 14, false);
		Label lMeasured = factory.labelFactory("Afmålt", 0, 0, 0, 0, 14, false);
		Label lScaleNo = factory.labelFactory("Vægt Nr.", 0, 0, 0, 0, 14, false);
		Label lPipetteNo = factory.labelFactory("Pipette Nr.", 0, 0, 0, 0, 14, false);
		Label lEndConcentration = factory.labelFactory("Slutkoncentration", 0, 0, 0, 0, 14, false);

		// TextFields
		TextField tfChemical = factory.textFieldFactory("", 200, 14);
		TextField tfCasNo = factory.textFieldFactory("", 200, 14);
		TextField tfProductNo = factory.textFieldFactory("", 200, 14);
		TextField tfBatchNo = factory.textFieldFactory("", 200, 14);
		TextField tfLotNo = factory.textFieldFactory("", 200, 14);
		TextField tfSupplier = factory.textFieldFactory("", 200, 14);
		TextField tfWeighed = factory.textFieldFactory("", 200, 14);
		TextField tfMeasured = factory.textFieldFactory("", 200, 14);
		TextField tfScaleNo = factory.textFieldFactory("", 200, 14);
		TextField tfPipetteNo = factory.textFieldFactory("", 200, 14);
		TextField tfEndConcentration = factory.textFieldFactory("", 200, 14);

		// Buttons
		Button btnAdd = factory.buttonFactory("Tilføj", 90, 14, false);
		Button btnCancel = factory.buttonFactory("Annuller", 90, 14, false);

		// Setup
		mainGrid.add(lCemical, 0, 0);
		mainGrid.add(tfChemical, 1, 0);
		mainGrid.add(lCasNo, 0, 1);
		mainGrid.add(tfCasNo, 1, 1);
		mainGrid.add(lProductNo, 0, 2);
		mainGrid.add(tfProductNo, 1, 2);
		mainGrid.add(lBatchNo, 0, 3);
		mainGrid.add(tfBatchNo, 1, 3);
		mainGrid.add(lLotNo, 0, 4);
		mainGrid.add(tfLotNo, 1, 4);
		mainGrid.add(lSupplier, 0, 5);
		mainGrid.add(tfSupplier, 1, 5);
		mainGrid.add(lWeighed, 0, 6);
		mainGrid.add(tfWeighed, 1, 6);
		mainGrid.add(lMeasured, 0, 7);
		mainGrid.add(tfMeasured, 1, 7);
		mainGrid.add(lScaleNo, 0, 8);
		mainGrid.add(tfScaleNo, 1, 8);
		mainGrid.add(lPipetteNo, 0, 9);
		mainGrid.add(tfPipetteNo, 1, 9);
		mainGrid.add(lEndConcentration, 0, 10);
		mainGrid.add(tfEndConcentration, 1, 10);

		btnBox.getChildren().addAll(btnCancel, btnAdd);
		mainBox.getChildren().addAll(mainGrid, btnBox);

		// Action
		btnCancel.setOnAction(e -> cancelPreparation());

		scene = new Scene(mainBox);
		stage.setScene(scene);
		stage.show();
	}

	public void cancelPreparation() {
		stage.close();
	}
}
