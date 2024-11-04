package lotto.model;

public class BonusNumber {

    private final LottoNumber number;

    private BonusNumber(LottoNumber number) {
        this.number = number;
    }

    public static BonusNumber from(LottoNumber number) {
        return new BonusNumber(number);
    }

    public boolean isMatched(Lotto lotto) {
        return lotto.numbers().contains(number);
    }

    public LottoNumber number() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BonusNumber that = (BonusNumber) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
