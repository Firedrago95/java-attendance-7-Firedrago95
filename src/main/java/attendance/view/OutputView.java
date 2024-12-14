package attendance.view;

import attendance.domain.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OutputView {

    public static void printCheckAttendance(LocalDateTime time,
        boolean alreadyCheck, String message) {
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = time.toLocalTime().format(formatDateTime);
        if (alreadyCheck) {
            System.out.println("이미 출석 하셨습니다. 출석 수정을 이용해주세요");
            return;
        }
        System.out.println(getFormat(time, message, formattedTime));
    }

    private static String getFormat(LocalDateTime time, String message, String formattedTime) {
        return String.format("%d월 %d일 %s요일 %s %s",
            time.getMonth().getValue(), time.getDayOfMonth(),
            DayOfWeek.convertName(time.getDayOfWeek().getValue()), formattedTime
            , message);
    }

    public static void printEditmessage(String message) {
        System.out.println(message);
    }
}
