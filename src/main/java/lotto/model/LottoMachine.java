package lotto.model;

import lotto.enums.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    private final Lotto winningLottoNumbers;

    public LottoMachine(Lotto winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public Map<LottoRank, Integer> match(List<LottoTicket> tickets) {
        Map<LottoRank, Integer> result = new HashMap<>();

        for (LottoTicket ticket : tickets) {
            LottoRank rank = getRank(ticket.getLottoNumbers());
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return result;
    }

    private LottoRank getRank(List<Integer> lottoNumbers) {
        int matchCount = (int) lottoNumbers.stream()
                .filter(winningLottoNumbers.getNumbers()::contains)
                .count();

        return LottoRank.matchCountAndRank(matchCount, false);
    }
}