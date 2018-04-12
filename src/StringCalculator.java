public class StringCalculator {
  public static String add(String input) {
    if (input.length() == 0)
      return "0";

    String[] operands = input.split(",");
    if (operands.length > 1)
      return addOperands(operands);

    return input;
  }

  private static String addOperands(String[] operands) {
    int lengthOfFractionalPart = getMaxLengthOfFractionPart(operands);
    if (lengthOfFractionalPart > 0) {
      int lengthOfIntegralPart = addFloatOperands(operands).indexOf('.');
      return addFloatOperands(operands).substring(0, lengthOfIntegralPart + ".".length() + lengthOfFractionalPart);
    }
    return addIntegerOperands(operands);
  }

  private static String addIntegerOperands(String[] operands) {
    int sum = 0;
    for (String operand : operands)
      sum += Integer.valueOf(operand);
    return String.valueOf(sum);
  }

  private static String addFloatOperands(String[] operands) {
    float sum = 0;
    for (String operand : operands)
      sum += Float.valueOf(operand);
    return String.valueOf(sum);
  }

  private static int getMaxLengthOfFractionPart(String[] operands) {
    int maxLength = 0;
    if (operands[0].indexOf('.') != -1)
      maxLength = operands[0].substring(operands[0].indexOf('.') + 1).length();
    for (int i = 1; i < operands.length; i++)
      if (operands[i].indexOf('.') != -1)
        if (operands[i].substring(operands[i].indexOf('.') + 1).length() > maxLength)
          maxLength = operands[i].substring(operands[i].indexOf('.') + 1).length();
    return maxLength;
  }
}
