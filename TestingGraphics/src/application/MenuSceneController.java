package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MenuSceneController
{
	@FXML
	// The reference of inputText will be injected by the FXML loader
	private TextField inputText;

	// The reference of outputText will be injected by the FXML loader
	@FXML
	private TextArea outputText;

	@FXML
	public Button nextBtn;
	
	@FXML
	public Button prevBtn;
	
	// location and resources will be automatically injected by the FXML loader
	@FXML
	private URL location;

	@FXML
	private ResourceBundle resources;
	
	@FXML
	private void initialize()
	{
        
        nextBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
        		try {
					Parent root = FXMLLoader.load(getClass().getResource(""));
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });
        
        prevBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
        		outputText.appendText(inputText.getText() + "\n");
            }
        });
	}
}
