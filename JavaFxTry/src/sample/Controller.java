package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    public Button loginButon;
    public Label userMessage;
    public TextField userName;

    @FXML
    private void loginClicked(ActionEvent event) {
        userMessage.setText("Welcome " + userName.getText());
    }
}
