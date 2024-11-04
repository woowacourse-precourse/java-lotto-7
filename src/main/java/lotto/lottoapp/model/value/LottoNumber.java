package lotto.lottoapp.model.value;

import java.util.Objects;

public sealed class LottoNumber implements Comparable<LottoNumber> permits BonusNumber {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private final Integer number;

    public LottoNumber(final Integer number) {
        if (number < MIN_VALUE || MAX_VALUE < number) {
            throw new IllegalArgumentException("로또 번호의 범위는 1~45입니다.");
        }
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public int compareTo(LottoNumber other) {
        if (other == null) {
            throw new IllegalArgumentException("null과 비교할 수 없습니다.");
        }
        return number.compareTo(other.getNumber());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

}
