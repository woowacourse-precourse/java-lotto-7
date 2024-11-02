package lotto.controller;

import lotto.exception.InvalidBonusNumberException;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PublishLotteries;
import lotto.model.Purchase;
import lotto.model.WinningHistory;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.model.Rank;

import java.util.List;
import java.util.Map;

import static lotto.common.RepeatInputUntilSuccess.repeatInputUntilSuccess;
import static lotto.exception.ErrorMessage.ALREADY_EXIST_IN_WINNING_NUMBERS;

public class LottoController {
    private Purchase purchase;
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;
    private PublishLotteries publishLotteries;
    private WinningHistory winningHistory;

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        buy();
        assign();
        showResult();
    }

    private void buy() {
        inputPurchaseAmount();
        publishLotto();
        printPublishedLotto();
    }

    private void assign() {
        assignWinningNumbers();
        assignBonusNumber();
    }

    private void showResult() {
        printFinalStatistics();
    }

    private void inputPurchaseAmount() {
        purchase = repeatInputUntilSuccess(() -> new Purchase(inputView.getPurchaseAmount()));
    }

    private void publishLotto() {
        publishLotteries = new PublishLotteries(purchase.getPurchaseCount());
    }

    private void printPublishedLotto() {
        outputView.printPublishedLotteries(publishLotteries.get());
    }

    private void assignWinningNumbers() {
        winningNumber = repeatInputUntilSuccess(() -> new WinningNumber(inputView.getWinningString()));
    }

    private void assignBonusNumber() {
        bonusNumber = repeatInputUntilSuccess(() -> {
            int number = inputView.getBonusNumber();
            checkBonusNumberDuplicate(number);
            return new BonusNumber(number);
        });
    }

    private void checkBonusNumberDuplicate(int number) {
        if (winningNumber.get().contains(number)) {
            throw new InvalidBonusNumberException(ALREADY_EXIST_IN_WINNING_NUMBERS.getMessage());
        }
    }

    private Map<Rank, Integer> getWinningHistories() {
        Map<Rank, Integer> winningCountOfEachRanks;
        List<Integer> winningNumbersToCompare = winningNumber.get();
        List<Lotto> publishedLotteries = publishLotteries.get();
        int bonus = bonusNumber.get();

        winningHistory = new WinningHistory(winningNumbersToCompare, publishedLotteries, bonus);
        winningCountOfEachRanks = winningHistory.getWinningCountOfEachRank();

        return winningCountOfEachRanks;
    }

    private double getTotalRateOfReturn() {
        int totalPrize = winningHistory.getTotalPrize();
        int purchasePrice = purchase.getPurchasePrice();
        double rateOfReturn = (double) totalPrize / purchasePrice * 100;

        return Math.round(rateOfReturn * 10) / 10.0;
    }

    private void printWinningHistories() {
        Map<Rank, Integer> winningCountOfEachRanks = getWinningHistories();
        outputView.printWinnings(winningCountOfEachRanks);
    }

    private void printTotalRateOfReturn() {
        double rateOfReturn = getTotalRateOfReturn();
        outputView.printRateOfReturn(rateOfReturn);
    }

    private void printFinalStatistics() {
        printWinningHistories();
        printTotalRateOfReturn();
    }
}
