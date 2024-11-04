package lotto.message;

public enum LottoErrorMessage implements Message {

    PURCHASE_AMOUNT_UNDER_BASE_LIMIT("구입금액이 최소 구입금액보다 작아요."),
    PURCHASE_AMOUNT_UNIT_INVALID("구입금액은 1000원 단위여야 해요."),

    MIN_QUANTITY_LOTTO_ISSUE("로또는 1개 이상 발급할 수 있어요."),

    LOTTO_NUMBERS_COUNT("로또 번호는 6개여야 해요."),
    LOTTO_NUMBERS_DUPLICATE("로또 번호에 중복된 숫자가 포함되어 있어요."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 1과 45 사이의 숫자여야 해요."),

    WINNING_NUMBERS_COUNT("당첨 번호는 6개여야 해요."),
    WINNING_NUMBERS_DUPLICATE("당첨 번호에 중복된 숫자가 포함되어 있어요."),
    WINNING_NUMBERS_OUT_OF_RANGE("당첨 번호는 1과 45 사이의 숫자여야 해요."),

    WINNING_SET_NUMBERS_DUPLICATE("당첨 번호와 보너스 번호가 중복될 수 없어요."),

    NOT_ALLOWED_PRIZE_TYPE("존재하지 않는 당첨 유형입니다.")
    ;

    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String get() {
        String format = "[ERROR] %s 다시 입력해주세요.";
        return String.format(format, message);
    }
}
