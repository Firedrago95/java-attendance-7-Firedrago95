package attendance.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return getStatus(10, time);
    }

    private static AttendanceStatus getStatus(int openTime, LocalTime time) {
        LocalTime absentTime = LocalTime.of(openTime, 0).plusMinutes(30);
        LocalTime lateTime = LocalTime.of(openTime, 0).plusMinutes(5);
        if (time.isAfter(absentTime)) return ABSENT;
        if (time.isAfter(lateTime)) return LATE;
        return ATTENDANT;
    }

    public static Map<AttendanceStatus, Integer> getAttendanceStatusResult(List<Attendance> attendanceRecord) {
        Map<AttendanceStatus, Integer> map = new HashMap<>();
        AttendanceStatus[] values = values();
        for (AttendanceStatus value : values) {
            map.put(value, 0);
        }

        for (Attendance attendance : attendanceRecord) {
            AttendanceStatus status = attendance.getStatus();
            map.put(status, map.get(status) + 1);
        }

        Integer lateCount = map.get(AttendanceStatus.LATE);
        if (lateCount >= 3) {
            int addAbsentCount = lateCount / 3;
            map.put(AttendanceStatus.ABSENT, map.get(AttendanceStatus.ABSENT) + addAbsentCount);
            map.put(AttendanceStatus.LATE, lateCount % 3);
        }
        return map;
    }

    public String getLabel() {
        return label;
    }
}
