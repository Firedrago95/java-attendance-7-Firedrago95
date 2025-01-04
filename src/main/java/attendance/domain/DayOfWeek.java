package attendance.domain;

import java.time.LocalDate;
import java.util.Arrays;

public enum DayOfWeek {
    MON(1, "월"),
    TUE(2, "화"),
    WED(3, "수"),
    THI(4, "목"),
    FRI(5, "금"),
    SAT(6, "토"),
    SUN(7, "일");

    private int index;
    private String label;

    DayOfWeek(int index, String label) {
        this.index = index;
        this.label = label;
    }

    public int getIndex() {
        return index;
    }

    public String getLabel() {
        return label;
    }

    public static String findLabel(LocalDate date) {
        int value = date.getDayOfWeek().getValue();
        DayOfWeek dayOfWeek = Arrays.stream(values())
                .filter(w -> w.getIndex() == value)
                .findFirst().get();
        return dayOfWeek.getLabel();
    }
}
