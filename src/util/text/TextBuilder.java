package util.text;

public class TextBuilder {
    private final StringBuilder builder;

    public TextBuilder() {
        builder = new StringBuilder();
    }

    public TextBuilder append(boolean predicate, String trueText, String falseText) {
        builder.append(predicate ? trueText + StringDefaultValue.NEW_LINE_TEXT : falseText + StringDefaultValue.NEW_LINE_TEXT);
        return this;
    }

    public TextBuilder append(boolean predicate, String trueText) {
        builder.append(predicate ? trueText + StringDefaultValue.NEW_LINE_TEXT : StringDefaultValue.EMPTY_TEXT);
        return this;
    }

    public TextBuilder append(String text, String prefixedText) {
        builder.append(text.trim().equals(StringDefaultValue.EMPTY_TEXT) ? StringDefaultValue.EMPTY_TEXT : prefixedText + " " + text + StringDefaultValue.NEW_LINE_TEXT);
        return this;
    }

    public TextBuilder append(String text) {
        builder.append(text.trim().equals(StringDefaultValue.EMPTY_TEXT) ? StringDefaultValue.EMPTY_TEXT : text + StringDefaultValue.NEW_LINE_TEXT);
        return this;
    }

    public TextBuilder appendAsDigit(String text, boolean isDouble) {
        if (isDouble) {
            builder.append(DigitParser.toDouble(text));
        } else {
            builder.append(DigitParser.toInteger(text));
        }
        builder.append(StringDefaultValue.NEW_LINE_TEXT);
        return this;
    }

    @Override
    public String toString() {
        try {
            return builder.toString();
        } finally {
            builder.setLength(0);
        }
    }
}
