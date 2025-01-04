package attendance.controller;

import attendance.service.AttendanceService;
import attendance.view.InputView;
import camp.nextstep.edu.missionutils.DateTimes;

public class AttendanceController {

    private AttendanceService service = new AttendanceService();

    public void run() {
        service.readFile();
        while (true) {
            String option = InputView.selectOption(DateTimes.now());
            logAttendance(option);
        }
    }

    private void logAttendance(String option) {
        if (option.equals("1")) {

        }
    }

}
