module com.vidshare.vidshare {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.vidshare.vidshare to javafx.fxml;
    exports com.vidshare.vidshare;
}