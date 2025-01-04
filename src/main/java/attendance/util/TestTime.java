package attendance.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TestTime {

    public static LocalDateTime now() {
        LocalDate localDate = LocalDate.of(2024, 12, 14);
        return localDate.atTime(LocalTime.now());
    }
}
