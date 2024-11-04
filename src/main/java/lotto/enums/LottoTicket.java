package lotto.enums;

public enum LottoTicket {
    PRICE(1000),
    ZERO(0);

    private final int value;

    LottoTicket(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
