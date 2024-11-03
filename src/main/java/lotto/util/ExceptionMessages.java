package lotto.util;

public enum ExceptionMessages {
    EMPTY_INPUT("값을 입력해주세요."),
    INVALID_CHARACTER("숫자를 정확히 입력해주세요."),
    INVALID_DELIMITER("구분자를 정확히 입력해주세요. 입력 가능한 구분자는 쉼표(,) 입니다."),
    BUDGETS_NOT_DIVISIBLE_BY_THOUSAND("구입 금액은 1,000으로 나누어 떨어져야 합니다."),
    NOT_SIX_LOTTO_NUMBER("로또 번호는 6개여야 합니다."),
    EXTEND_NUMBERS_BOUNDARY("로또 번호의 숫자 범위는 1~45입니다."),
    DUPLICATED_NUMBERS("로또 번호로 동일한 숫자를 사용해서는 안됩니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호는 로또 번호와 동일해서는 안됩니다.");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format("[ERROR] %s", message);
    }
}
