package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.messages.WinningMessage;

public class LottoResult {
    private static final Map<WinningMessage, Integer> winningResults = new EnumMap<>(WinningMessage.class);

    public LottoResult() {
        WinningMessage[] ranks = WinningMessage.values();
        for (WinningMessage rank : ranks) {
            winningResults.put(rank, 0);
        }
    }

    public void calculateWinningResult(List<Lotto> lottoNumbers, Numbers numbers) {
        Lotto winningNumbers = numbers.getWinningNumbers();
        int bonusNumber = numbers.getBonusNumber();

        lottoNumbers.forEach(lottoNumber ->
            updateWinningResults(lottoNumber, winningNumbers, bonusNumber));
    }

    private void updateWinningResults(Lotto lottoNumber, Lotto winningNumbers, int bonusNumber) {
        int matchCount = lottoNumber.countMatchingNumbers(winningNumbers);

        if (matchCount == 4) {
            updateBonus(lottoNumber, bonusNumber);
            return;
        }
        updateResultsWithoutBonus(matchCount);
    }

    private void updateBonus(Lotto lottoNumber, int bonusNumber) {
        if (lottoNumber.contains(bonusNumber)) {
            winningResults.put(WinningMessage.SECOND, winningResults.get(WinningMessage.SECOND) + 1);
        }
    }

    private void updateResultsWithoutBonus(int matchCount) {
        WinningMessage[] ranks = WinningMessage.values();
        for (WinningMessage rank : ranks) {
            if (rank.getMatchCount() == matchCount) {
                winningResults.put(rank, winningResults.get(rank) + 1);
            }
        }
    }

    public Map<WinningMessage, Integer> getWinningResults() {
        return winningResults;
    }
}
