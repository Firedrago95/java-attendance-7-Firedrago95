package attendance.controller;

import attendance.service.AttendanceService;
import attendance.view.InputView;
import attendance.view.OutputView;
import camp.nextstep.edu.missionutils.DateTimes;

import java.time.LocalDate;
import java.time.LocalTime;

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
            LocalDate now = DateTimes.now().toLocalDate();
            service.checkWeekendOrHoliday(now);
            String name = InputView.readName();
            service.validateRegistration(name);
            LocalTime time = InputView.readTime();
            service.validateAttendTime(time);
            String result = service.attend(name, now, time);
            OutputView.printAttendResult(result);
        }
    }

}
