package com.vidshare.vidshare;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {

    @FXML
    private TextField usremail;
    @FXML
    private TextField usrpassword;
    private Firebase fbase;
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    public void onCreateAccountButton(ActionEvent actionEvent) throws IOException, FirebaseAuthException {
        fbase.createAccount(usremail.getText(), usrpassword.getText());
    }

    @FXML
    public void onReturnToSignInHyperlink(Event event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("signin-view.fxml"));
        root = loader.load();
        SignInController scc = loader.getController();
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