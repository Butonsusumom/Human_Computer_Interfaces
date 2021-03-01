package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;


public class Controller implements Initializable {
    @FXML
    private Slider slider;
    @FXML
    private Label conversion_rate;
    @FXML
    private TextField input_value;
    @FXML
    private TextField output_value;
    @FXML
    private Button convert_button;
    @FXML
    private Button clear_button;
    @FXML
    private CheckBox check_aut;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Clear
        input_value.setText("0");
        output_value.setText("0");
        slider.setValue(1);

        //Slider-conversion_rate
        conversion_rate.textProperty().bind(Bindings.format("%.2f", slider.valueProperty()));

        //Disables conver tbutton
        convert_button.disableProperty().bind(check_aut.selectedProperty());

        //Automatic conversion
        slider.valueProperty().addListener((observabl, oldvalu, newvalu) -> {
            if(check_aut.isSelected())
                output_value.setText(""+Float.parseFloat(conversion_rate.getText().replace(",",".")) * Float.parseFloat(input_value.getText().replace(",",".")));
        });
        input_value.textProperty().addListener((observab, oldval, newval) -> {
            if(check_aut.isSelected() && !newval.equals(""))
                output_value.setText(""+Float.parseFloat(conversion_rate.getText().replace(",",".")) * Float.parseFloat(newval.replace(",",".")));
        });
    }

    @FXML
    private void convert(ActionEvent event) {
        float output = Float.parseFloat(conversion_rate.getText().replace(",",".")) * Float.parseFloat(input_value.getText().replace(",","."));
        output_value.setText((output+"").replace(".",","));
    }

    @FXML
    private void clear(ActionEvent event) {
        input_value.setText("0");
        output_value.setText("0");
    }
}
