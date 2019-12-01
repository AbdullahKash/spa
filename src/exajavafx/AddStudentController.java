/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exajavafx;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sayg9
 */
public class AddStudentController implements Initializable {

    
    Student s1 = new Student();
    
    
    @FXML
    private Button btnSave;
    @FXML
    private Button btnBack;
    @FXML
    private TextField textName;
    @FXML
    private TextField textEmail;
    @FXML
    private TextField textMobile;
    @FXML
    private TextField textAddress;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Save(ActionEvent event) throws SQLException {
        if (textName.getText().isEmpty()){
            System.out.println(" Enter the Your Name !! ");
        }else if (textEmail.getText().isEmpty()){
            System.out.println(" Enter the Your Email !! ");
        }else if (textMobile.getText().isEmpty()){
            System.out.println(" Enter the Your Mobile !! ");
        } else if (textAddress.getText().isEmpty()){
            System.out.println(" Enter the Your Address !! ");
        } else{
        s1.AddStudent(textName.getText() , textEmail.getText() , textMobile.getText() , textAddress.getText());
        }
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        btnBack.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
