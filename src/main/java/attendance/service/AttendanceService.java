package attendance.service;

import attendance.domain.AttendanceReader;
import attendance.domain.Member;
import attendance.domain.Members;
import java.time.LocalDateTime;
import java.util.List;

public class AttendanceService {

    private Members members;

    public void readAttendanceRecord() {
        AttendanceReader reader = new AttendanceReader();
        List<Member> members = reader.readAttendanceRecords();
        this.members = new Members(members);
    }

    public boolean checkAttendance(String name, LocalDateTime time) {
        boolean alreadyAttend = members.checkAlreadyAttendance(name, time);
        if (!alreadyAttend) return false;
        members.attendance(name, time);
        return true;
    }

    public void checkExistName(String name) {
        members.isExist(name);
    }
}
