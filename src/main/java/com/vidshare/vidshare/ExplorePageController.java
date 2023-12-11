package com.vidshare.vidshare;

import com.google.api.gax.paging.Page;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.firebase.cloud.StorageClient;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.media.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ExplorePageController implements Initializable {

    @FXML MenuBar menuBar;
    @FXML MenuItem menuItem;

    @FXML MediaView mediaView;
    private MediaPlayer mediaPlayer;
    private Media media;

    private Firebase fbase;
    private Stage stage;
    private Scene scene;
    private Parent root;

    private Storage storage;
    private ArrayList<String> mediaLinks;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.mediaLinks = new ArrayList<>();
        this.storage = StorageClient.getInstance().bucket().getStorage();

        Page<Blob> videos = this.storage.get("fall23csc325kevin-sun.appspot.com").list();

        for(Blob b : videos.iterateAll()){
            mediaLinks.add(b.getMediaLink());
        }

        playNextVideo();
    }

    private void playNextVideo(){
        if (mediaPlayer != null)
            mediaPlayer.pause();

        Collections.shuffle(mediaLinks);
        playVideo(mediaLinks.get(0));
    }

    private void playVideo(String mediaLink){
        media = new Media(mediaLink);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setVolume(20.0);
        mediaPlayer.play();
    }

    @FXML
    protected void logOut (ActionEvent event) throws IOException {
        Stage stage = (Stage) menuBar.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("signin-view.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    protected void goToFollowers (ActionEvent event) throws IOException {
        Stage stage = (Stage) menuBar.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("followerslist-view.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void goToFollowing (ActionEvent event) throws IOException {
        Stage stage = (Stage) menuBar.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("followinglist-view.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void goToCredentials (ActionEvent event) throws IOException {
        Stage stage = (Stage) menuBar.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("editpage-view.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void goToCopyright (ActionEvent event) throws IOException {
        Stage stage = (Stage) menuBar.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Copyright.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void goToHowToUse (ActionEvent event) throws IOException {
        Stage stage = (Stage) menuBar.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("HowToUse.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void goToToS (ActionEvent event) throws IOException {
        Stage stage = (Stage) menuBar.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Terms Of Service.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setInstance(Firebase fbase, Stage stage){
        this.fbase=fbase;
        this.stage=stage;
    }


    @FXML protected void buttonPressedLike(ActionEvent event) throws IOException {
        playNextVideo();
    }

    @FXML protected void buttonPressedDislike(ActionEvent event) throws IOException {
        playNextVideo();
    }
}