package attendance.util;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class LateDesicion {

    public static String judgeTime(LocalDateTime time) {
        LocalTime attend = time.toLocalTime();
        LocalTime openTime = LocalTime.of(8, 00);
        LocalTime lateTime;
        LocalTime absenseTime;
        if (time.getDayOfWeek().getValue() == 1) {
            lateTime = LocalTime.of(13, 05);
            absenseTime = LocalTime.of(13, 30);
            if ((attend.equals(openTime)|| attend.isAfter(openTime))
                && attend.isBefore(lateTime)) {
                return "(출석)";
            }
            if ((attend.equals(lateTime) || attend.isAfter(lateTime))
                && attend.isBefore(absenseTime)) {
                return "(지각)";
            }
            return "(결석)";
        }
        lateTime = LocalTime.of(10,05);
        absenseTime = LocalTime.of(10, 30);
        if ((attend.equals(openTime)|| attend.isAfter(openTime))
            && attend.isBefore(lateTime)) {
            return "(출석)";
        }
        if ((attend.equals(lateTime) || attend.isAfter(lateTime))
            && attend.isBefore(absenseTime)) {
            return "(지각)";
        }
        return "(결석)";
    }
}
