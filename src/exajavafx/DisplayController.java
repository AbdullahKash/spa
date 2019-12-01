/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exajavafx;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sayg9
 */
public class DisplayController implements Initializable {

    Student s1 = new Student();
            
    @FXML
    private ListView<String> listdisplay;
    @FXML
    private TextField textresult;
    @FXML
    private Button blogin;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> users = new ArrayList<String>();
        users = s1.getUser();
        ObservableList<String> userobser = FXCollections.observableArrayList(users);
        FXCollections.sort(userobser);
         listdisplay.getItems().addAll(userobser);
         
         listdisplay.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            
            public void changed(ObservableValue<? extends String> observable,String oldValue, String newValue) {
                                                textresult.setText(s1.getPassword(newValue));
            }
                 });
    }

    @FXML
    private void blogin(ActionEvent event) throws IOException {
        blogin.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
}
