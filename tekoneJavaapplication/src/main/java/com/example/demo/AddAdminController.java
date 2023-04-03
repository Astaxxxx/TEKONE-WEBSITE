package com.example.demo;

import com.example.demo.module.Admin;
import com.example.demo.module.AdminCollection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.DefaultStringConverter;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;


public class AddAdminController  {
    @FXML private TextField nameField;
    @FXML private TextField emailField;
    @FXML private TextField passwordField;
    @FXML private TextField addressField;
    @FXML private TextField phoneField;
@FXML
private Button add;
@FXML
private Button clear;
@FXML
private Button back;
private AdminCollection adminCollection = new AdminCollection();






    @FXML
    private void handleAdd(ActionEvent event) {
        // Get input values from the user
        String name = nameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String address = addressField.getText();
        String phone = phoneField.getText();

        // Create a new Admin object
        Admin admin = new Admin(0,name, email, password, address, phone);

        // Add the new admin to the database
        adminCollection.addAdmin(admin);

        // Display a success message to the user
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Admin Added");
        alert.setHeaderText(null);
        alert.setContentText("The admin has been added to the database.");
        alert.showAndWait();


        nameField.clear();
        emailField.clear();
        passwordField.clear();
        addressField.clear();
        phoneField.clear();
    }


    @FXML
private  void handleClear(ActionEvent event){
        nameField.clear();
        emailField.clear();
        passwordField.clear();
        addressField.clear();
        phoneField.clear();
}

    @FXML
    private void handleBack(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdminList.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Unable to load main.fxml");
            alert.setContentText("Please try again later.");
            alert.showAndWait();
        }
    }


}
