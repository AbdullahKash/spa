/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exajavafx ;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sayg9
 */
public class RegistersController implements Initializable {

    
    Student s1 = new Student();
    
    
    private TextField usertext;
    private PasswordField passtext;
    private Button back;

    
    @FXML
    private TextField studenttext;
    @FXML
    private PasswordField coursetext;
    @FXML
    private Button btnRgs;
    @FXML
    private ChoiceBox<Integer> choiceIdStudent;
    @FXML
    private ChoiceBox<Integer> choiceIdCourse;
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ArrayList<Integer> c = new ArrayList<String>();
        Collections.sort(c);
        ObservableList<Integer> userobsercity = FXCollections.observableArrayList(c);
        choiceIdStudent.getItems().addAll(userobsercity);
        choiceIdStudent.setPrefWidth(150);
        
    }    

    private void Save(ActionEvent event) throws SQLException {
         if (!choiceIdStudent.isFocused()){
            System.out.println(" Enter the user name or password !! ");
        } else if (!choiceIdCourse.isFocused()){
            System.out.println(" Enter the user name or password !! ");
        } else{
        s1.AddCourseRegister(choiceIdStudent.getValue() , choiceIdCourse.getValue());
        }
    }
    private void Show(ActionEvent event) {
        for (int i =0 ; i< s1.user.size() ; i++){
            for(int j = 0 ; j< s1.pass.size() ; j++){
         System.out.println("the user name = " + s1.user.get(i) );
         System.out.println("the password = " + s1.pass.get(j) );
            }
        }
    }

    private void Back(ActionEvent event) throws IOException {
        back.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("Student.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Register(ActionEvent event) {
    }
    
}
