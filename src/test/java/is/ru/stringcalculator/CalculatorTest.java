package is.ru.stringcalculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testEmptyString() {
        Assert.assertEquals(0, Calculator.add(""));
    }

    @Test
    public void testSums() {
        String[] inputs = {
            "1",
            "1,2",
            "1,2,3",
            "1,3,4,2,1,4,5,7,12,5,124,213,4,5,5,4,3,3,4",
            "1,31,123,4537346,2352352,2352355,636346,4323,4,2,1,4,5,7,12,5,124,213,4,5,5,4,3,3,4",
            "1,2\n3",
            "1\n2\n3,4",
            "\n", 
        };
        int[] expectedValues = {
            1,
            3,
            6,
            409,
            9883282,
            6,
            10,
            0,
        };

        for(int i = 0; i < inputs.length; i++) {
            Assert.assertEquals(expectedValues[i], Calculator.add(inputs[i]));
        }
    }
}

