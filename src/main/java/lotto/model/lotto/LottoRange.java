package lotto.model.lotto;

public enum LottoRange {
    MIN_NUMBER(1),
    MAX_NUMBER(45);

    private final int description;

    LottoRange(int description) {
        this.description = description;
    }

    public int getDescription() {
        return description;
    }
}
