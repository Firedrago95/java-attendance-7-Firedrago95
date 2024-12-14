package attendance.domain;

import attendance.constants.ErrorMessage;
import java.time.LocalDateTime;
import java.util.List;

public class Members {

    private List<Member> members;

    public Members(List<Member> members) {
        this.members = members;
    }

    public void isExist(String name) {
        boolean isExist = members.stream()
            .anyMatch(member -> member.getName().equals(name));
        if(!isExist) {
            throw new IllegalArgumentException(ErrorMessage.NO_NICNAME.getMessage());
        }
    }

    public boolean checkAlreadyAttendance(String name, LocalDateTime time) {
        Member findMember = getFindMember(name);
        return findMember.hasAttendance(time);
    }

    public void attendance(String name, LocalDateTime time) {
        Member findMember = getFindMember(name);
        findMember.addAttendance(time);
    }

    public String editAttendance(String name, LocalDateTime time) {
        Member findMember = getFindMember(name);
        return findMember.editAttendance(time);
    }

    private Member getFindMember(String name) {
        Member findMember = members.stream()
            .filter(member -> member.getName().equals(name))
            .findFirst().get();
        return findMember;
    }
}
