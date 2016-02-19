package com.example.cecilerobertm.amp.model;

public abstract class Envelope {
    private double length;
    private double width;
    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Envelope(double length, double width, double weight) {
        this.length = length;
        this.width = width;
        this.weight = weight;
    }
}
