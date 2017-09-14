import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void calculateEmptyString() throws Exception {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void calculateOneNumber() throws Exception {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void calculateTwoNumbers() throws Exception {
        assertEquals(2, StringCalculator.add("1,1"));
    }

    @Test
    public void calculateWithNewlineInInput() throws Exception {
         assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void calculateWithCustomDefinedDelimiter() throws Exception {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
        assertEquals(3, StringCalculator.add("//:\n1:2"));
    }

    @Test
    public void addOneNegativeNumber() throws Exception {
        expectedException.expect(StringCalculator.NegativesNotAllowedException.class);
        expectedException.expectMessage("negatives not allowed: -1");
        StringCalculator.add("-1");
    }
}

