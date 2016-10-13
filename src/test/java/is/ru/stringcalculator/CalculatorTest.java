package is.ru.stringcalculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    /* Assert that the empty input string results in 0 */
    @Test
    public void testEmptyString() {
        Assert.assertEquals(0, Calculator.add(""));
    }

    /* Assert that valid input strings correctly sum */
    @Test
    public void testSums() {
        String[] inputs = {
            "1",
            "1,2",
            "1,2,3",
            "1,3,4,2,1,4,5,7,12,5,124,213,4,5,5,4,3,3,4",
            "1,2\n3",
            "1\n2\n3,4",
            "\n", 
        };
        int[] expectedValues = {
            1,
            3,
            6,
            409,
            6,
            10,
            0,
        };

        for(int i = 0; i < inputs.length; i++) {
            Assert.assertEquals(expectedValues[i], Calculator.add(inputs[i]));
        }
    }

    /* Assert that values larger than 1000 are ignored */
    @Test
    public void testLargeValuesIgnored() {
        Assert.assertEquals(0, Calculator.add("1001"));
        Assert.assertEquals(2, Calculator.add("1001,2"));
        String input = "1,31,123,4537346,2352352,2352355,636346,4323,4,2,1,4,5,7,12,5,124,213,4,5,5,4,3,3,4";
        Assert.assertEquals(560, Calculator.add(input));
    }

    /* Assert that inputs with negative numbers throw an exception */
    @Test
    public void testNegativeInputThrows() {
        try {
            Calculator.add("1,-1,1");
            Assert.fail("Expected negative inputs to throw an exception, but I got none");
        } catch(IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Negatives not allowed: -1");
        }

        try {
            Calculator.add("2,-4,3,-5");
            Assert.fail("Expected negative inputs to throw an exception, but I got none");
        } catch(IllegalArgumentException e) {
            Assert.assertEquals(e.getMessage(), "Negatives not allowed: -4,-5");
        }
    }

    /* Assert that we can use custom different input delimiters */
    @Test
    public void testCustomInputDelimiters() {
        Assert.assertEquals(0, Calculator.add("//;\n0"));
        Assert.assertEquals(3, Calculator.add("//-\n0-1-2"));
        Assert.assertEquals(3, Calculator.add("//ff\n0ff1ff2"));
    }
}

