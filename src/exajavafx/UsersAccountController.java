/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exajavafx;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author sayg9
 */
public class UsersAccountController implements Initializable {

    Student s;

    @FXML
    private TableColumn<UserAccountMain, String> columnUsername;
    @FXML
    private TableColumn<UserAccountMain, String> columnpassword;
    @FXML
    private Button btnedite;
    @FXML
    private TextField textuser;
    @FXML
    private TextField textpass;
    @FXML
    private TableView<UserAccountMain> tblusers;

    ObservableList<UserAccountMain> oblist = FXCollections.observableArrayList();
    @FXML
    private TextField textSearch;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("aaaaaa");
        columnUsername.setCellValueFactory(new PropertyValueFactory<>("userName"));
        columnpassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        s = new Student();
        try {
            ResultSet rs = s.SearchStudents(textuser.getText());
            while (rs.next()) {
                oblist.add(new UserAccountMain(rs.getString("UserName"), rs.getString("Password")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblusers.setItems(oblist);
    }

    @FXML
    private void Edit(ActionEvent event) throws SQLException {
        s = new Student();
        s.EditStudents(textuser.getText(), textpass.getText());
        String user = textuser.getText();
        tblusers.getItems().clear();
        textSearch.clear();
        textpass.clear();
        btnedite.setDisable(true);
        s = new Student();
        try {
            ResultSet rs = s.SearchStudents(user);
            while (rs.next()) {
                oblist.add(new UserAccountMain(rs.getString("UserName"), rs.getString("Password")));
            }
// TODO
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblusers.setItems(oblist);
    }

    @FXML
    private void ReadFromTable(MouseEvent event) {
        int index = tblusers.getSelectionModel().getSelectedIndex();
        System.out.println(index);
        UserAccountMain users = tblusers.getItems().get(index);
        textuser.setText(users.getUserName());
        textpass.setText(users.getPassword());
        btnedite.setDisable(false);
    }

    @FXML
    private void SearchUser(KeyEvent event) {
        String user = textSearch.getText();
        tblusers.getItems().clear();
        textuser.clear();
        textpass.clear();
        btnedite.setDisable(true);
        s = new Student();
        try {
            ResultSet rs = s.SearchStudents(user);
            while (rs.next()) {
                oblist.add(new UserAccountMain(rs.getString("UserName"), rs.getString("Password")));
            }
// TODO
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblusers.setItems(oblist);
    }

}
