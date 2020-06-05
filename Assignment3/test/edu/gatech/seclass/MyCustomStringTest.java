package edu.gatech.seclass;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Junit test class created for use in Georgia Tech CS6300.
 *
 * You should implement your tests in this class.
 */

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    /*** name="[countNumbers] First example in the interface documentation", number="Student Test 1" ***/
    public void testCountNumbersS1() {
        mycustomstring.setString("My numbers are 11, 96, and thirteen");
        assertEquals(2, mycustomstring.countNumbers());
    }

    @Test
    /*** name="[countNumbers] Counting in an empty string", number="Student Test 2" ***/
    public void testCountNumbersS2() {
        mycustomstring.setString("");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test 
    /*** name="[addNumber] First example in the interface documentation", number="Student Test 3" ***/
    public void testAddNumberS1() {
        mycustomstring.setString("hello 90, bye 2");
        assertEquals("hello 110, bye 22", mycustomstring.addNumber(20, false));
    }

    @Test
    /*** name="[addNumber] reverse the added number", number="Student Test 4" ***/
    public void testAddNumbersS2() {
        mycustomstring.setString("hello 90, bye 2");
        assertEquals("hello 801, bye 02", mycustomstring.addNumber(18, true));
    }

    @Test(expected = IllegalArgumentException.class)
    /*** name="[addNumber] adding negative number illegal", number="Student Test 5" ***/
    public void testAddNumbersS3() {
        mycustomstring.setString("1234567890");
        assertEquals("90123456788", mycustomstring.addNumber(-30, false));
    }

    @Test
    /*** name="[convertDigitsToNamesInSubstring] First example in the interface documentation", number="Student Test 6" ***/
    public void testConvertDigitsToNamesInSubstringS1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZEROme dONESIX1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test (expected = MyIndexOutOfBoundsException.class)
    /*** name="[convertDigitsToNamesInSubstring] index out of bounds test", number="Student Test 7" ***/
    public void testConvertDigitsToNamesInSubstringS2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 80);
        assertEquals("I'd b3tt3r put sZEROme dONESIX1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test (expected = IllegalArgumentException.class)
    /*** name="[convertDigitsToNamesInSubstring] startPostion > endPosition", number="Student Test 8" ***/
    public void testConvertDigitsToNamesInSubstringS3() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(20, 16);
        assertEquals("I'd b3tt3r put sZEROme dONESIX1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test
    /*** name="[convertDigitsToNamesInSubstring] given example", number="Student Test 9" ***/
    public void testConvertDigitsToNamesInSubstringS4() {
        mycustomstring.setString("abc416d");
        mycustomstring.convertDigitsToNamesInSubstring(2, 7);
        assertEquals("abcFOURONESIXd", mycustomstring.getString());
    }

    @Test
    /*** name="[convertDigitsToNamesInSubstring] whole string is a number", number="Student Test 10" ***/
    public void testConvertDigitsToNamesInSubstringS5() {
        mycustomstring.setString("123 456 **007**");
        mycustomstring.convertDigitsToNamesInSubstring(1, 15);
        assertEquals("ONETWOTHREE FOURFIVESIX **ZEROZEROSEVEN**", mycustomstring.getString());
    }

}
