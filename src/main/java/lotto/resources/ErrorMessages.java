package lotto.resources;

public enum ErrorMessages {
    // buyer
    LOTTOS_COUNT_MISMATCH_CUSTOM_LOTTOS_SIZE
            ("[Error] 구매할 로또 개수와 커스텀 로또의 개수가 다릅니다."),

    // input
    INVALID_NULL_INPUT("[ERROR] null 이 입력되서는 안됩니다."),
    INVALID_EMPTY_OR_WHITESPACE("[ERROR] 빈 문자열, 공백이 입력되서는 안됩니다."),
    INVALID_START_WITH_COMMA("[ERROR] 쉼표(\",\")로 시작해서는 안됩니다."),
    INVALID_END_WITH_COMMA("[ERROR] 쉼표(\",\")로 끝나서는 안됩니다."),
    INVALID_CONSECUTIVE_COMMAS("[ERROR] 쉼표(\",\"가 연속으로 입력되서는 안됩니다."),
    INVALID_NUMERIC_INPUT("[ERROR] 숫자만 입력 가능합니다."),
    INVALID_NUMERIC_OR_COMMA_INPUT("[ERROR] 숫자와 \",\"만 입력 가능합니다."),

    // Money
    NEGATIVE_QUANTITY_MONEY("[ERROR] 돈은 0원 이상이어야 합니다."),
    INVALID_THOUSAND_UNIT_MONEY("[ERROR] 돈은 1,000원 단위로 떨어져야 합니다."),

    // Lotto
    INVALID_LOTTO_TOTAL_NUMBER("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("[ERROR] 로또 번호는 중복되면 안됩니다."),

    // Number
    INVALID_RANGE_LOTTO_NUMBER("[ERROR] 로또 번호의 범위는 1 ~ 45 입니다."),
    DUPLICATE_BONUS_NUMBER("[ERROR] 보너스 번호와 추첨 로또 번호가 중복되면 안됩니다.");

    private final String message;

    ErrorMessages(final String errorMessage) {
        this.message = errorMessage;
    }

    public String getMessage() {
        return message;
    }

}
