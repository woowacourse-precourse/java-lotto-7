package lotto.domain.number;

import static lotto.LottoConstants.LOTTO_NUMBER_MAX;
import static lotto.LottoConstants.LOTTO_NUMBER_MIN;
import static lotto.message.ErrorMessage.LOTTO_SCOPE_ERROR;

public abstract class LottoNumber {
    private final int number;

    public LottoNumber(int number) {
        validateScope(number);
        this.number = number;
    }

    private void validateScope(int number) {
        boolean result = number >= LOTTO_NUMBER_MIN && number <= LOTTO_NUMBER_MAX;
        if (!result) {
            throw new IllegalArgumentException(LOTTO_SCOPE_ERROR.getMessage());
        }
    }

    public int getNumber() {
        return number;
    }

    public boolean isSame(LottoNumber lottoNumber) {
        return number == lottoNumber.getNumber();
    }
}
