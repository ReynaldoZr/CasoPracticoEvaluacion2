module org.example.evaluacion2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.evaluacion2 to javafx.fxml;
    exports org.example.evaluacion2;
}