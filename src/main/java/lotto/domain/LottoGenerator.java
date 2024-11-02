package lotto.domain;

import lotto.strategy.LottoCreateStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static List<Lotto> generateLotto(Budget budget, LottoCreateStrategy lottoCreateStrategy) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoCounts = budget.findLottoCounts();

        while (lottoCounts > 0) {
            lottos.add(new Lotto(lottoCreateStrategy.createRandomLottoNumbers()));
            lottoCounts--;
        }
        return lottos;
    }
}
