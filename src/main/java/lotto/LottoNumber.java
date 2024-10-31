package lotto;

import java.util.Objects;

public class LottoNumber {
    private static final String INVALID_NUMBER_ERROR = "[ERROR] : 로또 숫자는 1에서 45사이만 입력 가능합니다.";
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;

    private int number;

    public LottoNumber(int number) {
        this.number = isValid(number);
    }

    private int isValid(int number) {
        if(number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_ERROR);
        }
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
