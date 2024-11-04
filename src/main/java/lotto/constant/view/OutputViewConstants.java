package lotto.constant.view;

public enum OutputViewConstants {
    LOTTO_TICKETS_COUNT_FORMAT("%d개를 구매했습니다."),
    INPUT_LOTTO_PRICE_PREFIX("구입금액을 입력해 주세요."),
    INPUT_LOTTO_NUMBERS_PREFIX("당첨 번호를 입력해 주세요."),
    INPUT_LOTTO_BONUS_NUMBER_PREFIX("보너스 번호를 입력해 주세요.");

    private final String message;

    OutputViewConstants(String message) {
        this.message = message;
    }

    public String formatMessage(Object... args) {
        return String.format(message, args);
    }

    @Override
    public String toString() {
        return message;
    }
}
