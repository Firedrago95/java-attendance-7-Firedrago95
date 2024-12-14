package attendance.constants;

public enum ErrorMessage {

    EMPTY_VALUE("빈 값을 입력하셨습니다. 값을 입력해주세요."),
    WRONG_FORM("잘못된 형식을 입력하였습니다."),
    NO_NICNAME("등록되지 않은 닉네임입니다."),
    FUTURE_EDIT("아직 수정할 수 없습니다."),
    NO_TIME("캠퍼스 운영 시간에만 출석이 가능합니다."),
    ALREADY_CHECK("이미 출석을 확인하였습니다. 필요한 경우 수정 기능을 이용해 주세요.");

    private final String PREFIX = "[ERROR] ";
    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
