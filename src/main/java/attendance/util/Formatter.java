package attendance.util;

import attendance.domain.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Formatter {

    public static String getFormat(LocalDateTime time) {
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = time.toLocalTime().format(formatDateTime);
        return String.format("%d월 %d일 %s요일 %s %s",
            time.getMonth().getValue(), time.getDayOfMonth(),
            DayOfWeek.convertName(time.getDayOfWeek().getValue()), formattedTime, LateDesicion.judgeTime(time));
    }

    public static String getShortFormat(LocalDateTime time) {
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = time.toLocalTime().format(formatDateTime);
        return String.format("%s %s", formattedTime, LateDesicion.judgeTime(time));
    }
}
