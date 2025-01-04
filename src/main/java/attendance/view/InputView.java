package attendance.view;

import attendance.util.DateFormatter;
import attendance.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.time.LocalDateTime;

public class InputView {

    public static final String OPTION_MESSAGE = "오늘은 %s입니다. 기능을 선택해 주세요.\n" +
            "1. 출석 확인\n" +
            "2. 출석 수정\n" +
            "3. 크루별 출석 기록 확인\n" +
            "4. 제적 위험자 확인\n" +
            "Q. 종료\n";

    public static String selectOption(LocalDateTime now) {
        System.out.printf(OPTION_MESSAGE, DateFormatter.formatDate(now.toLocalDate()));
        String input = Console.readLine();
        InputValidator.validateOption(input);
        return input;
    }
}
