package com.example.cecilerobertm.amp.model;

/**
 * Created by michael on 17/02/16.
 */
public abstract class Envelope {
    private int length;
    private int width;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private int weight;
}
