package com.example.ud06tarea4polimorfismo.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Estrella extends Figura {
    protected Polygon estrella;

    //Constructor estrella
    public Estrella(int x, int y, Color color, int size) {
        super(x, y, color, size);
        estrella = new Polygon();
        double[] starPoints = {
                x, y - size,
                x + size / 2.5, y - size / 2.5,
                x + size, y,
                x + size / 2.5, y + size / 2.5,
                x, y + size,
                x - size / 2.5, y + size / 2.5,
                x - size, y,
                x - size / 2.5, y - size / 2.5
        };
        estrella.getPoints().addAll(toObject(starPoints));
        estrella.setFill(color);
    }


    /**
     * Convertimos el array de tipo primitivo
     * @param doubleArray array a convertir
     * @return array convertido
     */
    private Double[] toObject(double[] doubleArray) {
        Double[] result = new Double[doubleArray.length];
        for (int i = 0; i < doubleArray.length; i++) {
            result[i] = doubleArray[i];
        }
        return result;
    }

    /**
     * Dibujamos estrella
     * @param pnPanel panel donde lo dibujaremos
     */
    @Override
    public void dibujar(Pane pnPanel) {
        pnPanel.getChildren().add(estrella);
    }

    /**
     * Borramos la estrella
     * @param pnPanel panel donde lo borrará
     */
    @Override
    public void borrar(Pane pnPanel) {
        pnPanel.getChildren().remove(estrella);
    }

    /**
     * Cambiamos posicion de estrella
     * @param x eje x
     * @param y eje y
     */
    @Override
    public void cambiarPosicion(int x, int y) {
        setX(x);
        setY(y);
        double[] starPoints = {
                x, y - getSize(),
                x + getSize() / 2.5, y - getSize() / 2.5,
                x + getSize(), y,
                x + getSize() / 2.5, y + getSize() / 2.5,
                x, y + getSize(),
                x - getSize() / 2.5, y + getSize() / 2.5,
                x - getSize(), y,
                x - getSize() / 2.5, y - getSize() / 2.5
        };
        estrella.getPoints().setAll(toObject(starPoints));
    }

    /**
     * Cambiamos color de estrella
     * @param color color que obtendrá
     */
    @Override
    public void cambiarColor(Color color) {
        this.setColor(color);
        estrella.setFill(color);
    }

    /**
     * Cambiamos tamaño de estrella
     * @param size tamaño que obtendrá
     */
    @Override
    public void cambiarSize(int size) {
        setSize(size);
        double[] starPoints = {
                getX(), getY() - size,
                getX() + size / 2.5, getY() - size / 2.5,
                getX() + size, getY(),
                getX() + size / 2.5, getY() + size / 2.5,
                getX(), getY() + size,
                getX() - size / 2.5, getY() + size / 2.5,
                getX() - size, getY(),
                getX() - size / 2.5, getY() - size / 2.5
        };
        estrella.getPoints().setAll(toObject(starPoints));
    }

    /**
     * Movemos estrella
     * @param pnPanel panel donde lo moveremos
     */
    @Override
    public void moverFigura(Pane pnPanel) {
        int newX = getX() + getDeltaX();
        int newY = getY() + getDeltaY();
        if (newX <= 0 || newX + getSize() >= pnPanel.getWidth()) {
            setDeltaX(-getDeltaX());
        }
        if (newY <= 0 || newY + getSize() >= pnPanel.getHeight()) {
            setDeltaY(-getDeltaY());
        }
        cambiarPosicion(newX, newY);
    }
}