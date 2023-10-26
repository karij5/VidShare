package com.vidshare.vidshare;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private Label emailText;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label passwordText;
    @FXML
    private Button signInButton;
    @FXML
    private Button signUpButton;


    @FXML
    protected void onSignInButtonClick() {
        //if(!emailField.getText().contains("@")){

        //}
    }

    @FXML
    protected void onSignUpButtonClick(){

    }
}