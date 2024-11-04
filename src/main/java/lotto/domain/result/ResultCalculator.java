package lotto.domain.result;

import lotto.domain.model.LottoRank;
import lotto.domain.model.LottoTickets;
import lotto.domain.model.WinningLotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultCalculator {
    private static final int INITIAL_COUNT = 0;
    private static final int INCREMENT_COUNT = 1;

    public Map<LottoRank, Integer> calculateResults(LottoTickets lottoTickets, WinningLotto winningLotto) {
        Map<LottoRank, Integer> results = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            results.put(rank, INITIAL_COUNT);
        }

        List<LottoRank> matches = lottoTickets.getTickets().stream()
                .map(lotto -> winningLotto.calculateRank(lotto.toLottoNumbers()))
                .collect(Collectors.toList());

        for (LottoRank rank : matches) {
            results.put(rank, results.get(rank) + INCREMENT_COUNT);
        }
        return results;
    }
}