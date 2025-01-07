package attendance.util;

import attendance.domain.DayOfWeek;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

    public static String formatTime(LocalTime time) {
        if (time == null) return "--:--";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(dateTimeFormatter);
    }

    public static LocalTime parseTime(String input) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(input, dateTimeFormatter);
    }

    public static LocalDate parseDate(String input) {
        int day = Integer.parseInt(input);
        return LocalDate.of(2024, 12, day);
    }
}
