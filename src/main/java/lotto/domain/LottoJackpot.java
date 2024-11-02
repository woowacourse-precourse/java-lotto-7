package lotto.domain;

import static lotto.message.ErrorMessage.EQUALS_LOTTO_BONUS;

public class LottoJackpot {

    private final Lotto lotto;
    private final LottoBonusNumber bonusNumber;

    public LottoJackpot(Lotto lotto, LottoBonusNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoBonusNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validate(Lotto lotto, LottoBonusNumber bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(EQUALS_LOTTO_BONUS.message());
        }
    }
}
