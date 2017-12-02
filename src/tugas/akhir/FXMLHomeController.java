/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.akhir;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import static de.jensd.fx.glyphs.icons525.Icons525.SELECT;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zendy bramantia
 */
public class FXMLHomeController implements Initializable {

    @FXML
    private JFXRadioButton steam;
    @FXML
    private ToggleGroup group;
    @FXML
    private JFXRadioButton axis;
    @FXML
    private JFXRadioButton indosat;
    @FXML
    private JFXRadioButton telkomsel;
    @FXML
    private JFXRadioButton gemscool;
    @FXML
    private JFXRadioButton garena;
    @FXML
    private JFXTextField editjumlahvoucher;
    @FXML
    private JFXButton submit;
    @FXML
    private JFXButton out;
    
    @FXML
    private JFXTextField hargavoucher;

    @FXML
    private JFXTextField biayabank;

    @FXML
    private JFXTextField hargatotal;

    @FXML
    private JFXTextArea hasil;
    
    @FXML
    private JFXButton KONFIRMASI;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonsubmit(ActionEvent event) {
        int voucher = Integer.parseInt(editjumlahvoucher.getText());
        int harga = 0;
        int bank = 0;
        int tambahan = 0;
        int total = 0;
        if (axis.isSelected()){
            tambahan = voucher * 15 / 100;
            harga = voucher + tambahan;
            bank = voucher * 5 / 100;
            total = harga + bank;
        }
        else if (telkomsel.isSelected()){
            tambahan = voucher * 10 / 100;
            harga = voucher + tambahan;
            bank = voucher * 5 / 100;
            total = harga + bank;
        }
        else if (indosat.isSelected()){
            tambahan = voucher * 10 / 100;
            harga = voucher + tambahan;
            bank = voucher * 10 / 100;
            total = harga + bank;
        }
        else if (steam.isSelected()){
            tambahan = voucher * 20 / 100;
            harga = voucher + tambahan;
            bank = voucher * 10 / 100;
            total = harga + bank;
        }
        else if (garena.isSelected()){
            tambahan = voucher * 15 / 100;
            harga = voucher + tambahan;
            bank = voucher * 5 / 100;
            total = harga + bank;
        }
        else if (gemscool.isSelected()){
            tambahan = voucher * 20 / 100;
            harga = voucher + tambahan;
            bank = voucher * 5 / 100;
            total = harga + bank;
        }
        hargavoucher.setText("Rp"+ harga);
        hargatotal.setText("Rp"+ total);
        biayabank.setText("Rp"+ bank);
        hasil.setText("Anda akan memesan voucher steam sejumlah Rp."+voucher+
                "\ndengan biaya total sebesar Rp."+total+
                "\nTekan tombol konfirmasi jika anda telah setuju\n"
                + "dan transfer sebesar"+total+
                "ke nomor atm 0000-1111-0000-2222");
        
    }
    
    @FXML
    void konfirmasi(ActionEvent event) throws IOException {
        ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLHasil.fxml"));
                Scene scene = new Scene (fxmlLoader.load(),900,450);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Terima Kasih");
                stage.show();
        
    }

    @FXML
    private void outbutton(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
