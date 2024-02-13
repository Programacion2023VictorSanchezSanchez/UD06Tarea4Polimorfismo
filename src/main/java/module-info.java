module com.example.ud06tarea4polimorfismo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ud06tarea4polimorfismo to javafx.fxml;
    exports com.example.ud06tarea4polimorfismo;
}