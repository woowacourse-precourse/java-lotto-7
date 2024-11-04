package lotto.service.domain.lotto;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber>{
    private static final int MINIMUM_NUMBER_RANGE = 1;
    private static final int MAXIMUM_NUMBER_RANGE = 45;
    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        validateRange(number);
    }

    private void validateRange(int number) {
        if(number > MAXIMUM_NUMBER_RANGE || number < MINIMUM_NUMBER_RANGE){
            throw new IllegalArgumentException("[ERROR] 로또 번호 범위(1~45)에 맞지 않는 숫자입니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(LottoNumber o){
        return Integer.compare(this.number, o.number);
    }
}
