package lotto.common;

public enum LottoNumbers {
    START(1),
    END(45),
    SIZE(6);

    private final int number;

    LottoNumbers(final int number) {
        this.number = number;
    }

    public int get() {
        return this.number;
    }
}
