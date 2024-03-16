package com.example.ud06tarea4polimorfismo.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rectangulo extends Figura {
    protected Rectangle rectangle;

    //Constructor
    public Rectangulo(int x, int y, Color color, int size) {
        super(x, y, color, size);
        rectangle = new Rectangle(size * 2, size);
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setFill(color);
    }

    /**
     * Dibujamos rectangulo
     * @param pnPanel panel donde lo dibujaremos
     */
    @Override
    public void dibujar(Pane pnPanel) {
        pnPanel.getChildren().add(rectangle);
    }

    /**
     * Borramos rectangulo
     * @param pnPanel panel donde lo borraremos
     */
    @Override
    public void borrar(Pane pnPanel) {
        pnPanel.getChildren().remove(rectangle);
    }

    /**
     * Cambiamos posicion de rectangulo
     * @param x eje x
     * @param y eje y
     */
    @Override
    public void cambiarPosicion(int x, int y) {
        setX(x);
        setY(y);
        rectangle.setX(x);
        rectangle.setY(y);
    }


    /**
     * Cambiamos color de rectangulo
     * @param color que obtendrá
     */
    @Override
    public void cambiarColor(Color color) {
        this.setColor(color);
        rectangle.setFill(color);
    }


    /**
     * Cambiamos tamaño de rectangulo
     * @param size tamaño que obtendrá
     */
    @Override
    public void cambiarSize(int size) {
        rectangle.setWidth(size * 2);
        rectangle.setHeight(size);
    }


    /**
     * Movemos rectangulo
     * @param pnPanel panel donde lo moveremos
     */
    @Override
    public void moverFigura(Pane pnPanel) {
        int newX = (int) rectangle.getX() + getDeltaX();
        int newY =(int) rectangle.getY()+ getDeltaY();
        if (newX <= 0  || newX >= pnPanel.getWidth() - rectangle.getWidth())  {
            setDeltaX(-getDeltaX());
        }
        if (newY <= 0 || newY >= pnPanel.getHeight() - rectangle.getHeight()) {
            setDeltaY(-getDeltaY());
        }
        cambiarPosicion(newX,newY);
    }
}
