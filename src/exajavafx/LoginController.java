/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exajavafx ;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sayg9
 */
public class LoginController implements Initializable {

    
    Student s1 = new Student(); 
    
    
    private Button register;
    private TextField textu;
    private Label label;
    private PasswordField textp;
    private Button display;

    @FXML
    private Button btnAddStudent;
    @FXML
    private Button btnAddCourse;
    @FXML
    private Button btnCourseRge;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void Login(ActionEvent event) throws IOException {
        if (textu.getText().isEmpty() || textp.getText().isEmpty()){
            label.setText("Please enter the user name or the password !!");
        }else 
                if(s1.CheckUser(textu.getText(),textp.getText()) == true){
                    label.setText(" wellcome ");    
            }else
                    label.setText("Wrong the Password or user name !!");
        }  

    @FXML
    private void AddStudent(ActionEvent event) throws IOException {
        btnAddStudent.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AddStudent.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void AddCourse(ActionEvent event) throws IOException {
        btnAddCourse.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("AddCourses.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void CourseRegister(ActionEvent event) throws IOException {
        btnCourseRge.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("Registers.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
