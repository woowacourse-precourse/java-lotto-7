package lotto.service;

import java.util.List;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningResult;
import lotto.domain.vo.Number;
import lotto.dto.BonusNumberRequest;
import lotto.dto.WinningNumbersRequest;

public class LottoService {
    private final WinningResult winningResult;

    public LottoService(WinningResult winningResult) {
        this.winningResult = winningResult;
    }

    public void processWinningResults(Lottos lottos, WinningNumbersRequest winningNumbersRequest, BonusNumberRequest bonusNumberRequest) {
        lottos.getTickets().forEach(lotto -> {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), winningNumbersRequest.getWinningNumbers());
            boolean hasBonus = lotto.getNumbers().contains(bonusNumberRequest.getBonusNumber());
            Rank rank = Rank.of(matchCount, hasBonus);
            winningResult.addResult(rank);
        });
    }

    public double calculateTotalReturn(int totalAmount) {
        return winningResult.calculateTotalReturn(totalAmount);
    }

    public WinningResult getWinningResult() {
        return winningResult;
    }

    private int countMatchingNumbers(List<Number> lottoNumbers, List<Number> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}

