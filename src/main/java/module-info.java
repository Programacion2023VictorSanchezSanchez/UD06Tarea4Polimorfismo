module com.example.ud06tarea4polimorfismo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ud06tarea4polimorfismo to javafx.fxml;
    exports com.example.ud06tarea4polimorfismo;
    exports com.example.ud06tarea4polimorfismo.model;
    exports com.example.ud06tarea4polimorfismo.controllers;
    opens com.example.ud06tarea4polimorfismo.controllers to javafx.fxml;
}