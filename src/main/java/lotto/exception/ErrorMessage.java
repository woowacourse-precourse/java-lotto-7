package lotto.exception;

public enum ErrorMessage {

    MONEY_NOT_MULTIPLE_OF_THOUSAND("구매 금액은 1,000원 단위로 입력해야 합니다."),
    MONEY_NOT_GREATER_THAN_A_THOUSAND("구매 금액은 최소 1,000원 이상이어야 합니다."),
    LOTTO_COUNT_NOT_SIX("로또 번호는 6개여야 합니다."),
    LOTTO_RANGE_NOT_MATCH("로또 번호의 범위는 1부터 45 사이여야 합니다."),
    BONUS_NUMBER_RANGE_NOT_MATCH("보너스 번호의 범위는 1부터 45 사이여야 합니다."),
    LOTTO_NUMBERS_DUPLICATED("로또 번호는 서로 중복되어서는 안 됩니다."),
    BONUS_NUMBER_NOT_DUPLICATED_WITH_LOTTO_NUMBER("보너스 번호는 로또 번호와 서로 중복되어서는 안 됩니다."),
    INPUT_NOT_EMPTY("입력은 비어있거나 공백일 수 없습니다."),
    MONEY_PARSING_ERROR_MESSAGE("구입 금액은 2,147,483,000원 이하의 숫자여야 합니다."),
    BONUS_NUMBER_PARSING_ERROR_MESSAGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    WINNING_NUMBERS_PARSING_ERROR_MESSAGE("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
