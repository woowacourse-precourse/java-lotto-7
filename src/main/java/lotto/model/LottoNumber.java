package lotto.model;

public class LottoNumber {

    private final int number;

    public LottoNumber(final String number) {
        this.number = Integer.parseInt(number);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LottoNumber lottoNumber)) {
            return false;
        }
        return this.number == lottoNumber.number;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }
}
