package attendance.util;

import attendance.constants.ErrorMessage;

import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern _REGEX = Pattern.compile("");

    private static void checkEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_VALUE.getMessage());
        }
    }

    private static void check_Form(String input) {
        if (!_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_FORM.getMessage());
        }
    }
}
