module com.app.jj {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.app.jj to javafx.fxml;
    exports com.app.jj;
}