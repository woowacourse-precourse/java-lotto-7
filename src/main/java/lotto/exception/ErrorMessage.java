package lotto.exception;

public enum ErrorMessage {
    BLANK_PURCHASE_AMOUNT("로또 구입 금액을 입력하지 않았습니다."),
    NOT_NUMERIC_PURCHASE_AMOUNT("구입 금액은 숫자여야 합니다."),
    NEGATIVE_PURCHASE_AMOUNT("구입 금액은 음수가 될 수 없습니다."),
    UNDER_THOUSAND_PURCHASE_AMOUNT("구입 금액은 최소 1,000원 이상이어야 합니다."),
    NOT_THOUSAND_UNIT_PURCHASE_AMOUNT("구입 금액은 1,000원 단위여야 합니다."),
    BLANK_WINNING_NUMBER("당첨 번호를 입력하지 않았습니다."),
    NOT_NUMERIC_LOTTO_NUMBER("로또 번호는 숫자여야 합니다."),
    NOT_LOTTO_NUMBER_COUNT_SIX("로또 번호는 6개여야 합니다."),
    OUT_RANGE_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복되지 않아야 합니다."),
    BLANK_BONUS_NUMBER("보너스 번호를 입력하지 않았습니다."),
    NOT_NUMERIC_BONUS_NUMBER("보너스 번호는 숫자여야 합니다."),
    OUT_RANGE_BONUS_NUMBER("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복되지 않아야 합니다."),
    TOO_BIG_INPUT("입력값에 너무 큰 수가 존재합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
