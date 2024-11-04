package common;

public enum LottoConstants {
    TICKET_PRICE(1000, "한 장당 로또 가격"),
    LOTTO_NUMBER_COUNT(6, "로또 번호 개수"),
    MAX_LOTTO_NUMBER(45, "최대 로또 번호"),
    MIN_LOTTO_NUMBER(1, "최소 로또 번호");

    private final int value;
    private final String description;

    LottoConstants(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
