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
        for (String s : nums)
            sum += Integer.valueOf(s);

        return sum;
    }
}
