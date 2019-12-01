/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exajavafx;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
public class MainPageController implements Initializable {

    Student s1 = new Student();
    
    
    @FXML
    private Button login;
    @FXML
    private Button register;
    @FXML
    private TextField textu;
    @FXML
    private Label label;
    @FXML
    private PasswordField textp;
    @FXML
    private Button display;
    @FXML
    private Button btntableview;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void Login(ActionEvent event ) throws IOException {
        
//        if (textu.getText().isEmpty() || textp.getText().isEmpty()) {
//            label.setText("Please enter the user name or the password !!");
//            
//        } else if (s1.CheckUser(textu.getText(), textp.getText()) != true) {
//                label.setText("Wrong the Password or user name !!");
//            } else {
            label.setText("Welcome .. ");
            display.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                System.out.println("abdullah");
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
           // }
    }
            @FXML
            private void display(ActionEvent event) throws IOException {
                display.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("Display.fxml"));

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }

            @FXML
            private void inputRgs
            (ActionEvent event) throws IOException {
                register.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("RegisterUsers.fxml"));

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }

            @FXML
            private void Tableview
            (ActionEvent event) throws IOException {
                btntableview.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("UsersAccount.fxml"));

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            }
        }
