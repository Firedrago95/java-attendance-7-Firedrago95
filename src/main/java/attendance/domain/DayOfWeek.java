package attendance.domain;

import java.util.Arrays;

public enum DayOfWeek {
    MON("월",1),
    TUE("화",2),
    WED("수",3),
    THI("목",4),
    FRI("금",5),
    SAT("토",6),
    SUN("일",7);

    private String name;
    private int num;

    DayOfWeek(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public static String convertName(int num) {
        return Arrays.stream(values())
            .filter(dayOfWeek -> dayOfWeek.num == num)
            .findFirst().get().name;
    }
}
