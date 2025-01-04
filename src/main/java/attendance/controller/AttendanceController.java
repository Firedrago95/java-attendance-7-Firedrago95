package attendance.controller;

import attendance.service.AttendanceService;
import attendance.util.TestTime;
import attendance.view.InputView;

public class AttendanceController {

    private AttendanceService service = new AttendanceService();

    public void run() {
        service.readFile();
        while (true) {
            String option = InputView.selectOption(TestTime.now());
            logAttendance(option);
        }
    }

    private void logAttendance(String option) {
        if (option.equals("1")) {

        }
    }

}
