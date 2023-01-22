module com.app.jj {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.app.jstore to javafx.fxml;
    exports com.app.jstore;
}