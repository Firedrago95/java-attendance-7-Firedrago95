package attendance.util;

import java.time.LocalDate;

public class DateFormatter {

    public static String formatDate(LocalDate date) {
        int monthValue = date.getMonthValue();
        int dayOfMonthValue = date.getDayOfMonth();
        String dayOfWeek = findDayOfWeek(date);

        return String.format("%d월 %d일 %s요일", monthValue, dayOfMonthValue, dayOfWeek);
    }
}
