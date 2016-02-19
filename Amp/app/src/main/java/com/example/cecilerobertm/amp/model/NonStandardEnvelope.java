package com.example.cecilerobertm.amp.model;

public class NonStandardEnvelope {

    private double length;
    private double width;
    private double weight;

    public NonStandardEnvelope(double length, double width, double weight) {
        this.length = length;
        this.width = width;
        this.weight = weight;

        validateInputs(length, width, weight);
    }

    public void validateInputs(double length, double width, double weight) throws IllegalArgumentException {
        boolean validLength = 0 <= length && length <= 380;
        boolean validWidth = 0 <= width && width <= 270;
        boolean validWeight = 0 <= weight && weight <= 500;

        if (!validLength && !validWidth && !validWeight)
            throw new IllegalArgumentException("Length, Width and Weight are outside of valid ranges");

        if (!validLength)
            throw new IllegalArgumentException("Length is outside of valid range");

        if (!validWidth)
            throw new IllegalArgumentException("Width is outside of valid range");

        if (!validWeight)
            throw new IllegalArgumentException("Weight is outside of valid range");

    }

    public double getCost() {
        if (0 <= this.getWeight() && this.getWeight() <= 100)
            return 0.98;
        else
            return 2.40;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

}
