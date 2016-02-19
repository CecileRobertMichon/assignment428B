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

    public Envelope(double length, double width, double weight) {
        this.length = length;
        this.width = width;
        this.weight = weight;
    }
}
