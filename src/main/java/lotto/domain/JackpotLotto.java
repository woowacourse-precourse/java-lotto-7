package lotto.domain;

import static lotto.message.ErrorMessage.EQUALS_LOTTO_BONUS;

public class JackpotLotto {

    private final Lotto lotto;
    private final LottoBonusNumber bonusNumber;

    public JackpotLotto(Lotto lotto, LottoBonusNumber bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, LottoBonusNumber bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException(EQUALS_LOTTO_BONUS.getMessage());
        }
    }

    public long getMatchCount(Lotto issueLotto) {
        return issueLotto.getNumbers().stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }

    public boolean isMatchBonusNumber(Lotto issueLotto) {
        return issueLotto.getNumbers().contains(bonusNumber.getNumber());
    }

    public LottoRank findRank(Lotto issueLotto) {
        return LottoRank.valueOf(getMatchCount(issueLotto), isMatchBonusNumber(issueLotto));
    }
}
