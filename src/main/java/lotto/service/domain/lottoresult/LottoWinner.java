package lotto.service.domain.lottoresult;

import java.util.Set;
import lotto.service.domain.lotto.Lotto;
import lotto.service.domain.lotto.LottoNumber;

public class LottoWinner {
    private final Lotto winnerLotto;
    private final LottoNumber bonusNumber;

    public LottoWinner(Lotto winnerLotto, LottoNumber bonusNumber) {
        validate(winnerLotto, bonusNumber);
        this.winnerLotto = winnerLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winnerLotto, LottoNumber bonusNumber) {
        if(winnerLotto.checkBonusDuplicate(bonusNumber)){

        }
    }
}
