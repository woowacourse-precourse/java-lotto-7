package lotto.domain.lotto;

import java.util.Objects;
import lotto.common.constant.Constants;
import lotto.common.exception.InvalidLottoNumberException;

public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if(lottoNumber < Constants.MIN_LOTTO_NUMBER || lottoNumber > Constants.MAX_LOTTO_NUMBER) {
            throw new InvalidLottoNumberException(lottoNumber);
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
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
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumber);
    }
}
