package attendance.domain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AttendanceReader {

    public List<Member> readAttendanceRecords() {
        try {
            String filePath = "src/main/resources/attendances.csv";
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            return makeMembers(br);
        } catch (
            IOException e) {
            throw new IllegalArgumentException("[ERROR] 파일 읽기 도중 오류가 발생했습니다.");
        }
    }

    private static List<Member> makeMembers(BufferedReader br) throws IOException {
        List<Member> members = new ArrayList<>();
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            addMembers(members, line);
        }
        return members;
    }

    private static void addMembers(List<Member> members, String line) {
        String[] split = line.split(",");
        String name = split[0];
        if (hasNotName(name, members)) {
            members.add(new Member(name));
        }
        String attendance = split[1];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(attendance, formatter);
        addAttendanceRecord(name, localDateTime, members);
    }

    private static boolean hasNotName(String name, List<Member> members) {
        return !members.stream()
            .anyMatch(member -> member.getName().equals(name));
    }

    private static void addAttendanceRecord(String name, LocalDateTime time,List<Member> members) {
        Member findMember = members.stream()
            .filter(member -> member.getName().equals(name))
            .findFirst().get();
        findMember.addAttendanceRecord(time);
    }
}
