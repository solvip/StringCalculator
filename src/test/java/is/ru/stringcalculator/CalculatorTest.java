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
}

