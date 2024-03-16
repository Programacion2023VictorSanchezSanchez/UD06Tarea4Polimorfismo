package com.example.ud06tarea4polimorfismo.controllers;

import com.example.ud06tarea4polimorfismo.model.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InicioController implements Initializable {

    Figura figuraActual;
    int xInicial;
    int yInicial;
    int sizeInicial = 50;
    ArrayList<Figura> figuras = new ArrayList<>();
    Timeline timeline;

    @FXML
    private Button btBorrarTodos;

    @FXML
    private Button btGuardar;

    @FXML
    private Polygon btIniciar;

    @FXML
    private Rectangle btParar;

    @FXML
    private ColorPicker cpColor;

    @FXML
    private Slider slPosicionX;

    @FXML
    private Slider slPosicionY;

    @FXML
    private Pane pnPanel;

    @FXML
    private Slider slSize;

    @FXML
    private AnchorPane apCrearFiguras;

    /**
     * Borramos todas las figuras
     * @param event
     */
    @FXML
    void onClickBorrarTodos(ActionEvent event) {
        figuras.clear();
    }

    @FXML
    void onClickColor(ActionEvent event) {

    }

    /**
     * Guardamos la figura
     * @param event
     */
    @FXML
    void onClickGuardar(ActionEvent event) {
        figuras.add(figuraActual);
        figuraActual.borrar(pnPanel);
    }

    /**
     * Iniciamos la aplicacion
     * @param event
     */
    @FXML
    void onClickIniciar(MouseEvent event) {
        //borramos figura existente

        if (figuraActual != null)
            figuraActual.borrar(pnPanel);

        //dibujamos las figuras en el array

        for (Figura figura : figuras) {
            figura.dibujar(pnPanel);
        }

        iniciaMovimiento();
        probandoFiguras(false);
        iniciaMovimiento();
    }

    /**
     * Borramos las figuras y paramos el movimiento
     * @param event
     */
    @FXML
    void onClickParar(MouseEvent event) {
        //borramos las figuras del array

        for (Figura figura : figuras) {
            figura.borrar(pnPanel);
        }

        //paramos el movimiento

        timeline.stop();
        probandoFiguras(true);
    }

    /**
     * Seleccionamos la figura que queremos y comprobamos que es
     * @param event
     */
    @FXML
    void onClickSeleccionFigura(MouseEvent event) {
        //borramos la figura existente si la hay

        if (figuraActual != null) {
            figuraActual.borrar(pnPanel);
        }

        Object figuraSeleccionada = event.getSource();

        //comprobamos el tipo de figura que es la seleccionada

        if (figuraSeleccionada instanceof Circle) {
            figuraActual = new Circulo(xInicial, yInicial, cpColor.getValue(), sizeInicial / 2);
        } else if (figuraSeleccionada instanceof Rectangle) {
            figuraActual = new Cuadrado(xInicial, yInicial, cpColor.getValue(), sizeInicial);
        } else if (figuraSeleccionada instanceof Polygon) {
            figuraActual = new Estrella(xInicial, yInicial, cpColor.getValue(), sizeInicial);
        } else {
            figuraActual = new Elipse(xInicial, yInicial, cpColor.getValue(), sizeInicial / 2);
        }
        figuraActual.dibujar(pnPanel);
    }

    /**
     * Barra para seleccionar tamaño
     * @param event
     */
    @FXML
    void onClickSliderSize(MouseEvent event) {
        if (figuraActual != null && figuraActual instanceof Cuadrado) {
            figuraActual.cambiarSize((int) slSize.getValue() * 2);
        } else if (figuraActual != null) {
            figuraActual.cambiarSize((int) slSize.getValue());
        }
    }

    /**
     * Barra de eje X
     * @param event
     */
    @FXML
    void onClickSliderX(MouseEvent event) {
        if (figuraActual != null) {
            figuraActual.cambiarPosicion((int) slPosicionX.getValue(), figuraActual.getY());
        }
    }

    /**
     * Barra de eje y
     * @param event
     */
    @FXML
    void onClickSliderY(MouseEvent event) {
        if (figuraActual != null) {
            figuraActual.cambiarPosicion(figuraActual.getX(), (int) slPosicionY.getValue());
        }
    }

    /**
     * Inicializamos la aplicación
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            //Obtenemos alto y ancho del anchorpane
            int anchoPanel = (int) pnPanel.getParent().getScene().getWidth();
            int altoPanel = (int) (pnPanel.getParent().getScene().getHeight() - pnPanel.getLayoutY());

            //Asignamos tamaño
            pnPanel.setPrefWidth(anchoPanel);
            pnPanel.setPrefHeight(altoPanel);

            //Inicializamos ejes
            xInicial = anchoPanel / 2;
            yInicial = altoPanel / 2;

            //Asignamos máximos y actuales
            slPosicionX.setMax(anchoPanel);
            slPosicionX.setValue(xInicial);
            slPosicionY.setMax(altoPanel);
            slPosicionY.setValue(yInicial);

        });
        probandoFiguras(true);
    }

    /**
     * Movemos las figuras
     */
    private void moverFiguras() {
        for (Figura figura : figuras) {
            figura.moverFigura(pnPanel);
        }
    }

    /**
     * Iniciamos movimiento
     */
    void iniciaMovimiento() {
        // Crea un Timeline para la animación
        if (timeline == null) {
            //cada 16milisegundos, llama a moverFiguras
            timeline = new Timeline(new KeyFrame(Duration.millis(16), event2 -> moverFiguras()));
            // Hace que la animación se repita indefinidamente
            timeline.setCycleCount(Timeline.INDEFINITE);
        }
        // Hace que la animación se repita indefinidamente
        timeline.play();
    }

    /**
     *Si la app esta iniciada desactivamos el boton de iniciar y de crear figuras, si la app esta parada desactivamose
     * el boton de parar
     * @param appParada si la app esta iniciada o no
     */
    private void probandoFiguras(boolean appParada) {
        apCrearFiguras.setDisable(!appParada);
        btIniciar.setDisable(!appParada);
        btParar.setDisable(appParada);
    }


    /**
     * Seleccionamos rectangulo
     * @param event
     */
    @FXML
    void onClickSeleccionFiguraRectangulo(MouseEvent event) {
        if (figuraActual != null) {
            figuraActual.borrar(pnPanel);
        }

        figuraActual = new Rectangulo(xInicial, yInicial, cpColor.getValue(), sizeInicial);
        figuraActual.dibujar(pnPanel);
    }


    /**
     * Seleccionamos triangulo
     * @param event
     */
    @FXML
    void onClickSeleccionFiguraTriangulo(MouseEvent event) {
        if (figuraActual != null) {
            figuraActual.borrar(pnPanel);
        }

        figuraActual = new Triangulo(xInicial, yInicial, cpColor.getValue(), sizeInicial / 2);
        figuraActual.dibujar(pnPanel);
    }
}
