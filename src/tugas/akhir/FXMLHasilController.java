/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.akhir;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zendy bramantia
 */
public class FXMLHasilController implements Initializable {


    @FXML
    private JFXButton ya;

    @FXML
    private JFXButton tidak;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
        @FXML
    void tidak(ActionEvent event) {
       ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void yaa(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLHome.fxml"));
                Scene scene = new Scene (fxmlLoader.load(),900,450);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("MenuAwal");
                stage.show();

    }

}
