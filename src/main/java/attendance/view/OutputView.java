package attendance.view;

public class OutputView {
    public static void printAttendResult(String result) {
        System.out.println(result);
    }

    public static void printCrewAttendanceMessage(String name) {
        System.out.printf("이번 달 %s의 출석 기록입니다.%n", name);
        System.out.println();
    }
}
