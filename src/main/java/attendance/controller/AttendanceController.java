package attendance.controller;

import attendance.service.AttendanceService;
import attendance.util.AttendanceValidator;
import attendance.view.InputView;

public class AttendanceController {
    private AttendanceService service = new AttendanceService();

    public void run() {
        service.readAttendanceRecord();
        while (true) {
            String input = InputView.printFunction();
            if (input.equals("Q")) {
                break;
            }
            if (input.equals("1")) {
                AttendanceValidator.checkToday();
            }
        }

    }

}
