package lotto.model;

import static lotto.constant.LottoConstants.MAX_NUMBER;
import static lotto.constant.LottoConstants.MIN_NUMBER;

import lotto.exception.LottoNumberOutOfRangeException;

public final class LottoNumber implements Comparable<LottoNumber> {
    private final Integer number;

    public LottoNumber(Integer number) {
        validateLottoNumberRange(number);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    private void validateLottoNumberRange(Integer number) {
        if (!isLottoNumberRange(number)) {
            throw new LottoNumberOutOfRangeException();
        }
    }

    private boolean isLottoNumberRange(Integer number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }
}
