package attendance.view;

import attendance.domain.DayOfWeek;
import attendance.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.DateTimes;
import java.time.LocalDateTime;

public class InputView {

    public static final String TODAY_MESSAGE = "오늘은 %d월 %d일 %s요일입니다. 기능을 선택해 주세요.\n";
    public static final String FUCTIONS = "1. 출석 확인\n"
        + "2. 출석 수정\n"
        + "3. 크루별 출석 기록 확인\n"
        + "4. 제적 위험자 확인\n"
        + "Q. 종료";

    public static String printFunction() {
        LocalDateTime now = DateTimes.now();
        System.out.println(String.format(TODAY_MESSAGE, now.getMonth().getValue(),
            now.getDayOfMonth() , DayOfWeek.convertName(now.getDayOfWeek().getValue())));
        System.out.println(FUCTIONS);
        String input = Console.readLine();
        InputValidator.checkFunction(input);
        return input;
    }
}
