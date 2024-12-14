package attendance.controller;

import attendance.service.AttendanceService;
import attendance.util.AttendanceValidator;
import attendance.util.LateDesicion;
import attendance.view.InputView;
import attendance.view.OutputView;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AttendanceController {
    private AttendanceService service = new AttendanceService();

    public void run() {
        service.readAttendanceRecord();
        while (true) {
            String input = InputView.printFunction();
            if (input.equals("Q")) {
                break;
            }
            attendanceCheck(input);
            attendanceEdit(input);
        }

    }

    private void attendanceCheck(String input) {
        if (input.equals("1")) {
            AttendanceValidator.checkToday();
            String name = InputView.readName();
            service.checkExistName(name);
            LocalDateTime time = InputView.readTime();
            boolean alreadyCheck = service.checkAttendance(name, time);
            String message = LateDesicion.judgeTime(time);
            OutputView.printCheckAttendance(time, alreadyCheck, message);
        }
    }

    private void attendanceEdit(String input) {
        if (input.equals("2")) {
            String name = InputView.readEditName();
            service.checkExistName(name);
            LocalDate date = InputView.readDate();
            service.checkEditDate(date);
            LocalDateTime time = InputView.readEditTime(date);
            String message = service.editAttendance(name, time);
            OutputView.printEditmessage(message);
        }
    }

}
