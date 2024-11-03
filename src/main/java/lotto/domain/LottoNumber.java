package lotto.domain;

import lotto.exception.LottoApplicationException;

public record LottoNumber(int number) implements Comparable<LottoNumber> {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    public LottoNumber {
        validateRange(number);
    }

    private void validateRange(int number) {
        if (isOutOfRange(number)) {
            String message = String.format("로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", MIN_VALUE, MAX_VALUE);
            throw new LottoApplicationException(message);
        }
    }

    private boolean isOutOfRange(int number) {
        return number < MIN_VALUE || number > MAX_VALUE;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }

}
