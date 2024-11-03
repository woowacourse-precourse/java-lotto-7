package lotto.controller;

import lotto.domain.*;
import lotto.dto.MatchResult;
import lotto.enums.LottoRank;
import lotto.util.InputHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private final ProfitCalculator profitCalculator = new ProfitCalculator();

    public void run() {

        PurchaseAmount purchaseAmount = InputHandler.readUntilValid(this::readPurchaseAmount);
        printPurchaseCount(purchaseAmount);
        LottoTicket lottoTicket = LottoTicket.of(lottoNumberGenerator, purchaseAmount);
        List<Lotto> ticket = lottoTicket.getTicket();
        displayPurchasedLottoNumbers(ticket);
        System.out.println();

        List<MatchResult> matchResults = getMatchResults(lottoTicket);

        double profitRate = getProfitRate(matchResults, purchaseAmount.getPurchaseAmount());
        OutputView.printTotalProfitRate(profitRate);
    }

    private PurchaseAmount readPurchaseAmount() {
        OutputView.printPurchaseAmountInputMessage();
        String purchaseAmount = InputHandler.readUntilValid(InputView::inputPurchaseAmount);
        return PurchaseAmount.from(purchaseAmount);
    }

    private void printPurchaseCount(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.countLottoQuantity();
        System.out.println();
        OutputView.printPurchaseCount(count);
    }

    private void displayPurchasedLottoNumbers(List<Lotto> ticket) {
        for (Lotto lotto : ticket) {
            OutputView.printPurchasedLottoNumbers(lotto.getNumbers());
        }
    }

    private List<MatchResult> getMatchResults(LottoTicket lottoTicket) {
        WinningNumber winningNumber = readWinningNumbers();
        BonusNumber bonusNumber = readBonusNumber(winningNumber);
        List<MatchResult> matchResults = lottoTicket.gatherMatchResult(winningNumber, bonusNumber);
        Map<LottoRank, Integer> lottoRankCount = produceStatistics(matchResults);
        OutputView.printWinningStatistics(lottoRankCount);
        return matchResults;
    }

    private WinningNumber readWinningNumbers() {
        return InputHandler.readUntilValid(this::inputWinningNumbers);
    }

    private WinningNumber inputWinningNumbers() {
        OutputView.printWinningNumbersInputMessage();
        String enteredWinningNumbers = InputHandler.readUntilValid(InputView::inputWinningNumbers);
        System.out.println();
        return WinningNumber.from(enteredWinningNumbers);
    }

    private BonusNumber readBonusNumber(WinningNumber winningNumber) {
        return InputHandler.readUntilValid(this::inputBonusNumber, winningNumber);
    }

    private BonusNumber inputBonusNumber(WinningNumber winningNumber) {
        OutputView.printBonusNumberInputMessage();
        String enteredBonusNumber = InputHandler.readUntilValid(InputView::inputBonusNumber);
        System.out.println();
        return BonusNumber.from(enteredBonusNumber, winningNumber);
    }

    private Map<LottoRank, Integer> produceStatistics(List<MatchResult> matchResults) {
        LottoResult lottoResult = new LottoResult();
        return lottoResult.produceStatistics(matchResults);
    }

    private double getProfitRate(List<MatchResult> matchResults, long purchaseAmount) {
        long totalWinningAmount = profitCalculator.calculateTotalWinningAmount(matchResults);
        return profitCalculator.calculateProfitRate(totalWinningAmount, purchaseAmount);
    }
}
