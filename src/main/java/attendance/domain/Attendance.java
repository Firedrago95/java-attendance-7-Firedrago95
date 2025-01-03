package attendance.domain;

import attendance.util.AttendanceValidator;

import java.time.LocalDate;
import java.time.LocalTime;

public class Attendance {
    private String name;
    private LocalDate date;
    private LocalTime time;
    private AttendanceStatus status;

    public Attendance(String name, LocalDate date, LocalTime time) {
        AttendanceValidator.validate(name, date, time);
        this.name = name;
        this.date = date;
        this.time = time;
        this.status = AttendanceStatus.findAttendanceStatus(date, time);
    }
}
