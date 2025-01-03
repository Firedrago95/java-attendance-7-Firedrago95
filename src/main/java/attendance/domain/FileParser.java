package attendance.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FileParser {

    public List<Attendance> readFile() {
        try {
            String filePath = "src/main/resources/attendances.csv";
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            List<Attendance> attendances = new ArrayList<>();
            Set<String> attendedMember = new HashSet<>();
            LocalDate prevDate = null;
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                prevDate = createAttendance(line, attendedMember, attendances, prevDate);
            }
            handleAbsentMember(attendedMember, prevDate, attendances);
            return attendances;
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    private LocalDate createAttendance(String line, Set<String> attendedMember, List<Attendance> attendances, LocalDate prevDate) {
        String[] input = line.split(",");
        String[] dateAndTime = input[1].split(" ");
        String name = input[0];
        LocalDate date = LocalDate.parse(dateAndTime[0], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalTime time = LocalTime.parse(dateAndTime[1], DateTimeFormatter.ofPattern("HH:mm"));
        attendedMember.add(name);
        attendances.add(new Attendance(name, date, time));
        checkAbsent(attendedMember, attendances, prevDate, date);
        prevDate = date;
        return prevDate;
    }

    private void checkAbsent(Set<String> attendedMember, List<Attendance> attendances,
                             LocalDate prevDate, LocalDate date) {
        if (prevDate != null && !date.equals(prevDate)) {
            handleAbsentMember(attendedMember, prevDate, attendances);
            attendedMember.clear();
        }
    }

    private void handleAbsentMember(Set<String> attendedMember, LocalDate prevDate, List<Attendance> attendances) {
        List<String> absents = findAbsentMember(attendedMember);
        for (String absent : absents) {
            attendances.add(new Attendance(absent, prevDate, null));
        }
    }

    private List<String> findAbsentMember(Set<String> attendedMember) {
        List<String> absents = new ArrayList<>();
        List<String> registeredMember = Arrays.asList("빙티", "이든", "빙봉", "짱수", "쿠키");
        for (String m : registeredMember) {
            if (!attendedMember.contains(m)) {
                absents.add(m);
            }
        }
        return absents;
    }
}
