package lotto.model;

public final class BonusNumber {
    private final LottoNumber number;

    public BonusNumber(Integer number) {
        this.number = new LottoNumber(number);
    }

    public LottoNumber getLottoNumber() {
        return number;
    }
}
