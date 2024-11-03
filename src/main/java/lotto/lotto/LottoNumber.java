package lotto.lotto;

public record LottoNumber(int value) implements Comparable<LottoNumber> {
    public static final int MIN_NUMBER_INCLUSIVE = 1;
    public static final int MAX_NUMBER_INCLUSIVE = 45;

    public LottoNumber {
        validate(value);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(value, o.value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    private void validate(int value) {
        if (!isInRange(value)) {
            throw LottoException.INVALID_NUMBER.getException();
        }
    }

    private boolean isInRange(int value) {
        return value >= MIN_NUMBER_INCLUSIVE && value <= MAX_NUMBER_INCLUSIVE;
    }
}
