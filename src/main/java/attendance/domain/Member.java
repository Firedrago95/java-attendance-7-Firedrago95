package attendance.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name;
    private List<LocalDateTime> attendanceRecord;

    public Member(String name) {
        this.name = name;
        this.attendanceRecord = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAttendanceRecord(LocalDateTime time) {
        attendanceRecord.add(time);
    }
}
