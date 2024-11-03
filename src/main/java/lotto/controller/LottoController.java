package lotto.controller;

import lotto.domain.*;
import lotto.dto.MatchResult;
import lotto.enums.LottoRank;
import lotto.util.Convertor;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private final ProfitCalculator profitCalculator = new ProfitCalculator();

    public void run() {
        String enteredPurchaseAmount = enterPurchaseAmount();
        PurchaseAmount purchaseAmount = PurchaseAmount.from(enteredPurchaseAmount);

        printPurchaseCount(purchaseAmount);
        LottoTicket lottoTicket = LottoTicket.of(lottoNumberGenerator, purchaseAmount);
        List<Lotto> ticket = lottoTicket.getTicket();
        displayPurchasedLottoNumbers(ticket);
        System.out.println();

        List<MatchResult> matchResults = getMatchResults(lottoTicket);

        double profitRate = getProfitRate(matchResults, enteredPurchaseAmount);
        OutputView.printTotalProfitRate(profitRate);
    }

    private String enterPurchaseAmount() {
        OutputView.printPurchaseAmountInputMessage();
        return InputView.inputPurchaseAmount();
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
        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber(winningNumber);
        List<MatchResult> matchResults = lottoTicket.gatherMatchResult(winningNumber, bonusNumber);
        Map<LottoRank, Integer> lottoRankCount = produceStatistics(matchResults);
        OutputView.printWinningStatistics(lottoRankCount);
        return matchResults;
    }

    private WinningNumber getWinningNumber() {
        OutputView.printWinningNumbersInputMessage();
        String inputWinningNumbers = InputView.inputWinningNumbers();
        System.out.println();
        return WinningNumber.from(inputWinningNumbers);
    }

    private BonusNumber getBonusNumber(WinningNumber winningNumber) {
        OutputView.printBonusNumberInputMessage();
        String inputBonusNumber = InputView.inputBonusNumber();
        System.out.println();
        return BonusNumber.from(inputBonusNumber, winningNumber);
    }

    private Map<LottoRank, Integer> produceStatistics(List<MatchResult> matchResults) {
        LottoResult lottoResult = new LottoResult();
        return lottoResult.produceStatistics(matchResults);
    }

    private double getProfitRate(List<MatchResult> matchResults, String enteredPurchaseAmount) {
        long totalWinningAmount = profitCalculator.calculateTotalWinningAmount(matchResults);
        long lottoPurchaseAmount = Convertor.convertToLong(enteredPurchaseAmount);
        return profitCalculator.calculateProfitRate(totalWinningAmount, lottoPurchaseAmount);
    }
}
