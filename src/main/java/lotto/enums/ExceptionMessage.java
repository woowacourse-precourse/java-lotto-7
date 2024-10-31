package lotto.enums;

public enum ExceptionMessage {
    NOT_BLANK("빈 칸은 입력할 수 없습니다."),
    INVALID_MONEY_UNIT("금액의 단위는 1000원이어야 합니다."),
    DUPLICATE_NUMBER("로또 번호는 중복될 수 없습니다."),
    OUT_OF_RANGE("1부터 45 사이의 숫자만 입력 가능합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
