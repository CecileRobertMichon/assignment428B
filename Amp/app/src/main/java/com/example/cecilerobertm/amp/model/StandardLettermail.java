package com.example.cecilerobertm.amp.model;

public class StandardLettermail extends Envelope {

    public StandardLettermail(double length, double width, double weight) {
        super(length, width, weight);
        validateInputs(length, width, weight);
    }

    public StandardLettermail(int length, int width, int weight) {
        super(length, width, weight);
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

    public float getCost() {
        if (0 <= this.getWeight() && this.getWeight() <= 30)
            return 0.49f;
        else if (30 < this.getWeight() && this.getWeight() <= 50)
            return 0.80f;
        else
            throw new IllegalArgumentException("Cost cannot be computed for the current range");
    }
}