package lotto.exception;

public enum ErrorMessage {
    INVALID_NUMBER_COUNT ("로또 번호는 6개여야 합니다."),
    OUT_OF_RANGE_NUMBER("로또 번호는 1 ~ 45이어야 합니다."),
    DUPLICATE_NUMBER("로또 번호는 중복될 수 없습니다."),
    BLANK_MONEY("아무 것도 입력하지 않았습니다."),
    NOT_DIGIT_FORMAT("숫자 형식으로 입력해야 합니다."),
    NOT_DIVIDED_MONEY("1000원 단위로 입력해야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 로또 번호와 중복될 수 없습니다."),
    NOT_EXIST_RANK_STATE("Rank가 존재하지 않습니다");

    private final static String EXCEPTION_HEADER = "[ERROR] ";
    private final String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return EXCEPTION_HEADER + message;
    }
}
