package is.ru.stringcalculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testEmptyString() {
        Assert.assertEquals(0, Calculator.add(""));
    }

    @Test
    public void testSimpleSums() {
        Assert.assertEquals(1, Calculator.add("1"));
        Assert.assertEquals(3, Calculator.add("1,2"));
    }

    @Test
    public void testComplicatedSums() {
        String input = "1,3,4,2,1,4,5,7,12,5,124,213,4,5,5,4,3,3,4";
        Assert.assertEquals(409, Calculator.add(input));
    }
}

