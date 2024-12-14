package attendance.util;

import attendance.domain.DayOfWeek;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDateTime;

public class AttendanceValidator {

    public static void checkToday() {
        LocalDateTime now = DateTimes.now();
        if (now.getDayOfWeek().getValue() == 6 || now.getDayOfWeek().getValue() == 7) {
            String message = String.format("[ERROR] %d월 %d일 %s요일은 등교일이 아닙니다.",
                now.getMonth().getValue(), now.getDayOfMonth(), DayOfWeek.convertName(now.getDayOfWeek().getValue()));
            throw new IllegalArgumentException(message);
        }
    }
}
