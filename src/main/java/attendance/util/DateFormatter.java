package attendance.util;

import attendance.domain.DayOfWeek;

import java.time.LocalDate;

public class DateFormatter {

    public static String formatDate(LocalDate date) {
        int monthValue = date.getMonthValue();
        int dayOfMonthValue = date.getDayOfMonth();
        String dayOfWeek = DayOfWeek.findLabel(date);

        return String.format("%d월 %d일 %s요일", monthValue, dayOfMonthValue, dayOfWeek);
    }
}
