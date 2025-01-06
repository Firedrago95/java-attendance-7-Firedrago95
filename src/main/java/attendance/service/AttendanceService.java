package attendance.service;

import attendance.domain.Attendance;
import attendance.domain.Attendances;
import attendance.domain.FileParser;
import attendance.util.AttendanceValidator;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
        return attendances.attend(name, now, time);
    }
}
