package com.example.ud06tarea4polimorfismo.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Triangulo extends Figura {
    protected Polygon triangulo;

    //Constructor
    public Triangulo(int x, int y, Color color, int size) {
        super(x, y, color, size);
        triangulo = new Polygon();
        triangulo.getPoints().addAll(new Double[]{
                (double) x, (double) y,
                (double) x + size, (double) y + 2 * size,
                (double) x + 2 * size, (double) y
        });
        triangulo.setFill(color);
    }

    /**
     * Dibujamos triangulo
     * @param pnPanel panel donde lo dibujaremos
     */
    @Override
    public void dibujar(Pane pnPanel) {
        pnPanel.getChildren().add(triangulo);
    }

    /**
     * Borramos triangulo
     * @param pnPanel triangulo donde lo borraremos
     */
    @Override
    public void borrar(Pane pnPanel) {
        pnPanel.getChildren().remove(triangulo);
    }

    /**
     * Cambiamos posicion de triangulo
     * @param x eje x
     * @param y eje y
     */
    @Override
    public void cambiarPosicion(int x, int y) {
        setX(x);
        setY(y);
        triangulo.getPoints().setAll(new Double[]{
                (double) x, (double) y,
                (double) x + getSize(), (double) y + 2 * getSize(),
                (double) x + 2 * getSize(), (double) y
        });
    }


    /**
     * Cambiamos color de triangulo
     * @param color que obtendrá
     */
    @Override
    public void cambiarColor(Color color) {
        this.setColor(color);
        triangulo.setFill(color);
    }


    /**
     * Cambiamos tamaño de triangulo
     * @param size tamaño que obtendrá
     */
    @Override
    public void cambiarSize(int size) {
        setSize(size);
        triangulo.getPoints().setAll(new Double[]{
                (double) getX(), (double) getY(),
                (double) getX() + size, (double) getY() + 2 * size,
                (double) getX() + 2 * size, (double) getY()
        });
    }


    /**
     * Movemos triangulo
     * @param pnPanel panel donde lo moveremos
     */
    @Override
    public void moverFigura(Pane pnPanel) {
        int newX = getX() + getDeltaX();
        int newY = getY() + getDeltaY();
        if (newX <= 0 || newX + 2 * getSize() >= pnPanel.getWidth()) {
            setDeltaX(-getDeltaX());
        }
        if (newY <= 0 || newY + 2 * getSize() >= pnPanel.getHeight()) {
            setDeltaY(-getDeltaY());
        }
        cambiarPosicion(newX, newY);
    }

}