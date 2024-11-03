package lotto;

public enum Constants {
    LOTTO_MIN_NUMBER(1),
    LOTTO_MAX_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    LOTTO_PRICE(1000),
    PERCENTAGE_MULTIPLIER(100),
    DELIMITER(","),
    MESSAGE_ENTER_BUY_AMOUNT("구입금액을 입력해 주세요."),
    MESSAGE_LOTTO_COUNT("개를 구매했습니다."),
    MESSAGE_ENTER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    MESSAGE_ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    MESSAGE_STATISTICS_HEADER("\n당첨 통계\n---"),
    TOTAL_PROFIT_RATE_MESSAGE_FORMAT("총 수익률은 %.1f%s"),
    NO_MATCH(0),
    DEFAULT(0);

    private final Object value;

    Constants(Object value) {
        this.value = value;
    }

    public int getNumberValue() {
        return (int) value;
    }

    public String getMessageValue() {
        return (String) value;
    }

    public String getDelimiter() {
        return (String) value;
    }

    public boolean isInt() {
        return value instanceof Integer;
    }

    public boolean isString() {
        return value instanceof String;
    }
}
