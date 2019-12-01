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
public class AddCoursesController implements Initializable {

    
    Student s1 = new Student();
    
    
    @FXML
    private Button btnSave;
    @FXML
    private Button btnBack;
    @FXML
    private TextField textName;
    @FXML
    private TextField texthour;
    @FXML
    private TextField textcode;
    @FXML
    private TextField textDepatment;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void Save(ActionEvent event) throws SQLException {
        if (textName.getText().isEmpty()){
            System.out.println(" Enter the user name or password !! ");
        }else if (texthour.getText().isEmpty()){
            System.out.println(" Enter the user name or password !! ");
        }else if (textcode.getText().isEmpty()){
            System.out.println(" Enter the user name or password !! ");
        } else if (textDepatment.getText().isEmpty()){
            System.out.println(" Enter the user name or password !! ");
        } else{
        s1.AddCourse(textName.getText() , textcode.getText() , texthour.getText() , textDepatment.getText());
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
