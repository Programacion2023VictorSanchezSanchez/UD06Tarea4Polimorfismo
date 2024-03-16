package com.example.ud06tarea4polimorfismo.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public abstract class Figura {
    protected int x;
    protected int y;
    protected int deltaX = 2;
    protected int deltaY = 1;

    protected Color color;
    protected int size;

    //Constructor
    public Figura(int x, int y, Color color, int size) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.size = size;
    }

    //Getter y setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //Metodos que heredaran el resto de figuras
    public void dibujar(Pane pnPanel) {}
    public void borrar(Pane pnPanel) {}
    public void cambiarPosicion(int x, int y) {}
    public void cambiarColor(Color color) {}
    public void cambiarSize(int size) {}
    public void moverFigura(Pane pnPanel) {}


}
