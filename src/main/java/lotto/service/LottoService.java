package lotto.service;

import lotto.domain.lotto.IssuedLotto;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Rank;
import lotto.domain.purchase.PurchaseAmount;
import lotto.domain.winning.WinningCombination;

import java.util.List;

public class LottoService {
    private final LottoGeneratorService ticketGenerator;
    private final WinningCheckerService winningChecker;
    private final ProfitCalculatorService profitCalculator;

    public LottoService() {
        ticketGenerator = new LottoGeneratorService();
        winningChecker = new WinningCheckerService();
        profitCalculator = new ProfitCalculatorService();
    }

    public List<Lotto> generateLottoTickets(PurchaseAmount purchaseAmount) {
        return ticketGenerator.generateLottoTickets(purchaseAmount);
    }

    public List<Rank> checkWinning(IssuedLotto issuedLotto, WinningCombination winningCombination) {
        return winningChecker.checkWinning(issuedLotto, winningCombination);
    }

    public double calculateProfitRate(List<Rank> ranks, PurchaseAmount purchaseAmount) {
        return profitCalculator.calculateProfitRate(ranks, purchaseAmount);
    }
}