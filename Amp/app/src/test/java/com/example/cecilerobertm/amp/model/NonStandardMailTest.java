package com.example.cecilerobertm.amp.model;

import org.junit.Test;

import java.util.Random;

/**
 * Non-standard envelopes cannot exceed a length of 380 mm.
 * Non-standard envelopes cannot exceed a width of 270 mm.
 * Non-standard envelopes cannot exceed a weight of 500 g.
 * <p/>
 * The postal rate for non-standard envelopes up to 100 g is $0.98.
 * The postal rate for non-standard envelopes over 100 g up to 500 g is $2.40.
 */
public class NonStandardMailTest {

    private float getRandomInRange(float minimum, float maximum) {
        Random rand = new Random();
        return rand.nextFloat() * (maximum - minimum) + minimum;
    }

    /**
     * Test1 - Test that all the parameters are in the proper ranges without error
     */
    @Test
    public void TestInRange() {
        float length = getRandomInRange(0, 380);
        float width = getRandomInRange(0, 270);
        float weight = getRandomInRange(0, 500);

        NonStandardEnvelope nonStandardEnvelope = new NonStandardEnvelope(length, width, weight);

        assert nonStandardEnvelope instanceof NonStandardEnvelope;
    }

    /**
     * Test2 - Test that length, width and weight can be retrieved and set on the letter
     */
    @Test
    public void TestGettersAndSetters() {

        NonStandardEnvelope nonStandardEnvelope = new NonStandardEnvelope(150, 140, 20);

        float length = 200, width = 150, weight = 40;

        nonStandardEnvelope.setLength(length);
        assert nonStandardEnvelope.getLength() == length;

        nonStandardEnvelope.setWidth(width);
        assert nonStandardEnvelope.getWidth() == width;

        nonStandardEnvelope.setWeight(weight);
        assert nonStandardEnvelope.getWeight() == weight;
    }

    /**
     * Test3 - Test that when all the parameters are outside the proper ranges
     * there should be an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestAllOutsideOfRange() {
        float length = getRandomInRange(-1, 0);
        float width = getRandomInRange(-1, 0);
        float weight = getRandomInRange(-1, 0);

        new NonStandardEnvelope(length, width, weight);

        length = getRandomInRange(380, 1000);
        width = getRandomInRange(270, 1000);
        weight = getRandomInRange(500, 1000);

        new NonStandardEnvelope(length, width, weight);
    }

    /**
     * Test4 - Test that when all the parameters are above the proper ranges
     * there should be an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestLengthOutsideRange() {
        float length = getRandomInRange(-1, 0);
        float width = getRandomInRange(0, 270);
        float weight = getRandomInRange(0, 500);

        new NonStandardEnvelope(length, width, weight);

        length = getRandomInRange(380, 1000);
        new NonStandardEnvelope(length, width, weight);
    }

    /**
     * Test5 - Test length is outside of valid range
     * there should be an IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestWidthOutsideOfRange() {
        float length = getRandomInRange(0, 380);
        float width = getRandomInRange(-1, 0);
        float weight = getRandomInRange(0, 500);

        new NonStandardEnvelope(length, width, weight);

        width = getRandomInRange(270, 1000);
        new NonStandardEnvelope(length, width, weight);
    }

    /**
     * Test6 - Test width is outside of valid range
     * there should be an IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestWeightOutsideOfRange() {
        float length = getRandomInRange(0, 380);
        float width = getRandomInRange(0, 270);
        float weight = getRandomInRange(-1, 0);

        new NonStandardEnvelope(length, width, weight);

        weight = getRandomInRange(500, 1000);
        new NonStandardEnvelope(length, width, weight);
    }

    /**
     * Test7 - Test weight is outside of valid range
     * there should be an IllegalArgumentException
     */
    @Test
    public void TestGetCost() {
        float length = getRandomInRange(0, 380);
        float width = getRandomInRange(0, 270);
        float weight = getRandomInRange(0, 100);

        assert new NonStandardEnvelope(length, width, weight).getCost() == 0.98f;

        weight = getRandomInRange(100.01f, 500);
        assert new NonStandardEnvelope(length, width, weight).getCost() == 2.40f;
    }

}
