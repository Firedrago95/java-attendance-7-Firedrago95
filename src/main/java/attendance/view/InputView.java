package attendance.view;

import attendance.util.DateFormatter;
import attendance.util.InputValidator;
import camp.nextstep.edu.missionutils.Console;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class InputView {

    public static final String OPTION_MESSAGE = "오늘은 %s입니다. 기능을 선택해 주세요.\n" +
            "1. 출석 확인\n" +
            "2. 출석 수정\n" +
            "3. 크루별 출석 기록 확인\n" +
            "4. 제적 위험자 확인\n" +
            "Q. 종료\n";
    public static final String NICNAME_MESSAGE = "닉네임을 입력해 주세요.";
    public static final String TIME_MESSAGE = "등교 시간을 입력해 주세요.";
    public static final String EDIT_NAME_MESSAGE = "출석을 수정하려는 크루의 닉네임을 입력해 주세요.";
    public static final String EDIT_DATE_MESSAGE = "수정하려는 날짜(일)를 입력해 주세요.";
    public static final String EDIT_TIME_MESSAGE = "언제로 변경하겠습니까?";

    public static String selectOption(LocalDateTime now) {
        System.out.printf(OPTION_MESSAGE, DateFormatter.formatDate(now.toLocalDate()));
        String input = Console.readLine();
        InputValidator.validateOption(input);
        return input;
    }

    public static String readName() {
        System.out.println(NICNAME_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateName(input);
        return input;
    }

    public static LocalTime readTime() {
        System.out.println(TIME_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateTime(input);
        return DateFormatter.parseTime(input);
    }

    public static String readEditName() {
        System.out.println(EDIT_NAME_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateName(input);
        return input;
    }

    public static LocalDate readEditDate() {
        System.out.println(EDIT_DATE_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateDate(input);
        return DateFormatter.parseDate(input);
    }

    public static LocalTime readEditTime() {
        System.out.println(EDIT_TIME_MESSAGE);
        String input = Console.readLine();
        InputValidator.validateTime(input);
        return DateFormatter.parseTime(input);
    }
}
