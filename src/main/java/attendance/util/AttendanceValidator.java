package attendance.util;

import attendance.constants.ErrorMessage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class AttendanceValidator {

    public static void validate(String name, LocalDate date, LocalTime time) {
        validateName(name);
        validateDate(date);
        validateTime(time);
    }

    private static void validateName(String name) {
        List<String> registeredMember = Arrays.asList("빙티", "이든", "빙봉", "짱수", "쿠키");
        if (!registeredMember.contains(name)) {
            throw new IllegalArgumentException(ErrorMessage.NO_NAME.getMessage());
        }
    }

    private static void validateDate(LocalDate date) {
        int dayOfWeek = date.getDayOfWeek().getValue();
        if (dayOfWeek == 6 || dayOfWeek == 7 || date.getDayOfMonth() == 25) {
            String formatDate = DateFormatter.formatDate(date);
            String errorMessage = ErrorMessage.NO_CLASS_DATE.getMessage();
            throw new IllegalArgumentException(String.format(errorMessage, formatDate));
        }
    }

    private static void validateTime(LocalTime time) {
        if (time == null) return;
        LocalTime openTime = LocalTime.of(8,0);
        LocalTime closeTime = LocalTime.of(23, 0);
        if (time.isBefore(openTime) || time.isAfter(closeTime)) {
            throw new IllegalArgumentException(ErrorMessage.NO_OPEN.getMessage());
        }
    }
}
