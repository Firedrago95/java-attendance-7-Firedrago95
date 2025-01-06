package attendance.domain;

import attendance.constants.ErrorMessage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class Attendances {
    private List<Attendance> attendances;

    public Attendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public void validateRegisteredName(String name) {
        boolean isRegistered = attendances.stream()
                .anyMatch(attendance -> attendance.getName().equals(name));

        if (!isRegistered) {
            throw new IllegalArgumentException(ErrorMessage.NO_NAME.getMessage());
        }
    }

    public void validateDuplicateAttendance(String name, LocalDate date) {
        boolean isAttended = attendances.stream()
                .anyMatch(attendance -> attendance.getName().equals(name)
                        && attendance.getDate().equals(date)
                        && attendance.getTime() != null);

        if (isAttended) {
            throw new IllegalArgumentException(ErrorMessage.ALREADY_CHECK.getMessage());
        }
    }

    public String attend(String name, LocalDate date, LocalTime time) {
        Optional<Attendance> existingAttendance = attendances.stream()
                .filter(attendance -> attendance.getName().equals(name)
                        && attendance.getDate().equals(date)).findFirst();

        if (existingAttendance.isPresent()) {
            Attendance attendance = existingAttendance.get();
            attendance.setAttendanceTime(time);
            return attendance.toString();
        }

        Attendance attendance = new Attendance(name, date, time);
        attendances.add(attendance);
        return attendance.toString();
    }

    public void validateAttendanceRecord(String name, LocalDate date) {
        boolean hasAttendanceRecord = attendances.stream()
                .anyMatch(attendance -> attendance.getName().equals(name)
                        && attendance.getDate().equals(date));

        if (!hasAttendanceRecord) {
            throw new IllegalArgumentException(ErrorMessage.NO_ATTENDANCE_RECORD.getMessage());
        }
    }

    public String editAttendance(String name, LocalDate date, LocalTime time) {
        Attendance findAttendance = attendances.stream()
                .filter(attendance -> attendance.getName().equals(name)
                        && attendance.getDate().equals(date)).findFirst().get();

        return findAttendance.editAttendTime(time);
    }
}
