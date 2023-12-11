module com.vidshare.vidshare {
    requires javafx.controls;
    requires javafx.fxml;
    requires google.cloud.firestore;
    requires firebase.admin;
    requires com.google.auth.oauth2;
    requires java.logging;
    requires com.google.api.apicommon;
    requires com.google.auth;
    requires google.cloud.core;
    requires google.cloud.storage;
    requires javafx.media;
    requires gax;

    opens com.vidshare.vidshare to javafx.fxml;
    exports com.vidshare.vidshare;
}