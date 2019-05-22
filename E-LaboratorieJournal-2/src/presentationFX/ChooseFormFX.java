package presentationFX;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChooseFormFX {

	private Stage stage;
	private Scene scene;
	
	public void start() {
		stage = new Stage();
		stage.setTitle("Opret Blanket");
		stage.setResizable(false);
		
		VBox mainBox = new VBox();
		mainBox.setPadding(new Insets(10, 10, 10, 10));
		mainBox.setSpacing(25);
		mainBox.setPrefWidth(250);
		mainBox.setPrefHeight(300);
		mainBox.setAlignment(Pos.CENTER);
		
		// Labels
		Label title = new Label("Hvilken type blanket skal du bruge?");
		
		// Buttons
		Button chemReagentForm = new Button("Chem Reagent Form");
		Button bioReagentForm = new Button("Bio Reagent From");
		Button bioSubstrateForm = new Button("Bio Substrate Form");
		
		// Setup
		mainBox.getChildren().addAll(title, chemReagentForm, bioReagentForm, bioSubstrateForm);
		
		// Action
		chemReagentForm.setOnAction(e -> loadChemReagentForm());
		bioReagentForm.setOnAction(e -> loadBioReagentForm());
		bioSubstrateForm.setOnAction(e -> loadBioSubstrateForm());
		
		scene = new Scene(mainBox);
		stage.setScene(scene);
		stage.show();
	}

	public void loadChemReagentForm() {
		ChemReagentFormFX chemReagentForm = new ChemReagentFormFX();
		chemReagentForm.start();
		stage.close();
	}
	public void loadBioReagentForm() {
		BioReagentFormFX bioReagentForm = new BioReagentFormFX();
		bioReagentForm.start();
		stage.close();
	}
	public void loadBioSubstrateForm() {
		BioSubstrateFormFX bioSubstrateForm = new BioSubstrateFormFX();
		bioSubstrateForm.start();
		stage.close();
	}
}
