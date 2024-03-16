package com.example.ud06tarea4polimorfismo.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Elipse extends Figura {
    protected Ellipse elipse;

    //Constructor
    public Elipse(int x, int y, Color color, int size) {
        super(x, y, color, size);
        elipse = new Ellipse(size * 2, size);
        elipse.setCenterX(x);
        elipse.setCenterY(y);
        elipse.setFill(color);
    }

    /**
     * Dibujamos elipse
     * @param pnPanel panel donde lo dibujamos
     */
    @Override
    public void dibujar(Pane pnPanel) {
        pnPanel.getChildren().add(elipse);
    }

    /**
     * Borramos elipse
     * @param pnPanel panel donde lo borraremos
     */
    @Override
    public void borrar(Pane pnPanel) {
        pnPanel.getChildren().remove(elipse);
    }

    /**
     * Cambiamos posicion elipse
     * @param x eje x
     * @param y eje y
     */
    @Override
    public void cambiarPosicion(int x, int y) {
        setX(x);
        setY(y);
        elipse.setCenterX(x);
        elipse.setCenterY(y);
    }


    /**
     * Cambiamos color elipse
     * @param color que obtendrá
     */
    @Override
    public void cambiarColor(Color color) {
        this.setColor(color);
        elipse.setFill(color);
    }


    /**
     * Cambiamos tamaño de la elipse
     * @param size tamaño que obtendrá
     */
    @Override
    public void cambiarSize(int size) {
        elipse.setRadiusX(size * 2);
        elipse.setRadiusY(size);
    }


    /**
     * Movemos elipse
     * @param pnPanel panel donde lo moveremos
     */
    @Override
    public void moverFigura(Pane pnPanel) {
        int newX = (int) elipse.getCenterX() + getDeltaX();
        int newY =(int) elipse.getCenterY() + getDeltaY();
        if (newX <= elipse.getRadiusX() || newX >= pnPanel.getWidth() - elipse.getRadiusX())
        {
            setDeltaX(-getDeltaX());
        }
        if (newY <= elipse.getRadiusY() || newY >= pnPanel.getHeight() - elipse.getRadiusY()) {
            setDeltaY(-getDeltaY());
        }
        cambiarPosicion(newX,newY);
    }

}
