module com.example.comparesocial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.comparesocial to javafx.fxml;
    exports com.example.comparesocial;
}