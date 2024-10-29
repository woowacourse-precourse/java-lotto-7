package lotto.application;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoQuantity;
import lotto.domain.Lottos;
import lotto.domain.PrizeNumber;
import lotto.domain.WinNumbers;

public class LottoApplication {

    private final MakeNumbersStrategy makeNumbersStrategy;
    private final Calculator calculator;

    public LottoApplication(MakeNumbersStrategy makeNumbersStrategy, Calculator calculator) {
        this.makeNumbersStrategy = makeNumbersStrategy;
        this.calculator = calculator;
    }

    public PrizeNumber run(LottoQuantity lottoQuantity, WinNumbers winNumbers,Lottos lottos) {
        return findWinningLottos(winNumbers, lottos);
    }

    private PrizeNumber findWinningLottos(WinNumbers winNumbers, Lottos lottos) {
        PrizeNumber prizeNumber = new PrizeNumber();
        List<Lotto> allLotto = lottos.value();
        for (Lotto lotto : allLotto) {
            prizeNumber.countMatchNumber(lotto.getNumbers(), winNumbers);
        }
        return prizeNumber;
    }
}
