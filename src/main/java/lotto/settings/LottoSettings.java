package lotto.settings;

public enum LottoSettings {
    SIZE(6),
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private int value;

    LottoSettings(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
