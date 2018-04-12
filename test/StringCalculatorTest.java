import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
  @Test
  public void add_withEmptyInput() {
    assertThat(StringCalculator.add("")).isEqualTo("0");
  }

  @Test
  public void add_withOneNumber() {
    assertThat(StringCalculator.add("1")).isEqualTo("1");
    assertThat(StringCalculator.add("2")).isEqualTo("2");
  }

  @Test
  public void add_withTwoNumbers() {
    assertThat(StringCalculator.add("1,2")).isEqualTo("3");
    assertThat(StringCalculator.add("1.1,2.2")).isEqualTo("3.3");
  }

  @Test
  public void add_withManyNumbers() {
    assertThat(StringCalculator.add("1,2,3,4,5")).isEqualTo("15");
    assertThat(StringCalculator.add("1.1,2.2,3.03,4.004")).isEqualTo("10.334");
  }
}
