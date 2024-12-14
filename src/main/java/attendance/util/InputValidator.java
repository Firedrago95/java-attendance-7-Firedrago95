package attendance.util;

import attendance.constants.ErrorMessage;
import java.util.regex.Pattern;

public class InputValidator {


    private static final Pattern FUNCTION_REGEX = Pattern.compile("[1234Q]");
    private static final Pattern NAME_REGEX = Pattern.compile("[가-힣]+");
    private static final Pattern TIME_REGEX = Pattern.compile("(0[0-9]|1[1-9]|2[0-3]):([0-5][0-9])");

    public static void checkFunction(String input) {
        checkEmpty(input);
        checkFunctionForm(input);
    }

    private static void checkEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_VALUE.getMessage());
        }
    }

    private static void checkFunctionForm(String input) {
        if (!FUNCTION_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_FORM.getMessage());
        }
    }

    public static void validateName(String input) {
        checkEmpty(input);
        checkNameForm(input);
    }

    private static void checkNameForm(String input) {
        if (!NAME_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_FORM.getMessage());
        }
    }

    public static void validateTime(String input) {
        checkEmpty(input);
        checkTimeForm(input);
    }

    private static void checkTimeForm(String input) {
        if (!TIME_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_FORM.getMessage());
        }
    }
}
