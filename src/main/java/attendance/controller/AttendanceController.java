package attendance.controller;

import attendance.service.AttendanceService;

public class AttendanceController {

    private AttendanceService service = new AttendanceService();

    public void run() {
        service.readFile();
    }

}
