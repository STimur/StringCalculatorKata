import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    @Test
    public void calculateEmptyString() throws Exception {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void calculateOneNumber() throws Exception {
        assertEquals(1, StringCalculator.add("1"));
    }
}

