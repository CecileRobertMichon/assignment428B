package com.example.cecilerobertm.amp.model;

public class NonStandardEnvelope extends Envelope {

    public NonStandardEnvelope(float length, float width, float weight) {
        super(length, width, weight);

        validateInputs(length, width, weight);
    }

    public NonStandardEnvelope(int length, int width, int weight) {
        super(length, width, weight);

        validateInputs(length, width, weight);
    }

    public void validateInputs(float length, float width, float weight) throws IllegalArgumentException {
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

    public float getCost() {
        if (0 <= this.getWeight() && this.getWeight() <= 100)
            return 0.98f;
        else if (100 < this.getWeight() && this.getWeight() <= 500)
            return 2.40f;
        else
            throw new IllegalArgumentException("Cost cannot be computed for the current range");
    }
}
