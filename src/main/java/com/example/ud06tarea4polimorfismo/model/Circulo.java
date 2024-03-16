package com.example.ud06tarea4polimorfismo.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Circulo extends Figura {
    protected Circle circle;

    //Constructor
    public Circulo(int x, int y, Color color, int size) {
        super(x, y, color, size);
        circle = new Circle(size);
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle.setFill(color);
    }

    /**
     * Dibujamos el circulo
     * @param pnPanel panel donde saldrá dibujado
     */
    @Override
    public void dibujar(Pane pnPanel) {
        pnPanel.getChildren().add(circle);
    }

    /**
     * Borramos el circulo
     * @param pnPanel del panel que se borrara
     */
    @Override
    public void borrar(Pane pnPanel) {
        pnPanel.getChildren().remove(circle);
    }

    /**
     * Cambiamos la posicion del circulo
     * @param x eje x
     * @param y eje y
     */
    @Override
    public void cambiarPosicion(int x, int y) {
        setX(x);
        setY(y);
        circle.setCenterX(x);
        circle.setCenterY(y);
    }

    /**
     * Cambiamos el color del circulo
     * @param color que obtendrá
     */
    @Override
    public void cambiarColor(Color color) {
        this.setColor(color);
        circle.setFill(color);
    }

    /**
     * Cambiamos tamaño del circulo
     * @param size tamaño que obtendra
     */
    @Override
    public void cambiarSize(int size) {
        circle.setRadius(size);
    }

    /**
     * Movemos circulo
     * @param pnPanel panel donde lo moveremos
     */
    @Override
    public void moverFigura(Pane pnPanel) {
        int newX = (int) circle.getCenterX() + getDeltaX();
        int newY =(int) circle.getCenterY() + getDeltaY();
        if (newX <= circle.getRadius() || newX >= pnPanel.getWidth() - circle.getRadius())
        {
            setDeltaX(-getDeltaX());
        }
        if (newY <= circle.getRadius() || newY >= pnPanel.getHeight() - circle.getRadius()) {
            setDeltaY(-getDeltaY());
        }
        cambiarPosicion(newX,newY);
    }
}
