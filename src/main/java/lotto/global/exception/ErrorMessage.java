package lotto.global.exception;

public enum ErrorMessage {
    // 구매 금액 관련 에러
    INVALID_PURCHASE_AMOUNT_NOT_NUMBER(1001, "[ERROR] 숫자만 입력 가능합니다."),
    INVALID_PURCHASE_AMOUNT_MINIMUM(1002, "[ERROR] 로또 구입 금액은 1,000원 이상이어야 합니다."),
    INVALID_PURCHASE_AMOUNT_UNIT(1003, "[ERROR] 로또 구입은 1,000원 단위로 가능합니다."),
    INVALID_PURCHASE_AMOUNT_MAXIMUM(1004, "[ERROR] 로또 구입 금액은 100,000,000원을 초과할 수 없습니다."),

    // 로또 번호 관련 에러
    INVALID_LOTTO_NUMBER_RANGE(2001, "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_NUMBER_NOT_NUMBER(2002, "[ERROR] 로또 번호는 숫자만 입력 가능합니다."),

    // 당첨 번호 관련 에러
    INVALID_WINNING_NUMBERS_SIZE(3001, "[ERROR] 당첨 번호는 6개여야 합니다."),
    INVALID_WINNING_NUMBERS_DUPLICATE(3002, "[ERROR] 당첨 번호에 중복된 숫자가 있습니다."),
    INVALID_WINNING_NUMBERS_NOT_NUMBER(3003, "[ERROR] 당첨 번호는 숫자만 입력 가능합니다."),

    // 보너스 번호 관련 에러
    INVALID_BONUS_NUMBER_NOT_NUMBER(4001, "[ERROR] 보너스 번호는 숫자만 입력 가능합니다."),
    INVALID_BONUS_NUMBER_DUPLICATE(4002, "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."),

    // 입력 형식 관련 에러
    INVALID_INPUT_NOT_NUMBER(5001, "[ERROR] 숫자만 입력 가능합니다."),
    INVALID_WINNING_NUMBERS_FORMAT(5002, "[ERROR] 당첨 번호는 쉼표(,)로 구분해야 합니다."),

    // 게임 상태 관련 에러
    GAME_NOT_STARTED(6001, "[ERROR] 게임이 시작되지 않았습니다."),
    WINNING_NUMBERS_NOT_SET(6002, "[ERROR] 당첨 번호가 설정되지 않았습니다.");

    private final int code;
    private final String message;

    ErrorMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getFormattedMessage(Object... args) {
        return String.format(message, args);
    }
}
