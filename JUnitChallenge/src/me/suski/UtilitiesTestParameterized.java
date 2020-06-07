package me.suski;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class UtilitiesTestParameterized {

    private String input;
    private String output;


    public UtilitiesTestParameterized(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][]{
                {"ABCDEFF","ABCDEF"},
                {"AB88EFFG","AB8EFG"},
                {"112233445566","123456"},
                {"ZYZQQB","ZYZQB"},
                {"A", "A"}

        });
    }

    @Test
    public void removePairs() throws Exception {
        assertEquals(output, Utilities.removePairs(input));
    }

}
