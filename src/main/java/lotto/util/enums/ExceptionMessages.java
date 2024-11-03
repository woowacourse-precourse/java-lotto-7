package lotto.util.enums;

public enum ExceptionMessages {
    NOT_DIVIDED_BY_LOTTO_PRICE("구입 금액은 1,000원 단위로 입력해야 합니다."),
    EXCEEDS_PURCHASE_LIMIT("복권 및 복권기금법에 의해서 1회 구매 한도는 10만원 입니다."),
    EMPTY_INPUT("입력이 비어있습니다."),
    INVALID_PURCHASE_AMOUNT_FORMAT("구입 금액은 양수형태로 입력해야합니다."),
    INVALID_WINNING_NUMBER_FORMAT("당첨 번호 형식은 \",\" 로 구분된 6개의 정수입력이어야 합니다."),
    INVALID_WINNING_NUMBER_COUNT("당첨 번호는 6개여야 합니다."),
    DUPLICATE_WINNING_NUMBER("당첨 번호는 중복될 수 없습니다."),
    WINNING_NUMBER_OUT_OF_RANGE("당첨 번호는 1에서 45 사이의 정수여야 합니다."),
    INVALID_BONUS_NUMBER_FORMAT("보너스 번호가 정수 형식이 아닙니다."),
    BONUS_NUMBER_OUT_OF_RANGE("보너스 번호는 1에서 45 사이의 정수여야 합니다."),
    DUPLICATE_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
