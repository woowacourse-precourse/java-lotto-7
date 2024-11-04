package lotto.enums;

public enum ExceptionMessage {
    LOTTO_NUMBER_COUNT_EXCEPTION("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_EXCEPTION("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_RANGE_EXCEPTION("당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    PURCHASE_AMOUNT_TOO_LARGE("구입금액이 너무 큽니다."),
    PURCHASE_AMOUNT_TOO_SMALL("구입금액은 1,000원 이상이어야 합니다."),
    PURCHASE_AMOUNT_UNIT_EXCEPTION("구입금액은 1,000원 단위로 입력할 수 있습니다."),
    PURCHASE_AMOUNT_FORMAT_EXCEPTION("구입금액은 양의 정수만 입력할 수 있습니다."),
    WINNING_NUMBER_COUNT_EXCEPTION("당첨 번호는 서로 다른 6개의 번호를 입력해 주세요."),
    WINNING_NUMBER_RANGE_EXCEPTION("당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_RANGE_EXCEPTION("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUMBER_DUPLICATE_EXCEPTION("당첨 번호와 보너스 번호는 중복될 수 없습니다."),
    BONUS_NUMBER_FORMAT_EXCEPTION("보너스 번호는 양의 정수만 입력할 수 있습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
