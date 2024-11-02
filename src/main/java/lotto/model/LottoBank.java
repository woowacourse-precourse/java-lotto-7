package lotto.model;

import java.util.List;

public class LottoBank {

    public LottoResult evaluate(WinningLotto winningLotto, List<Lotto> myLottos, BonusNumber bonusNumber) {
        List<Prize> prizes = myLottos.stream().map(mLotto -> Prize.getPrize(winningLotto, mLotto, bonusNumber))
                .toList();
        return new LottoResult(prizes);
    }
}
