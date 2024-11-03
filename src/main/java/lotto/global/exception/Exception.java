package lotto.global.exception;

public enum Exception {
    INVALID_MONEY_FORMAT("구입 금액은 1,000원 이상이어야 합니다."),
    INDIVISIBLE_MONEY("구입 금액은 1,000원 단위여야 합니다."),
    NOT_INTEGER("금액은 정수만 가능합니다."),
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private static final String PREFIX = "[ERROR] ";

    final String message;

    Exception(final String message) {
        this.message = PREFIX + message;
    }
}
