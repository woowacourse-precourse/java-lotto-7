package lotto.domain;

import static lotto.message.ErrorMessage.ERROR_LOTTO_AND_BONUS_NUMBER_DUPLICATE;

public class LottoJackpot {

    private final Lotto lotto;
    private final LottoBonusNumber bonusNumber;

    public LottoJackpot(Lotto lotto, LottoBonusNumber bonusNumber) {
        validateDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoBonusNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validateDuplicate(Lotto lotto, LottoBonusNumber bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(ERROR_LOTTO_AND_BONUS_NUMBER_DUPLICATE.message());
        }
    }
}
