package me.suski;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {

    @Test
    public void everyNthChar() {
        assertArrayEquals("el".toCharArray(),
                Utilities.everyNthChar("hello".toCharArray(), 2));

        assertArrayEquals("o".toCharArray(),
                Utilities.everyNthChar("hello".toCharArray(), 5));

        assertArrayEquals("hello".toCharArray(),
                Utilities.everyNthChar("hello".toCharArray(), 6));
    }

    @Test
    public void removePairs() {
        assertEquals("ABCDEF",
                Utilities.removePairs("AABCDDEFF"));

        assertEquals("ABCABDEF",
                Utilities.removePairs("ABCCABDEEF"));

        assertEquals("ABCDEF",
                Utilities.removePairs("ABCDEF"));

        assertEquals("ABCDEF",
                Utilities.removePairs("ABBBBBBCDEF"));

        assertEquals("ABCDEF",
                Utilities.removePairs("ABBBBBCDEF"));

        assertEquals("ABCDEF",
                Utilities.removePairs("ABBBBBCDEFFFFFFFF"));

        assertEquals("A",
                Utilities.removePairs("A"));

        assertEquals("A",
                Utilities.removePairs("AAAAAAAAAAAAA"));

        assertEquals("",
                Utilities.removePairs(""));

        assertNull(Utilities.removePairs(null));
    }

    @Test
    public void converter() {

        assertEquals(300, Utilities.converter(10, 5));
    }

    @Test(expected = ArithmeticException.class)
    public void converter_divide0() {

        assertEquals(300, Utilities.converter(10, 5));
        Utilities.converter(10,0);
    }

    @Test
    public void nullIfOddLength() {

        assertEquals("hello!", Utilities.nullIfOddLength("hello!"));
        assertNull(Utilities.nullIfOddLength("hello"));
    }
}