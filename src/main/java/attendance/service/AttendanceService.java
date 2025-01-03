package attendance.service;

import attendance.domain.Attendance;
import attendance.domain.Attendances;
import attendance.domain.FileParser;

import java.util.List;

public class AttendanceService {

    private Attendances attendances;

    public void readFile() {
        FileParser fileParser = new FileParser();
        List<Attendance> attendancesRecords = fileParser.readFile();
        this.attendances = new Attendances(attendancesRecords);
    }
}
