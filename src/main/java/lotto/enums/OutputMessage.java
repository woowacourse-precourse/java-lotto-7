package lotto.enums;

public enum OutputMessage implements MessageProvider {
    PURCHASED_LOTTO_COUNT_MESSAGE("%d개를 구매했습니다."),
    LOTTO_WINNING_MESSAGE("당첨 통계\n---");

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