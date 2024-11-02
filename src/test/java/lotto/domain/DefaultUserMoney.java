package lotto.domain;

public enum DefaultUserMoney {
    USER_MONEY(8000),
    USER_MONEY_TEN_THOUSAND(10000);

    private final int unit;

    private DefaultUserMoney(int unit) {
        this.unit = unit;
    }

    public int getUnit() {
        return unit;
    }
}
