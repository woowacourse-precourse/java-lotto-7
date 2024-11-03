package lotto.application.ticket.domain.ticket;

public enum LottoNumberRule {
    START_INCLUSIVE(1),
    END_INCLUSIVE(45),
    SIZE(6);

    private int value;

    LottoNumberRule(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
