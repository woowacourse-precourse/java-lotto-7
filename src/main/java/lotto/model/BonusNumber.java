package lotto.model;

public class BonusNumber {
    private final LottoNumber number;

    public BonusNumber(final String number) {
        this.number = new LottoNumber(number);
    }

    public int getNumber() {
        return number.getNumber();
    }
}
