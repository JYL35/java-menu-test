package menu.constant;

public enum ErrorMessage {
    IS_EMPTY("비어있습니다."),

    COACHES_OUT_OF_RANGE("코치의 수는 최소 2명, 최대 5명이어야 합니다."),
    COACH_NAME_OUT_OF_RANGE("코치의 이름은 2~4글자이어야 합니다."),
    COACHES_OVERLAP("코치들이 중복됩니다."),

    MENU_COUNT_OUT_OF_RANGE("못 먹는 메뉴의 수는 최소 0개, 최대 2개어야 합니다."),
    MENU_OVERLAP("메뉴들이 중복됩니다."),

    INVALID_FORMAT("잘못된 형식을 입력하였습니다."),
    NOT_FOUND_NICKNAME("등록되지 않은 닉네임입니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
