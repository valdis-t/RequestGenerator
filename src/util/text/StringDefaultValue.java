package util.text;

import boot.Authentication;

public interface StringDefaultValue {
    String EMPTY_TEXT = Authentication.getAllowedText();
    String NEW_LINE_TEXT = "\n";
    String SPACE = " ";
    String OLD_SPACE = "_";
    String DIVIDER = "******************************\n";
}