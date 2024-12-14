package attendance.util;

import attendance.constants.ErrorMessage;
import java.util.regex.Pattern;

public class InputValidator {


    private static final Pattern FUNCTION_REGEX = Pattern.compile("[1234Q]");

    public static void checkFunction(String input) {
        checkEmpty(input);
        check_Form(input);
    }

    private static void checkEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_VALUE.getMessage());
        }
    }

    private static void check_Form(String input) {
        if (!FUNCTION_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_FORM.getMessage());
        }
    }
}
