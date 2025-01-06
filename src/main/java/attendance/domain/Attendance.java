package attendance.domain;

import attendance.util.DateFormatter;

import java.time.LocalDate;
import java.time.LocalTime;

public class Attendance {
    private String name;
    private LocalDate date;
    private LocalTime time;
    private AttendanceStatus status;

    public Attendance(String name, LocalDate date, LocalTime time) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.status = AttendanceStatus.findAttendanceStatus(date, time);
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s",
                DateFormatter.formatDate(date), DateFormatter.formatTime(time), status.getLabel());
    }

    public void setAttendanceTime(LocalTime attendedTime) {
        this.time = attendedTime;
        this.status = AttendanceStatus.findAttendanceStatus(date, attendedTime);
    }

    public String editAttendTime(LocalTime time) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.toString());
        this.setAttendanceTime(time);
        sb.append(" -> ");
        sb.append(DateFormatter.formatTime(this.time) + " " + this.status.getLabel());
        sb.append(" 수정 완료!");
        return sb.toString();
    }
}
