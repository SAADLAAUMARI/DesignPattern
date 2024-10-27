module com.example.observer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.observer to javafx.fxml;
    exports com.example.observer;
}