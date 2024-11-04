package lotto.common.exception;

public enum ErrorMessage {

    INVALID_INPUT("입력이 잘못 되었습니다."),
    INVESTMENT_MUST_BE_GREATER_THAN_ZERO("금액은 0 이상이어야 합니다."),
    INVESTMENT_MUST_BE_DIVISIBLE_BY_THOUSAND("금액은 1000으로 나누어 떨어져야 합니다."),
    INVESTMENT_MUST_BE_LESS_THAN_OR_EQUAL_ONE_HUNDRED_THOUSAND("금액은 100000 이하여야 합니다."),
    LOTTO_SIZE_MUST_BE_SIX("로또 번호는 6개여야 합니다."),
    LOTTO_CANNOT_BE_DUPLICATED("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1부터 45 사이여야 합니다."),
    WINNING_NUMBERS_SIZE_MUST_BE_SIX("당첨 번호는 6개여야 합니다."),
    WINNING_NUMBERS_CANNOT_BE_DUPLICATED("당첨 번호는 중복될 수 없습니다."),
    BONUS_NUMBER_CANNOT_BE_DUPLICATED("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    INPUT_MUST_BE_NUMERIC("입력은 숫자만 가능합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }
}
