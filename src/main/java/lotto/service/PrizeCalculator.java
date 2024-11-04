package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.WinningLotto;

public class PrizeCalculator {
    private final LottoEvaluator evaluator = new LottoEvaluator();

    public int calculateTotalPrize(Iterable<Lotto> lottoTickets, WinningLotto winningLotto) {
        int totalPrize = 0;
        for (Lotto lottoTicket : lottoTickets) {
            LottoRank rank = evaluator.determineLottoRank(lottoTicket, winningLotto);
            totalPrize += rank.getPrizeAmount();
        }
        return totalPrize;
    }
}
