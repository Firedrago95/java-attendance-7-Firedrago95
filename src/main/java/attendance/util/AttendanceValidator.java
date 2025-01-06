package attendance.util;

import attendance.constants.ErrorMessage;
import camp.nextstep.edu.missionutils.DateTimes;

import java.time.LocalDate;
import java.time.LocalTime;

public class AttendanceValidator {

    public static void validateDate(LocalDate date) {
        int dayOfWeek = date.getDayOfWeek().getValue();
        if (dayOfWeek == 6 || dayOfWeek == 7 || date.getDayOfMonth() == 25) {
            String formatDate = DateFormatter.formatDate(date);
            String errorMessage = ErrorMessage.NO_CLASS_DATE.getMessage();
            throw new IllegalArgumentException(String.format(errorMessage, formatDate));
        }
    }

    public static void validateTime(LocalTime time) {
        if (time == null) return;
        LocalTime openTime = LocalTime.of(8,0);
        LocalTime closeTime = LocalTime.of(23, 0);
        if (time.isBefore(openTime) || time.isAfter(closeTime)) {
            throw new IllegalArgumentException(ErrorMessage.NO_OPEN.getMessage());
        }
    }

    public static void validateFutureDate(LocalDate date) {
        if (date.isAfter(DateTimes.now().toLocalDate())) {
            throw new IllegalArgumentException(ErrorMessage.FUTURE.getMessage());
        }
    }
}
