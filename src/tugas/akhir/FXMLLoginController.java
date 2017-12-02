/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas.akhir;

import com.jfoenix.controls.JFXButton;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author zendy bramantia
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private JFXButton login;
    @FXML
    private JFXButton daftar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void buttonlogin(ActionEvent event) throws IOException {
        Connection connection;
        PreparedStatement ps;
            try{
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tugas_akhir", "root", "");
                ps = connection.prepareStatement("SELECT * FROM `akun` WHERE username=? AND password=?");
                ps.setString(1, username.getText());
                ps.setString(2, password.getText());
                ResultSet result = ps.executeQuery();
            if(result.next()){
                Component rootPane = null;
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Benar!");
                ((Node)(event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("FXMLHome.fxml"));
                Scene scene = new Scene (fxmlLoader.load(),900,450);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Home");
                stage.show();
            } else {               
                Component rootPane = null;
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Salah!");
                username.requestFocus();
                password.requestFocus();
                 }
            } catch (java.sql.SQLException ex){
                Component rootPane = null;
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Gagal!");
            }
    }
    @FXML
    private void buttondaftar(ActionEvent event) throws IOException {
        Connection con=new c_koneksi().getConnection();
    Connection connection;
    PreparedStatement st;
        try{ 
       connection =DriverManager.getConnection("jdbc:mysql://localhost/tugas_akhir?zeroDate TimeBehavior=convertToNull", "root", "");
    st=connection.prepareStatement("insert into akun(username,password) values(?,?)");
    st.setString(1,username.getText());
    st.setString(2,password.getText());
        
        st.execute();
        JOptionPane.showMessageDialog(null, "Tersimpan");
        
   }catch(Exception e){
       JOptionPane.showMessageDialog(null, e);
   }
   }       
}                                 


    

