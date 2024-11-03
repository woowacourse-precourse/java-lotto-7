package lotto.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import lotto.dto.LottoResultDto;
import lotto.utils.RankMessages;

public class LottoResults {
    private final Map<Rank, Integer> lottoResults = new LinkedHashMap<>();

    public LottoResults() {
        initializeResults();
    }

    private void initializeResults() {
        for (Rank rank : Rank.values()) {
            lottoResults.put(rank, 0);
        }
    }

    public void calculateResults(LottoTickets lottoTickets, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        for (List<Integer> numbers : lottoTickets.getLottoTickets()) {
            Lotto lottoTicket = Lotto.from(numbers);
            Rank rank = determineRank(winningNumbers, bonusNumber, lottoTicket);
            lottoResults.put(rank, lottoResults.get(rank) + 1);
        }
    }

    private Rank determineRank(WinningNumbers winningNumbers, BonusNumber bonusNumber, Lotto lotto) {
        int matchCount = calculateMatchCount(winningNumbers, lotto);
        boolean bonusMatch = lotto.contains(bonusNumber.getBonusNumber());
        return Rank.matchLotto(matchCount, bonusMatch);
    }

    private int calculateMatchCount(WinningNumbers winningNumbers, Lotto lotto) {
        return (int) winningNumbers.getWinningNumbers().stream()
                .filter(lotto::contains)
                .count();
    }

    public long calculateTotalEarnings() {
        return lottoResults.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

}
