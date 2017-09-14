public class StringCalculator {
    public static int add(String input) {
        if (input.isEmpty())
            return 0;

        String[] nums = input.split(",");
        int sum = 0;
        for (String s : nums)
            sum += Integer.valueOf(s);

        return sum;
    }
}
