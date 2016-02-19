package com.example.cecilerobertm.amp.model;

public class StandardLettermail {

    private double length, width, weight;

    public StandardLettermail(double length, double width, double weight) {
        this.length = length;
        this.width = width;
        this.weight = weight;

        validateInputs(length, width, weight);
    }

    public void validateInputs(double length, double width, double weight) throws IllegalArgumentException {
        boolean validLength = 140 <= length && length <= 245;
        boolean validWidth = 90 <= width && width <= 156;
        boolean validWeight = 3.0f <= weight && weight <= 50.0f;

        if (!validLength && !validWidth && !validWeight)
            throw new IllegalArgumentException("Length, Width and Weight are outside of valid ranges");

        if (!validLength)
            throw new IllegalArgumentException("Length is outside of valid range");

        if (!validWidth)
            throw new IllegalArgumentException("Width is outside of valid range");

        if (!validWeight)
            throw new IllegalArgumentException("Weight is outside of valid range");

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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public float getCost() {
        if (0 <= this.getWeight() && this.getWeight() <= 30)
            return 0.49f;
        else
            return 0.80f;
    }
}