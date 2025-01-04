package attendance.util;

import attendance.constants.ErrorMessage;

import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern OPTION_REGEX = Pattern.compile("[1234Q]");

    public static void validateOption(String input) {
        checkEmpty(input);
        checkOptionForm(input);
    }

    private static void checkEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_VALUE.getMessage());
        }
    }

    private static void checkOptionForm(String input) {
        if (!OPTION_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_FORM.getMessage());
        }
    }
}
