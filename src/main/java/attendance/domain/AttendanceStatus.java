package attendance.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum AttendanceStatus {
    ATTENDANT("(출석)"),
    LATE("(지각)"),
    ABSENT("(결석)");

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
        Map<AttendanceStatus, Integer> attendanceCountMap = initializeAttendanceCountMap();
        updateAttendanceCounts(attendanceRecord, attendanceCountMap);
        adjustLateToAbsent(attendanceCountMap);
        return attendanceCountMap;
    }

    private static Map<AttendanceStatus, Integer> initializeAttendanceCountMap() {
        Map<AttendanceStatus, Integer> map = new LinkedHashMap<>();
        for (AttendanceStatus status : AttendanceStatus.values()) {
            map.put(status, 0);
        }
        return map;
    }

    private static void updateAttendanceCounts(List<Attendance> attendanceRecord, Map<AttendanceStatus, Integer> map) {
        for (Attendance attendance : attendanceRecord) {
            map.compute(attendance.getStatus(), (status, count) -> count + 1);
        }
    }

    private static void adjustLateToAbsent(Map<AttendanceStatus, Integer> map) {
        int lateCount = map.get(AttendanceStatus.LATE);
        int addAbsentCount = lateCount / 3;
        map.put(AttendanceStatus.ABSENT, map.get(AttendanceStatus.ABSENT) + addAbsentCount);
        map.put(AttendanceStatus.LATE, lateCount % 3);
    }

    public String getLabel() {
        return label;
    }
}
