package lotto.exception;

public enum ErrorMessage {
    NULL_INPUT("[ERROR] NULL을 입력할 수 없습니다."),
    EMPTY_INPUT("[ERROR] 빈 문자열을 입력할 수 없습니다."),

    NOT_INTEGER("[ERROR] 정수가 아닌 값을 입력할 수 없습니다."),

    NOT_NEGATIVE("[ERROR] 입력된 금액은 음수일 수 없습니다."),
    NOT_ZERO("[ERROR] 입력된 금액은 0일 수 없습니다."),
    EXCEEDS_LIMIT("[ERROR] 입력된 금액이 너무 큽니다. 최대 금액은 1억 원입니다."),
    NOT_MULTIPLE_OF_UNIT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),

    INVALID_TICKET_COUNT("[ERROR] 계산된 티켓 수가 올바르지 않습니다."),

    INVALID_POOL_SIZE("[ERROR] 당첨 숫자 풀의 크기가 올바르지 않습니다."),
    DUPLICATE_NUMBER_IN_POOL("[ERROR] 당첨 숫자 풀에 중복된 숫자가 포함되어 있습니다."),
    NUMBER_OUT_OF_RANGE("[ERROR] 당첨 숫자 풀에 생성된 숫자가 유효 범위를 벗어났습니다."),

    NULL_LOTTO_NUMBERS("[ERROR] 로또 번호 리스트는 NULL일 수 없습니다."),
    EMPTY_LOTTO_NUMBERS("[ERROR] 로또 번호 리스트는 비어 있을 수 없습니다."),
    DUPLICATE_NUMBER_IN_WINNING_NUMBERS("[ERROR] 로또 번호 리스트에 중복된 숫자가 포함되어 있습니다."),

    NEGATIVE_OR_ZERO_TICKET_COUNT("[ERROR] 티켓 수는 1 이상이어야 합니다."),

    EMPTY_PART_INPUT("[ERROR] 입력값에 빈 항목이 포함되어 있습니다. 쉼표로 구분된 숫자만 입력하세요."),
    INVALID_VALUE_INPUT("[ERROR] 잘못된 값이 포함되어 있습니다. 숫자만 입력하세요."),
    INVALID_COMMA_POSITION("[ERROR] 입력 값의 시작 또는 끝에 콤마가 포함될 수 없습니다."),

    INVALID_SIZE("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호에는 중복된 숫자가 포함될 수 없습니다."),
    INVALID_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),

    NOT_ZERO_TOTAL_PURCHASE("[ERROR] 구입 총액은 0일 수 없습니다."),

    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호는 로또 번호와 중복될 수 없습니다."),
    INVALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
