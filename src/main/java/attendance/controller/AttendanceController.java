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
            editAttendance(option);
            readCrewAttendanceRecord(option);
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

    private void editAttendance(String option) {
        if (option.equals("2")) {
            String name = InputView.readEditName();
            service.validateRegistration(name);
            LocalDate date = InputView.readEditDate();
            service.checkWeekendOrHoliday(date);
            service.checkFuture(date);
            service.hasAttendanceRecord(name, date);
            LocalTime time = InputView.readEditTime();
            service.validateAttendTime(time);
            String result = service.editAttendance(name, date, time);
            OutputView.printAttendResult(result);
        }
    }

    private void readCrewAttendanceRecord(String option) {
        if (option.equals("3")) {
            String name = InputView.readName();
            service.validateRegistration(name);
            OutputView.printCrewAttendanceMessage(name);
            String attendanceRecord = service.getAttendanceRecord(name, DateTimes.now().toLocalDate());
            OutputView.printAttendResult(attendanceRecord);
        }
    }

}
