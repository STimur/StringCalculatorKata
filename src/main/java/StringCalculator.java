public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty())
            return 0;

        String delimitersExp = ",|\n";
        if (input.startsWith("//")) {
            delimitersExp = input.substring(2, input.indexOf("\n"));
            input = input.substring(input.indexOf("\n") + 1);
        }
        String[] nums = input.split(delimitersExp);
        int sum = 0;
        String msg = "negatives not allowed:";
        boolean negativesPresented = false;
        for (String s : nums) {
            int num = Integer.valueOf(s);
            if (num < 0) {
                msg += " " + num;
                negativesPresented = true;
            }
            sum += Integer.valueOf(s);
        }
        if (negativesPresented)
            throw new NegativesNotAllowedException(msg);

        return sum;
    }

    public static class NegativesNotAllowedException extends RuntimeException {
        public NegativesNotAllowedException(String message) {
            super(message);
        }
    }
}
