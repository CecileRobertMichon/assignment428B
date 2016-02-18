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
        assert nonStandardEnvelope.getLength() >= 0 && nonStandardEnvelope.getLength() <= 380;
        assert nonStandardEnvelope.getWidth() >= 0 && nonStandardEnvelope.getWidth() <= 270;
        assert nonStandardEnvelope.getWeight() >= 0 && nonStandardEnvelope.getWeight() <= 500;
    }

    /**
     * Test2 - Test that all the parameters are outside the proper ranges
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestAllBelowRange() {
        float length = getRandomInRange(-1, 0);
        float width = getRandomInRange(-1, 0);
        float weight = getRandomInRange(-1, 0);

        new NonStandardEnvelope(length, width, weight);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestAllAboveRange() {
        float length = getRandomInRange(380, 1000);
        float width = getRandomInRange(270, 1000);
        float weight = getRandomInRange(500, 1000);

        new NonStandardEnvelope(length, width, weight);
    }

    /**
     * Test3 - Test length is outside of valid range
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestLengthBelowRange() {
        float length = getRandomInRange(-1, 0);
        float width = getRandomInRange(0, 270);
        float weight = getRandomInRange(0, 500);

        new NonStandardEnvelope(length, width, weight);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestLengthAboveRange() {
        float length = getRandomInRange(380, 1000);
        float width = getRandomInRange(0, 270);
        float weight = getRandomInRange(0, 500);

        new NonStandardEnvelope(length, width, weight);
    }

    /**
     * Test4 - Test width is outside of valid range
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestWidthBelowRange() {
        float length = getRandomInRange(0, 380);
        float width = getRandomInRange(-1, 0);
        float weight = getRandomInRange(0, 500);

        new NonStandardEnvelope(length, width, weight);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestWidthAboveRange() {
        float length = getRandomInRange(0, 380);
        float width = getRandomInRange(270, 1000);
        float weight = getRandomInRange(0, 500);

        new NonStandardEnvelope(length, width, weight);
    }

    /**
     * Test5 - Test weight is outside of valid range
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestWeightBelowRange() {
        float length = getRandomInRange(0, 380);
        float width = getRandomInRange(0, 270);
        float weight = getRandomInRange(-1, 0);

        new NonStandardEnvelope(length, width, weight);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestWeightAboveRange() {
        float length = getRandomInRange(0, 380);
        float width = getRandomInRange(0, 270);
        float weight = getRandomInRange(500, 1000);

        new NonStandardEnvelope(length, width, weight);
    }

    /**
     * Test6 - Test cost is either of two values based on two weight ranges
     */
    @Test
    public void TestCostInBottomRange() {
        float length = getRandomInRange(0, 380);
        float width = getRandomInRange(0, 270);
        float weight = getRandomInRange(0, 100);

        assert new NonStandardEnvelope(length, width, weight).getCost() == 0.98f;
    }

    @Test
    public void TestCostInTopRange() {
        float length = getRandomInRange(0, 380);
        float width = getRandomInRange(0, 270);
        float weight = getRandomInRange(100.01f, 500);

        assert new NonStandardEnvelope(length, width, weight).getCost() == 2.40f;
    }
}
