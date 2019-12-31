package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxFXMLController
{
	@FXML
	// The reference of inputText will be injected by the FXML loader
	private TextField inputText;

	// The reference of outputText will be injected by the FXML loader
	@FXML
	private TextArea outputText;

	// The reference of outputText will be injected by the FXML loader
	@FXML
	public Button okBtn;

	
	// location and resources will be automatically injected by the FXML loader
	@FXML
	private URL location;

	@FXML
	private ResourceBundle resources;

	// Add a public no-args constructor
	public FxFXMLController()
	{

	}
	
	@FXML
	private void initialize()
	{
        okBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
        		outputText.appendText(inputText.getText() + "\n");
            }
        });
	}
}
