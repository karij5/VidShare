module com.vidshare.vidshare {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vidshare.vidshare to javafx.fxml;
    exports com.vidshare.vidshare;
}