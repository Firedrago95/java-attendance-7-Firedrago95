package attendance.util;

import attendance.domain.DayOfWeek;

import java.time.LocalDate;

public class DateFormatter {

    public static String formatDate(LocalDate date) {
        int monthValue = date.getMonthValue();
        int dayOfMonthValue = date.getDayOfMonth();
        String dayOfWeek = DayOfWeek.findLabel(date);

        return String.format("%s월 %s일 %s요일", formatTwo(monthValue), formatTwo(dayOfMonthValue), dayOfWeek);
    }

    private static String formatTwo(int monthValue) {
        return String.format("%02d", monthValue);
    }
}
