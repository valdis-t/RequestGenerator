package util.text;

public class DigitParser {
    private DigitParser() {
    }

    public static double toDouble(String source) {
        boolean commaDetected = false;
        char[] chars = source.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char current : chars) {
            if (Character.isDigit(current)) {
                builder.append(current);
            } else if (!commaDetected && builder.length() != 0 & (current == ',' || current == '.')) {
                commaDetected = true;
                builder.append('.');
            }
        }
        return builder.length() != 0 ? Double.parseDouble(builder.toString()) : 0;
    }

    public static int toInteger(String source) {
        String digitsOnly = source.replaceAll("[^0-9]", "");
        return digitsOnly.length() != 0 ? Integer.parseInt(digitsOnly) : 0;
    }
}
