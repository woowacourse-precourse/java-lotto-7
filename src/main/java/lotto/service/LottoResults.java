package lotto.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.SequencedMap;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;

public class LottoResults {
    private final SequencedMap<Rank,Integer> lottoResults = new LinkedHashMap<>();

    public LottoResults(){
        initializeResults();
    }

    private void initializeResults(){
        for (Rank rank : Rank.values()) {
            lottoResults.put(rank,0);
        }
    }

    private int calculateMatchCount(WinningNumbers winningNumbers, Lotto lotto) {
        int matchCount = 0;
        List<Integer> winningNumbersList = winningNumbers.getWinningNumbers();

        for (Integer number : lotto.getNumbers()) {
            if (winningNumbersList.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
