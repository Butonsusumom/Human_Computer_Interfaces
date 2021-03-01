package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author ydavpacat
 */
public class Controller implements Initializable {

    @FXML
    private GridPane gridP;
    @FXML
    private Circle circulo;

    private int n=5;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void keyPressed(InputMethodEvent event) {
    }

    @FXML
    private void initialize(KeyEvent event) {
        System.out.println(event.getCode());


        int fila = gridP.getRowIndex(circulo);
        int columna = gridP.getColumnIndex(circulo);

        if (event.getCode().equals(KeyCode.RIGHT) && columna  < n-1){
            gridP.setColumnIndex(circulo, columna +1);
        }

        if (event.getCode().equals(KeyCode.LEFT) && columna  > 0){
            gridP.setColumnIndex(circulo, columna -1);
        }


        if (event.getCode().equals(KeyCode.UP) && fila > 0){
            gridP.setRowIndex(circulo, fila-1);
        }

        if (event.getCode().equals(KeyCode.DOWN) && fila < n-1){
            gridP.setRowIndex(circulo, fila+1);

        }
        System.out.println("("+fila+" "+ columna+")");


    }

}