package attendance.domain;

import attendance.util.Formatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Member {

    private String name;
    private List<LocalDateTime> attendanceRecord;

    public Member(String name) {
        this.name = name;
        this.attendanceRecord = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAttendanceRecord(LocalDateTime time) {
        attendanceRecord.add(time);
    }

    public boolean hasAttendance(LocalDateTime time) {
        boolean match = attendanceRecord.stream()
            .anyMatch(record -> record.toLocalDate().isEqual(time.toLocalDate()));
        return match;
    }

    public void addAttendance(LocalDateTime time) {
        attendanceRecord.add(time);
    }

    public String editAttendance(LocalDateTime time) {
        LocalDate editDate = time.toLocalDate();
        LocalDateTime findDate = attendanceRecord.stream()
            .filter(record -> record.toLocalDate().equals(editDate))
            .findFirst().get();
        int index = attendanceRecord.indexOf(findDate);
        attendanceRecord.set(index, time);
        return makePrintForm(findDate, time);
    }

    private String makePrintForm(LocalDateTime findDate, LocalDateTime time) {
        StringBuilder sb = new StringBuilder();
        sb.append(Formatter.getFormat(findDate));
        sb.append(" -> ");
        sb.append(Formatter.getShortFormat(time));
        sb.append(" 수정 완료!");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        List<LocalDateTime> copy = new ArrayList<>(attendanceRecord);
        Collections.sort(copy);
        copy.forEach(s -> {
            sb.append(Formatter.getFormat(s) + System.lineSeparator());
        });
        return sb.toString();
    }
}
