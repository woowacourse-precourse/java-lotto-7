package lotto.enums;

import static lotto.enums.Constants.*;

public enum ExceptionMessage {
    NOT_INT("정수를 입력해주세요."),
    INVALID_MONEY_UNIT(String.format("%d원 단위로 입력해야합니다.", MONEY_UNIT.getValue())),
    ZERO_EXCEPTION("0 이상의 수를 입력해주세요."),
    INVALID_NUMBER_OF_WINNING_NUMBERS("당첨 번호의 갯수는 6개여야 합니다."),
    INVALID_WINNING_NUM_RANGE("당첨 번호는 1이상 45이여야 합니다."),
    INVALID_WINNING_NUM_DUPLICATE("중복된 당첨번호가 있어서는 안됩니다.")
    ;

    public static final String BASE_MESSAGE = "[ERROR] %s";

    private final String message;


    ExceptionMessage(String message) {
        this.message = String.format((BASE_MESSAGE), message);
    }

    public String getMessage() {
        return message;
    }
}
