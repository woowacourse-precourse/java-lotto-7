package common;

public enum LottoNumber {
    START(0),
    END(45),
    SIZE(6);

    private final int number;

    LottoNumber(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
