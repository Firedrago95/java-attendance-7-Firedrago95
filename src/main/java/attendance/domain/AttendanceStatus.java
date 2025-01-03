package attendance.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public enum AttendanceStatus {
    ATTENDANT("(출석)"),
    ABSENT("(결석)"),
    LATE("(지각)");

    private String label;

    AttendanceStatus(String label) {
        this.label = label;
    }

    public static AttendanceStatus findAttendanceStatus (LocalDate date, LocalTime time) {
        if (time == null) return ABSENT;
        if (date.getDayOfWeek().getValue() == 1) {
            return getStatus(13, time);
        }
        return getStatus(8, time);
    }

    private static AttendanceStatus getStatus(int openTime, LocalTime time) {
        LocalTime absentTime = LocalTime.of(openTime, 0).plusMinutes(30);
        LocalTime lateTime = LocalTime.of(openTime, 0).plusMinutes(5);
        if (time.isAfter(absentTime)) return ABSENT;
        if (time.isAfter(lateTime)) return LATE;
        return ATTENDANT;
    }

    public String getLabel() {
        return label;
    }
}
