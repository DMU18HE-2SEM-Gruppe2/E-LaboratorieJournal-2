package presentationFX;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class FactoryFX {

	public Button buttonFactory(String text, int width, int fontSize, boolean disable) {
		Button template = new Button(text);
		template.setMinWidth(width);
		template.setFont(Font.font(fontSize));
		template.setDisable(disable);
		return template;
	}
	
	public TextField textFieldFactory(String text, int width, int fontSize) {
		TextField template = new TextField();
		template.setPromptText(text);
		template.setPrefWidth(width);
		template.setFont(Font.font(fontSize));

		return template;
	}
	
	public TextArea textAreaFactory(int height, int width, int fontsize, boolean monospace) {
		TextArea template = new TextArea();
		template.setPrefHeight(height);
		template.setPrefWidth(width);
		template.setFont(Font.font(fontsize));
		if (monospace == true) {
			template.setStyle("-fx-font-family: 'monospaced';");
		}
		return template;
	}
	
	public Label labelFactory(String text, int t, int r, int b, int l, int fontSize, boolean bold) {
		Label template = new Label(text);
		template.setPadding(new Insets(t, r, b, l));
		template.setFont(Font.font(fontSize));
		if (bold == true) {
			template.setStyle("-fx-font-weight: bold;");
		}
		return template;
	}
	
	public VBox vBoxFactory(int spacing, int t, int r, int b, int l, Pos alignment) {
		VBox template = new VBox(spacing);
		template.setPadding(new Insets(t, r, b, l));
		template.setAlignment(alignment);
		return template;
	}

	public HBox hBoxFactory(int spacing, int t, int r, int b, int l, Pos alignment) {
		HBox template = new HBox(spacing);
		template.setPadding(new Insets(t, r, b, l));
		template.setAlignment(alignment);
		return template;
	}
}
