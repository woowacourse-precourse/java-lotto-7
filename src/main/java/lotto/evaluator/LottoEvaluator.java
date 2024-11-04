package lotto.evaluator;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;

import java.util.List;
import java.util.Set;

public class LottoEvaluator {

    public LottoRank evaluate(Lotto ticket, Lotto winningLotto, int bonusNumber) {
        Set<Integer> ticketNumbersSet = Set.copyOf(ticket.getNumbers());
        long matchedCount = ticketNumbersSet.stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();

        boolean hasBonus = ticketNumbersSet.contains(bonusNumber);
        return LottoRank.getRank((int) matchedCount, hasBonus);
    }

    public LottoResult calculateResults(List<Lotto> lottoTickets, Lotto winningLotto, int bonusNumber) {
        LottoResult result = new LottoResult();
        lottoTickets.stream()
                .map(lottoTicket -> {
                    LottoRank rank = evaluate(lottoTicket, winningLotto, -1);
                    if (rank == LottoRank.THIRD) {
                        rank = evaluate(lottoTicket, winningLotto, bonusNumber);
                    }
                    return rank;
                })
                .forEach(result::addRank);

        return result;
    }

}
