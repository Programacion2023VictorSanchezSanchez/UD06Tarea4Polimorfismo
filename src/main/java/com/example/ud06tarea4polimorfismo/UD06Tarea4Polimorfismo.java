package com.example.ud06tarea4polimorfismo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UD06Tarea4Polimorfismo extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UD06Tarea4Polimorfismo.class.getResource("inicio-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Figuras");
        stage.setScene(scene);
        stage.show();
    }


}
