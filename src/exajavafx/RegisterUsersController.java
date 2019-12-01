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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sayg9
 */
public class RegisterUsersController implements Initializable {

    
    Student s1 = new Student();
    
    
    @FXML
    private TextField usertext;
    @FXML
    private PasswordField passtext;
    @FXML
    private Button save;
    @FXML
    private Button show;
    @FXML
    private Button back;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     @FXML
    private void Save(ActionEvent event) throws SQLException {
        if (usertext.getText().isEmpty() || passtext.getText().isEmpty()){
            System.out.println(" Enter the user name or password !! ");
        }else 
        s1.AddUsers(usertext.getText(), passtext.getText());
        }

    @FXML
    private void Show(ActionEvent event) {
        for (int i =0 ; i< s1.user.size() ; i++){
            for(int j = 0 ; j< s1.pass.size() ; j++){
         System.out.println("the user name = " + s1.user.get(i) );
         System.out.println("the password = " + s1.pass.get(j) );
            }
        }
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        back.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
    
}
