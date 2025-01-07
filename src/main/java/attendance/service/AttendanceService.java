package attendance.service;

import attendance.domain.Attendance;
import attendance.domain.AttendanceStatus;
import attendance.domain.Attendances;
import attendance.domain.FileParser;
import attendance.util.AttendanceValidator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public class AttendanceService {

    private Attendances attendances;

    public void readFile() {
        FileParser fileParser = new FileParser();
        List<Attendance> attendancesRecords = fileParser.readFile();
        this.attendances = new Attendances(attendancesRecords);
    }

    public void validateRegistration(String name) {
        attendances.validateRegisteredName(name);
    }

    public void checkWeekendOrHoliday(LocalDate now) {
        AttendanceValidator.validateDate(now);
    }

    public void validateAttendTime(LocalTime time) {
        AttendanceValidator.validateTime(time);
    }

    public String attend(String name, LocalDate now, LocalTime time) {
        attendances.validateDuplicateAttendance(name, now);
        return attendances.attend(name, now, time) + System.lineSeparator();
    }

    public void checkFuture(LocalDate date) {
        AttendanceValidator.validateFutureDate(date);
    }

    public void hasAttendanceRecord(String name, LocalDate date) {
        attendances.validateAttendanceRecord(name, date);
    }

    public String editAttendance(String name, LocalDate date, LocalTime time) {
        return attendances.editAttendance(name, date, time);
    }

    public String getAttendanceRecord(String name, LocalDate today) {
        StringBuilder sb = new StringBuilder();
        List<Attendance> attendanceRecord = attendances.getAttendanceRecord(name, today);
        Map<AttendanceStatus, Integer> attendanceResult = AttendanceStatus.getAttendanceStatusResult(attendanceRecord);
        convertAttendanceRecordToString(attendanceRecord, sb);
        convertAttendanceResultToString(attendanceResult, sb);
        return sb.toString();
    }

    private void convertAttendanceRecordToString(List<Attendance> attendanceRecord, StringBuilder sb) {
        attendanceRecord.forEach(attendance -> {
            sb.append(attendance.toString()).append(System.lineSeparator());
        });
        sb.append(System.lineSeparator());
    }

    private void convertAttendanceResultToString(Map<AttendanceStatus, Integer> attendanceResult, StringBuilder sb) {
        for (AttendanceStatus attendanceStatus : attendanceResult.keySet()) {
            sb.append(String.format("%s: %d회%n",
                    removeParentheses(attendanceStatus.getLabel()), attendanceResult.get(attendanceStatus)));
        }
        sb.append(System.lineSeparator());

        analyzeAttendResult(attendanceResult, sb);
    }

    private static void analyzeAttendResult(Map<AttendanceStatus, Integer> attendanceResult, StringBuilder sb) {
        Integer absentCount = attendanceResult.get(AttendanceStatus.ABSENT);
        if (absentCount > 5) {
            sb.append("제적 대상자 입니다.").append(System.lineSeparator());
        }
        if (absentCount >= 3) {
            sb.append("면담 대상자 입니다.").append(System.lineSeparator());
        }
        if (absentCount >= 2) {
            sb.append("경고 대상자 입니다.").append(System.lineSeparator());
        }
    }

    private String removeParentheses(String label) {
        return label.substring(1, label.length() - 1);
    }

}
