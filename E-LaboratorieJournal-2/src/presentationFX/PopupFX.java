package presentationFX;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class PopupFX {
	private Stage popUp;
	private Scene cancelScene;
	private ActionEvent actionEvent;
	FactoryFX factory = new FactoryFX();
	
	private Label lCancel, lCancelInfo;
	public Button btnNo, btnYes;
	private VBox mainBox;
	private HBox btnBox;
	
	public boolean cancelClick;
	public boolean lockClick;
		
	public void startCancel() {
		popUp = new Stage();
		popUp.setTitle("Annuller");		
		popUp.initModality(Modality.APPLICATION_MODAL);
		
		lCancel = factory.labelFactory("Er du sikker på at du vil annullere?", 0, 0, 0, 0, 14, true);
		lCancelInfo = factory.labelFactory("Hvis du annullerer bliver intet gemt", 0, 0, 0, 0, 12, false);
		
		btnNo = factory.buttonFactory("Nej", 90, 14, false);
		btnNo.setOnAction(e -> btnCancelNoAction());
		
		btnYes = factory.buttonFactory("Ja", 90, 14, false);
		btnYes.setOnAction(e -> btnCancelYesAction());
		
		
		mainBox = factory.vBoxFactory(15, 10, 10, 10, 10, Pos.CENTER);
		mainBox.setPrefWidth(325);
		mainBox.setPrefHeight(150);
		btnBox = factory.hBoxFactory(50, 10, 10, 10, 10, Pos.CENTER);
	
		btnBox.getChildren().addAll(btnNo, btnYes);
		mainBox.getChildren().addAll(lCancel, lCancelInfo, btnBox);

		cancelScene = new Scene(mainBox);
		
		popUp.setScene(cancelScene);		
		popUp.show();
	}
	
	public void startSaveAndLock() {
		popUp = new Stage();
		popUp.setTitle("Gem og Lås");
		popUp.initModality(Modality.APPLICATION_MODAL);
		
		lCancel = factory.labelFactory("Er du sikker på at du vil låse denne blanket?", 0, 0, 0, 0, 14, true);
		lCancelInfo = factory.labelFactory("Hvis du låser kan du ikke længere rette i blanketten", 0, 0, 0, 0, 12, false);
		
		btnNo = factory.buttonFactory("Nej", 90, 14, false);
		btnNo.setOnAction(e -> btnCancelNoAction());
		
		btnYes = factory.buttonFactory("Ja", 90, 14, false);
//		btnYes.setOnAction(e -> btnYesAction());
		
		mainBox = factory.vBoxFactory(15, 10, 10, 10, 10, Pos.CENTER);
		mainBox.setPrefWidth(325);
		mainBox.setPrefHeight(150);
		btnBox = factory.hBoxFactory(50, 10, 10, 10, 10, Pos.CENTER);
	
		btnBox.getChildren().addAll(btnNo, btnYes);
		mainBox.getChildren().addAll(lCancel, lCancelInfo, btnBox);

		cancelScene = new Scene(mainBox);
		
		popUp.setScene(cancelScene);		
		popUp.show();
	}
	
	public void btnCancelNoAction() {
		popUp.close(); 	
	}
	
	public boolean btnCancelYesAction() {
		cancelClick = true;
		popUp.close();
		return cancelClick;
	}
	
	public boolean btnLockYesAction() {
		lockClick = true;
		popUp.close();
		return lockClick;
	}
}