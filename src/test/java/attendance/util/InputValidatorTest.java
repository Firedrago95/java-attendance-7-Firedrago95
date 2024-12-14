package attendance.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"01:60"})
    void 시간_입력_예외_테스트(String input) {
        Assertions.assertThrows(IllegalArgumentException.class,
            () -> InputValidator.validateTime(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"01:59", "23:59"})
    void 정상_시간_입력_테스트(String input) {
        Assertions.assertDoesNotThrow(() -> InputValidator.validateTime(input));
    }
}