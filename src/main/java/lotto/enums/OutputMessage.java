package lotto.enums;

public enum OutputMessage implements MessageProvider {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASED_LOTTO_COUNT_MESSAGE("%d개를 구매했습니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getLottoCountMessage(int count) {
        return String.format(message, count);
    }
}

