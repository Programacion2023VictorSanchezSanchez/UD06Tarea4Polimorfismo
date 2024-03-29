package com.example.ud06tarea4polimorfismo.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Cuadrado extends Figura {
    protected Rectangle rectangle;

    //Constructor
    public Cuadrado(int x, int y, Color color, int size) {
        super(x, y, color, size);
        rectangle = new Rectangle(size, size);
        rectangle.setX(x);
        rectangle.setY(y);
        rectangle.setFill(color);
    }

    /**
     * Dibujamos cuadrado
     * @param pnPanel panel donde lo dibujamos
     */
    @Override
    public void dibujar(Pane pnPanel) {
        pnPanel.getChildren().add(rectangle);
    }

    /**
     * Borramos cuadrado
     * @param pnPanel panel donde lo borramos
     */
    @Override
    public void borrar(Pane pnPanel) {
        pnPanel.getChildren().remove(rectangle);
    }

    /**
     * Cambiamos posicion del cuadrado
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
     * Cambiamos color del cuadrado
     * @param color que obtendrá
     */
    @Override
    public void cambiarColor(Color color) {
        this.setColor(color);
        rectangle.setFill(color);
    }


    /**
     * Cambiamos tamaño del cuadrado
     * @param size tamaño que obtendrá
     */
    @Override
    public void cambiarSize(int size) {
        rectangle.setWidth(size);
        rectangle.setHeight(size);
    }


    /**
     * Movemos cuadrado
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
