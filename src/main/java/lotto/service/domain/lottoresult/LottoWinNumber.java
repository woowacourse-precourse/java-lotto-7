package lotto.service.domain.lottoresult;

import lotto.service.domain.lotto.Lotto;
import lotto.service.domain.lotto.LottoNumber;

public class LottoWinNumber {
    private final Lotto winnerLotto;
    private final LottoNumber bonusNumber;

    public LottoWinNumber(Lotto winnerLotto, LottoNumber bonusNumber) {
        validateBounusNumberDuplicate(winnerLotto, bonusNumber);
        this.winnerLotto = winnerLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBounusNumberDuplicate(Lotto winnerLotto, LottoNumber bonusNumber) {
        if(winnerLotto.checkBonusNumberDuplicate(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }

    public Lotto getWinnerLotto() {
        return winnerLotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
