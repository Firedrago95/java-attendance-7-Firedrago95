package attendance.util;

import attendance.constants.ErrorMessage;

import java.util.regex.Pattern;

public class InputValidator {

    private static final Pattern OPTION_REGEX = Pattern.compile("[1234Q]");
    private static final Pattern NAME_REGEX = Pattern.compile("[가-힣]+");
    private static final Pattern TIME_REGEX = Pattern.compile("([0-1][0-9]|2[0-3]):([0-5][0-9])");
    private static final Pattern DATE_REGEX = Pattern.compile("[1-9]|[1-2][0-9]|3[0-1]");

    public static void validateOption(String input) {
        checkEmpty(input);
        checkOptionForm(input);
    }

    public static void validateName(String input) {
        checkEmpty(input);
        checkNameForm(input);
    }

    public static void validateTime(String input) {
        checkEmpty(input);
        checkTimeForm(input);
    }

    public static void validateDate(String input) {
        checkEmpty(input);
        checkDateForm(input);
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

    private static void checkNameForm(String input) {
        if (!NAME_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_FORM.getMessage());
        }
    }

    private static void checkTimeForm(String input) {
        if (!TIME_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_FORM.getMessage());
        }
    }

    private static void checkDateForm(String input) {
        if (!DATE_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_FORM.getMessage());
        }
    }
}
