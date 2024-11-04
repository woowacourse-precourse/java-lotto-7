package lotto;

public class LottoNumber {

    static final int RANGE_MINIMUM = 1;
    static final int RANGE_MAXIMUM = 45;
    private final static String LOTTO_RANGE_EXCEPTION_MESSAGE = "로또 번호는 1~45 내에 있어야 합니다";
    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < RANGE_MINIMUM || number > RANGE_MAXIMUM) {
            throw new IllegalArgumentException(LOTTO_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public int getNumber() {
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

        LottoNumber that = (LottoNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
