package com.vidshare.vidshare;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInController {
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
    private Firebase fbase;
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    protected void onSignInButtonClick(Event event) throws IOException, FirebaseAuthException {
        try {
            String idToken = fbase.getUserToken(emailField.getText(), passwordField.getText());
            if(idToken==null){
                emailField.setText("");
                passwordField.setText("");
            }
            else{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("explorepage-view.fxml"));
                root = loader.load();
                ExplorePageController epc = loader.getController();
                epc.setInstance(fbase, stage);
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException | FirebaseAuthException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onSignUpHyperlinkClick(Event event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signup-view.fxml"));
        root = loader.load();
        SignupController scc = loader.getController();
        scc.setInstance(fbase, stage);
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setInstance(Firebase fbase, Stage stage){
        this.fbase=fbase;
        this.stage=stage;
    }
}