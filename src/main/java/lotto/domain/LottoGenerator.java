package lotto.domain;

import lotto.strategy.LottoCreateStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static List<Lotto> generateLotto(Budget budget, LottoCreateStrategy lottoCreateStrategy) {
        List<Lotto> lottoTickets = new ArrayList<>();
        int lottoCounts = budget.findLottoCounts();

        while (lottoCounts > 0) {
            lottoTickets.add(new Lotto(lottoCreateStrategy.createRandomLottoNumbers()));
            lottoCounts--;
        }
        return lottoTickets;
    }
}
