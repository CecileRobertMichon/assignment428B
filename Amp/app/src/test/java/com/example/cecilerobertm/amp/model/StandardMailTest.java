package com.example.cecilerobertm.amp.model;

import org.junit.Test;

import java.util.Random;

/**
 * A standard envelope has a minimum length of 140 mm and a maximum length of 245 mm.
 * A standard envelope has a minimum width of 90 mm and a maximum width of 156 mm.
 * A standard envelope has a minimum weight of 3.0 g.
 * A standard envelope has a maximum weight of 50.0 g.
 * <p/>
 * The postal rate for standard envelopes up to 30 g is $0.49.
 * The postal rate for standard envelopes over 30 g up to 50 g is $0.80.
 */
public class StandardMailTest {

    private float getRandomInRange(float minimum, float maximum) {
        Random rand = new Random();
        return rand.nextFloat() * (maximum - minimum) + minimum;
    }

    /**
     * Test1 - Test that all the parameters are in the proper ranges without error
     */
    @Test
    public void TestInRange() {
        float length = getRandomInRange(140, 245);
        float width = getRandomInRange(90, 156);
        float weight = getRandomInRange(3, 50);

        StandardLettermail standardLettermail = new StandardLettermail(length, width, weight);
        assert standardLettermail instanceof StandardLettermail;
    }

    /**
     * Test2 - Test that length, width and weight can be retrieved and set on the letter
     */
    @Test
    public void TestGettersAndSetters() {

        StandardLettermail standardLettermail = new StandardLettermail(150, 140, 20);

        float length = 200, width = 150, weight = 40;

        standardLettermail.setLength(length);
        assert standardLettermail.getLength() == length;

        standardLettermail.setWidth(width);
        assert standardLettermail.getWidth() == width;

        standardLettermail.setWeight(weight);
        assert standardLettermail.getWeight() == weight;
    }

    /**
     * Test3 - Test that when all the parameters are outside the proper ranges
     * there should be an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestAllBelowRange() {
        float length = getRandomInRange(0, 139.9f);
        float width = getRandomInRange(0, 89.9f);
        float weight = getRandomInRange(0, 2.9f);
        new StandardLettermail(length, width, weight);
    }

    /**
     * Test4 - Test that when all the parameters are above the proper ranges
     * there should be an IllegalArgumentException.
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestAllAboveRange() {
        float length = getRandomInRange(245, 1000);
        float width = getRandomInRange(90, 1000);
        float weight = getRandomInRange(50, 1000);
        new StandardLettermail(length, width, weight);
    }

    /**
     * Test5 - Test length is outside of valid range
     * there should be an IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestLengthOutsideOfRange() {
        float length = getRandomInRange(0, 139.9f);
        float width = getRandomInRange(90, 156);
        float weight = getRandomInRange(3, 50);
        new StandardLettermail(length, width, weight);

        length = getRandomInRange(245, 1000);
        new StandardLettermail(length, width, weight);
    }

    /**
     * Test6 - Test width is outside of valid range
     * there should be an IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestWidthOutsideRange() {
        float length = getRandomInRange(140, 245);
        float width = getRandomInRange(0, 89.9f);
        float weight = getRandomInRange(3, 50);
        new StandardLettermail(length, width, weight);

        width = getRandomInRange(156, 1000);
        new StandardLettermail(length, width, weight);
    }

    /**
     * Test7 - Test weight is outside of valid range
     * there should be an IllegalArgumentException
     */
    @Test(expected = IllegalArgumentException.class)
    public void TestWeightOutsideRange() {
        float length = getRandomInRange(140, 245);
        float width = getRandomInRange(90, 156);
        float weight = getRandomInRange(0, 3);
        new StandardLettermail(length, width, weight);

        weight = getRandomInRange(50, 1000);
        new StandardLettermail(length, width, weight);
    }

    /**
     * Test8 - Test cost is either of two values based on two weight ranges
     */
    @Test
    public void TestGetCost() {
        float length = getRandomInRange(140, 245);
        float width = getRandomInRange(90, 156);
        float weight = getRandomInRange(3, 30);

        StandardLettermail standardLettermail = new StandardLettermail(length, width, weight);
        assert standardLettermail.getCost() == 0.49f;

        weight = getRandomInRange(30, 50);
        standardLettermail.setWeight(weight);
        assert standardLettermail.getCost() == 0.80f;
    }
}
