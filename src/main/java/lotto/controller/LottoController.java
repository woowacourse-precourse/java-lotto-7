package lotto.controller;

import lotto.domain.*;
import lotto.dto.MatchCondition;
import lotto.enums.LottoRank;
import lotto.util.Convertor;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
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

        List<MatchCondition> matchConditions = getMatchConditions(lottoTicket);

        double profitRate = getProfitRate(matchConditions, enteredPurchaseAmount);
        outputView.printTotalProfitRate(profitRate);
    }

    private String enterPurchaseAmount() {
        outputView.printPurchaseAmountInputMessage();
        return inputView.inputPurchaseAmount();
    }

    private void printPurchaseCount(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.countLottoQuantity();
        System.out.println();
        outputView.printPurchaseCount(count);
    }

    private void displayPurchasedLottoNumbers(List<Lotto> ticket) {
        for (Lotto lotto : ticket) {
            outputView.printPurchasedLottoNumbers(lotto.getNumbers());
        }
    }

    private List<MatchCondition> getMatchConditions(LottoTicket lottoTicket) {
        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber();
        List<MatchCondition> matchConditions = lottoTicket.gatherMatchCondition(winningNumber, bonusNumber);
        Map<LottoRank, Integer> lottoRankCount = produceStatistics(matchConditions);
        outputView.printWinningStatistics(lottoRankCount);
        return matchConditions;
    }

    private WinningNumber getWinningNumber() {
        outputView.printWinningNumbersInputMessage();
        String inputWinningNumbers = inputView.inputWinningNumbers();
        System.out.println();
        return WinningNumber.from(inputWinningNumbers);
    }

    private BonusNumber getBonusNumber() {
        outputView.printBonusNumberInputMessage();
        String inputBonusNumber = inputView.inputBonusNumber();
        System.out.println();
        return BonusNumber.from(inputBonusNumber);
    }

    private Map<LottoRank, Integer> produceStatistics(List<MatchCondition> matchConditions) {
        LottoResult lottoResult = new LottoResult();
        return lottoResult.produceStatistics(matchConditions);
    }

    private double getProfitRate(List<MatchCondition> matchConditions, String enteredPurchaseAmount) {
        long totalWinningAmount = profitCalculator.calculateTotalWinningAmount(matchConditions);
        long lottoPurchaseAmount = Convertor.convertToLong(enteredPurchaseAmount);
        return profitCalculator.calculateProfitRate(totalWinningAmount, lottoPurchaseAmount);
    }
}
