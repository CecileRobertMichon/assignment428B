package com.example.cecilerobertm.amp.model;

public abstract class Envelope {
    private float length;
    private float width;
    private float weight;

    public float getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Envelope(float length, float width, float weight) {
        this.length = length;
        this.width = width;
        this.weight = weight;
    }
}
