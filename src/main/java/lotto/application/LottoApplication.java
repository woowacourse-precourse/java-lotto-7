package lotto.application;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoQuantity;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinNumbers;

public class LottoApplication {

    private final MakeNumbersStrategy makeNumbersStrategy;

    public LottoApplication(MakeNumbersStrategy makeNumbersStrategy) {
        this.makeNumbersStrategy = makeNumbersStrategy;
    }

    public void run(LottoQuantity lottoQuantity, WinNumbers winNumbers) {
        List<Lotto> lottosTemp = new ArrayList<>();
        for (int i = 0; i < lottoQuantity.value(); i++) {
            List<Integer> numbers = makeNumbersStrategy.makeNumbers();
            lottosTemp.add(new Lotto(numbers));
        }
        Lottos lottos = Lottos.of(lottosTemp);
    }
//
//    private Rank findWinningLottos(WinNumbers winNumbers, Lottos lottos) {
//        List<Lotto> allLotto = lottos.value();
//        for (Lotto lotto : allLotto) {
//        }
//    }
}
