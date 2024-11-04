package lotto.domain;

import java.util.Objects;

public class LottoNumber {


    public static final int LOTTO_MIN_VALUE = 1;
    public static final int LOTTO_MAX_VALUE = 45;
    public static final String LOTTO_NUMBER_ERROR_MSG
            = String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", LOTTO_MIN_VALUE, LOTTO_MAX_VALUE);

    private final int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public LottoNumber(LottoNumber obj) {
        this.number = obj.number;
    }

    public static LottoNumber parseLottoNumber(String input) {
        try {
            return new LottoNumber(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MSG);
        }
    }

    private void validate(int number) {
        if (number < LOTTO_MIN_VALUE || number > LOTTO_MAX_VALUE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MSG);
        }
    }


    /*
     * Getter
     * */
    public int getNumber() {
        return number;
    }


    /*
     * Override methods
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoNumber that)) {
            return false;
        }
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
