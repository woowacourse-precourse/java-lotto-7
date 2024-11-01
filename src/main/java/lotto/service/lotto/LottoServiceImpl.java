package lotto.service.lotto;

import lotto.exception.lotto.LottoErrorMessages;

public class LottoServiceImpl implements LottoService {
    @Override
    public boolean validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_AMOUNT_NON_POSITIVE.getMessage());
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(LottoErrorMessages.INVALID_AMOUNT_NOT_DIVISIBLE_BY_1000.getMessage());
        }
        return true;
    }
}

