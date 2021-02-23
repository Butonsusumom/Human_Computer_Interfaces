package sample;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

    @FXML
    private Button but1;
    @FXML
    private Button but2;
    @FXML
    private Button but3;
    @FXML
    private Button but4;
    @FXML
    private Button but5;
    @FXML
    private Button but6;
    @FXML
    private Button but7;
    @FXML
    private Button but8;
    @FXML
    private Button but9;
    @FXML
    private TextField scoreO;
    @FXML
    private TextField scoreX;

    private boolean firstPlayer = true;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        scoreO.setText("0");
        scoreX.setText("0");
    };

    @FXML
    private void buts(ActionEvent event){
        Button cell = (Button) event.getTarget();
        String label = cell.getText();

        if(isEmpty(label)){
            if(firstPlayer) {
                cell.setText("O");
            }
            else {
                cell.setText("X");
            }

            int winner = checkWinner();

            if(winner != 2) {
                TextField text;
                String alertChar;
                if (winner == 0){
                    text = scoreO;
                    alertChar = "O";
                }
                else{
                    text = scoreX;
                    alertChar = "X";
                }

                int wins = parseInt((text).getText());
                wins++;
                (text).setText(Integer.toString(wins));
                disBut();
                winnerAlert(alertChar);
            }
            firstPlayer = !firstPlayer;
        }
    }

    private void winnerAlert(String player){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game over");
        alert.setHeaderText("The " + player + " player wins!");

        alert.showAndWait();
    }

    private boolean isEmpty(String a){
        return a.equals("");
    }

    public boolean checkLine(Button b, Button c, Button d){
        String a = b.getText();
        if (isEmpty(b.getText())||isEmpty(c.getText())||isEmpty(d.getText())) return false;
        return b.getText().equals(a) && c.getText().equals(a) && d.getText().equals(a);
    }

    public int whoWins(Button but){
        if (but.getText().equals("O")){
            return 0;
        }
        return 1;
    }

    // 0 - 0 \ 1 - x \2 - no one\ 3 - draw
    private int checkWinner(){

        int winner = 2;

        // Column 1, Row 1, Diagonal 1
        if(!isEmpty(but1.getText())){
            if(checkLine(but1, but4, but7) || checkLine(but1, but2, but3) ||
                    checkLine(but1, but5, but9)) {
                winner = whoWins(but1);
            }
        }

        // Column 2, Row 3
        if(!isEmpty(but8.getText())){
            if(checkLine(but2, but5, but8) || checkLine(but7, but8, but9)) {
                winner = whoWins(but8);
            }
        }

        // Column 3, Diagonal 2
        if(!isEmpty(but3.getText())){
            if(checkLine(but3, but6, but9) || checkLine(but3, but5, but7)){
                winner = whoWins(but3);
            }
        }

        // Row 2
        if(checkLine(but4, but5, but6)){
            winner= whoWins(but4);
        }

        return winner;
    }

    public void disBut(){
        disable(true);
    }

    @FXML
    private void start(ActionEvent event){
        clearGrid();
        disable(false);
    }

    @FXML
    private void reset(ActionEvent event){
        clearScore();
        clearGrid();
    }

    @FXML
    private void clearGrid(){
        but1.setText("");
        but2.setText("");
        but3.setText("");
        but4.setText("");
        but5.setText("");
        but6.setText("");
        but7.setText("");
        but8.setText("");
        but9.setText("");
    }

    @FXML
    private void clearScore(){
        scoreO.setText("0");
        scoreX.setText("0");
    }

    @FXML
    private void disable(boolean bool){
        but1.setDisable(bool);
        but2.setDisable(bool);
        but3.setDisable(bool);
        but4.setDisable(bool);
        but5.setDisable(bool);
        but6.setDisable(bool);
        but7.setDisable(bool);
        but8.setDisable(bool);
        but9.setDisable(bool);
    }

}